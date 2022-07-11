package MapModel;

import RoomModel.Room;
import RoomModel.StartingRoom;

import java.util.HashMap;

public class MapController {

    HashMap<Location, Room> myMap;


    MapController(){
        myMap = new HashMap<Location, StartingRoom>()
    }


}
