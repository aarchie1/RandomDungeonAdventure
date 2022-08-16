package FXGL11View;

import GameModel.Directions;
import com.almasb.fxgl.texture.Texture;

import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;

public enum DoorTemplate {
    DOORUP,
    DOORDOWN,
    DOORLEFT,
    DOORRIGHT;


    static DoorTemplate getDoor(final String s){
        Directions d = Directions.getDirection(s);
        return switch (d) {
            case UP -> DOORUP;
            case DOWN -> DOORDOWN;
            case LEFT -> DOORLEFT;
            case RIGHT -> DOORRIGHT;
        };
    }

    public static Texture getTexture(){
        // match class with image returend when called staticly
        //switch ()
        //
        Texture node = getAssetLoader().loadTexture("tile.png");
        node.setTranslateX(510);
        node.setTranslateY(230);
        node.setScaleX(5);
        node.setScaleY(2.8);
        return node;
    }
}
