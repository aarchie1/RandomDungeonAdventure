package CreatureEntityModel;

/**
 * Inherits from CreatureEntityModel and is abstract
 * A hero never gets fewer attacks than a monster
 * A hero has a chance to block an attack. (int)
 * Calls super constructor and has a constructor for Hero specific fields.
 * A hero has regular attacks and a special skill
 * @author Anthony Archie
 * @version 1.0
 */
public class Hero extends DungeonCharacter {
    private final double myBlockAccuracy;
    private final String myRegularAttack;
    private final String mySpecialAttack;


    /**
     *
     * @param theName this is the name of the Dungeon Character.
     * @param theHitPoints this is the amount of Hit Points/Health a Dungeon Character has.
     * @param theDamageRangeMin this is the minimum range for the Dungeon Characters Damage.
     * @param theDamageRangeMax this is the maximum range for the Dungeon Characters Damage.
     * @param theAttackSpeed this is the attack speed for the Dungeon Character.
     * @param theAttackAccuracy this is the attack accuracy for the Dungeon Character.
     * @param theBlockAccuracy this is the block accuracry for the Dungeon Hero.
     * @param theRegularAttack this is the regular attack for the Dungeon Hero.
     * @param theSpecialAttack this is the special attack for the Dungeon Hero.
     */
    public Hero(final String theName, int theHitPoints, final int theDamageRangeMin, final int theDamageRangeMax,
                int theAttackSpeed, double theAttackAccuracy, final double theBlockAccuracy,
                final String theRegularAttack, final String theSpecialAttack) {
        super(theName, theHitPoints, theDamageRangeMin, theDamageRangeMax, theAttackSpeed, theAttackAccuracy);
        myBlockAccuracy = theBlockAccuracy;
        myRegularAttack = theRegularAttack;
        mySpecialAttack = theSpecialAttack;
    }

    /**
     * Calls Super toString Method and adds data specific to the Hero Class
     * @return A string representing the data of the Hero/Dungeon Character
     */
    @Override
    public String toString() {
        // String concatenation
        super.toString();
        return "Hero{" +
                "myBlockAccuracy=" + myBlockAccuracy +
                ", myRegularAttack='" + myRegularAttack + '\'' +
                ", mySpecialAttack='" + mySpecialAttack + '\'' +
                '}';
    }

    public double getMyBlockAccuracy() {
        return myBlockAccuracy;
    }

    public String getMyRegularAttack() {
        return myRegularAttack;
    }

    public String getMySpecialAttack() {
        return mySpecialAttack;
    }
}
