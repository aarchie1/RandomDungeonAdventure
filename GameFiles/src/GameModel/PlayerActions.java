package GameModel;

public enum PlayerActions {
    HEALPOT,
    VISONPOT,
    PLAYERINV;

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
