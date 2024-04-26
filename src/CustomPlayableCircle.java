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

    private static final double movingStep = 10.0;
    private double xDisplacement = 0.0;

    private double motionDuration = 16.0;

    private ScaleTransition deformationAnimation;
    private double deformationDuration = 100.0;

    public double yGroundReference;


/* >>>> constructors <<<< */


    public CustomPlayableCircle(double v2) {
        super(v2);
    }
    public CustomPlayableCircle(double v2, Paint paint) {
        super(v2, paint);
    }
    public CustomPlayableCircle() {
    }
    public CustomPlayableCircle(double v, double v1, double v2) {
        super(v, v1, v2);
    }
    public CustomPlayableCircle(double v, double v1, double v2, Paint paint) {
        super(v, v1, v2, paint);
    }


/* >>>> setters and getters <<<< */


/* >>>> enable object motion controls function <<<< */


    public void enableMotionControls() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(motionDuration), e -> {
        // horizontal motion
            double newX = this.getCenterX() + xDisplacement;
            // checks if the object hits the walls of the scene
            if (newX > this.getScene().getWidth() - this.getRadius()) {
                newX = this.getScene().getWidth() - this.getRadius();
            }
            if (newX < this.getRadius()) {
                newX = this.getRadius();
            }
            this.setCenterX(newX);

        // vertical motion
            // V = Vo + g*t
            // the equation is reduced and simplified to avoid doing multiplication/division operations which can lead to accuracy problems.
            yVelocity += VirtualGravity;

            double newY = this.getCenterY() + yVelocity;

            // Checks if the object hits the ground reference of y-axis
            if (newY >= this.yGroundReference - this.getRadius()) {
                newY = this.yGroundReference - this.getRadius();
                yVelocity = 0.0;
                inAir = false;
            }
            this.setCenterY(newY);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
        if (key == KeyCode.RIGHT) {
            xDisplacement = movingStep;
            this.xDeformation(1.1);
        }
        else if (key == KeyCode.LEFT) {
            xDisplacement = -movingStep;
            this.xDeformation(1.1);
        }
        else if (key == KeyCode.SPACE && !inAir) {
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
