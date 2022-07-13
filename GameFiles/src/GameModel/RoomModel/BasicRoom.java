package RoomModel;

import RoomEntity.RoomEntity;
import RoomEntity.EmptyRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a basic room, and is here for inheritance purposes.
 */
public class BasicRoom implements Room {
    /**
     * This list holds the contents of the room.
     */
    List<RoomEntity> myEntitys = null;

    BasicRoom(){
        myEntitys = new ArrayList<RoomEntity>();
        myEntitys.add(new EmptyRoom());
    }

    /**
     * Constructs a basic room.
     * @param arr the RoomEntitys in the room.
     */
    BasicRoom(List<RoomEntity> arr){
        myEntitys = arr;
    }

    /**
     * Sets new contents to the room.
     * @param arr the List of RoomEntitys
     */
    public void setMyEntitys(List<RoomEntity> arr) {
        myEntitys = arr;
    }

    /**
     * Gets a copy of the List of RoomEntiys.
     * @return the RoomEntityList
     */
    public List<RoomEntity> getMyEntitys(){
        return myEntitys;
    }

    /**
     * Removes the target RoomEntity.
     * @param theTarget
     */
    @Override
    public void removeEntity(RoomEntity theTarget) {
        myEntitys.remove(theTarget);
    }

    /**
     * Adds an entity to the room
     * @param e
     */
    @Override
    public void addEntity(RoomEntity e) {
        myEntitys.add(e);
    }

    /**
     * Returns the contents of the room in String form.
     * @return
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (RoomEntity r : myEntitys) {
            sb.append(r.toString());
        }
        return sb.toString();
    }
}
