package FXGL11View;

import CreatureEntityModel.CreatureEntityController;
import CreatureEntityModel.Monster;
import GameModel.Directions;
import com.almasb.fxgl.physics.box2d.collision.shapes.Shape;
import com.almasb.fxgl.texture.Texture;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGL.getAssetLoader;


/**
 * This Class holds the templates for our monsters.
 * It should contain a spawn monster and the ENUMS for the different options.
 * It implements CreatureEntity's so that it can make them with spawnMonster
 */
public enum MonsterTemplates {
    GREMLIN, OGRE, SKELETON;

    public static Boolean IsMonster(final String theName) {
        String[] myMon = {"GREMLIN", "OGRE", "SKELETON"};
        for (String s:myMon) {
            if (s.equals(theName)) {
                return true;
            }
        }
        return false;
    }

    public static Texture getTexture(String theTemplate){
        String[] myMon = {"GREMLIN", "OGRE", "SKELETON"};
        Texture node;
        node = getAssetLoader().loadTexture("tile.png");
        node.setTranslateX(510);
        node.setTranslateY(230);
        node.setScaleX(5);
        node.setScaleY(2.8);

        /*
        // match class with image returned when called statically
        for (String s : myMon) {
            if (s.equals(theTemplate)) {
                switch (s) {
                    case "GREMLIN" -> {
                        node = getAssetLoader().loadTexture("gremlin.png");
                        node.setTranslateX(510);
                        node.setTranslateY(230);
                        node.setScaleX(5);
                        node.setScaleY(2.8);
                    }
                    case "GREMLIN" -> {
                        node = getAssetLoader().loadTexture("gremlin.png");
                        node.setTranslateX(510);
                        node.setTranslateY(230);
                        node.setScaleX(5);
                        node.setScaleY(2.8);
                    }

                }
            }
        }
                */
        return node;
    }
//            case "OGRE" -> {
//        node = getAssetLoader().loadTexture("oger.png");
//        node.setTranslateX(510);
//        node.setTranslateY(230);
//        node.setScaleX(5);
//        node.setScaleY(2.8);
//    }
//            case "SKELETON" -> {
//        node = getAssetLoader().loadTexture("skeleton.png");
//        node.setTranslateX(510);
//        node.setTranslateY(230);
//        node.setScaleX(5);
//        node.setScaleY(2.8);
//    }
//    default -> node = getAssetLoader().loadTexture("gremlin.png");
//};

}
