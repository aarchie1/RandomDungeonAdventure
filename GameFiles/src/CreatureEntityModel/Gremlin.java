package CreatureEntityModel;

/**
 * This is a sub-class/ child of Monster.
 * Stats from TCSS 360 Specs Sheet: Hp 70, AttackSpeed 5, AttackAccuracy 80 percent, MinDamageRange 15
 * MaxDamageRange 30, HealingPercentage 40 percent, MinHealPoints 20, MaxHealPoints 40.
 * @author Anthony Archie
 * @version 1.0
 */
public class Gremlin extends Monster{

    /**
     * Constructor To set up Gizmo the Gremlin
     */
    public Gremlin() {
        super("Gizmo The Gremlin", 70, 15, 30,
                5, .8, .4,
                20, 40);
    }
}
