package MapModel;
import GameModel.Location;
import RoomModel.*;

import java.util.HashMap;

/**
 * Current class name RADSMap as Map is already a class in java.
 * A Map object should contain rooms.
 * A Map object should be able to produce a string representation of it's rooms
 * A Map object does not control rooms, it just organizes and displays them.
 * A Map should have a RoomController that manages its rooms.
 * Maps make use of the Location class for its X/Y input
 * Maps do not track the player, they just display
 * @author Rowan W Osmon
 *
 */
public interface RADSMap {

    /**
     * This is used to replace a room on the map with a specific Room.
     * @param theLocation The X/Y coordinate of the room.
     * @param theRoom A Room to be placed at that location.
     */
    void replaceRoom(Location theLocation, Room theRoom);

    /**
     * This is called to generate a room
     */
    void generateRoom(Location theLocation);

    /**
     * This should return every room stored on the map in string form.
     * @return String representing all rooms on this map.
     */
    String fullMap(final int x, final int they);

    Room getRoomAt(Location theLocation);

    /**
     * This should return the 9x9 centered on the input location.
     * @returnString representing 9x9 rooms.
     */
    String localMap(Location theLocation);



}
