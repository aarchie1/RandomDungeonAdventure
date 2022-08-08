package RoomEntity;

import java.util.ArrayList;

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

    private ArrayList<RoomEntity> myContents;
    private final CreatureCrossover myCreatureCrossover;

    public EntityController(){
        myContents = new ArrayList<>();
        myCreatureCrossover = new CreatureCrossover();
    }

    /**
     * This Method is called on to generate the contents of the starting room.
     * @return
     */
    public ArrayList<RoomEntity> getStartingRoom(){
        myContents = getBasicRoom();
        myContents.add(new DevAmulet());
        addDoor("UP");
        return myContents;
    }

    public ArrayList<RoomEntity> getBasicRoom() {
        myContents = new ArrayList<>();
        myContents.add(WallFactory.UP);
        myContents.add(WallFactory.DOWN);
        myContents.add(WallFactory.LEFT);
        myContents.add(WallFactory.RIGHT);
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
    public boolean isMonster(String theName) {
        return false;
    }

    // Method to add Pillars

    // Method to add healthPotion

    // Method to add visionPotion

    // Method to add door
    public void addDoor(final String theDir) {
        if (DoorFactory.doorGen(theDir) != null){
            myContents.remove(WallFactory.wallGen(theDir));
            myContents.add(DoorFactory.doorGen(theDir));
        }

    }

    // Method to add trap







}
