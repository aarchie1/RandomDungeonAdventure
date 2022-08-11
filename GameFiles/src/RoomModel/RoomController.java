package RoomModel;


import RoomEntity.EntityController;

import java.util.ArrayList;
import java.util.List;

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
        ArrayList<String> arr = new ArrayList<>();
        for (Object i : myEntityEditor.getStartingRoom()){
            arr.add(i.toString());
        }
        Room start = new BasicRoom(arr);
        return start;
    }

    /**
     * Generates a basic room
     * @return Room Object containing a basic room
     */
    public Room genericRoom() {
        Room theRoom = new BasicRoom();
        theRoom.addEntity(myEntityEditor.getBasicRoom().toString());
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

    public void doorCheck(final String[] doorLocations,final Room theCurrent){

        for (String s: doorLocations){

            myEntityEditor.LoadContents(theCurrent.getMyEntities());
        }
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
