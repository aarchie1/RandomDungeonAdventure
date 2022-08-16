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
    RoomController myRoom ;

    /**
     *
     */
    public MapController(){
        explored = 0;
        myMap = new BasicMap();
        myRoom = new RoomController();
    }

    /**
     * porivate update room count when move
     * @param theLocation
     */
    public void exploredUpdate(final Location theLocation) {
        if (Math.abs(theLocation.getMyX()) > explored){
            explored = theLocation.getMyX();;
        }
        if (Math.abs(theLocation.getMyY()) > explored){
            explored = theLocation.getMyY();
        }
    }



    /**
     *
     * @param theCoordinates
     * @return
     */
    public Room getRoomAt(final Location theCoordinates){
        exploredUpdate(theCoordinates);
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
