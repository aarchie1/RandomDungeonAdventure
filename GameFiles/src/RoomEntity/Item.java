package RoomEntity;

/**
 * An Item is a room entity that can be carried by the player
 * This class is intended to be the basis of inheritance for all
 * Item type objects
 * It is currently stubbed out for testing purposes
 * @author Rowan W Osmon
 */
public class Item implements RoomEntity {
    private final String myName;

    private String myFlavorText = "";

    public Item(String myName) {
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
