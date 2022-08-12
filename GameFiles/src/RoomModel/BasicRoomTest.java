package RoomModel;

import RoomEntity.*;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is used to test the BasicRoom Class
 * Changelog 0.01 -> 0.02:
 * refactored tests to use the public RoomEntity class
 * rather then the package Item class
 * @author Rowan W Osmon
 * @version 0.02
 */
class BasicRoomTest {
    Room myRoom = new BasicRoom();
    RoomEntity myDevAmulet = new RoomEntity() {
        @Override
        public String getMyName() {
            return"DEVAMULET";
        }
        @Override
        public String toString() {
            return getMyName();
        }
    };


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myRoom = new BasicRoom();
    }

    @org.junit.jupiter.api.Test
    void setMyEntities() {
        ArrayList <String> arr = new ArrayList<>();
        arr.add(myDevAmulet.toString());
        myRoom = new BasicRoom(arr);
        assertEquals(myDevAmulet.toString(), arr.get(0));
    }

    @org.junit.jupiter.api.Test
    void getMyEntities() {
        List <String> arr;
        myRoom.addEntity(myDevAmulet.toString());
        arr = myRoom.getMyEntities();
        System.out.println(arr.get(0));
        assertEquals(myDevAmulet.toString(), arr.get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void removeEntity() {
        myRoom.addEntity(myDevAmulet.toString());
        assertEquals(myRoom.toString().contains(myDevAmulet.toString()), true);
        myRoom.removeEntity(myDevAmulet.toString());
        System.out.println(myRoom.toString());
        assertEquals(myRoom.toString().contains(myDevAmulet.toString()),false);
    }

    @org.junit.jupiter.api.Test
    void addEntity() {
        myRoom.addEntity(myDevAmulet.toString());
        System.out.println(myRoom.toString());
        assertEquals(myRoom.toString().contains(myDevAmulet.toString()),true);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(myRoom.toString());
        assertEquals("EmptyRoom", myRoom.toString());
    }
}