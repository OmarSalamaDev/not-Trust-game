import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables
    public CustomPlayableCircle spirit;


    @Override
    public void start(Stage primaryStage) {


/* >>>>>> Setup code <<<<<< */


        // stages and scenes setup
        Pane root = new Pane();
        Scene primaryScene = new Scene(root, 1000, 600, Color.BLACK);
        primaryScene.getRoot().requestFocus();
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);

        // instantiate spirit object
        spirit = new CustomPlayableCircle(20, Color.WHITE);
        spirit.yGroundReference = primaryScene.getHeight(); // initialize ground reference of y-axis
        spirit.setCenterX(primaryScene.getWidth() / 2.0);
        //spirit.yGroundReference = 200; // play with it ;)
        spirit.setCenterY(spirit.yGroundReference - spirit.getRadius());
        root.getChildren().add(spirit);


/* >>>>>> Stage title and icon <<<<<< */


        primaryStage.setTitle("Project");


/* >>>>>> main code <<<<<< */


        // actions setup for spirit object
        primaryScene.setOnKeyPressed(e -> spirit.handlePressedKey(e.getCode()));
        primaryScene.setOnKeyReleased(e -> spirit.handleReleasedKey(e.getCode()));
        spirit.enableMotionControls();



/* >>>>>> ....... <<<<<< */


    }


    // launcher (main)
    public static void main(String[] args) {
        launch(args);
    }
}
