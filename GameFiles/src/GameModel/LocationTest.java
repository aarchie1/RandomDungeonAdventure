package GameModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the Location class.
 * @author Rowan W Osmon
 * @version 0.01
 */
class LocationTest {

    @Test
    void compare() {
        Location test1 = new Location(0,0);
        Location test2 = new Location(0,0);
        assertEquals(test1, test2);
    }

}