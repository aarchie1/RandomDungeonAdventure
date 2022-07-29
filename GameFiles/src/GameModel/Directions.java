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
            case "W":
                myD = Directions.UP;
                break;
            case "S":
                myD = Directions.DOWN;
                break;
            case "A" :
                myD = Directions.LEFT;
                break;
            case "D" :
                myD =Directions.RIGHT;
                break;
            default:
                myD = null;
                break;
        }
        return myD;
    }
}
