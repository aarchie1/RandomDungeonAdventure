package MapModel;

/**
 * This class is used as an X/Y coordinate system.
 */
public class Location {

    private final int myX;
    private final int myY;

    public Location(final int theX, final int theY){
        myX = theX;
        myY = theY;
    }

    public int getMyY() {
        return myY;
    }

    public int getMyX() {
        return myX;
    }
}
