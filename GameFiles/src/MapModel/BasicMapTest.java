package MapModel;

import GameModel.Location;
import RoomModel.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicMapTest {
    BasicMap myMap = new BasicMap();
    Location myStart = new Location(0,0);
    @BeforeEach
    void setUp() {
        myMap = new BasicMap();
    }

    @org.junit.jupiter.api.Test
    void replaceRoom() {

    }

    @org.junit.jupiter.api.Test
    void generateRoom() {
    }

    @org.junit.jupiter.api.Test
    void fullMap() {
    }

    @org.junit.jupiter.api.Test
    void getRoomAt() {
        Room test1 = myMap.getRoomAt(myStart);
        System.out.println(test1.toString());
    }

    @org.junit.jupiter.api.Test
    void localMap() {
    }

}