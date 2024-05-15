

import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class Trap extends Block {

    private double startX = 150;
    private double startY = 500;


    public Trap(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void setStartingPos(double x, double y) {
        startX = x;
        startY = y;
    }

    @Override
    public void checkBlock(boolean state) {
        if (!state) intersectionTimer.stop();
        else {
            intersectionTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                        Sounds.soundOfDeath();
                        Main.spirit.setCenterX(startX);
                        Main.spirit.setCenterY(startY);
                        Main.spirit.setVx(0);
                        Main.spirit.setVy(0);
                        if (Main.spirit.isReversed) Main.spirit.reverseGravity();
                        ScenesLoader.gameRoot.getChildren().clear();
                        ScenesLoader.gameRoot.getChildren().add(Levels.level(Levels.currentLevel));
                    }
                }
            };
            intersectionTimer.start();
        }
    }



}
