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
 * @version .02
 */
public class EntityController {
    private boolean areMonstersDefeated;
    private ArrayList<RoomEntity> myContents = new ArrayList<>();
    public EntityController(){
        areMonstersDefeated = false;
    }


    public RoomEntity addMonster(){
        RoomEntity myCreature = new CreatureCrossover("monster");
        return myCreature;
    }

    public ArrayList<RoomEntity> getStartingRoom(){
        myContents = new ArrayList<>();
        myContents.add(new DevAmulet());
        return myContents;
    }

    // Method to addHero
    public RoomEntity addHero (){
        RoomEntity myCreature = new CreatureCrossover("hero");
        return myCreature;
    }

    // Method to Remove Monster
    public void removeMonster(){

    }
    // Method to remove Hero when leaving the room

    // Method to add Pillars

    // Method to add healthPotion

    // Method to add visionPotion

    // Method to add door

    // Method to add trap







}
