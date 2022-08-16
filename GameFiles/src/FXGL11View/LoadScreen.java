package FXGL11View;

import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.scene.LoadingScene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;



import static com.almasb.fxgl.dsl.FXGL.*;

public class LoadScreen extends LoadingScene {

    public LoadScreen(){
        var text = getUIFactoryService().newText("Loading Room", Color.BLACK, 46.0);
        centerText(text, getAppWidth()/2,getAppHeight()/3 + 25);
        var hbox = new HBox(5);
        hbox.setTranslateX(getAppWidth() / 2 - 20);
        hbox.setTranslateY(getAppHeight() / 2);
        getContentRoot().getChildren().set(1,text);
        getContentRoot().getChildren().set(2,hbox);
    }
}
