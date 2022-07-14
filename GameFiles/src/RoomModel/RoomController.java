package RoomModel;

import RoomEntity.EmptyRoom;

/**
 * This class is used to control all Rooms
 * It needs methods stubbed out
 * RoomController should have methods that when called on
 * generate a room with different starting contents
 *      ex: StartingRoom, Exit, Objective.
 * It should also allow the placement and removal of RoomEntities
 *      using a EntityController
 * It should not decide when to place a door/wall,
 *      it is used to place/edit/remove them.
 *
 */
public class RoomController {

    public RoomController(){

    }


    public Room genericRoom() {
        return new BasicRoom();
    }
}
