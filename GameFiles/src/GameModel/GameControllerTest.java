package GameModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class needs to be implemented!
 */
class GameControllerTest {

    GameModelController testGame = new GameModelController();
    @BeforeEach
    void setUp() {
        testGame = new GameModelController();
    }

    @Test
    void newGame() {

    }

    @Test
    void loadGame() {

    }

    @Test
    void saveGame() {

    }

    @Test
    void enterDirection() {

    }

    @Test
    void actionMenu() {
        System.out.println(testGame.actionMenu(""));

    }

    @Test
    void moveLocal() {
        fail();
    }

    @Test
    void setLocal() {
        fail();
    }

    @Test
    void showCurrentRoom() {
        System.out.println(testGame.showCurrentRoom());

    }

    @Test
    void hasWon() {
        fail();
    }
}