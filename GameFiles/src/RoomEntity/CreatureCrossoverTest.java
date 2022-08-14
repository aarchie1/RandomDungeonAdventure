package RoomEntity;

import CreatureEntityModel.CreatureEntityController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tester for Creature Crossover methods
 * @author Rowan W Osmon
 * @version 0.01
 */
class CreatureCrossoverTest {

    CreatureCrossover testCross = new CreatureCrossover();
    CreatureEntityController monsterData = new CreatureEntityController();
    @BeforeEach
    void setUp() {
        testCross = new CreatureCrossover();
        monsterData = new CreatureEntityController();
    }

    @Test
    void testToString() {
        assertEquals(testCross.toString(), "GREMLIN");
    }

    @Test
    void addRandMonster() {
        testCross = testCross.addRandMonster();
        //System.out.println(testCross.toString());
        assertTrue(monsterData.isAMonster(testCross.toString()));
    }

    @Test
    void isAMonster() {
        for (int i = 0; i < 100; i++){
            testCross.addRandMonster();
            System.out.println(testCross.addRandMonster());
            assertTrue(monsterData.isAMonster(testCross.toString()));
        }
    }

    @Test
    void getMyName() {
        assertTrue(testCross.getMyName().equalsIgnoreCase("GREMLIN"));
    }
}