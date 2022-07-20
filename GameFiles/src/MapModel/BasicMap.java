package MapModel;

import GameModel.Location;
import RoomModel.Room;
import RoomModel.RoomController;
import RoomModel.StartingRoom;

/**
 * A basic map. It implements the methods in the RADSMap
 * It may be used for inheritance, testing, and modeling a Map class.
 * @author Rowan W Osmon
 * @version 0.01
 *
 * Rowan's notes:
 * This class needs a tester.
 * This class needs to be refactored.
 * It should use RoomController for its Room operations.
 * This class (or an extension of it) should also
 *      place a starting room, the 4 objectives, and the ExitRoom
 */
public class BasicMap implements RADSMap {

    RoomController myRoomControl = new RoomController();

    BasicMap(){
        generateRoom(myCoordinate);
        replaceRoom(myCoordinate, myRoomControl.startRoom());
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
    public void generateRoom(Location theLocation) {

        if (!myMap.containsKey(theLocation)) {
            myMap.put(theLocation, myRoomControl.genericRoom());
        }

    }

    /**
     * This Method is used to return all explored rooms.
     * Tt returns strings.
     * @return
     */
    @Override
    public String fullMap() {
        StringBuilder sb = new StringBuilder();
        for (Location l : myMap.keySet()){
            sb.append(myMap.get(l).toString());
        }
        return sb.toString();
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
    public Room getRoomAt(Location theLocation) {
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
        StringBuilder sb = new StringBuilder();
        for (int i = -1; i < 2; i++){
            for (int j = -1; j< 2; j++){
                l = new Location(theLocation.getMyX()+i, theLocation.getMyY()+j);
                if(!myMap.containsKey(l)){
                    myMap.put(l, myRoomControl.genericRoom());
                }
                sb.append("[" + myMap.get(l) + "]");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
