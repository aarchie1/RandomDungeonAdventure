package MapModel;

import GameModel.Location;
import RoomModel.BasicRoom;
import RoomModel.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMapTest {
    BasicMap myMap = new BasicMap();
    Location myStart = new Location(0,0);

    Location myCurrent = new Location(0,0);
    private void moveOne(int theX, int theY){

        myCurrent = new Location(myStart.getMyX() + theX, myStart.getMyX()+theY);
    }
    @BeforeEach
    void setUp() {
        myMap = new BasicMap();
    }

    @org.junit.jupiter.api.Test
    void replaceRoom() {
        System.out.println("\n***Begin replaceRoom test***\n");
        System.out.println(myMap.getRoomAt(myStart).toString());

    }

    @org.junit.jupiter.api.Test
    void generateRoom() {
        System.out.println("\n***Begin generateRoom test***\n");


        moveOne(1,0);
    myMap.generateRoom(myCurrent);
    myMap.replaceRoom(myCurrent, new BasicRoom());
    }

    @org.junit.jupiter.api.Test
    void fullMap() {
        System.out.println("\n***Begin fullMap test***\n");
        System.out.println(myMap.fullMap());
    }

    @org.junit.jupiter.api.Test
    void getRoomAt() {
        System.out.println("\n***Begin getRoomAt test***\n");
        Room test1 = myMap.getRoomAt(myStart);
        System.out.println(test1.toString());
    }

    @org.junit.jupiter.api.Test
    void localMap() {
        System.out.println("\n***Begin localMap test***\n");
        System.out.println(myMap.localMap(myStart));
    }

}