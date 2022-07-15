package RoomEntity;

/**
 * A RoomEntity is an object that returns a string. RoomEntity are used in a Room Object.
 * RoomEntitys may be properties of the room such as walls, traps, or doors.
 * RoomEntitys may also be items, monsters, objectives, and even the player.
 * Anything that is going to occupy the room is a room entity.
 * All RoomEntitys must have a name that they return toString so that they can be
 * found in a Room correctly.
 */
public interface RoomEntity {

    public String toString();



}
