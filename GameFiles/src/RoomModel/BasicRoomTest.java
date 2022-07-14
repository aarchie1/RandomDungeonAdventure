package RoomModel;

//This is used to test the BasicRoom Class
import static org.junit.jupiter.api.Assertions.*;

class BasicRoomTest {
    Room myRoom = new BasicRoom();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myRoom = new BasicRoom();
    }

    @org.junit.jupiter.api.Test
    void setMyEntitys() {

    }

    @org.junit.jupiter.api.Test
    void getMyEntitys() {
    }

    @org.junit.jupiter.api.Test
    void removeEntity() {
    }

    @org.junit.jupiter.api.Test
    void addEntity() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        System.out.println(myRoom.toString());
        assertEquals("E", myRoom.toString());
    }
}