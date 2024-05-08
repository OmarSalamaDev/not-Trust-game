import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class Trap extends Rectangle {

    public Trap(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void checkCollision(Spirit spirit, double startX, double startY) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                    spirit.setCenterX(startX);
                    spirit.setCenterY(startY);
                    spirit.setVx(0);
                    spirit.setVy(0);
                    if (spirit.isReversed) spirit.reverseGravity();
                }
            }
        };
        timer.start();

    }

}