import javafx.animation.*;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class CustomPlayableCircle extends Circle {


/* >>>> class attributes <<<< */


    private static final double VirtualGravity = 0.5;

    private double jumpVelocity = -10.0;
    private double yVelocity = 0.0;
    private boolean inAir = false;

    private static final double movingStep = 5;
    private double xDisplacement = 0.0;

    private ScaleTransition deformationAnimation;
    private double deformationDuration = 100.0;

    public double yGroundReference;


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

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }


    /* >>>> move function <<<< */


    public void enableMotionControls() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                // horizontal motion
                double newX = getCenterX() + xDisplacement;
                // checks if the object hits the walls of the scene
                if (newX > getScene().getWidth() - getRadius()) {
                    newX = getScene().getWidth() - getRadius();
                }
                if (newX < getRadius()) {
                    newX = getRadius();
                }
                setCenterX(newX);

                // vertical motion
                // V = Vo + g*t
                // the equation is reduced and simplified to avoid doing multiplication/division operations which can lead to accuracy problems.
                yVelocity += VirtualGravity;

                double newY = getCenterY() + yVelocity;

                // Checks if the object hits the ground reference of y-axis
                if (newY >= yGroundReference - getRadius()) {
                    newY = yGroundReference - getRadius();
                    yVelocity = 0.0;
                    inAir = false;
                }
                setCenterY(newY);
            }
        };
        animationTimer.start();
    }
    

/* >>>> deformation functions <<<< */


    public void xDeformation(double factor) {
        deformationAnimation = new ScaleTransition(Duration.millis(deformationDuration), this);
        deformationAnimation.setFromX(1);
        deformationAnimation.setToX(factor);
        deformationAnimation.setAutoReverse(true);
        deformationAnimation.setCycleCount(2);
        deformationAnimation.play();

    }
    public void yDeformation(double factor) {
        deformationAnimation = new ScaleTransition(Duration.millis(100), this);
        deformationAnimation.setFromY(1);
        deformationAnimation.setToY(factor);
        deformationAnimation.setAutoReverse(true);
        deformationAnimation.setCycleCount(2);
        deformationAnimation.play();
    }


/* >>>> pressed key handler function <<<< */


    public void handlePressedKey(KeyCode key) {
        if (key == KeyCode.RIGHT || key == KeyCode.D) {
            xDisplacement = movingStep;
            this.xDeformation(1.1);
        }
        if (key == KeyCode.LEFT || key == KeyCode.A) {
            xDisplacement = -movingStep;
            this.xDeformation(1.1);
        }
        if (key == KeyCode.SPACE && !inAir) {
            yVelocity = jumpVelocity;
            inAir = true;
            this.yDeformation(1.2);
        }
    }


/* >>>> Released key handler function <<<< */


    public void handleReleasedKey(KeyCode key) {
        xDisplacement = 0.0;
    }


/* >>>> ..... <<<< */


}
