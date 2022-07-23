package CreatureEntityModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import CreatureEntityModel.DungeonCharacter;


import static org.junit.jupiter.api.Assertions.*;

class CreatureEntityControllerTest {
    CreatureEntityController myHero  = new CreatureEntityController("hero");
    CreatureEntityController myMonster = new CreatureEntityController("Monster");

    public void setHPHelper(CreatureEntityController theCharacter, int theHP){
        theCharacter.setMyHitPoints(theHP);
    }

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
        setHPHelper(myHero, 0);
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