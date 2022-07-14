package RoomEntity;

public class EmptyRoom implements RoomEntity {

    final private String myContents;
    public EmptyRoom(){
        myContents = "E";
    }

    @Override
    public String toString() {
        return myContents;
    }

}
