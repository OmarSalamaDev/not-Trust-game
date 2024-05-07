import javafx.animation.AnimationTimer;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {


    /* >>>> class attributes <<<< */
    

    private double H;
    private double W;
    private double R;
    public static Spirit spirit;
    boolean isReset = false;


    /* >>>> constructors <<<< */


    public Block(double x, double y, double width, double height) {
        super(x, y, width, height);
        R = spirit.getRadius();
        H = getHeight();
        W = getWidth();
    }


    


    public void checkBlock() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // check if the spirit touches the block
                if (spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                    spirit.isBlock = true;
                    changeBorders(spirit);
                    isReset = true;
                }
                // if not touched, reset values
                else {
                    spirit.isBlock = false;
                    spirit.isOnBlock = false;
                    if (isReset) {
                        spirit.resetBorders();
                        isReset = false;
                    }
                }
            }
        };
        timer.start();
    }


    public void changeBorders(Spirit spirit) {
        // upper and lower edge
        if (spirit.getCenterX()+R > getX() && spirit.getCenterX()-R < getX()+W){
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
        else if (spirit.getCenterX()+R == getX()) {
            spirit.setRightBorder(getX());
        }
        // right edge
        else if (spirit.getCenterX()-R == getX()+W) {
            spirit.setLeftBorder(getX()+W);
        }
    }






}