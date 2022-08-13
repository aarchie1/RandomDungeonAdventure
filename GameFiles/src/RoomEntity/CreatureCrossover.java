package RoomEntity;

/**
 * This Class serves as the bridge between the CreatureEntityModel and the RoomEntityModel.
 * This Class should instantiate a CreatureEntityController in order to make use of the controller
 * to place monster and heroes in rooms as necessary.
 * @author Anthony Archie
 * @author Rowan W Osmon
 * @version 0.01
 */
import CreatureEntityModel.CreatureEntityController;

class CreatureCrossover implements RoomEntity {

    String myName;
    private CreatureEntityController myCreatureController;

    CreatureCrossover() {
        myCreatureController = new CreatureEntityController();
        myName = "GREMLIN";
    }


    public CreatureEntityController getMyCreatureController() {
        return myCreatureController;
    }


    public CreatureCrossover addMonster(){
        myName = myCreatureController.getMonster();
        return this;
    }

    @Override
    public String toString() {
        return getMyName();
    }


    @Override
    public String getMyName() {
        return myName;
    }

}
