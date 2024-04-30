import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        //primaryScene.getRoot().requestFocus();
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);

        // instantiate spirit object
        spirit = new CustomPlayableCircle(10, Color.WHITE);
        spirit.yGroundReference = primaryScene.getHeight(); // initialize ground reference of y-axis
        spirit.setCenterX(primaryScene.getWidth() / 2.0);
        //spirit.yGroundReference = 300; // play with it ;)
        spirit.setCenterY(spirit.yGroundReference - spirit.getRadius());
        root.getChildren().add(spirit);



        /* test code

        Rectangle block = new Rectangle(100, 550, 50,50);
        block.setFill(Color.RED);
        root.getChildren().add(block);



        boolean on = false;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(spirit.getCenterX() < 150 && spirit.getCenterX() > 50 && spirit.getCenterY()==500) {
                    //spirit.setyVelocity(0);
                    //spirit.setCenterY(50);
                    spirit.yGroundReference -= 50;
                }
               else {
                    spirit.yGroundReference = primaryScene.getHeight();
                }

            }
        };
        timer.start();*/



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
