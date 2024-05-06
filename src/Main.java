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
    public Block b4;
    public Block b5;
    public Block b6;
    public Block b7;
    public Block b8;
    public Block b9;


    @Override
    public void start(Stage primaryStage) {

        // setup
        Pane root = new Pane();
        Scene primaryScene = new Scene(root, 1200, 600, Color.rgb(91, 233, 240));
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");

        // instantiate spirit object
        spirit = new CustomPlayableCircle(10, Color.RED);
        spirit.setDefaultBorders(0, primaryScene.getHeight()-100, primaryScene.getWidth(), 0);
        spirit.setCenterX(400);
        spirit.setCenterY(primaryScene.getHeight() - spirit.getRadius());
        root.getChildren().add(spirit);

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

        // set default spirit for the block class
        Block.spirit = spirit;

        // test block 1
        b1 = new Block(0, 0, 1200, 100);
        b1.setFill(Color.rgb(19, 47, 99));
        b1.checkBlock();
        root.getChildren().add(b1);

        // test block 2
        b2 = new Block(0, 500, 1200, 100);
        b2.setFill(Color.rgb(19, 47, 99));
        b2.checkBlock();
        root.getChildren().add(b2);

        // test block 3
        b3 = new Block(0, 100, 100, 400);
        b3.setFill(Color.rgb(19, 47, 99));
        b3.checkBlock();
        root.getChildren().add(b3);

        // test block 4
        b4 = new Block(1100, 100, 100, 400);
        b4.setFill(Color.rgb(19, 47, 99));
        b4.checkBlock();
        root.getChildren().add(b4);

        // test block 5
        b5 = new Block(900, 420, 70, 10);
        b5.setFill(Color.rgb(19, 47, 99));
        b5.checkBlock();
        root.getChildren().add(b5);

        // test block 6
        b6 = new Block(700, 350, 70, 10);
        b6.setFill(Color.rgb(19, 47, 99));
        b6.checkBlock();
        root.getChildren().add(b6);

        // test block 7
        b7 = new Block(500, 270, 70, 10);
        b7.setFill(Color.rgb(19, 47, 99));
        b7.checkBlock();
        root.getChildren().add(b7);

        // test block 8
        b8 = new Block(400, 190, 70, 250);
        b8.setFill(Color.rgb(19, 47, 99));
        b8.checkBlock();
        root.getChildren().add(b8);






    }


    /* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }
}