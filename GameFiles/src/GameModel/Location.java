package GameModel;

import java.util.Comparator;
import java.util.Objects;

/**
 * This class is used as an X/Y coordinate system.
 * @author Rowan W Osmon
 * @version 0.01
 */
public class Location implements Comparator<Location>{

    @Override
    public int compare(Location o1, Location o2) {
        return Comparator.comparing(Location::getMyX)
                .thenComparing(Location::getMyY)
                .compare(o1, o2);
    }

    @Override
    public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if (obj == null){
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Location other = (Location) obj;
            if (getMyX() != other.getMyX() && getMyY() != other.getMyY()){
                return false;
            }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getMyX(),getMyY());
    }

    private final class Coordinates {
        private final int myX;
        private final int myY;

        private Coordinates(final int theX, final int theY){
            myX = theX;
            myY = theY;
        }
        private int getMyY() {
            return myY;
        }

        private int getMyX() {
            return myX;
        }
    }

    private final Coordinates myCoordinates;
    public Location(final int theX, final int theY){
        myCoordinates = new Coordinates(theX,theY);
    }

    public int getMyY() {
        return myCoordinates.getMyY();
    }

    public int getMyX() {
        return myCoordinates.getMyX();
    }


}

