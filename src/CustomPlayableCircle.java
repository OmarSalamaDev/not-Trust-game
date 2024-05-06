import javafx.animation.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class CustomPlayableCircle extends Circle {


    /* >>>> class attributes <<<< */


    private static final double GRAVITY = 0.5;

    private double Vx = 0.0;
    private double Vy = 0.0;
    private double xStep = 5;
    private double yStep = 10;
    public boolean inAir = false;

    public double yGroundReference;

    // scene borders relative to the class
    private double lowerBorder;
    private double upperBorder;
    private double leftSBorder;
    private double rightBorder;


    /* >>>> constructors <<<< */


    public CustomPlayableCircle(double radius) {
        super(radius);
    }
    public CustomPlayableCircle(double radius, Paint paint) {
        super(radius, paint);
    }
    public CustomPlayableCircle() {
    }
    public CustomPlayableCircle(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }
    public CustomPlayableCircle(double centerX, double centerY, double radius, Paint paint) {
        super(centerX, centerY, radius, paint);
    }


    /* >>>> setters and getters <<<< */


    // Scene borders setter
    public void setSceneBorders(double upperSceneBorder, double lowerSceneBorder, double rightSceneBorder, double leftSceneBorder) {
        this.upperBorder = upperSceneBorder;
        this.lowerBorder = lowerSceneBorder;
        this.rightBorder = rightSceneBorder;
        this.leftSBorder = leftSceneBorder;
    }

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
        return leftSBorder;
    }

    public void setLeftBorder(double leftSceneBorder) {
        this.leftSBorder = leftSceneBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightSceneBorder) {
        this.rightBorder = rightSceneBorder;
    }



    // velocity getters and setters
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



    /* >>>> Update position function <<<< */


    public void updatePosition() {

        // add gravity
        Vy += GRAVITY;

        // set new positions
        double newX = getCenterX() + Vx;
        double newY = getCenterY() + Vy;

        // checks if the object hits the borders of the scene
        if (newX > rightBorder - getRadius()) newX = rightBorder - getRadius();
        if (newX < leftSBorder + getRadius()) newX = leftSBorder + getRadius();
        if (newY >= yGroundReference - getRadius()) {
            newY = yGroundReference - getRadius();
            Vy = 0.0;
            inAir = false;
        }
        if (newY < upperBorder + getRadius()) {
            newY = upperBorder + getRadius();
            Vy = 0;
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


    /* >>>> ..... <<<< */





    /* >>>> ..... <<<< */




    /* >>>> ..... <<<< */


}