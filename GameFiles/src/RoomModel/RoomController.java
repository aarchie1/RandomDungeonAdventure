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
 * @author Rowan W Osmon
 * @author Anthony Archie
 * @version .02
 *
 */
public class RoomController {

    EntityController myEntityEditor = new EntityController();

    /**
     * Default Constructor
      */
    public RoomController(){

    }

    /**
     * This method generates the start room.
     * @return Room object representing the starting room
     */
    public Room startRoom() {
        Room start = new StartingRoom(myEntityEditor.getStartingRoom());
        return start;
    }

    /**
     * Generates a basic room
     * @return Room Object containing a basic room
     */
    public Room genericRoom() {
        Room theRoom = new BasicRoom();
        //theRoom.addEntity(myEntityEditor.addMonster());
        return theRoom;
    }

    /**
     * This room generates the special rooms of the Dungeons
     * @param theRoom this is the room that is being set
     * @return returns a presetroom
     */
    public PreSetRoom generateRoom(final String theRoom) {
        PreSetRoom specialRoom = PreSetRoom.GENERIC;
        switch(theRoom) {
            case "start":
                specialRoom = PreSetRoom.START;
                break;
            case "exit":
                specialRoom = PreSetRoom.EXIT;
                break;
            case "object":
                specialRoom = PreSetRoom.OBJECTIVE;
                break;
            default:
                break;
        }
        return specialRoom;
    }
}
