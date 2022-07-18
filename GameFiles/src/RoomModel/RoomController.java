package RoomModel;


import RoomEntity.EntityController;

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

    EntityController myRoomEditer = new EntityController();
    /**
     *
     */
    public RoomController(){

    }

    public Room startRoom() {

        return new StartingRoom(myRoomEditer.getStartingRoom());
    }

    /**
     * Generates a basic room
     * @return
     */
    public Room genericRoom() {
        return new BasicRoom();
    }

    public PreSetRoom generateRoom(final char theRoom) {
        PreSetRoom specialRoom = PreSetRoom.GENERIC;
        switch(theRoom) {
            case 's':
                specialRoom = PreSetRoom.START;
                break;
            case 'e':
                specialRoom = PreSetRoom.EXIT;
                break;
            case 'o':
                specialRoom = PreSetRoom.OBJECTIVE;
                break;
        }
        return specialRoom;
    }
}
