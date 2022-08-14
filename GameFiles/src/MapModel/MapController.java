package MapModel;

import GameModel.Location;
import RoomModel.Room;
import RoomModel.RoomController;

/**
 * This class is used to control all RADSMaps.
 * It will be used whenever a RADSMap operation is needed.
 * Maps should hold a Location as a key, and a room as a value.
 * Maps should display a single room, a 9x9 of rooms,
 *      and/or all rooms.
 * Maps should take locations or strings as input.
 * Maps should output Rooms or Strings.
 *
 *
 * 
 * @author Rowan W Osmon
 *
 *
 * Rowan's Notes: This class needs more features and a tester to be implemented.
 *
 */
public class MapController {
    int explored;
    RADSMap myMap;
    Location myLocal;

    RoomController myRoom ;

    /**
     *
     */
    public MapController(){
        explored = 0;
        myMap = new BasicMap();
        myLocal = new Location(0,0);
        myRoom = new RoomController();
    }

    /**
     *
     * @param theLocation
     */
    public void setLocal(final Location theLocation) {
        myLocal = theLocation;
        if (Math.abs(theLocation.getMyX()) > explored){
            explored = theLocation.getMyX();;
        }
        if (Math.abs(theLocation.getMyY()) > explored){
            explored = theLocation.getMyY();
        }
        myMap.generateRoom(myLocal);
    }

    //navigate through locations from start to dest
    //for each
    //retrieve from map store as room for editing
    // Room c = myMap.roomAt(Location current)
    // Room n = myMap.roomat(Location next)

    //subprob1 - where are you moveing next
    // logic to get correct door location by how you are moving (if next is +- x or y);
    // save as Direction[] doorLocations (UP<DOWN<LEFT<RIGHT)) -> turn to strings or change input of function below)

    //subprob2 = call to room door logic at those location with the stored direction
    // c.DoorCheck(String[] doorLocations, c)
    // need to add logic to get reverse of direction for use here.
    // n.DoorCheck(mirror(doorLocations), n)

    //store back in map
    //myMap.replaceRoom(current, c);
    //                    (next, n);


    // Algo for door placment
    // take as input the map,
    // produce a map with door edited so that object can be reached.
    /*



     */



    /**
     *
     * @param theCoordinates
     * @return
     */
    public Room getRoomAt(final Location theCoordinates){
        return myMap.getRoomAt(theCoordinates);
    }

    /**
     *
     * @return
     */
    public String getFullMap(){
        return myMap.fullMap(explored);
    }

    public String getLocalMap(final Location theLocal) {
        return myMap.localMap(theLocal);
    }

    public void removeEntity(final Location theLocal, String theName) {
        Room theCurrent = myMap.getRoomAt(theLocal);
        theCurrent.removeEntity(theName);
        myMap.replaceRoom(theLocal, theCurrent);
    }

}
