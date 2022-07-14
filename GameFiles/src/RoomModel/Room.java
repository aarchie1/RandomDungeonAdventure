package RoomModel;

import RoomEntity.RoomEntity;

import java.util.List;

/**
 * A room is a list of RoomEntitys.
 * A Room should be able to provide the list of entitys, add to it, or remove an element from it.
 * A Room's toString should be a list of its contents.
 *
 */
public interface Room {



    /**
     * Adds a Room Entity to the List.
     */
    void addEntity(RoomEntity e);

    /**
     * Returns a copy of the list when called on
     * @return a List of RoomEntitys.
     */
    List<RoomEntity> getMyEntitys();

    /**
     * Removes the targeted RoomEntity from the list.
     * @param theTargetName
     */
    void removeEntity(String theTargetName);
    
    public String toString();


}
