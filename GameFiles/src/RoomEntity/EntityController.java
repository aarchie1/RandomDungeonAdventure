package RoomEntity;

import CreatureEntityModel.CreatureEntityController;

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

    private boolean areMonstersDefeated;
    private ArrayList<RoomEntity> myContents = new ArrayList<>();
    private final CreatureCrossover myCreatureCrossover = new CreatureCrossover();

    public EntityController(){
        areMonstersDefeated = false;
    }

    // Method to get starting room
    public ArrayList<RoomEntity> getStartingRoom(){
        myContents = new ArrayList<>();
        addHero();
        myContents.add(myCreatureCrossover);
        myContents.add(new DevAmulet());
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

    // Method to remove Hero when leaving the room

    // Method to add Pillars

    // Method to add healthPotion

    // Method to add visionPotion

    // Method to add door

    // Method to add trap







}
