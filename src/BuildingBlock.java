import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BuildingBlock extends Rectangle {

    public BuildingBlock(double width, double height, Color color, double x, double y) {
        super(width, height, color);
        setTranslateX(x);
        setTranslateY(y);
    }

   public boolean checkCollision(CustomPlayableCircle circle) {
    // Check if the circle intersects with the block
    if (circle.getBoundsInParent().intersects(this.getBoundsInParent())) {
        double circleTop = circle.getCenterY() - circle.getRadius();
        double circleBottom = circle.getCenterY() + circle.getRadius();
        double circleLeft = circle.getCenterX() - circle.getRadius();
        double circleRight = circle.getCenterX() + circle.getRadius();

        // Vertical collision detection
        if (circleBottom > this.getTranslateY() && circleTop < this.getTranslateY() + getHeight()) {
            // Circle is within the vertical boundaries of the block
            if (circleBottom > this.getTranslateY() && circleBottom < this.getTranslateY() + getHeight() / 2.0) {
                // Circle is colliding with the top half of the block
                circle.setCenterY(this.getTranslateY() - circle.getRadius());
                circle.stop();
            } else if (circleTop < this.getTranslateY() + getHeight() && circleTop > this.getTranslateY() + getHeight() / 2.0) {
                // Circle is colliding with the bottom half of the block
                circle.setCenterY(this.getTranslateY() + getHeight() + circle.getRadius());
                circle.stop();
            }
        }

        // Horizontal collision detection
        if (circleRight > this.getTranslateX() && circleLeft < this.getTranslateX() + getWidth()) {
            // Circle is within the horizontal boundaries of the block
            if (circleRight > this.getTranslateX() && circleLeft < this.getTranslateX() + getWidth()) {
                // Circle is colliding with the sides of the block
                if (circle.getCenterX() > this.getTranslateX()-2 && circle.getCenterX() < this.getTranslateX() + getWidth()+2) {
                    // Circle is within the block's width, adjust its position vertically
                    if (circleBottom > this.getTranslateY() && circleTop < this.getTranslateY() + getHeight() / 2.0) {
                        // Circle is colliding with the top half of the block, adjust its position to the top edge
                        circle.setCenterY(this.getTranslateY() - circle.getRadius());
                        circle.stop();
                    } else if (circleTop < this.getTranslateY() + getHeight() && circleBottom > this.getTranslateY() + getHeight() / 2.0) {
                        // Circle is colliding with the bottom half of the block, adjust its position to the bottom edge
                        circle.setCenterY(this.getTranslateY() + getHeight() + circle.getRadius());
                        circle.stop();
                    }
                } else {
                    // Circle is colliding with the sides of the block
                    if (circleRight > this.getTranslateX() && circleLeft < this.getTranslateX() + getWidth() / 2.0) {
                        // Circle is colliding with the left side of the block, adjust its position to the left edge
                        circle.setCenterX(this.getTranslateX() - circle.getRadius()-7);
                    } else if (circleLeft < this.getTranslateX() + getWidth() && circleRight > this.getTranslateX() + getWidth() / 2.0) {
                        // Circle is colliding with the right side of the block, adjust its position to the right edge
                        circle.setCenterX(this.getTranslateX() + getWidth() + circle.getRadius()+7);
                    }
                }
            }
        }
        return true;
    }
    return false;
}



}
