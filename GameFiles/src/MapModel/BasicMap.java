package MapModel;

import GameModel.Directions;
import GameModel.Location;
import RoomModel.BasicRoom;
import RoomModel.Room;
import RoomModel.RoomController;

import java.util.*;


/**
 * A basic map. It implements the methods in the RADSMap
 * This class is can be though of as a graph of a Integer (X,Y) coordinate pair. as the
 * It may be used for inheritance, testing, and modeling a Map class.
 * This class is used to place a starting room, the 4 objectives, and the ExitRoom
 * @author Rowan W Osmon
 * @version 0.01
 *
 * Rowan's notes:
 *
 */
class BasicMap implements RADSMap {

    /**
     * Maps take locations as input. All Maps are centered at Location(0,0)
     */
    Location myCoordinate;

    /**
     * This HashMap is used for quick and dynamic access to the map
     * The keys can be iterated over to generate the entire map when needed.
     * A Map with <Location, Room> allows for a dynamic map, vs a 2D array
     */
    HashMap<Location, Room> myMap;

    /**
     * A Map needs to generate Rooms.
     */
    private RoomController myRoomControl;
    BasicMap(){
        myCoordinate = new Location(0,0);
        myMap = new HashMap<>();
        myRoomControl = new RoomController();
        generateRoom(myCoordinate);
        placeStartingRooms();
    }

    private void placeStartingRooms(){
        // Set Locations for OBJECTIVES and EXIT

        replaceRoom(myCoordinate, myRoomControl.startRoom());
        /*
        replaceRoom(new Location(4,4), myRoomControl.generateRoom("OBJECTIVE"));
        replaceRoom(new Location(1,2), myRoomControl.generateRoom("OBJECTIVE"));
        replaceRoom(new Location(-2,-1), myRoomControl.generateRoom("OBJECTIVE"));
        replaceRoom(new Location(3,-2), myRoomControl.generateRoom("OBJECTIVE"));
        replaceRoom(new Location(0,-1), myRoomControl.generateRoom("EXIT"));

         */
        int numObjectives = 5;
        for (int i = 0; i < numObjectives; i++){
          Location l = keyCheck();
          while (myMap.containsKey(l)){
                l = keyCheck();
            }
            if (i == numObjectives-1){
                replaceRoom(l, myRoomControl.generateRoom("EXIT"));
            } else{
                replaceRoom(l, myRoomControl.generateRoom("OBJECTIVE"));
            }
        route();
        }

    }

    private Location keyCheck(){
        Random b = new Random();
        int myX = b.nextInt(-2, 2);
        int myY = b.nextInt(-2, 2);
        return new Location(myX, myY);
    }

    /**
     * This method is used to replace a Room at a Location.
     * It takes the desired Location and
     * the Room that you want placed as inputs.
     * @param theLocation The X/Y coordinate of the room.
     * @param theRoom A Room to be placed at that location.
     */
    @Override
    public void replaceRoom(Location theLocation, Room theRoom) {
        myMap.put(theLocation, theRoom);
    }

    /**
     * This method uses the Room Controller to generate a generic room.
     * It takes as input the Location that you want a room at.
     * @param theLocation
     */
    @Override
    public void generateRoom(final Location theLocation) {

        if (!myMap.containsKey(theLocation)) {
            myMap.put(theLocation, myRoomControl.genericRoom());
        }

    }

    /**
     * This Method is used to return all explored rooms.
     * it returns a string.
     *
     * Rowan's notes:
     * would like to refactor this to not use a 2d String array
     *
     * @return
     */
    @Override
    public String fullMap(int theI) {

        if (theI < 3) {
            theI =3;
        }
        int rowOffset = -theI;
        int columnOffset = -theI;
        String[][] arr = new String[2*Math.abs(theI)][2*Math.abs(theI)];
        Location theCoord;
        for (int i = 0; i < arr.length; i++){
           for (int j = 0; j < arr[i].length; j++){
               theCoord = new Location(rowOffset+i,columnOffset+j);
               if(myMap.containsKey(theCoord)){
                   arr[i][j] = "(" + myMap.get(theCoord)+")";
               } else {
                   arr[i][j] = "()";
               }
            }
        }

        return Arrays.deepToString(arr).replace("], ", "]\n");
    }

    /**
     * This Method is used to return a Room out of the map
     * It takes the room location as input.
     * If no Room exits at that location, a room is generated at that location.
     * It returns the Room object.
     * @param theLocation
     * @return
     */
    @Override
    public Room getRoomAt(final Location theLocation) {
        Room r;
        if (!myMap.containsKey(theLocation)) {
            generateRoom(theLocation);
        }
        r = myMap.get(theLocation);
        return r;
    }

    /**
     * This method is used to return a 9x9 string of the rooms around the target
     * It takes as input the location to be at the center of the 9x9
     * It returns a string representing the contents of the room.
     * @param theLocation
     * @return
     */
    @Override
    public String localMap(Location theLocation) {
        Location l;
        int sizeOfVisionOutput = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = -sizeOfVisionOutput; i <= sizeOfVisionOutput; i++){
            for (int j = -sizeOfVisionOutput; j <= sizeOfVisionOutput; j++){
                l = new Location(theLocation.getMyX()+i, theLocation.getMyY()+j);
                if(!myMap.containsKey(l)){
                    generateRoom(l);
                }
                sb.append("[" + myMap.get(l) + "]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void route() {
        Set<Location> keys = new HashSet<>();
        for (Location l : myMap.keySet()){
            keys.add(l);
        }

        for(Location l : keys) {
            walker(new Location(0,0), l);
        }
    }


    /**
     * This method goes through the first 6 locations in our map when it is located
     * For each room between the starting location and the other 5, this will travel the
     * other path between the start and other location
     * @param target
     * @return
     */
    private void walker(final Location theCurrent,final Location target) {
        // if current location is not equal to target then do body
        Location current = theCurrent;
        Directions d;
        Location next = null;
        while (current.compare(current,target) != 0) {
            if(current.getMyY() < target.getMyY()) {
                d = Directions.RIGHT;
                next = Directions.nextLocation(d,current);
            } else if (current.getMyY() > target.getMyY()) {
                d = Directions.LEFT;
                next = Directions.nextLocation(d,current);
            } else if (current.getMyX() < target.getMyX()) {
                d = Directions.DOWN;
                next = Directions.nextLocation(d,current);
            } else {
                d = Directions.UP;
                next = Directions.nextLocation(d,current);
            }
            assignDoors(d, current);
            assignDoors(Directions.reverse(d), next);
            current = next;
        }
    }
    private void assignDoors(Directions d,Location local ){
        Room r = getRoomAt(local);
        r = myRoomControl.doorCheck(d,r);
        replaceRoom(local, r);
    }

}
