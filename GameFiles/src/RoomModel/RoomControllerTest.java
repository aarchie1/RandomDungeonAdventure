package RoomModel;

import RoomEntity.EntityController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoomControllerTest {
    RoomController rC = new RoomController();
    EntityController eC = new EntityController();

    @BeforeEach
    void setUp() {
        rC = new RoomController();
    }

    @Test
    void startRoom() {
        Room start = rC.startRoom();
        System.out.println(start.toString());
        List<String> expectedContents = eC.getStartingRoom();
        System.out.println(expectedContents);
        List<String> actualContents = start.getMyEntities();
        assertEquals(expectedContents.size(), actualContents.size());
        if (expectedContents.size() == actualContents.size()){
            for (int i = 0; i < actualContents.size();i++){
                assertEquals(expectedContents.get(i), actualContents.get(i));

            }
        }
    }

    @Test
    void genericRoom() {
        Room start = rC.genericRoom();
        System.out.println(start.toString());
        List<String> expectedContents = eC.getBasicRoom();
        System.out.println(expectedContents);
        List<String> actualContents = start.getMyEntities();
        assertEquals(expectedContents.size(), actualContents.size());
        if (expectedContents.size() == actualContents.size()){
            for (int i = 0; i < actualContents.size();i++){
                assertEquals(expectedContents.get(i), actualContents.get(i));

            }
        }
    }

    @Test
    void generateRoom() {
        Room start = rC.generateRoom("OBJECTIVE");
        System.out.println(start.toString());
        List<String> expectedContents = eC.getStartingRoom();
        System.out.println(expectedContents);
        List<String> actualContents = start.getMyEntities();
        assertEquals(expectedContents.size(), actualContents.size());
        if (expectedContents.size() == actualContents.size()){
            for (int i = 0; i < actualContents.size();i++){
                assertEquals(expectedContents.get(i), actualContents.get(i));

            }
        }
    }

    @Test
    void doorCheck() {

    }

    @Test
    void removeMonsters() {
    }
}