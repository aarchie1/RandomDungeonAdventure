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

    RADSMap myMap;
    Location myLocal;

    RoomController myRoom ;
    Room myCurrentRoom;

    public MapController(){
        myMap = new BasicMap();
        myLocal = new Location(0,0);
        myRoom = new RoomController();
    }
    public void setLocal(final Location theLocation) {
        myLocal = theLocation;
        myMap.generateRoom(myLocal);
        myCurrentRoom = myMap.getRoomAt(myLocal);
    }



    public Room getRoomAt(final Location theCoordinates){
        return myMap.getRoomAt(theCoordinates);
    }

    public String getFullMap(){
        return myMap.fullMap();
    }

    public String getLocalMap(final Location theLocal) {
        return myMap.localMap(theLocal);
    }


}
