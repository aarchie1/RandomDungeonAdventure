package MapModel;

import RoomModel.Room;
import RoomModel.RoomController;

/**
 * This class is used to control all RADSMaps.
 * It will be used whenever a RADSMap operation is needed.
 *
 *
 * @author Rowan W Osmon
 *
 *
 * Rowan's Notes: This class needs more features and a tester to be implemented.
 *
 */
public class MapController {

    RADSMap myMap = new BasicMap();
    Location myLocal = new Location(0,0);

    RoomController myRoom = new RoomController();
    Room myCurrentRoom;

    MapController(){

    }
    public void setLocal(Location theLocation) {
        myLocal = theLocation;
        myMap.generateRoom(myLocal);
        myCurrentRoom = myMap.getRoomAt(myLocal);
    }

    public void moveLocal(String theDirection){
        int theX = myLocal.getMyX();
        int theY = myLocal.getMyY();
        switch(theDirection) {
            case "up":      theY++;
                            break;
            case "down":    theY--;
                            break;
            case "left":    theX--;
                            break;
            case "right":   theX++;
                            break;
            default:        throw new RuntimeException("Not a valid input!");
        }
        setLocal(new Location(theX, theY));

    }

    public String localMap() {
        return
    }




}
