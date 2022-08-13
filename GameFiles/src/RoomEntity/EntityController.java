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
    private RoomEntity addObjective(){
        return ItemFactory.spawnItem(ItemFactory.OBJECTIVE);
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
    private Item addVisionPotion(){
        return ItemFactory.spawnItem(ItemFactory.VISONPOT);
    }

    /**
     * This method places a door in the indicated direction.
     * This method takes the arraylist as it need to remove a wall when it adds a door.
     *
     * @param myContents The List of RoomEntitys that you want the door placed in.
     * @param theDir The direction you want the door in.
     * @return the modified list.
     */
    public ArrayList<RoomEntity> addDoor(ArrayList<RoomEntity> myContents, final String theDir) {
        if (DoorFactory.getDoor(theDir) != null){
            myContents.remove(WallFactory.getWall(theDir));
            myContents.add(DoorFactory.getDoor(theDir));
        }
        return myContents;
    }


    private RoomEntity addWall(final String theDir) {
        return WallFactory.spawnWall(WallFactory.getWall(theDir));
    }

    /**
     * This method adds a Trap to the room and applys damage to the hero.
     */
    private RoomEntity addTrap(){
        return ItemFactory.spawnItem(ItemFactory.TRAP);
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
                myContents.add(addWall(s));
            } else if (isDoor(s)){
                myContents = addDoor(myContents,s);
            } else if (isTrap(s)){
                myContents.add(addTrap());
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
