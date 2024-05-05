import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {


    // global objects and variables
    public CustomPlayableCircle spirit;
    public AnimationTimer motionTimer;
    public KeyCode thisKey = null;
    public KeyCode previousKey = null;
    public boolean isBlock = false;
    public boolean isOnBlock = false;


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
        spirit.setCenterX(primaryScene.getWidth() / 2.0);
        //spirit.yGroundReference = 300; // play with it ;)
        spirit.setCenterY(spirit.yGroundReference - spirit.getRadius());
        root.getChildren().add(spirit);



        // enable for spirit object
        enableMotion(spirit);

        // test block
        Rectangle block = new Rectangle(400, 550, 200, 50);
        block.setFill(Color.RED);
        root.getChildren().add(block);
        checkblock(block);

//        // test block
//        Rectangle bl = new Rectangle(600, 550, 50, 50);
//        bl.setFill(Color.GREEN);
//        root.getChildren().add(bl);
//        checkblock(bl);

        // keyboard actions control
        spirit.getScene().setOnKeyPressed(e -> {
            thisKey = e.getCode();
            //if (!isBlock) previousKey = null;
            if (thisKey == KeyCode.RIGHT) {
                spirit.setVx(spirit.getxStep());
                previousKey = thisKey;
            }
            else if (thisKey == KeyCode.LEFT) {
                spirit.setVx(-spirit.getxStep());
                previousKey = thisKey;
            }
            else if (thisKey == KeyCode.SPACE && !spirit.inAir) {
                spirit.setVy(-spirit.getyStep());
                spirit.inAir = true;
                previousKey = thisKey;
            }
        });
        spirit.getScene().setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                spirit.setVx(0.0);
            }
        });

//        // instantiate building block (platform)
//        BuildingBlock platform = new BuildingBlock(100, 30, Color.GREEN, 350, 550);
//        BuildingBlock platform1 = new BuildingBlock(100, 30, Color.GREEN, 420, 520);
//        BuildingBlock platform2 = new BuildingBlock(200, 20, Color.GREEN, 50, 450);
//        root.getChildren().addAll(platform, platform1, platform2);
//
//        // Add trap to the scene
//        Trap trap = new Trap(100, 10, Color.RED, 700,590 );
//        root.getChildren().add(trap);
//
//        // test timer
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                spirit.updatePosition();
//                // check collision with the platforms
//                if (platform.checkCollision(spirit)) {
//                    spirit.setVy(0);
//                }
//                if (platform1.checkCollision(spirit)) {
//                    spirit.setVy(0);
//                }
//                if (platform2.checkCollision(spirit)) {
//                    spirit.setVy(0);
//                }
//                if (trap.checkCollision(spirit)) {
//                    // Spirit touched the trap, reset its position
//                    spirit.setCenterX(primaryScene.getWidth() / 6.0); // Set to starting X position
//                    spirit.setCenterY(spirit.yGroundReference - spirit.getRadius()); // Set to starting Y position
//                }
//            }
//        };
//        timer.start();





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





    public void checkblock(Rectangle x) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (spirit.getBoundsInParent().intersects(x.getBoundsInParent())) {
                    isBlock = true;

                    // checks if the object is on the block and updates ground reference
                    if (spirit.getCenterY() + spirit.getRadius() >= x.getY() && spirit.getCenterX() >= x.getX() && spirit.getCenterX() <= x.getX()+x.getWidth()){
                        isOnBlock = true;
                        spirit.setxStep(5);
                        spirit.yGroundReference = 550;
                    }
                    else if (true) {
                        isOnBlock = false;
                        spirit.setxStep(0);
                        spirit.setVx(0);
                    }
                }
                else {
                    isBlock = false;
                    spirit.setxStep(5);
                    spirit.yGroundReference = 600;
                }
            }
        };
        timer.start();
    }


/* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }
}
