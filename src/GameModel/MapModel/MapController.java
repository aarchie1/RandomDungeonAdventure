package MapModel;

import RoomModel.Room;
import MapModel.Location;
import RoomModel.StartingRoom;

import java.util.HashMap;

public class MapController {

    HashMap<Location, Room> myMap;


    MapController(){
        myMap = new HashMap<>();
    }


}
