package RoomEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityControllerTest {
    EntityController ec = new EntityController();

    @BeforeEach
    void setup() {
        ec = new EntityController();
    }

    @Test
    void getStartingRoom() {
        StringBuilder sb = new StringBuilder();
        for (String s: ec.getStartingRoom()) {
            sb.append(s+"\n");
        }
        System.out.println(sb);
    }

    @Test
    void getBasicRoom() {
    }

    @Test
    void addMonster() {
    }

    @Test
    void addHero() {
    }

    @Test
    void removeMonster() {
    }

    @Test
    void isMonster() {
    }

    @Test
    void isItem() {
    }

    @Test
    void isObjective() {
    }

    @Test
    void addObjective() {
    }

    @Test
    void addHealthPotion() {
    }

    @Test
    void addVisionPotion() {
    }

    @Test
    void addDoor() {
    }

    @Test
    void addTrap() {
    }

    @Test
    void loadContents() {
    }

    @Test
    void getContents() {
    }
}