package RoomModel;

//This is used to test the BasicRoom Class

import RoomEntity.DevAmulet;
import RoomEntity.Item;
import RoomEntity.RoomEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicRoomTest {
    Room myRoom = new BasicRoom();
    Item myDevAmulet = new DevAmulet();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myRoom = new BasicRoom();
    }

    @org.junit.jupiter.api.Test
    void setMyEntitys() {
        List <RoomEntity> arr = new ArrayList<>();
        arr.add(myDevAmulet);
        myRoom = new BasicRoom(arr);
        assertEquals(myDevAmulet.toString(), arr.get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void getMyEntitys() {
        List <RoomEntity> arr;
        myRoom.addEntity(myDevAmulet);
        arr = myRoom.getMyEntitys();
        System.out.println(arr.get(0));
        assertEquals(myDevAmulet.toString(), arr.get(0).toString());
    }

    @org.junit.jupiter.api.Test
    void removeEntity() {
        Item myI = new Item("theTestItem");

        myRoom.addEntity(myDevAmulet);
        myRoom.addEntity(myI);
        myRoom.removeEntity(myDevAmulet.toString());
        System.out.println(myRoom.toString());
        assertEquals(myI.toString(), myRoom.toString());
    }

    @org.junit.jupiter.api.Test
    void addEntity() {
        myRoom.addEntity(new DevAmulet());
        System.out.println(myRoom.toString());
        assertEquals("DevAmulet", myRoom.toString());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(myRoom.toString());
        assertEquals("Empty Room", myRoom.toString());
    }
}