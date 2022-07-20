package GameModel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void compare() {
        Location test1 = new Location(0,0);
        Location test2 = new Location(0,0);
        assertEquals(test1, test2);
    }

}