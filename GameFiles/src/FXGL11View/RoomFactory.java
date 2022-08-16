package FXGL11View;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.views.ScrollingBackgroundView;
import com.almasb.fxgl.entity.*;

import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;

import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;

import java.util.ArrayList;

import static FXGL11View.EntityKeyWords.PLAYER;
import static com.almasb.fxgl.dsl.FXGL.*;
public class RoomFactory implements EntityFactory {
    private Node node;

    @Spawns("background")
    public Entity newBackground(SpawnData data) {
        node = getAssetLoader().loadTexture("tile.png");
        node.setTranslateX(510);
        node.setTranslateY(230);
        node.setScaleX(5);
        node.setScaleY(2.8);
        return entityBuilder()
                .view(node)
                .zIndex(-1)
                .with(new IrremovableComponent())
                .build();
    }

    @Spawns("player")
    public Entity thePlayer(SpawnData data) {
        node = getAssetLoader().loadTexture("knight.png");
        node.setScaleX(.125);
        node.setScaleY(.125);
        return entityBuilder(data)
                .view(node)
                .type(PLAYER)
                .with(new CollidableComponent(true))
                .with(new IrremovableComponent())
                .with(new ViewController())
                .build();
    }

}
