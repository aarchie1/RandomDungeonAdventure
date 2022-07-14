package RoomEntity;

/**
 * This Class is a RoomEntity representing an empty room.
 */
public class EmptyRoom implements RoomEntity {

    final private String myContents;
    public EmptyRoom(){
        myContents = "Empty Room";
    }

    @Override
    public String toString() {
        return myContents;
    }

}
