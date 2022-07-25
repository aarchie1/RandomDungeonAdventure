package CreatureEntityModel;


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
    private DungeonCharacter myCharacter;
    private Monster myMonster;
    private Hero myHero;

    public CreatureEntityController(final String theCharacter){
        //Create hero instance
        if(theCharacter.toLowerCase().equals("hero")){
            myHero = new Warrior();
        }
        //Create monster instance
        if(theCharacter.toLowerCase().equals("monster")){
            myCharacter = new Gremlin();
        }
    }

    /**
     * This method returns the creatures name as a String
     * @return String representing the Characters Name.
     */
    public String getCharacterName(){
        return myCharacter.getMyName();
    }

    /**
     * This method makes a call to the Dungeon Character to see if the Character is Alive.
     * @return boolean representing true if the Dungeon Character is alive, and false otherwise
     */
    public boolean checkAlive(){
        if(myCharacter.getMyHitPoints() > 0 ){
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
        myHero.addMyItems(theItem);
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
        }
    }

}
