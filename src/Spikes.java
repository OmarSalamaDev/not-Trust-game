import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Spikes extends Trap {


    public Spikes(double x, double y) {
        super(x, y, 50, 10);
        Image img = new Image(Main.spikeImagePath);
        this.setFill(new ImagePattern(img));
    }
}
