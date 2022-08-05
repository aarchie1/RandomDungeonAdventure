package CreatureEntityModel;

import java.util.Random;

/**
 * Inherits from CreatureEntityModel and is abstract
 * Calls super constructor and has a constructor for Monster Specific Skills
 * Monsters have the ability to heal, which is based on chance and heals a specific amount of HP
 * @author Anthony Archie
 * @version 1.0
 */
public class Monster extends DungeonCharacter{
    private final double myHealingPercentage;
    private final int myHealPointRangeMin;
    private final int myHealPointRangeMax;

    /**
     * @param theName           this is the name of the Dungeon Character.
     * @param theHitPoints      this is the amount of Hit Points/Health a Dungeon Character has.
     * @param theDamageRangeMin this is the minimum range for the Dungeon Characters Damage.
     * @param theDamageRangeMax this is the maximum range for the Dungeon Characters Damage.
     * @param theAttackSpeed    this is the attack speed for the Dungeon Character.
     * @param theAttackAccuracy this is the attack accuracy for the Dungeon Character.
     * @param theHealingPercentage this is the healing percentage for the Dungeon Character.
     * @param theHealPointRangeMin this is the minimum range for the Dungeon Characters Healing skill.
     * @param theHealPointRangeMax his is the maximum range for the Dungeon Characters Healing skill.
     */
    public Monster(final String theName, int theHitPoints, final int theDamageRangeMin, final int theDamageRangeMax,
                   final int theAttackSpeed, final double theAttackAccuracy, final double theHealingPercentage,
                   final int theHealPointRangeMin, final int theHealPointRangeMax) {
        super(theName, theHitPoints, theDamageRangeMin, theDamageRangeMax, theAttackSpeed, theAttackAccuracy);
        myHealingPercentage = theHealingPercentage;
        myHealPointRangeMin = theHealPointRangeMin;
        myHealPointRangeMax = theHealPointRangeMax;
    }

    /**
     * Calls Super toString Method and adds data specific to the Monster Class
     * @return A string representing the data of the Monster/Dungeon Character
     */
    @Override
    public String toString() {
        super.toString();
        return "Monster{" +
                "myHealingPercentage=" + myHealingPercentage +
                '}';
    }
    

    /**
     * Getter Method for healing percentage
     * @return double representing the chance for a monster to heal after being attacked.
     */
    public double getMyHealingPercentage() {
        return myHealingPercentage;
    }

    @Override
    void setDamage(final int theDamage) {
        int newHp = getMyHitPoints() - theDamage;
        setMyHitPoints(newHp);
        double healingChance = getMyHealingPercentage() * 100;
        Random r = new Random();
        if(r.nextInt(100) < healingChance){
            int healing = r.nextInt(myHealPointRangeMax - myHealPointRangeMin +1 ) + myHealPointRangeMin;
            setMyHitPoints(getMyHitPoints() + healing);
        }
    }
}
