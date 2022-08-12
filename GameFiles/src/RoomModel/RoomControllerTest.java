package RoomModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomControllerTest {
    RoomController rC = new RoomController();

    @BeforeEach
    void setUp() {
        rC = new RoomController();
    }

    @Test
    void startRoom() {
        Room start = rC.startRoom();
        System.out.println(start.toString());
    }

    @Test
    void genericRoom() {
    }

    @Test
    void generateRoom() {
    }

    @Test
    void doorCheck() {
    }

    @Test
    void removeMonsters() {
    }
}