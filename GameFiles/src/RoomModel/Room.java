package RoomModel;

import RoomEntity.EntityController;


import java.util.ArrayList;
import java.util.List;

/**
 * A room is a list of RoomEntitys.
 * A Room should be able to provide the list of entitys, add to it, or remove an element from it.
 * A Room's toString should be a list of its contents.
 * @author Rowan W Osmon
 */
public interface Room {


    /**
     * Adds a Room Entity to the List.
     */
    void addEntity(String theEntityName);


    /**
     * Returns a copy of the list when called on
     * @return a List of RoomEntitys.
     */
    ArrayList<String> getMyEntities();

    /**
     * Removes the targeted RoomEntity from the list.
     * @param theTargetName
     */
    void removeEntity(String theTargetName);
    
    public String toString();

}
