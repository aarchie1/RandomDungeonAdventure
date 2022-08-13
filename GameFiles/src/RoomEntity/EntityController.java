package RoomEntity;

import java.util.ArrayList;
import java.util.List;

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
    private CreatureCrossover myCreatureCrossover;

    public EntityController(){
        myCreatureCrossover = new CreatureCrossover();
    }

    /**
     * This Method is called on to generate the contents of the starting room.
     *
     * @return
     */
    public ArrayList<String> getStartingRoom(){
        ArrayList<RoomEntity> myContents = basicRoom();
        myContents.add(ItemFactory.DEVAMULET);
        myContents = addDoor(myContents,"w");
        return getContents(myContents);
    }

    /**
     * This method is called on each room first. It adds 4 walls to the room.
     * @return
     */
    private ArrayList<RoomEntity> basicRoom() {
        ArrayList<RoomEntity> myContents = new ArrayList<>();
        myContents.add(WallFactory.WALLUP);
        myContents.add(WallFactory.WALLDOWN);
        myContents.add(WallFactory.WALLLEFT);
        myContents.add(WallFactory.WALLRIGHT);
        return myContents;
    }
    public ArrayList<String> getBasicRoom(){
        return getContents(basicRoom());
    }

    // Method to addMonster
    private CreatureCrossover addMonster(final String theName){
        return new CreatureCrossover();
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

        return ItemFactory.isItem(theName);
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

    public boolean isExit(final String theName) {
        boolean flag;
        switch (theName.toLowerCase()) {
            case "exit" -> flag = true;
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
    public boolean isDoor(final String theName) {
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

    public boolean isTrap(String theName) {
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
    private ArrayList<RoomEntity> addObjective(ArrayList<RoomEntity> myContents){

        Item myItem = ItemFactory.spawnItem(ItemFactory.OBJECTIVE);
        myCreatureCrossover.getMyCreatureController().giveItem(myItem.toString());
        myContents.remove(myItem);
        return myContents;
    }

    /**
     * This method adds a health potion to the players inventory
     */
    private Item addHealthPotion(){
        return ItemFactory.spawnItem(ItemFactory.HEALPOT);
    }

    /**
     * This method adds a vision potion to the players inventory
     */
    private ArrayList<RoomEntity> addVisionPotion(ArrayList<RoomEntity> myContents){
        Item myItem = ItemFactory.spawnItem(ItemFactory.VISONPOT);
        myCreatureCrossover.getMyCreatureController().giveItem(myItem.toString());
        myContents.remove(myItem);
        return myContents;
    }

    // Method to add door
    public ArrayList<RoomEntity> addDoor(ArrayList<RoomEntity> myContents, final String theDir) {
        if (DoorFactory.getDoor(theDir) != null){
            myContents.remove(WallFactory.getWall(theDir));
            myContents.add(DoorFactory.getDoor(theDir));
        }
        return myContents;
    }

    private ArrayList<RoomEntity> addWall(ArrayList<RoomEntity> myContents, final String theDir) {
        if (WallFactory.getWall(theDir) != null){
            myContents.add(WallFactory.getWall(theDir));
        }
        return myContents;
    }

    /**
     * This method adds a Trap to the room and applys damage to the hero.
     */
    private ArrayList<RoomEntity> addTrap(ArrayList<RoomEntity> myContents){
        Item myItem = ItemFactory.spawnItem(ItemFactory.TRAP);
        myContents.add(myItem);
        return myContents;
    }

    /**
     * This method should create a room with the contents of the List.
     * Each string should represent a single door, wall, item, or monster
     * This method should match the requested string with the correct enum object.
     * @param theContents A list of the RoomEntities to be manipulated by the controller.
     */
    public ArrayList <RoomEntity> LoadContents(final List<String> theContents) {
        ArrayList <RoomEntity> myContents = new ArrayList<>();
        for(String s: theContents){
            if (isMonster(s)){
                myContents.add(new CreatureCrossover());
            } else if(isItem(s)){
                myContents.add(ItemFactory.spawnItem(s));
            }else if(isWall(s)){
                switch(s){
                    case "wallup" -> myContents = addWall(myContents,"w");
                    case "walldown" -> myContents = addWall(myContents,"s");
                    case "wallleft" -> myContents = addWall(myContents,"a");
                    case "wallright" -> myContents = addWall(myContents,"d");
                }
            } else if (isDoor(s)){
                switch(s){
                    case "doorup" -> myContents = addDoor(myContents,"w");
                    case "downdoor" -> myContents = addDoor(myContents,"s");
                    case "doorleft" -> myContents = addDoor(myContents,"a");
                    case "doorightr" -> myContents = addDoor(myContents,"d");
                }
            } else if (isTrap(s)){
                myContents = addTrap(myContents);
            }
        }
        return myContents;
    }

    public ArrayList<String> getContents(List <RoomEntity> theContents){
        ArrayList<String> theNames = new ArrayList<>();
        for (RoomEntity e : theContents){
            theNames.add(e.getMyName());
        }
        return theNames;
    }


    public ArrayList<String> getEndRoom() {
        ArrayList<RoomEntity> myContents = basicRoom();

        myContents.add(ItemFactory.spawnItem(ItemFactory.EXIT));
        myContents = addDoor(myContents,"w");
        return getContents(myContents);
    }

    public ArrayList<String> getObjectiveRoom() {
        ArrayList<RoomEntity> myContents = basicRoom();

        return getContents(myContents);
    }
}
