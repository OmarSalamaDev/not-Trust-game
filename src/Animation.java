
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class Animation extends Pane {
    private Block block;
    private Spirit spirit;
    private double startMotion;
    private double endMotion;
    private double step ;
    private boolean moveRight = true;
    private boolean moveUp = true;
    private MotionType motionType;

    public enum MotionType {
        HORIZONTAL,
        VERTICAL
    }

    public Animation(Block block, Spirit spirit, double startMotion, double endMotion, double step, MotionType motionType) {
        this.block = block;
        this.spirit = spirit;
        this.startMotion = startMotion;
        this.endMotion = endMotion;
        this.motionType = motionType;
        this.step=step;
        startAnimation();
    }

    private void startAnimation() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (motionType == MotionType.HORIZONTAL) {
                    horizontalMove();
                } else if (motionType == MotionType.VERTICAL) {
                    verticalMove();
                }
            }
        };
        animationTimer.start();
    }

    private void horizontalMove() {
        double newX;
        if (spirit.isOnBlock) {
            // If the spirit is on the block, synchronize its movement with the block
//            double delta = moveRight ? step : -step; // Determine the direction of movement
//            spirit.setCenterX(spirit.getCenterX() + delta);
            spirit.setCenterX(spirit.getCenterX() + (moveRight ? step : -step));
        }
        if (moveRight) {
            newX = block.getX() + step;
            if (newX > endMotion - block.getWidth()) {
                moveRight = false; // Change direction
                newX = endMotion - block.getWidth(); // Set newX to maximum width
            }
        } else {
            newX = block.getX() - step;
            if (newX < startMotion) {
                moveRight = true; // Change direction
                newX = startMotion; // Set newX to 0
            }
        }
        block.setX(newX);
    }

    private void verticalMove() {
        double newY;
        if (spirit.isOnBlock) {
            // If the spirit is on the block, synchronize its movement with the block
            double delta = moveUp ? step : -step; // Determine the direction of movement
            spirit.setCenterY(spirit.getCenterY() + delta);
        }
        if (moveUp) {
            newY = block.getY() - step;
            if (newY < startMotion) {
                moveUp = false; // Change direction
                newY = startMotion; // Set newY to 0
            }
        } else {
            newY = block.getY() + step;
            if (newY > endMotion - block.getHeight()) {
                moveUp = true; // Change direction
                newY = endMotion - block.getHeight(); // Set newY to maximum height
            }
        }
        block.setY(newY);
    }
}