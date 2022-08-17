package GameModel;

public enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
    ;

   public static Directions getDirection(final String theDirection){
        Directions myD;
        switch (theDirection) {
            case "UP":
                myD = Directions.UP;
                break;
            case "DOWN":
                myD = Directions.DOWN;
                break;
            case "LEFT" :
                myD = Directions.LEFT;
                break;
            case "RIGHT":
                myD = Directions.RIGHT;
                break;
            default:
                myD = null;
                break;
        }
        return myD;
    }

    public static Directions getInputDirection(String theDirection) {
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
            case "d":
                myD = Directions.RIGHT;
                break;
            default:
                myD = null;
                break;
        }
        return myD;
    }
    /**
     *
     */
    public static Location nextLocation(final Directions d, final Location current){
        if ((d != null)) {
            return switch (d) {
                case UP -> new Location(current.getMyX() - 1, current.getMyY());
                case DOWN -> new Location(current.getMyX() + 1, current.getMyY());
                case LEFT -> new Location(current.getMyX(), current.getMyY() - 1);
                case RIGHT -> new Location(current.getMyX(), current.getMyY() + 1);
                default -> new Location(current.getMyX(), current.getMyY());
            };
        }
        return current;
    }

    public static Directions reverse (Directions d) {
        return switch (d) {
            case RIGHT -> LEFT;
            case LEFT -> RIGHT;
            case UP -> DOWN;
            case DOWN -> UP;
        };
    }


}
