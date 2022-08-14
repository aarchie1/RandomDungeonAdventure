package RoomEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    public EntityController(){
    }

    /**
     * This Method is called on to generate the contents of the starting room.
     *
     * @return An ArrayList of Strings that are the keyword contents of the room.
     */
    public ArrayList<String> getStartingRoom(){
        ArrayList<RoomEntity> myContents = basicRoom();
        myContents.add(ItemFactory.DEVAMULET);
        myContents = addDoor(myContents,"w");
        return getContents(myContents);
    }

    /**
     * This method is called on each room first. It adds 4 walls to the room.
     * @return A List of RoomEntities that are common to all rooms
     */
    private ArrayList<RoomEntity> basicRoom() {
        ArrayList<RoomEntity> myContents = new ArrayList<>();
        myContents.add(WallFactory.WALLUP);
        myContents.add(WallFactory.WALLDOWN);
        myContents.add(WallFactory.WALLLEFT);
        myContents.add(WallFactory.WALLRIGHT);
        return myContents;
    }

    private ArrayList<RoomEntity> randomRoom() {
        ArrayList<RoomEntity> myContents = basicRoom();
        Random r = new Random();
        int roll = r.nextInt(0,6);
        if (roll >= 3) {
            CreatureCrossover c = new CreatureCrossover();
            c.addRandMonster();
            myContents.add(c);
        }
        roll = r.nextInt(0,6);
        if(roll >= 4) {
            myContents.add(ItemFactory.spawnItem(ItemFactory.HEALPOT));
        }
        roll = r.nextInt(0,6);
        if (roll >= 5) {
            myContents.add(ItemFactory.spawnItem(ItemFactory.VISONPOT));
        }
        roll = r.nextInt(0,6);
        if (roll == 6) {
            myContents.add(ItemFactory.spawnItem(ItemFactory.TRAP));
        }
        return myContents;
    }

    /**
     * Get a list of elements common to all rooms.
     * @return an arraylist of strings that are the contents of the room
     */
    public ArrayList<String> getBasicRoom(){
        return getContents(basicRoom());
    }

    public ArrayList<String> getRandomRoom() {
        return getContents(randomRoom());
    }

    /**
     * This method should be used to determine if a string theName is a monster
     * If it is a match return true.
     * else false.
     * @param theName the string for the monster name to look for.
     * @return true if the name matches a monster, false otherwise
     */
    public boolean isMonster(final String theName) {
        return CreatureCrossover.isAMonster(theName);
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
        flag = "objective".equalsIgnoreCase(theName);
        return flag;
    }

    public boolean isExit(final String theName) {
        boolean flag;
        flag = "exit".equalsIgnoreCase(theName);
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
            case "wallup", "walldown", "wallleft", "wallright" -> flag = true;
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
            case "doorup", "doordown", "doorleft", "doorright" -> flag = true;
            default -> flag = false;
        }
        return flag;
    }

    /**
     * This Method returns true if the string matchs a trap
     * @param theName keyword to look for
     * @return true if the keyword is a trap, else false
     */
    public boolean isTrap(final String theName) {
        boolean flag;
        flag = "trap".equalsIgnoreCase(theName);
        return flag;
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
        ArrayList <String> myContents = getRandomRoom();
        myContents.add(ItemFactory.OBJECTIVE.toString());
        return myContents;
    }
}
