package RoomModel;



import RoomEntity.RoomEntity;

import java.util.ArrayList;

/**
 * This class is a special Room placed only when a new game is called.
 * It should contain the player, and any starting RoomEntities.
 * It must have at least 1 door.
 * It should not contain a trap, monster, objective, exit, or item.
 */
public class StartingRoom extends BasicRoom {
    private Boolean isStartTile = true;

    StartingRoom(ArrayList<RoomEntity> arr) {
        super(arr);

    }



}
