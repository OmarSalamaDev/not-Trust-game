import javafx.animation.AnimationTimer;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {


    /* >>>> class attributes <<<< */


    private boolean isBlock = false;
    private boolean isOnBlock = false;
    private CustomPlayableCircle spirit;


    /* >>>> constructors <<<< */


    public Block() {
    }
    public Block(double v, double v1, CustomPlayableCircle spirit) {
        super(v, v1);
        this.spirit = spirit;
        checkBlock();
    }
    public Block(double v, double v1, Paint paint, CustomPlayableCircle spirit) {
        super(v, v1, paint);
        this.spirit = spirit;
        checkBlock();
    }
    public Block(double v, double v1, double v2, double v3, CustomPlayableCircle spirit) {
        super(v, v1, v2, v3);
        this.spirit = spirit;
        checkBlock();
    }


    /* >>>> setters and getters <<<< */


    /* >>>>  <<<< */


    private void checkBlock() {
        AnimationTimer timer = new AnimationTimer() {
            double R = spirit.getRadius();
            double H = getHeight();
            double W = getWidth();
            @Override
            public void handle(long l) {
                // check if the spirit touches the block
                if (spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                    isBlock = true;

                    // upper and lower edge
                    if (spirit.getCenterX()+R > getX() && spirit.getCenterX()-R < getX()+W){
                        // the spirit is above the block
                        if (spirit.getCenterY()+R >= getY() && spirit.getCenterY()+R <= getY()+H/3.0) {
                            isOnBlock = true;
                            spirit.setxStep(5);
                            spirit.yGroundReference = getY();
                        }
                        // the spirit is under the block
                        else {
                            spirit.setUpperBorder(getY()+getHeight());
                        }
                    }
                    // left edge
                    if (spirit.getCenterX()+R == getX() && !isOnBlock) {
                        spirit.setRightBorder(getX());
                    }
                    // right edge
                    if (spirit.getCenterX()-R == getX()+W && !isOnBlock) {
                        spirit.setLeftBorder(getX()+W);
                    }
                }
                // if not touched, reset values
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
}
