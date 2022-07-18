package CreatureEntityModel;

/**
 * This is a sub-class/child of hero.
 * Thief has a special skill of surprise attack, which has a 40 percent chance of success. If this is sucessful,
 * thief gets an extra attack in the current round. There is a 20 percent change the thief is caught and no attack
 * is preformed. The last 40 percent is a normal attack.
 * Stats from TCSS 360 Specs Sheet: HP 75, AttackSpeed 6, AttackAccuracy 80 percent, MinDamageRange 20,
 * MaxDamageRange 40, BlockAccuracy 40 percent.
 * @author Anthony Archie
 * @version 1.0
 */
public class Thief extends Hero{

    public Thief() {
        super("Garret The Thief", 75, 20, 40, 6,
                .8, .4, "Pick Pocket", "Surpise Attack");
    }
}
