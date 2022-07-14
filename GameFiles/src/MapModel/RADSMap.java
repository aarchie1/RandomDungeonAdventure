package MapModel;
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
     * Maps take locations as input. All Maps are centered at Location(0,0)
     */
    Location myCoordinate = new Location(0,0);

    /**
     * A Map needs to generate Rooms.
     */
    RoomController myRoomControl = new RoomController();

    /**
     * This HashMap is used for quick and dynamic access to the map
     * The keys can be iterated over to generate the entire map when needed.
     * A Map with <Location, Room> allows for a dynamic map, vs a 2D array
     */
    HashMap<Location, Room> myMap = new HashMap<>();

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
    String fullMap();

    Room getRoomAt(Location theLocation);

    /**
     * This should return the 9x9 centered on the input location.
     * @returnString representing 9x9 rooms.
     */
    String localMap(Location theLocation);



}
