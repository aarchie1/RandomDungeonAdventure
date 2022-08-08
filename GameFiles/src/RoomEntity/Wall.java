package RoomEntity;

public class Wall implements  RoomEntity{
    private final String myName;

    private String myFlavorText = "";

    public Wall(String myName) {
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

    public void setMyFlavorText(String myFlavorText) {
        this.myFlavorText = myFlavorText;
    }
}
