package CreatureEntityModel;

import java.util.*;


/**
 * A Dungeon Character is the parent for the hierachy of characters that will be in the dungeon.
 * A character can be a monster or a hero (the player)
 * Fields from specs include: Name, Hit points, Damage Range, Attack Speed (1 is slowest),
 * and Attack Accuracy.
 * Methods from specs include: getters/setters for fields, attack behaviour method.
 * @author Anthony Archie
 * @version .02
 */
public class DungeonCharacter implements CreatureEntity {
    private final String myName;
    private int myHitPoints;
    private final int myDamageRangeMin;
    private final int myDamageRangeMax;
    private final int myAttackSpeed;
    private final double myAttackAccuracy;


    /**
     *
     * @param theName this is the name of the Dungeon Character.
     * @param theHitPoints this is the amount of Hit Points/Health a Dungeon Character has.
     * @param theDamageRangeMin this is the minimum range for the Dungeon Characters Damage.
     * @param theDamageRangeMax this is the maximum range for the Dungeon Characters Damage.
     * @param theAttackSpeed this is the attack speed for the Dungeon Character.
     * @param theAttackAccuracy this is the attack accuracy for the Dungeon Character.
     */
    public DungeonCharacter(final String theName, final int theHitPoints, final int theDamageRangeMin,
                            final int theDamageRangeMax, final int theAttackSpeed,
                            final double theAttackAccuracy) {
        myName = theName;
        myHitPoints = theHitPoints;
        myDamageRangeMin = theDamageRangeMin;
        myDamageRangeMax = theDamageRangeMax;
        myAttackSpeed = theAttackSpeed;
        myAttackAccuracy = theAttackAccuracy;
    }

    /**
     * This method is built into the CreatureEntityModel Model in accordance to the spec sheet.
     * This method will take in an opponent modify the oppenents hp depeding on the accuracy of the
     * current character.
     * @param theOpponent this is the oppenent that will have hit points taken away given an accurate attack.
     */
    public void attackBehavior(final DungeonCharacter theOpponent){
        if (myAttackAccuracy > 0 ){
            double hitChance = myAttackAccuracy * 100;
            Random r = new Random();
            int l = r.nextInt(100);
            if( l < hitChance){
                int damage = r.nextInt(myDamageRangeMax - myDamageRangeMin + 1 ) + myDamageRangeMin;
                theOpponent.setDamage(damage);
            }
        }

    }

    /**
     * This method sets damage for the given character
     * @param theDamage this is the amount of damage taken during battle that will be applied to the HP.
     */
    void setDamage(final int theDamage){
        int newHp = getMyHitPoints() - theDamage;
        setMyHitPoints(newHp);
    }

    /**
     * This method sets the hitpoints for the current character.
     * @param myHitPoints the hit points which need to be set for the charcter
     */
    void setMyHitPoints(final int myHitPoints) {
        this.myHitPoints = myHitPoints;
    }

    /**
     * This method fulfills the contract of the CreatureEntity Interface.
     * @return a String representing a Dungeon Character and its data.
     */
    @Override
    public String toString() {
        return "myName='" + myName + '\'' +
                ", myHitPoints=" + myHitPoints +
                ", myDamageRangeMin=" + myDamageRangeMin +
                ", myDamageRangeMax=" + myDamageRangeMax +
                ", myAttackSpeed=" + myAttackSpeed +
                ", myAttackAccuracy=" + myAttackAccuracy +
                '}';
    }

    /**
     * Used to get the string myName by itself.
     * @return String the contents of myName.
     */
    @Override
    public String getMyName() {
        return myName;
    }

    /**
     * This method returns the hit points for the current character.
     * @return int representing the hit points of a character.
     */
    int getMyHitPoints() {
        return myHitPoints;
    }

    /**
     * This method will retrieve a Characters attack speed
     * @return int representing the attack speed of a Dungeon Character.
     */
    int getMyAttackSpeed() {
        return myAttackSpeed;
    }

    /**
     * This method will retrieve a Characters attack Accuracy
     * @return double representing the attack accuracy of a Dungeon Character.
     */
    double getMyAttackAccuracy(){
        return myAttackAccuracy;
    }

    public int getMyDamageRangeMin() {
        return myDamageRangeMin;
    }

    public int getMyDamageRangeMax() {
        return myDamageRangeMax;
    }





}
