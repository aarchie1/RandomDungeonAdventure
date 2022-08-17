package CreatureEntityModel;

import java.util.ArrayList;
import java.util.Random;

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
    private static final int VISION_POTION_VALUE = 20;
    private int myHealthPotions;
    private int myVisionPotions;


    private int myObjectives;
    private ArrayList<String> myItems;
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
        myHealthPotions = 0;
        myVisionPotions = 0;
        myItems = new ArrayList<>();
    }

    /**
     * Calls Super toString Method and adds data specific to the Hero Class
     * @return A string representing the data of the Hero/Dungeon Character
     */
    @Override
    public String toString() {
        // String concatenation
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Hero:" +
                "myBlockAccuracy=" + myBlockAccuracy +
                ", myRegularAttack='" + myRegularAttack + '\'' +
                ", mySpecialAttack='" + mySpecialAttack + '\'' +
                '}');
        return sb.toString();
    }

    @Override
    void setDamage(final int theDamage) {
        double blockChance = getMyBlockAccuracy() * 100;
        Random r = new Random();
        int randomBlockChance = r.nextInt(100);
        if(randomBlockChance < blockChance){
            return;
        }
        int newHp = getMyHitPoints() - theDamage;
        setMyHitPoints(newHp);
    }

    public void setMyHealthPotions(final int thePotionCount) {
        myHealthPotions = thePotionCount;
    }

    public void setMyVisionPotions(final int thePotionCount) {
        myVisionPotions = thePotionCount;
    }

    public void addMyItems(final String theItem) {
        myItems.add(theItem);
    }

    public void removeMyItems(final String theItem) {
        if(myItems.contains(theItem)){
            myItems.remove(theItem);
        }
    }

    int getMyHealthPotions() {
        return myHealthPotions;
    }

    int getMyVisionPotions() {
        return myVisionPotions;
    }

    public int getMyObjectives() {
        return myObjectives;
    }

    public void setMyObjectives() {
        myObjectives++;
    }

    ArrayList<String> getMyItems() {
        return myItems;
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
