import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables
    public CustomPlayableCircle spirit;
    public Block b1;
    public Block b2;
    public Block b3;


    @Override
    public void start(Stage primaryStage) {

        // setup
        Pane root = new Pane();
        Scene primaryScene = new Scene(root, 1000, 600, Color.BLACK);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");

        // instantiate spirit object
        spirit = new CustomPlayableCircle(20, Color.WHITE);
        spirit.setDefaultBorders(0, primaryScene.getHeight(), primaryScene.getWidth(), 0);
        spirit.setCenterX(900);
        spirit.setCenterY(primaryScene.getHeight() - spirit.getRadius());
        root.getChildren().add(spirit);

        // set default spirit for the block class
        Block.spirit = spirit;

        // test block 1
        b1 = new Block(400, 350, 200, 200);
        b1.setFill(Color.RED);
        b1.checkBlock();
        root.getChildren().add(b1);

        // test block 2
        b2 = new Block(300, 300, 50, 50);
        b2.setFill(Color.BLUE);
        b2.checkBlock();
        root.getChildren().add(b2);

        // test block 3
        b3 = new Block(100, 400, 200, 100);
        b3.setFill(Color.YELLOW);
        b3.checkBlock();
        root.getChildren().add(b3);

        // handel keyboard actions
        spirit.getScene().setOnKeyPressed(e -> {
            KeyCode thisKey = e.getCode();

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


    /* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }
}