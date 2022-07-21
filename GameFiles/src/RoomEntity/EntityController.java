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
 *
 */
public class EntityController {
    private boolean areMonstersDefeated;
    private ArrayList<RoomEntity> myContents = new ArrayList<>();
    public EntityController(){
        areMonstersDefeated = false;
    }


    public RoomEntity addMonster(){
        RoomEntity myCreature = new CreatureCrossover();
        return myCreature;
    }

    public ArrayList<RoomEntity> getStartingRoom(){
        myContents = new ArrayList<>();
        myContents.add(new DevAmulet());
        return myContents;
    }





}
