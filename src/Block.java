import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {


    /* >>>> class attributes <<<< */
    

    private final double H;
    private final double W;
    private final double R;
    public static Spirit spirit;
    public boolean isReset = false;
    public boolean isMoving = false;
    public boolean isTouched = false;
    private AnimationTimer timer;
    private double motionStep;

    public enum MotionType {
        HORIZONTAL,
        VERTICAL
    }


    /* >>>> constructors <<<< */


    public Block(double x, double y, double width, double height) {
        super(x, y, width, height);
        R = spirit.getRadius();
        H = getHeight();
        W = getWidth();
    }


    /* >>>> check for blocks <<<<*/


    public void checkBlock() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // check if the spirit touches the block
                if (spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                    spirit.isBlock = true;
                    isTouched = true;
                    changeBorders(spirit);
                    isReset = true;
                }
                // if not touched, reset values
                else {
                    if (isReset) {
                        spirit.isBlock = false;
                        isTouched = false;
                        spirit.isOnBlock = false;
                        spirit.resetBorders();
                        isReset = false;
                    }
                }
            }
        };
        timer.start();
    }


    /* >>>> change borders <<<< */


    public void changeBorders(Spirit spirit) {
        // upper and lower edge
        if (spirit.getCenterX()+R > getX()+5 && spirit.getCenterX()-R < getX()+W-5){
            // the spirit is above the block
            if (spirit.getCenterY()+R >= getY() && spirit.getCenterY()+R <= getY()+H/1.5) {
                spirit.isOnBlock = true;
                spirit.setLowerBorder(getY());
            }
            // the spirit is under the block
            else {
                spirit.setUpperBorder(getY()+getHeight());
            }
        }
        // left edge
        else if (spirit.getCenterX()+R >= getX() && spirit.getCenterX()+R <= getX()+W/1.5) {
            spirit.setRightBorder(getX());
        }
        // right edge
        else if (spirit.getCenterX()-R <= getX()+W && spirit.getCenterX()-R >= getX()+W/1.5) {
            spirit.setLeftBorder(getX()+W);
        }
    }


    /* >>>> animation setup <<<< */


    public void setupAnimation(double startPos, double endPos, MotionType motionType, double step) {
        motionStep = step;
        if (motionType == MotionType.HORIZONTAL) {
            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (getX()+motionStep >= endPos) motionStep *= -1;
                    else if (getX()+motionStep <= startPos) motionStep *= -1;
                    setX(getX() + motionStep);
                    if (isTouched) {
                        spirit.setCenterX(spirit.getCenterX()+motionStep);
                    }
                }
            };
        }
        else if (motionType == MotionType.VERTICAL) {
            timer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (getY()+motionStep >= endPos) motionStep *= -1;
                    else if (getY()+motionStep <= startPos) motionStep *= -1;
                    setY(getY() + motionStep);
                    if (isTouched) {
                        spirit.setCenterY(spirit.getCenterY()+motionStep);
                        spirit.setLowerBorder(spirit.getLowerBorder()+motionStep);
                        spirit.setUpperBorder(spirit.getUpperBorder()+motionStep);
                    }
                }
            };
        }
    }


    /* >>>> animation start/stop <<<< */


    public void animate(boolean state) {
        if (state) {
            isMoving = true;
            timer.start();
        }
        else {
            isMoving = false;
            timer.stop();
        }
    }



}