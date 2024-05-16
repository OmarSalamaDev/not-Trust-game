import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;


public class Door extends Block {

    public Door(double x, double y) {
        super(x, y, 30, 45);
        Image img = new Image("media/images/door.png");
        this.setFill(new ImagePattern(img));
    }

    @Override
    public void checkBlock(boolean state) {
        if (!state) intersectionTimer.stop();
        else {
            intersectionTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getBoundsInParent().intersects(getBoundsInParent())) {
                        Sounds.soundOfWin();
                        ScenesLoader.gameRoot.getChildren().clear();
                        ScenesLoader.gameRoot.getChildren().add(Levels.level(Levels.currentLevel + 1));
                    }
                }
            };
            intersectionTimer.start();
        }
    }


}
