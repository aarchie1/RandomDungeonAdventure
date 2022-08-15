package RoomModel;


import RoomEntity.EntityController;
import RoomEntity.RoomEntity;

import java.util.ArrayList;


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
 * @version .03
 *
 */
public class RoomController {

    EntityController myEntityEditor;

    /**
     * Default Constructor
     */
    public RoomController() {
        myEntityEditor = new EntityController();
    }

    /**
     * This method generates the start room.
     *
     * @return Room object representing the starting room
     */
    public Room startRoom() {
        return PreSetRoom.spawnRoom(PreSetRoom.STARTROOM);
    }

    /**
     * Generates a basic room
     *
     * @return Room Object containing a basic room
     */
    public Room genericRoom() {
        return PreSetRoom.spawnRoom(PreSetRoom.GENERICROOM);
    }

    /**
     * This room generates the special rooms of the Dungeons
     *
     * @param theRoom this is the room that is being set
     * @return returns a presetroom
     */
    public Room generateRoom(final String theRoom) {
        PreSetRoom specialRoom = PreSetRoom.GENERICROOM;
        switch (theRoom) {
            case "START":
                specialRoom = PreSetRoom.STARTROOM;
                break;
            case "EXIT":
                specialRoom = PreSetRoom.EXITROOM;
                break;
            case "OBJECTIVE":
                specialRoom = PreSetRoom.OBJECTIVEROOM;
                break;
            default:
                break;
        }
        return PreSetRoom.spawnRoom(specialRoom);
    }

    // take input from the map which indicate where doors should be in the room -
    // call on the RoomEntity controller to get those room objects and add them to the room.

    public Room doorCheck(final String[] doorLocations, final Room theCurrent) {
        ArrayList<RoomEntity> arr = myEntityEditor.LoadContents(theCurrent.getMyEntities());
        for (String s : doorLocations) {
            arr = myEntityEditor.addDoor(arr, s);
        }
        BasicRoom update = new BasicRoom(myEntityEditor.getContents(arr));
        return update;
    }
}