package CreatureEntityModel;


import java.util.ArrayList;

import static java.lang.Integer.parseInt;

/**
 * This Class is used to control all the CreatureEntities. (Dungeon Characters)
 * It needs all methods stubbed out
 * This Class is used to produce all the Dungeon Characters and provide the methods
 * to control them.
 * @author Anthony Archie
 * @version .02
 */
public class CreatureEntityController {
    private Monster myMonster;
    private Hero myHero;

    public CreatureEntityController(){

    }

    // Method for creating instance of a hero
    public void createHero(){
        myHero = new Warrior();
    }

    // Method for creating instance of a monster
    public void createMonster(){
        myMonster = new Gremlin();
    }

    // Method for retrieving current monsters name
    public String getMyMonster() {
        return myMonster.getMyName();
    }

    //Method for retreiving current heros name
    public String getMyHero() {
        return myHero.getMyName();
    }

    // Method for testing purposes
    public void setHeroDamage(final int theDamage){
        myHero.setDamage(theDamage);
    }

    // Method for testing purpose, maybe leave in depending on team decision
    // Credit to tutorial point for the code on Creating a string from a ArrayList
    // https://www.tutorialspoint.com/How-to-create-a-string-from-a-Java-ArrayList#:~:text=To%20convert%20the%20contents%20of,using%20the%20toString()%20method.
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
    public void useHealthPotion(final String thePotionValue){
        if( myHero.getMyHealthPotions() > 0){
            myHero.setMyHealthPotions(myHero.getMyHealthPotions() - 1);
            myHero.setMyHitPoints(myHero.getMyHitPoints() + parseInt(thePotionValue));
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
