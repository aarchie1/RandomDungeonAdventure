package RoomModel;

import RoomEntity.EmptyRoom;

/**
 * This class is used to control all Rooms
 */
public class RoomController {

    public RoomController(){

    }


    public Room genericRoom() {
        return new BasicRoom();
    }
}
