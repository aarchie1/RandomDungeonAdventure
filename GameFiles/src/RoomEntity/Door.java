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
        return myName.toString();
    }

    @Override
    public String getMyName() {
        return null;
    }

    public void setMyFlavorText(String myFlavorText) {
        this.myFlavorText = myFlavorText;
    }
}
