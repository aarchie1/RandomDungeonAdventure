package RoomEntity;

import CreatureEntityModel.CreatureEntityController;
import GameModel.GameController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureCrossoverTest {

    CreatureCrossover testCross = new CreatureCrossover();
    @BeforeEach
    void setUp() {
        testCross = new CreatureCrossover();
    }

    @Test
    void getMyCreatureController() {

    }

    @Test
    void addMonster() {
        assertNull(testCross.toString());
        testCross.addMonster();
        System.out.println(testCross.toString());

    }

    @Test
    void addHero() {
    }

    @Test
    void testToString() {
    }
}