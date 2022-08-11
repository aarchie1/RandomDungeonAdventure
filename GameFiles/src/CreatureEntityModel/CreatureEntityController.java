package CreatureEntityModel;


import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Integer.parseInt;

/**
 * This Class is used to control all the CreatureEntities. (Dungeon Characters)
 * This Class is used to produce all the Dungeon Characters and provide the methods
 * to control them.
 * @author Anthony Archie
 * @version .03
 */
public class CreatureEntityController {
    private Monster myMonster;
    private Hero myHero;
    private ArrayList<DungeonCharacter> myCharacters;
    private final static int HEALTH_Potion_Value = 40;

    public CreatureEntityController(){
        myCharacters  = new ArrayList<DungeonCharacter>();
        createHero("warrior");

    }

    /**
     * This method creates and instance of a hero and assigns that hero object to a field of this class
     * @param theHeroName this is a String representing the name of the hero to be created.
     */
    public void createHero(final String theHeroName){
        switch(theHeroName.toLowerCase()){
            case "thief" -> myHero = HeroFactory.spawnHero(HeroFactory.THIEF);
            case "warrior" -> myHero = HeroFactory.spawnHero(HeroFactory.WARRIOR);
            case "priestess" -> myHero = HeroFactory.spawnHero(HeroFactory.PRIESTESS);
        }
        myCharacters.add(myHero);
    }

    /**
     * This method creates and instance of a monster and assigns that hero object to a field of this class.
     * this currently defaults to a gremlin and will be refactored later to handle other monster types.
     */
     public void createMonster(final String theMonsterName){
        switch(theMonsterName.toLowerCase()){
            case "gremlin" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.GREMLIN);
            case "ogre" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.OGRE);
            case "skeleton" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.SKELETON);
        }
        myCharacters.add(myMonster);
    }

     public void removeMonster(final String theMonsterName){
        switch(theMonsterName.toLowerCase()){
            case "gremlin" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.GREMLIN);
            case "ogre" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.OGRE);
            case "skeleton" -> myMonster = MonsterFactory.spawnMonster(MonsterFactory.SKELETON);
        }
        myCharacters.remove(myMonster);
    }

    /**
     * This method is used to get the monster as a String
     * @return String representing the monsters name.
     */
    public String getMyMonster() {
            String m = "";
            try {
                m = myMonster.getMyName();
            } catch (NullPointerException e) {

                m = "No monster in creatureEntityController!";
            }
        return m;
    }

    /**
     * This method is used to get the hero as a String
     * @return String representing the hero's name
     */
    public String getMyHero() {
        return myHero.toString();
    }

    /**
     * This method is a mock method for testing purpose of apply damage to a hero
     * @param theDamage this is an integer representing the amount of damage to be applied to the hero
     */
    public void setHeroDamage(final int theDamage){
        myHero.setDamage(theDamage);
    }


    /**
     * This method is called to fight a monster.
     * It is the public face for the BattleLoop logic
     * It takes a String theMonsterName, which is used to match a monster to its stats.
     * The checkHeroAlive method should be called after this is run
     * @param theMonsterName
     */
    public void fightAMonster(final String theMonsterName) {
        // logic to determine monster - stubbed below - input string, output a Monster
        Monster opponent =  findMonster(theMonsterName);
        if (opponent == null) {
            return;
        }
        BattleLogic bl = new BattleLogic(myHero, opponent);
        int heroHealth = bl.startBattle();
        if ( heroHealth > 0) {
            System.out.println("Hero has slain the monster");
            myHero.setMyHitPoints(heroHealth);
        } else {
            System.out.println("Hero has been slain by the monster");
        }

    }

    /**
     * This method should match a String MonsterName to its matching monster class
     * It should fail-safe into a default monster
     * This method should be private and is used by the fightAMonster method
     * @param theMonsterName a string of the monster name
     * @return the MonsterClass for use in battleLogic
     */
    private Monster findMonster(final String theMonsterName) {
        Iterator i = myCharacters.iterator();
        while(i.hasNext()){
           DungeonCharacter d = (DungeonCharacter) i.next();
            if (d.getMyName().equalsIgnoreCase(theMonsterName)){
                return (Monster) d;
            }
        }
        // Default fail safe
        Monster theMonster = MonsterFactory.spawnMonster(MonsterFactory.GREMLIN);
        return theMonster;
    }

    /**
     * This method is for returning a copy of the items a hero has as a String.
     * Credit to tutorial point for the code on Creating a string from a ArrayList
     *  https://www.tutorialspoint.com/How-to-create-a-string-from-a-Java-
     *     ArrayList#:~:text=To%20convert%20the%20contents%20of,using%20the%20toString()%20method.
     * @return String representing the hero's items
     */
    public String getMyHeroItems(){
        ArrayList<String> al = myHero.getMyItems();
        StringBuffer sb = new StringBuffer();
        for (String s : al) {
            sb.append(s);
            sb.append(" ");
        }
        String str = sb.toString();
        return str;
    }

    /**
     * This method makes a call to the Dungeon Character to see if the Character is Alive.
     * @return boolean representing true if the Dungeon Character is alive, and false otherwise
     */
    public boolean checkHeroAlive(){
        if(myHero.getMyHitPoints() > 0 ){
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method interacts with the Dungeon Characters arraylist of items to add items.
     * @param theItem this is a String representing the item to be given to the player
     * @return this is an integer representing the number of items a player has
     */
    public int giveItem(final String theItem){
        if(theItem.equals("HealthPotion")){
            myHero.setMyHealthPotions(myHero.getMyHealthPotions() + 1);
            myHero.addMyItems(theItem);
        } else if(theItem.equals("VisionPotion")){
            myHero.setMyVisionPotions(myHero.getMyVisionPotions() + 1);
            myHero.addMyItems(theItem);
        } else {
            myHero.addMyItems(theItem);
        }
        return myHero.getMyItems().size();
    }

    /**
     * This method takes a String representing the health potions value and applies it to the
     * players HP
     * @param thePotionValue this is a String that represents the value of the health potion
     */
    public void useHealthPotion(){
        if( myHero.getMyHealthPotions() > 0){
            myHero.setMyHealthPotions(myHero.getMyHealthPotions() - 1);
            myHero.setMyHitPoints(myHero.getMyHitPoints() + HEALTH_Potion_Value);
            myHero.removeMyItems("HealthPotion");
        }
    }

    /**
     * This method is called when using a vision potion. Its main purpose is to update
     * the count of player vision potions as the logic for using this type of potion
     * lives in the MapModel package.
     */
    public void useVisionPotion(){
        if( myHero.getMyVisionPotions() > 0){
            myHero.setMyVisionPotions(myHero.getMyVisionPotions() - 1);
            myHero.removeMyItems("VisionPotion");
        }
    }

}
