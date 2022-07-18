package CreatureEntityModel;

/**
 * This is a sub-class/ child of Hero.
 * A Warrior has a special skill called Crushing Blow that does 75 - 175 points of damage
 * but only has a 40% chance of succeeding.
 * Should override the attack method from Hero to accommodate the Special Attack vs Regular Attack.
 * Stats from TCSS 360 Specs Sheet: Hp 125, AttackSpeed 4, AttackAccuracy 80 percent, MinDamageRange 35
 * MaxDamageRange 60, blockAccuracy 20 percent.
 * @author Anthony Archie
 * @version 1.0
 */
public class Warrior extends Hero {


    public Warrior() {
        super("Wyze the Warrior", 125, 30, 60,
                4, .8, .2,
                "War Hammer", "Crushing Blow");

    }
}
