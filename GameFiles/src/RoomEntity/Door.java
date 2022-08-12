package RoomEntity;

public class Door implements RoomEntity{
    private final String myName;

    private String myFlavorText = "";

    public Door(String myName) {
        this.myName = myName;
        setMyFlavorText("");
    }

    public String getFlavorText(){
        return myFlavorText;
    }

    @Override
    public String toString() {
        return getMyName();
    }

    @Override
    public String getMyName() {
        return myName;
    }

    public void setMyFlavorText(String myFlavorText) {
        this.myFlavorText = myFlavorText;
    }
}
