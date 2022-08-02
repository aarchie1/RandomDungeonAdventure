package GameModel;

public enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
    ;

   static Directions getDirection(final String theDirection){
        Directions myD;
        switch (theDirection) {
            case "w":
                myD = Directions.UP;
                break;
            case "s":
                myD = Directions.DOWN;
                break;
            case "a" :
                myD = Directions.LEFT;
                break;
            case "d" :
                myD = Directions.RIGHT;
                break;
            default:
                myD = null;
                break;
        }
        return myD;
    }
}
