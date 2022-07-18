package CreatureEntityModel;

/**
 * This is a sub-class/ child of Monster.
 * Stats from TCSS 360 Specs Sheet: Hp 100, AttackSpeed 3, AttackAccuracy 80 percent, MinDamageRange 30
 * MaxDamageRange 50, HealingPercentage 30 percent, MinHealPoints 30, MaxHealPoints 50.
 * @author Anthony Archie
 * @version 1.0
 */
public class Skeleton extends Monster {

    /**
     * Constructor To set up Gravelord the Skeleton
     */
    public Skeleton() {
        super("Gravelord the Skeleton", 100, 30, 50,
                3, .8, .3, 30, 50);
    }
}
