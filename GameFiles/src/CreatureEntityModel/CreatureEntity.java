package CreatureEntityModel;

/**
 * A CreatureEntity is a object that returns a string. CreatureEntities are used in a Room Object.
 * CreatureEntities will be the main class that Heros and Monster Inherit from.
 * CreatureEntities all need to abide by the contract that they return a string containing their data.
 * @author Anthony Archie
 * @version 1.0
 */
public interface CreatureEntity {
    String myName = "";
    public String toString();

    String getMyName();

}
