
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Block extends Rectangle {


    /* >>>> class attributes <<<< */

    private static final List<Block> instances = new ArrayList<>();

    private final double H;
    private final double W;
    private final double R;
    public boolean isReset = false;
    public boolean isMoving = false;
    public boolean isTouched = false;
    public AnimationTimer intersectionTimer;
    private AnimationTimer animationTimer;
    private double motionStep;
    private boolean trollCheck = false;


    public enum MotionDirection {
        HORIZONTAL,
        VERTICAL
    }

    public enum MotionType {
        ENDLESS,
        END
    }


    /* >>>> constructors <<<< */


    public Block(double x, double y, double width, double height) {
        super(x, y, width, height);
        R = Main.spirit.getRadius();
        H = getHeight();
        W = getWidth();
        instances.add(this);
        checkBlock(true);
    }


    /* >>>> check for blocks <<<<*/


    public void checkBlock(boolean state) {
        if (!state) intersectionTimer.stop();
        else {
            intersectionTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    // check if the spirit touches the block
                    if (Main.spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                        Main.spirit.isBlock = true;
                        isTouched = true;
                        changeBorders(Main.spirit);
                        isReset = true;
                    }
                    // if not touched, reset values
                    else {
                        if (isReset) {
                            Main.spirit.isBlock = false;
                            isTouched = false;
                            Main.spirit.isOnBlock = false;
                            Main.spirit.isUnderBlock = false;
                            Main.spirit.resetBorders();
                            isReset = false;
                        }
                    }
                }
            };
            intersectionTimer.start();
        }
    }


    /* >>>> change borders <<<< */


    public void changeBorders(Spirit spirit) {
        // upper and lower edge
        if (spirit.getCenterX() + R > getX() + 5 && spirit.getCenterX() - R < getX() + W - 5) {
            // the spirit is above the block
            if (spirit.getCenterY() + R >= getY() && spirit.getCenterY() + R <= getY() + H / 1.5) {
                spirit.isOnBlock = true;
                spirit.setLowerBorder(getY());
            }
            // the spirit is under the block
            else {
                spirit.setUpperBorder(getY() + getHeight());
                spirit.isUnderBlock = true;
            }
        }
        // left edge
        else if (spirit.getCenterX() + R >= getX() && spirit.getCenterX() + R <= getX() + W / 1.5) {
            spirit.setRightBorder(getX());
        }
        // right edge
        else if (spirit.getCenterX() - R <= getX() + W && spirit.getCenterX() - R >= getX() + W / 1.5) {
            spirit.setLeftBorder(getX() + W);
        }
    }


    /* >>>> animation setup <<<< */


    public void setupAnimation(double startPos, double endPos, MotionDirection motionDirection, MotionType motionType, double troll, double step) {
        motionStep = step;
        if ((motionDirection == MotionDirection.HORIZONTAL) && (motionType == MotionType.ENDLESS)) {
            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (getX() + motionStep >= endPos) motionStep *= -1;
                    else if (getX() + motionStep <= startPos) motionStep *= -1;
                    setX(getX() + motionStep);
                    if (isTouched) {
                        Main.spirit.setCenterX(Main.spirit.getCenterX() + motionStep);
                    }
                }
            };
        }
        else if ((motionDirection == MotionDirection.HORIZONTAL) && (motionType == MotionType.END)) {
            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() >= troll) trollCheck = true;
                    if (trollCheck) {
                        if ((getX() + motionStep < endPos) && (getX() + motionStep > startPos)) {
                            setX(getX() + motionStep);
                            if (isTouched) {
                                Main.spirit.setCenterX(Main.spirit.getCenterX() + motionStep);
                            }
                        }

                    }
                }
            };
        }
        else if ((motionDirection == MotionDirection.VERTICAL) && (motionType == MotionType.ENDLESS)) {
            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (getY() + motionStep >= endPos) motionStep *= -1;
                    else if (getY() + motionStep <= startPos) motionStep *= -1;
                    setY(getY() + motionStep);
                    if (isTouched) {
                        Main.spirit.setCenterY(Main.spirit.getCenterY() + motionStep);
                        Main.spirit.setLowerBorder(Main.spirit.getLowerBorder() + motionStep);
                        Main.spirit.setUpperBorder(Main.spirit.getUpperBorder() + motionStep);
                    }
                }
            };
        }
        else if ((motionDirection == MotionDirection.VERTICAL) && (motionType == MotionType.END)) {
            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() >= troll) trollCheck = true;
                    if (trollCheck) {
                        if (getY() + motionStep < endPos) {
                            setY(getY() + motionStep);
                            if (isTouched) {
                                Main.spirit.setCenterY(Main.spirit.getCenterY() + motionStep);
                                Main.spirit.setLowerBorder(Main.spirit.getLowerBorder() + motionStep);
                                Main.spirit.setUpperBorder(Main.spirit.getUpperBorder() + motionStep);
                            }
                        }

                    }
                }
            };

        }
    }



    /* >>>> animation start/stop <<<< */


    public void animate(boolean state) {
        if (state) {
            isMoving = true;
            animationTimer.start();
        } else {
            isMoving = false;
            animationTimer.stop();
        }
    }

    public static void stopAnimationTimers() {
        for (Block instance : instances) {
            instance.intersectionTimer.stop();
            if (instance.isMoving) instance.animationTimer.stop();
        }
    }
}
