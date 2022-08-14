package MapModel;

import GameModel.Location;
import RoomModel.Room;
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
        for (int i = 0; i < 5; i++){
            m.setLocal(new Location(i,0));
            System.out.println(m.getFullMap());
        }
        for (int i = 0; i < 5; i++){
            m.setLocal(new Location(0,i));
            System.out.println(m.getRoomAt(m.myLocal));
        }
        System.out.println(m.getFullMap());
    }

    @Test
    void getLocalMap() {
        System.out.println(m.getLocalMap(new Location(0,0)));
    }

    @Test
    void removeEntity() {
        Location l = new Location(0,0);
        Room r = m.getRoomAt(l);
        System.out.println(r);

        m.removeEntity(l, "START");
        System.out.println(m.getRoomAt(l));

    }
}