package MapModel;

import RoomModel.Room;

import java.util.HashMap;

/**
 *This class is used to control all Maps.
 */
public class MapController {

    HashMap<Location, Room> myMap;


    MapController(){
        myMap = new HashMap<>();
    }


}
