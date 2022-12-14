package RoomModel;

import RoomEntity.EntityController;
import RoomEntity.RoomEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a basic room, and is here for inheritance purposes.
 *
 * @author Rowan W Osmon
 * @version 0.01
 */
public class BasicRoom implements Room {
    /**
     * This list holds the contents of the room.
     */
    EntityController myContentsEdit;
    ArrayList<String> myEntities;
    /**
     * This Boolean is used to quickly determine if the room is empty or not.
     */
    Boolean isEmpty;

    /**
     * Constructs a basic room.
     * This Room has an ArrayList<RoomEntity> that is empty
     */
    public BasicRoom(){
        myEntities = new ArrayList<>();
        myContentsEdit = new EntityController();
        isEmpty = true;
    }

    /**
     * Constructs a basic room with a List of RoomEntities.
     * @param arr the RoomEntities in the room.
     */
    BasicRoom(final ArrayList<String> arr){
        setMyEntities(arr);
        checkIfEmpty();

    }

    /**
     * Sets new contents to the room.
     * @param arr the List of RoomEntities
     */
    public void setMyEntities(final List<String> arr) {
        if (myEntities == null){
            myEntities = new ArrayList<>();
        }
        myEntities.addAll(arr);
        checkIfEmpty();
    }

    /**
     * Gets a copy of the List of RoomEntities.
     * @return the RoomEntityList
     */
    @Override
    public ArrayList<String> getMyEntities(){
        return myEntities;
    }

    /**
     * Removes the Named RoomEntity.
     * This method iterates through the array of objects in the room
     * It does this to check the Name of each RoomEntity.
     * If it finds the correct name, it removes that RoomEntity from the List
     * @param theTargetName
     */
    @Override
    public void removeEntity(final String theTargetName) {
        for (String r : myEntities){
            if (r.equals(theTargetName)) {
                myEntities.remove(r);
                break;
            }
        }
        checkIfEmpty();
    }

    /**
     * Adds an entity to the room
     * @param e
     */
    @Override
    public void addEntity(String e) {
        myEntities.add(e);
        checkIfEmpty();
    }


    /**
     * Checks if this room is empty or not
     * @return true if it is, false if not.
     */
    public void checkIfEmpty(){
        if (myEntities.isEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

    }

    /**
     * Returns the contents of the room in String form.
     * @return
     */
    public String toString(){
        if (isEmpty){
            return "EmptyRoom";
        }
        StringBuilder sb = new StringBuilder();
        for (String r : myEntities) {

            sb.append(" " + r + " ");

        }
        return sb.toString();
    }
}
