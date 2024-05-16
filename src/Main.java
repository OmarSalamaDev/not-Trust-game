

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables

    public static Spirit spirit;

    public static Paint backgroundColor = Color.rgb(138, 67, 132);
    public static Paint blockColor = Color.rgb(64, 2, 58);
    public static Paint spiritColor = Color.rgb(255, 255, 255);
    public static Paint trapColor = Color.rgb(249, 115, 0);

    public static String spikeImagePath = "media/images/trap-1.png";

    public static boolean mute = true;


    @Override
    public void start(Stage primaryStage) {


        // setup stage
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");
        Image icon = new Image("media/icons/icon-1.png");
        primaryStage.getIcons().add(icon);






//        backgroundColor = Color.rgb(138, 67, 132);
//        blockColor = Color.rgb(64, 2, 58);
//        spiritColor = Color.rgb(255, 255, 255);
//        trapColor = Color.rgb(249, 115, 0);



//        backgroundColor = Color.rgb(136, 156, 191);
//        blockColor = Color.rgb(0, 32, 84);
//        spiritColor = Color.rgb(255, 255, 255);
//        trapColor = Color.rgb(224, 7, 13);

//        backgroundColor = Color.rgb(76, 75, 76);
//        blockColor = Color.BLACK;
//        spiritColor = Color.WHITE;
//        trapColor = Color.rgb(163, 163, 163);



        // instantiate spirit object
        Main.spirit = new Spirit(10, Main.spiritColor);
        Main.spirit.setDefaultBorders(0, 700, 1200,0);

        // setup menus and scenes
        ScenesLoader.setupMenus(primaryStage);

        // play intro scene
        primaryStage.setScene(ScenesLoader.introScene());
        //primaryStage.setScene(ScenesLoader.levelTransition(1));



    }


    /* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }

}