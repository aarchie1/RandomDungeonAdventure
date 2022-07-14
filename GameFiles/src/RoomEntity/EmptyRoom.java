package RoomEntity;

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
