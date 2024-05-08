import javafx.animation.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Spirit extends Circle {


    /* >>>> class attributes <<<< */


    private double GRAVITY = 0.5;

    private double Vx = 0.0;
    private double Vy = 0.0;
    private double xStep = 5;
    private double yStep = 10;
    public boolean inAir = false;

    // scene borders relative to the class
    private double lowerBorder;
    private double upperBorder;
    private double leftBorder;
    private double rightBorder;

    private double defaultLower;
    private double defaultUpper;
    private double defaultLeft;
    private double defaultRight;

    public boolean isBlock = false;
    public boolean isOnBlock = false;
    public boolean isReversed = false;


    /* >>>> constructors <<<< */


    public Spirit(double radius) {
        super(radius);
    }
    public Spirit(double radius, Paint paint) {
        super(radius, paint);
        enableMotion();
    }
    public Spirit() {
        enableMotion();
    }
    public Spirit(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
        enableMotion();
    }
    public Spirit(double centerX, double centerY, double radius, Paint paint) {
        super(centerX, centerY, radius, paint);
        enableMotion();
    }


    /* >>>> setters and getters <<<< */


    // Scene borders setter
    public void setDefaultBorders(double upperBorder, double lowerBorder, double rightBorder, double leftBorder) {
        this.lowerBorder = lowerBorder;
        this.upperBorder = upperBorder;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;

        defaultLower = lowerBorder;
        defaultUpper = upperBorder;
        defaultLeft = leftBorder;
        defaultRight = rightBorder;
    }

    // borders
    public double getLowerBorder() {
        return lowerBorder;
    }
    public void setLowerBorder(double lowerSceneBorder) {
        this.lowerBorder = lowerSceneBorder;
    }
    public double getUpperBorder() {
        return upperBorder;
    }
    public void setUpperBorder(double upperSceneBorder) {
        this.upperBorder = upperSceneBorder;
    }
    public double getLeftBorder() {
        return leftBorder;
    }
    public void setLeftBorder(double leftSceneBorder) {
        this.leftBorder = leftSceneBorder;
    }
    public double getRightBorder() {
        return rightBorder;
    }
    public void setRightBorder(double rightSceneBorder) {
        this.rightBorder = rightSceneBorder;
    }

    // reset borders
    public void resetBorders() {
        lowerBorder = defaultLower;
        upperBorder = defaultUpper;
        leftBorder = defaultLeft;
        rightBorder = defaultRight;
    }

    // velocity
    public double getVx() {
        return Vx;
    }
    public void setVx(double vx) {
        this.Vx = vx;
    }
    public double getVy() {
        return Vy;
    }
    public void setVy(double vy) {
        this.Vy = vy;
    }

    // steps
    public double getxStep() {
        return xStep;
    }
    public void setxStep(double xStep) {
        this.xStep = xStep;
    }
    public double getyStep() {
        return yStep;
    }
    public void setyStep(double yStep) {
        this.yStep = yStep;
    }

    // gravity flipper
    public void gravityFlip() {
        GRAVITY *= -1;
        yStep *= -1;
        isReversed = !isReversed;
    }



    /* >>>> Update position function <<<< */


    public void updatePosition() {

        // add gravity
        Vy += GRAVITY;

        // set new positions
        double newX = getCenterX() + Vx;
        double newY = getCenterY() + Vy;

        // checks if the object hits the borders of the scene

        if (newX > rightBorder - getRadius()) newX = rightBorder - getRadius();
        if (newX < leftBorder + getRadius()) newX = leftBorder + getRadius();
        if(!isReversed) {
            if (newY >= lowerBorder - getRadius()) {
                newY = lowerBorder - getRadius();
                Vy = 0.0;
                inAir = false;
            }
            if (newY < upperBorder + getRadius()) {
                newY = upperBorder + getRadius();
                Vy = 0;
            }
        }
        else {
            if (newY <= upperBorder + getRadius()) {
                newY = upperBorder + getRadius();
                Vy = 0.0;
                inAir = false;
            }
            if (newY > lowerBorder - getRadius()) {
                newY = lowerBorder - getRadius();
                Vy = 0;
            }
        }

        // apply the new position
        setCenterX(newX);
        setCenterY(newY);
    }


    /* >>>> deformation functions <<<< */


    public void xDeformation(double factor) {
        ScaleTransition deformationAnimation = new ScaleTransition(Duration.millis(100), this);
        deformationAnimation.setFromX(1);
        deformationAnimation.setToX(factor);
        deformationAnimation.setAutoReverse(true);
        deformationAnimation.setCycleCount(2);
        deformationAnimation.play();

    }
    public void yDeformation(double factor) {
        ScaleTransition deformationAnimation = new ScaleTransition(Duration.millis(100), this);
        deformationAnimation.setFromY(1);
        deformationAnimation.setToY(factor);
        deformationAnimation.setAutoReverse(true);
        deformationAnimation.setCycleCount(2);
        deformationAnimation.play();
    }


    /* >>>> enable motion for the object  <<<< */


    public void enableMotion() {
        AnimationTimer motionTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                updatePosition();
            }
        };
        motionTimer.start();
    }


    /* >>>> ..... <<<< */




    /* >>>> ..... <<<< */


}