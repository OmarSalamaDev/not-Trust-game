import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables
    public Spirit spirit;
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
        Scene primaryScene = new Scene(root, 1200, 600);
        primaryScene.setFill( Color.rgb(91, 233, 240));
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Project");

        // instantiate spirit object
        spirit = new Spirit(10, Color.RED);
        spirit.setDefaultBorders(100, primaryScene.getHeight()-100, primaryScene.getWidth()-100, 100);
        spirit.setCenterX(400);
        spirit.setCenterY(spirit.getLowerBorder() - 100 - spirit.getRadius());
        root.getChildren().add(spirit);


        // in-game main menu
        VBox d = new VBox();
        Scene x = new Scene(d,1200,600, Color.BLACK);
        x.getStylesheets().add("style.css");

        d.setAlignment(Pos.CENTER);
        d.setSpacing(20);
        //Button btn1 = new Button("btn1");
        //Button btn2 = new Button("btn2");
        //Rectangle btn1 = new Rectangle(50,50,Color.RED);
        //Rectangle btn2 = new Rectangle(50,50,Color.RED);
        CustomButton btn1 = new CustomButton(200,100,Color.BLUE,"btn1", Color.WHITE);
        CustomButton btn2 = new CustomButton(200,100,Color.RED,"btn2", Color.WHITE);
//        btn1.setId("simple-btn");
//        btn2.setId("simple-btn");
//        btn1.getStyleClass().addAll("btn1");
//        btn2.getStyleClass().addAll("btn2");
        d.getChildren().addAll(btn1, btn2);


        // handel keyboard actions
        primaryScene.setOnKeyPressed(e -> {
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
            else if (thisKey == KeyCode.SHIFT) {
                spirit.gravityFlip();
                spirit.inAir = false;
            }
            else if (thisKey == KeyCode.ESCAPE) {
                primaryStage.setScene(x);
            }
            else if (e.getCode() == KeyCode.S) b6.animate(false);
            else if (e.getCode() == KeyCode.D) b6.animate(true);

        });
        spirit.getScene().setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                spirit.setVx(0.0);
            }
        });
        x.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(primaryScene);
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
        b5 = new Block(900, 420, 70, 25);
        b5.setFill(Color.rgb(19, 47, 99));
        b5.checkBlock();
        root.getChildren().add(b5);

        // test block 6
        b6 = new Block(700, 200, 70, 80);
        b6.setFill(Color.rgb(19, 47, 99));
        b6.checkBlock();
        root.getChildren().add(b6);

        // test block 7
        b7 = new Block(500, 270, 70, 25);
        b7.setFill(Color.rgb(19, 47, 99));
        b7.checkBlock();
        root.getChildren().add(b7);

        // test block 8
        b8 = new Block(400, 190, 70, 250);
        b8.setFill(Color.rgb(19, 47, 99));
        b8.checkBlock();
        root.getChildren().add(b8);

        // block 6 animation
        b6.setupAnimation(200, 350, Block.MotionType.VERTICAL, 1);
        b6.animate(true);


    }


    /* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }
}