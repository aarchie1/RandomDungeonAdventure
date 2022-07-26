package RoomEntity;

/**
 * This Class serves as the bridge between the CreatureEntityModel and the RoomEntityModel.
 * This Class should instantiate a CreatureEntityController in order to make use of the controller
 * to place monster and heroes in rooms as necessary.
 * @author Anthony Archie
 * @author Rowan W Osmon
 * @version .01
 */
import CreatureEntityModel.CreatureEntityController;

public class CreatureCrossover implements RoomEntity {
    private final CreatureEntityController myCreatureController;


    CreatureCrossover(final String theCharacter){
        myCreatureController = new CreatureEntityController();
    }

    @Override
    public String toString() {
        return myCreatureController.getMyHero() + "\n" + myCreatureController.getMyMonster();
    }

}
