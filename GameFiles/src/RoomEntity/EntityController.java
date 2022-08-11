package RoomEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * This Class is used to control all RoomEntity's
 * It is intended to use this class to produce
 *      the RoomEntities needed by other classes.
 * RoomEntities are anything in the room.
 * This includes Items, Monsters, Objectives, Traps,
 *      DungeonFeatures, and if the Room is empty a description
 *      of that EmptyRoom.
 * @author Rowan W Osmon
 * @author Anthony Archie
 * @version .03
 */
public class EntityController {

    private static final int TRAP_DAMAGE = 10;
    private List<RoomEntity> myContents;
    private final CreatureCrossover myCreatureCrossover;

    public EntityController(){
        myContents = new ArrayList<>();
        myCreatureCrossover = new CreatureCrossover();
    }

    /**
     * This Method is called on to generate the contents of the starting room.
     *
     * @return
     */
    public List<RoomEntity> getStartingRoom(){
        myContents = getBasicRoom();
        myContents.add(new DevAmulet());
        addDoor("w");
        return myContents;
    }

    /**
     * This method is called on each room first. It adds 4 walls to the room.
     * @return
     */
    public List<RoomEntity> getBasicRoom() {
        myContents = new ArrayList<>();
        myContents.add(WallFactory.WALLUP);
        myContents.add(WallFactory.WALLDOWN);
        myContents.add(WallFactory.WALLLEFT);
        myContents.add(WallFactory.WALLRIGHT);
        return myContents;
    }

    // Method to addMonster
    public void addMonster(){
        myCreatureCrossover.addMonster();
    }

    // Method to addHero
    public void addHero (){
        myCreatureCrossover.addHero();
    }

    // Method to Remove Monster
    public void removeMonster(final String theMonsterName){
        myCreatureCrossover.removeMonster(theMonsterName);
    }

    /**
     * This method should be used to determine if a string theName is a monster
     * If it is a match return true.
     * else false.
     * @param theName the string for the monster name to look for.
     * @return true if the name matches a monster, false otherwise
     */
    public boolean isMonster(final String theName) {
        boolean flag;
        switch(theName.toLowerCase()){
            case "gremlin" -> flag = true;
            case "ogre" -> flag = true;
            case "skeleton" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This method should be used to determine if a string theName is an item
     * If it is a match return true.
     * else false.
     * @param theName the string for the item name to look for.
     * @return true if the name matches an item, false otherwise
     */
    public boolean isItem(final String theName) {
        boolean flag;
        switch(theName.toLowerCase()){
            case "visionpot" -> flag = true;
            case "healpot" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This method should be used to determine if a string theName is an objective
     * If it is a match return true.
     * else false.
     * @param theName the string for the objective name to look for.
     * @return true if the name matches an objective, false otherwise
     */
    public boolean isObjective(final String theName){
        boolean flag;
        switch(theName.toLowerCase()){
            case "objective" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This method should be used to determine if a string theName is a wall
     * If it is a match return true.
     * else false.
     * @param theName the string for the wall to look for.
     * @return true if the name matches a wall, false otherwise
     */
    private boolean isWall(final String theName) {
        boolean flag;
        switch(theName.toLowerCase()){
            case "wallup" -> flag = true;
            case "walldown" -> flag = true;
            case "wallleft" -> flag = true;
            case "wallright" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This method should be used to determine if a string theName is a door
     * If it is a match return true.
     * else false.
     * @param theName the string for the door to look for.
     * @return true if the name matches a door, false otherwise
     */
    private boolean isDoor(final String theName) {
        boolean flag;
        switch(theName.toLowerCase()){
            case "doorup" -> flag = true;
            case "doordown" -> flag = true;
            case "doorleft" -> flag = true;
            case "doorright" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    private boolean isTrap(String theName) {
        boolean flag;
        switch(theName.toLowerCase()){
            case "trap" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This method adds a Pillar to the players inventory
     */
    public void addObjective(){
        Item myItem = ItemFactory.spawnItem(ItemFactory.OBJECTIVE);
        myCreatureCrossover.getMyCreatureController().giveItem(myItem.toString());
        myContents.remove(myItem);
    }

    /**
     * This method adds a health potion to the players inventory
     */
    public void addHealthPotion(){
        Item myItem = ItemFactory.spawnItem(ItemFactory.HEALPOT);
        myCreatureCrossover.getMyCreatureController().giveItem(myItem.toString());
        myContents.remove(myItem);
    }

    /**
     * This method adds a vision potion to the players inventory
     */
    public void addVisionPotion(){
        Item myItem = ItemFactory.spawnItem(ItemFactory.VISONPOT);
        myCreatureCrossover.getMyCreatureController().giveItem(myItem.toString());
        myContents.remove(myItem);
    }

    // Method to add door
    public void addDoor(final String theDir) {
        if (DoorFactory.getDoor(theDir) != null){
            myContents.remove(WallFactory.getWall(theDir));
            myContents.add(DoorFactory.getDoor(theDir));
        }
    }

    private void addWall(final String theDir) {
        if (WallFactory.getWall(theDir) != null){
            myContents.add(WallFactory.getWall(theDir));
        }
    }

    /**
     * This method adds a Trap to the room and applys damage to the hero.
     */
    public void addTrap(){
        Item myItem = ItemFactory.spawnItem(ItemFactory.TRAP);
        myContents.add(myItem);
    }

    /**
     * This method should create a room with the contents of the List.
     * Each string should represent a single door, wall, item, or monster
     * This method should match the requested string with the correct enum object.
     * @param theContents A list of the RoomEntities to be manipulated by the controller.
     */
    public void LoadContents(final List<String> theContents) {
        for(String s: theContents){
            if (isMonster(s)){
                addMonster();
            } else if(isItem(s)){
                if (s.equalsIgnoreCase("visionpot")){
                    addVisionPotion();
                }else {
                    addHealthPotion();
                }
            } else if(isObjective(s)){
                addObjective();
            } else if(isWall(s)){
                switch(s){
                    case "wallup" -> addWall("up");
                    case "walldown" -> addWall("down");
                    case "wallleft" -> addWall("left");
                    case "wallright" -> addWall("right");
                }
            } else if (isDoor(s)){
                switch(s){
                    case "doorup" -> addDoor("up");
                    case "downdoor" -> addDoor("down");
                    case "doorleft" -> addDoor("left");
                    case "doorightr" -> addDoor("right");
                }
            } else if (isTrap(s)){
                addTrap();
            }
        }
    }

    public List<String> getContents(){
        List<String> theNames = new ArrayList<>();
        for (RoomEntity e : myContents){
            theNames.add(e.getMyName());
        }
        return theNames;
    }



}
