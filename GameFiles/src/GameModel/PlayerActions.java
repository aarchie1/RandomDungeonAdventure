package GameModel;

/**
 * This Enum is used to select between action the player can take
 */
public enum PlayerActions {
    HEALPOT,
    VISONPOT,
    PLAYERINV;

    /**
     * This is used to decide which action is wanted.
     * @param theAction a string that is used as input
     * @return the PlayerAction used with that string
     */
    static PlayerActions getAct(final String theAction){
        PlayerActions myA;
        switch (theAction) {
            case "H":
                myA = PlayerActions.HEALPOT;
                break;
            case "V":
                myA = PlayerActions.VISONPOT;
                break;
            case "I":
                myA = PlayerActions.PLAYERINV;
                break;
            default:
                myA = null;
                break;
        }
        return myA;
    }
}
