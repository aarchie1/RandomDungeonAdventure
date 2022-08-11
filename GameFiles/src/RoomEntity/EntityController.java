package RoomEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is used to control all RoomEntity's
 * It needs all methods stubbed out
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
        addDoor("UP");
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
    public void removeMonster(){

    }

    /**
     * This method should be used to determine if a string theName is a monster
     * If it is a matcu return true.
     * else false.
     * @param theName the string for the monster name to look for.
     * @return true if the name matches a monster, false otherwise
     */
    public boolean isMonster(final String theName) {
        return false;
    }

    // Method to add Pillars

    // Method to add healthPotion

    // Method to add visionPotion

    // Method to add door
    public void addDoor(final String theDir) {
        if (DoorFactory.getDoor(theDir) != null){
            myContents.remove(WallFactory.getWall(theDir));
            myContents.add(DoorFactory.getDoor(theDir));
        }

    }

    /**
     * This method should create a room with the contents of the List.
     * Each string should represent a single door, wall, item, or monster
     * This method should match the requested string with the correct enum object.
     * @param theContents A list of the RoomEntities to be manipulated by the controller.
     */
    public void LoadContents(final List<String> theContents) {

    }

    public List<String> getContents(){
        List<String> theNames = new ArrayList<>();
        for (RoomEntity e : myContents){
            theNames.add(e.getMyName());
        }
        return theNames;
    }

    // Method to add trap







}
