import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables
    public CustomPlayableCircle spirit;
    public AnimationTimer motionTimer;
    public KeyCode thisKey = null;
    public KeyCode previousKey = null;

    public Block b1;
    public Block b2;

    int i = 0;



    @Override
    public void start(Stage primaryStage) {

        // setup
        Pane root = new Pane();
        Scene primaryScene = new Scene(root, 1000, 600, Color.BLACK);
        //primaryScene.getRoot().requestFocus();
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");

        // instantiate spirit object
        spirit = new CustomPlayableCircle(20, Color.WHITE);
        spirit.yGroundReference = primaryScene.getHeight(); // initialize ground reference of y-axis
        spirit.setSceneBorders(0, primaryScene.getHeight(), primaryScene.getWidth(), 0);
        spirit.setCenterX(900);
        //spirit.yGroundReference = 300; // play with it ;)
        spirit.setCenterY(spirit.yGroundReference - spirit.getRadius());
        root.getChildren().add(spirit);

        // enable for spirit object
        enableMotion(spirit);

        // test block 1
        b1 = new Block(400, 350, 200, 200);
        b1.setFill(Color.RED);
        b1.checkBlock(spirit);
        root.getChildren().add(b1);

        // test block 2
        b2 = new Block(300, 300, 50, 50);
        b2.setFill(Color.RED);
        b2.checkBlock(spirit);
        root.getChildren().add(b2);




        
        // handel keyboard actions
        spirit.getScene().setOnKeyPressed(e -> {
            thisKey = e.getCode();

            if (thisKey == KeyCode.RIGHT) {
                spirit.setVx(spirit.getxStep());
            }
            else if (thisKey == KeyCode.LEFT) {
                spirit.setVx(-spirit.getxStep());
            }
            else if (thisKey == KeyCode.SPACE && !spirit.inAir) {
                spirit.setVy(-spirit.getyStep());
                spirit.inAir = true;
            }
        });
        spirit.getScene().setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                spirit.setVx(0.0);
            }
        });


    }


    /* >>>> enable motion for the object  <<<< */


    public void enableMotion(CustomPlayableCircle spirit) {
        motionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                spirit.updatePosition();
            }
        };
        motionTimer.start();
    }








    /* >>>> launcher  <<<< */



    public static void main(String[] args) {
        launch(args);
    }
}
