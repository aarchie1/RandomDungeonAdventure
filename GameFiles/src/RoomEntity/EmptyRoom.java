package RoomEntity;

/**
 * This Class is a RoomEntity representing an empty room.
 * @author Rowan W Osmon
 */
public class EmptyRoom implements RoomEntity {

    final private String myContents;
    public EmptyRoom(){
        myContents = "EmptyRoom";
    }

    @Override
    public String toString() {
        return myContents;
    }

    @Override
    public String getMyName() {
        return myContents;
    }

}
