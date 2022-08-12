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
    public RoomController(){

        myEntityEditor = new EntityController();
    }

    /**
     * This method generates the start room.
     * @return Room object representing the starting room
     */
    public Room startRoom() {

        Room start = new BasicRoom(myEntityEditor.getStartingRoom());

        return start;
    }

    /**
     * Generates a basic room
     * @return Room Object containing a basic room
     */
    public Room genericRoom() {
        Room theRoom = new BasicRoom(myEntityEditor.getBasicRoom());
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

    // take input from the map which indicate where doors should be in the room -
    // call on the RoomEntity controller to get those room objects and add them to the room.

    public Room doorCheck(final String[] doorLocations,final Room theCurrent){
        ArrayList<RoomEntity> arr = myEntityEditor.LoadContents(theCurrent.getMyEntities());
        for (String s: doorLocations){
            arr = myEntityEditor.addDoor(arr,s);
        }

        BasicRoom update = new BasicRoom(myEntityEditor.getContents(arr));
        return update;
    }

    /**
     * This method should check for a monster, if a string matching a monster is found,
     * then the monster is removed. The room should be saved with its updated state.
     * @param theCurrent the current room being checked for monsters.
     * @return Room the room which was altered
     */
    public Room removeMonsters(Room theCurrent) {
        for (String s: theCurrent.getMyEntities()){
            if (myEntityEditor.isMonster(s)){
                theCurrent.removeEntity(s);
                myEntityEditor.removeMonster(s);
            }
        }
        return theCurrent;

    }
}
