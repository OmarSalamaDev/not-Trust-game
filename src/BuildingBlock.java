import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BuildingBlock extends Rectangle {

    public BuildingBlock(double width, double height, Color color, double x, double y) {
        super(width, height, color);
        setX(x);
        setY(y);
    }

    public boolean checkCollision(CustomPlayableCircle circle) {
        // Check if the circle intersects with the block
        if (circle.getBoundsInParent().intersects(this.getBoundsInParent())) {
            double circleTop = circle.getCenterY() - circle.getRadius();
            double circleBottom = circle.getCenterY() + circle.getRadius();
            double circleLeft = circle.getCenterX() - circle.getRadius();
            double circleRight = circle.getCenterX() + circle.getRadius();




            // Circle is within the vertical boundaries of the block


            // Horizontal & Vertical collision detection


            // Circle is within the horizontal boundaries of the block
            if (circleRight > this.getX()) {
                // Circle is colliding with the sides of the block
                if (circle.getCenterX() > this.getX() && circle.getCenterX() < this.getX() + getWidth()) {
                    // Circle is within the block's width, adjust its position vertically
                    if (circleBottom > this.getY() && circleTop < this.getY() + getHeight() / 2.0) {
                        // Circle is colliding with the top half of the block, adjust its position to the top edge
                        circle.setCenterY(this.getY() - circle.getRadius());
                        circle.setVy(0);
                        circle.inAir = false;
                    } else if (circleTop < this.getY() + getHeight() && circleBottom > this.getY() + getHeight() / 2.0) {
                        // Circle is colliding with the bottom half of the block, adjust its position to the bottom edge
                        circle.setCenterY(this.getY() + getHeight() + circle.getRadius());
                        circle.setVy(0);
                    }
                } else {
                    // Circle is colliding with the sides of the block
                    if (circleRight > this.getX() && circleLeft < this.getX() + getWidth() / 2.0) {
                        // Circle is colliding with the left side of the block, adjust its position to the left edge
                        circle.setCenterX(this.getX() - circle.getRadius()-7);
                    } else if (circleLeft < this.getX() + getWidth() && circleRight > this.getX() + getWidth() / 2.0) {
                        // Circle is colliding with the right side of the block, adjust its position to the right edge
                        circle.setCenterX(this.getX() + getWidth() + circle.getRadius()+7);
                    }
                }
            }

            return true;
        }
        return false;
    }
}