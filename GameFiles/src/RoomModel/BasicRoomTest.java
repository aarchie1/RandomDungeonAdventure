package RoomModel;

import RoomEntity.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is used to test the BasicRoom Class
 * @author Rowan W Osmon
 * @version 0.01
 */
class BasicRoomTest {
    Room myRoom = new BasicRoom();
    Item myDevAmulet = new DevAmulet();

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
        Item myI = new Item("theTestItem");

        myRoom.addEntity(myDevAmulet.toString());
        myRoom.addEntity(myI.toString());
        myRoom.removeEntity(myDevAmulet.toString());
        System.out.println(myRoom.toString());
        assertEquals(myI.toString(), myRoom.toString());
    }

    @org.junit.jupiter.api.Test
    void addEntity() {
        myRoom.addEntity(new DevAmulet().toString());
        System.out.println(myRoom.toString());
        assertEquals("DevAmulet", myRoom.toString());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(myRoom.toString());
        assertEquals("EmptyRoom", myRoom.toString());
    }
}