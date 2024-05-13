import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Control {


    public static void spiritControls(Stage stage) {

        Main.levelScenes.setOnKeyPressed(e -> {
            KeyCode thisKey = e.getCode();
            // right
            if (thisKey == KeyCode.RIGHT) {
                Main.spirit.setVx(Main.spirit.getxStep());
            }
            // left
            else if (thisKey == KeyCode.LEFT) {
                Main.spirit.setVx(-Main.spirit.getxStep());
            }
            // up
            else if (thisKey == KeyCode.SPACE && !Main.spirit.inAir) {
                Main.spirit.setVy(-Main.spirit.getyStep());
                Main.spirit.inAir = true;
            }
            // reverse gravity
            else if (thisKey == KeyCode.SHIFT) {
                Main.spirit.reverseGravity();
                Main.spirit.inAir = false;
            }
            // menu button
            else if (thisKey == KeyCode.ESCAPE) {
                stage.setScene(Main.inGameMenu);
            }
            else if (thisKey == KeyCode.NUMPAD1) {
                Levels.clearRoot();
                Block.stopAnimationTimers();
                Main.spirit.resetBorders();
                if (Main.spirit.isReversed) Main.spirit.reverseGravity();
                Main.levelScenes.setRoot(Levels.level(1));
            }
            else if (thisKey == KeyCode.NUMPAD2) {
                Levels.clearRoot();
                Block.stopAnimationTimers();
                Main.spirit.resetBorders();
                if (Main.spirit.isReversed) Main.spirit.reverseGravity();
                Main.levelScenes.setRoot(Levels.level(2));
            }
            else if (thisKey == KeyCode.NUMPAD0) Levels.clearRoot();
        });

        Main.levelScenes.setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                Main.spirit.setVx(0.0);
            }
        });
    }





}
