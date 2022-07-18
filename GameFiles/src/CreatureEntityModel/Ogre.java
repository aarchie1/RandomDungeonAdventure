package CreatureEntityModel;

/**
 * This is a sub-class/ child of Monster.
 * Stats from TCSS 360 Specs Sheet: Hp 200, AttackSpeed 2, AttackAccuracy 60 percent, MinDamageRange 30
 * MaxDamageRange 60, HealingPercentage 10 percent, MinHealPoints 30, MaxHealPoints 60.
 * @author Anthony Archie
 * @version 1.0
 */
public class Ogre extends Monster{


    public Ogre() {
        super("Shrek the Ogre", 200, 30, 60,2,
                .6, .1, 30, 60);
    }
}
