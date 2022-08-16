package FXGL11View;

import GameModel.GameModelController;
import com.almasb.fxgl.app.ApplicationMode;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.scene.LoadingScene;
import com.almasb.fxgl.app.scene.SceneFactory;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGL.*;

public class GameView extends GameApplication {
    private Entity player;

    int myWidth = 1280;
    int myHeight = 720;
    private static final GameModelController myEngine = new GameModelController();
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(myWidth);
        settings.setHeight(myHeight);
        settings.setTitle("RADS");
        settings.setVersion("0.0.3");

        /*
        settings.setSceneFactory(new SceneFactory() {
            public LoadingScene newLoadingScene() {

                return new LoadScreen();
            }

        });
        */
    }

    @Override
    protected void initInput() {
        /*
        getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() {
                player.getComponent(ViewController.class).left();
            }
        });
        */

        FXGL.onKey(KeyCode.D, () -> {
            player.translateX(5); // move right 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.A, () -> {
            player.translateX(-5); // move left 5 pixels
            FXGL.inc("pixelsMoved", -5);
        });

        FXGL.onKey(KeyCode.W, () -> {
            player.translateY(-5); // move up 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

        FXGL.onKey(KeyCode.S, () -> {
            player.translateY(5); // move down 5 pixels
            FXGL.inc("pixelsMoved", +5);
        });

    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("pixelsMoved", 0);
    }



    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new RoomFactory());
        spawn("background");
        player = spawn("player",50,50);
        spawn("background");
        /*
        Node node = FXGL.getAssetLoader().loadTexture("knight.png");
        node.setScaleX(.125);
        node.setScaleY(.125);
        player = entityBuilder()
                .at(300, 300)
                //.view(new Rectangle(25, 25, Color.BLUE))
                .viewWithBBox(node)
                .with(new CollidableComponent(true))
                .buildAndAttach();

         */
    }

    @Override
    protected void initUI() {
        Text textPixels = new Text();
        textPixels.setTranslateX(50); // x = 50
        textPixels.setTranslateY(100); // y = 100
        textPixels.textProperty().bind(getWorldProperties().intProperty("pixelsMoved").asString());
        getGameScene().addUINode(textPixels); // add to the scene graph
        //getGameScene().addUINode(brickTexture);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
