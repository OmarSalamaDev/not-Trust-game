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
    public Rectangle block;
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
        spirit.setCenterX(900);
        //spirit.yGroundReference = 300; // play with it ;)
        spirit.setCenterY(spirit.yGroundReference - spirit.getRadius());
        root.getChildren().add(spirit);



        // enable for spirit object
        enableMotion(spirit);

        // test block 1
        block = new Rectangle(400, 450, 200, 50);
        block.setFill(Color.RED);
        root.getChildren().add(block);
        checkblock(block);

        // keyboard actions control
        spirit.getScene().setOnKeyPressed(e -> {
            thisKey = e.getCode();
            
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
            double r = spirit.getRadius();
            @Override
            public void handle(long l) {
                // check if the spirit touches the block
                if (spirit.getBoundsInParent().intersects(x.getBoundsInParent())) {
                    isBlock = true;
                    spirit.setUpperBorder(x.getY()+x.getHeight());
                    
//                    // upper edge
//                    if (spirit.getCenterY()+spirit.getRadius() > x.getY() && spirit.getCenterX()+spirit.getRadius() > x.getX() && spirit.getCenterX()-spirit.getRadius() < x.getX()+x.getWidth()){
//                        isOnBlock = true;
//                        spirit.setxStep(5);
//                        spirit.yGroundReference = x.getY();
//                    }
                    // lower edge
                    //if (spirit.getCenterY()-r > x.getY()+x.getHeight() && !isOnBlock) {
                        
                    //}
                    // left edge
                    if (spirit.getCenterX()+r == x.getX() && !isOnBlock) {
                        spirit.setRightBorder(block.getX());
                    }
                    // right edge
                    if (spirit.getCenterX()-r == x.getX()+x.getWidth() && !isOnBlock) {
                        spirit.setLeftBorder(block.getX()+x.getWidth());
                    }
                   
                } 
                // reset values
                else {
                    isBlock = false;
                    isOnBlock = false;
                    spirit.setxStep(5);
                    spirit.setyStep(20);
                    spirit.yGroundReference = 600;
                    spirit.setRightBorder(1000);
                    spirit.setLeftBorder(0);
                    spirit.setUpperBorder(0);
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
