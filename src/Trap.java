import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Trap extends Rectangle {

    public Trap(double width, double height, Color color, double x, double y) {
        super(width, height, color);
        setX(x);
        setY(y);
    }

    public boolean checkCollision(CustomPlayableCircle circle) {
        // Check if the circle intersects with the trap
        if (circle.getBoundsInParent().intersects(this.getBoundsInParent())) {
            // Reset the position of the circle
            circle.setCenterX(circle.getScene().getWidth() / 6.0); // Set to starting X position
            circle.setCenterY(circle.getLowerBorder() - circle.getRadius()); // Set to starting Y position
            return true;
        }
        return false;
    }
}