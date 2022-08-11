package MapModel;

import GameModel.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapControllerTest {
    MapController m = new MapController();
    @BeforeEach
    void setup(){
        m = new MapController();
    }
    @Test
    void setLocal() {

    }

    @Test
    void getRoomAt() {
    }

    @Test
    void getFullMap() {
        System.out.println(m.getFullMap());
        m.setLocal(new Location(2,2));
        System.out.println(m.getFullMap());
    }

    @Test
    void getLocalMap() {
        System.out.println(m.getLocalMap(new Location(0,0)));
    }
}