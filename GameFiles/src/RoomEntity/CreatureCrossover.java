package RoomEntity;

/**
 * This Class serves as the bridge between the CreatureEntityModel and the RoomEntityModel.
 * This Class should instantiate a CreatureEntityController in order to make use of the controller
 * to get monster name Strings.
 * This class stores a string of a single monster name. The Entity controller should place a copy of this entity whenever directed to.
 * The EntityController when being asked about a String entity will ask this class if the string in question is a monster name
 *
 * @author Anthony Archie
 * @author Rowan W Osmon
 * @version 0.02
 */
import CreatureEntityModel.CreatureEntityController;

class CreatureCrossover implements RoomEntity {

    String myName;


    CreatureCrossover() {
        myName = "GREMLIN";
    }


    CreatureCrossover addRandMonster(){
        CreatureEntityController myCreatureController = new CreatureEntityController();
        myName = myCreatureController.getMonster();
        return this;
    }

    static Boolean isAMonster(final String theName){
        CreatureEntityController myCreatureController = new CreatureEntityController();
        return myCreatureController.isAMonster(theName);
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
