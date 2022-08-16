package CreatureEntityModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CreatureEntityControllerTest {
    CreatureEntityController myController  = new CreatureEntityController();



    @BeforeEach
    void setUp(){
        myController.createMonster("Gremlin");

    }

    @Test
    void getCharacterNames() {
        assertEquals("warrior", myController.getMyHero().toLowerCase());
        assertEquals("gremlin", myController.getMyMonster().toLowerCase());
    }

    @Test
    void checkAlive() {
        assertEquals(true, myController.checkHeroAlive());
        myController.setHeroDamage(125);
        assertEquals(false, myController.checkHeroAlive());
    }

    @Test
    void giveItem() {
        helperGiveHeroPillars();
        String str =  myController.getMyHeroItems();
        String[] strSplit = str.split(" ");
        ArrayList<String> strList = new ArrayList<String>(
                Arrays.asList(strSplit));
        int heroesItems = strList.size();
        assertEquals(4, heroesItems);
    }
    @Test
    void giveItem2() {
        boolean winCondition = false;
        helperGiveHeroPillars();
        String str =  myController.getMyHeroItems();
        String[] strSplit = str.split(" ");
        ArrayList<String> strList = new ArrayList<String>(
                Arrays.asList(strSplit));
        int heroesItems = strList.size();
        if (strList.contains("Pillar1") && strList.contains("Pillar2") &&
                strList.contains("Pillar3") && strList.contains("Pillar4")) {
            winCondition = true;
        }
        assertEquals(true, winCondition);
    }

    @Test
    void useHealthPotion() {
        String str = "HealthPotion";
        boolean condition = false;
        myController.giveItem(str);
        String heroItems = myController.getMyHeroItems();
        if(str.equals(heroItems.substring(0,heroItems.length()-1))){
            condition = true;
        }
        assertEquals(true , condition);
        myController.setHeroDamage(125);
        assertEquals(false, myController.checkHeroAlive());
        myController.useHealthPotion();
        assertEquals(true, myController.checkHeroAlive());
        System.out.println(myController.checkHeroAlive());
    }

    @Test
    void useVisionPotion() {
        ArrayList<String> strList = new ArrayList<String>();
        String item1 = "VisionPotion";
        boolean condition = false;
        myController.giveItem(item1);
        String heroItems = myController.getMyHeroItems();
        if(item1.equals(heroItems.substring(0,heroItems.length()-1))){
            condition = true;
        }
        assertEquals(true , condition);
        myController.useVisionPotion();
        String str =  myController.getMyHeroItems();
        String[] strSplit = str.split(" ");
        if( strSplit == null){
            strList = new ArrayList<String>(Arrays.asList(strSplit));
        }
        int heroesItems = strList.size();
        assertEquals(0, heroesItems);
    }
    @Test
    void battle1(){
        myController.createMonster("gremlin");
        System.out.println("Hero Status Prior to battle: " + "\n" + myController.getMyHero());
        System.out.println("Begin Fight:");
        myController.fightAMonster("gremlin");
        System.out.println("Hero Status After battle: " + "\n" + myController.getMyHero());
    }



    private void helperGiveHeroPillars() {
        myController.giveItem("Pillar1");
        myController.giveItem("Pillar2");
        myController.giveItem("Pillar3");
        myController.giveItem("Pillar4");
    }

}
