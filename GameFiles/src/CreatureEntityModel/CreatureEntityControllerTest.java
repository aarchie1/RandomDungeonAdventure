package CreatureEntityModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CreatureEntityModel.DungeonCharacter;


import static org.junit.jupiter.api.Assertions.*;

class CreatureEntityControllerTest {
    CreatureEntityController myHero  = new CreatureEntityController("hero");
    CreatureEntityController myMonster = new CreatureEntityController("Monster");


    @BeforeEach
    void setUp(){
        CreatureEntityController myHero  = new CreatureEntityController("hero");
        CreatureEntityController myMonster = new CreatureEntityController("Monster");
    }

    @Test
    void getCharacterNames() {
        //System.out.println(myHero.getCharacterName());
        assertEquals("Wyze the Warrior", myHero.getCharacterName());
        assertEquals("Gizmo The Gremlin", myMonster.getCharacterName());
    }

    @Test
    void checkAlive() {
        System.out.println(myHero.checkAlive());

    }

    @Test
    void giveItem() {
    }

    @Test
    void useHealthPotion() {
    }

    @Test
    void useVisionPotion() {
    }
}