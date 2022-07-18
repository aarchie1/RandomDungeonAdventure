package CreatureEntityModel;

/**
 * This is a sub-class/child of hero.
 * Priestess has a special skill of heal, which has a range of how many hitpoints will be healed.
 * Stats from TCSS 360 Specs Sheet: HP 75, AttackSpeed 5, AttackAccuracy 70 percent, MinDamageRange 25,
 * MaxDamageRange 45, BlockAccuracy 30 percent.
 * @author Anthony Archie
 * @version 1.0
 */
public class Priestess extends Hero{


    public Priestess() {
        super("Gandalf The Great", 75, 25, 45,
                5, .7, .3,
                "Cast Spell", "Heal");
    }
}
