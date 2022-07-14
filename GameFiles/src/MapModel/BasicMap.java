package MapModel;

import RoomModel.Room;
import RoomModel.RoomController;

/**
 * A basic map. It implements the methods in the RADSMap
 * It may be used for inheritance, testing, and modeling a Map class.
 */
public class BasicMap implements RADSMap {

    BasicMap(){
        generateRoom(myCoordinate);
    }

    @Override
    public void replaceRoom(Location theLocation, Room theRoom) {
        myMap.put(theLocation, theRoom);
    }

    @Override
    public void generateRoom(Location theLocation) {
        if (!myMap.containsKey(theLocation)) {
            myMap.put(theLocation, myRoomControl.genericRoom());
        }

    }

    @Override
    public String fullMap() {
        StringBuilder sb = new StringBuilder();
        for (Location l : myMap.keySet()){
            sb.append(myMap.get(l).toString());
        }
        return sb.toString();
    }

    @Override
    public Room getRoomAt(Location theLocation) {
        Room r;
        if (!myMap.containsKey(theLocation)) {
            generateRoom(theLocation);
        }
        r = myMap.get(theLocation);
        return r;
    }

    @Override
    public String localMap(Location theLocation) {
        Location l;
        StringBuilder sb = new StringBuilder();
        for (int i = -1; i < 2; i++){
            for (int j = -1; j< 2; j++){
                l = new Location(theLocation.getMyX()+i, theLocation.getMyY()+j);
                if(!myMap.containsKey(l)){
                    myMap.put(l, myRoomControl.genericRoom());
                }
                sb.append(myMap.get(l));
            }
        }
        return sb.toString();
    }
}
