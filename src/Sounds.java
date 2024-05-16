import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;


public class Sounds {




    public static void soundOfJump() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/jump_66.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();
    }

    public static void soundOfDeath() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/Death_92.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.setVolume(0.2);
        media.play();
    }

    public static void downReverseGravity() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/revflip.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();

    }

    public static void upReverseGravity() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/up.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();


    }

    public static void soundOfTeleport() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/Teleport_37.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();

    }

    public static void soundOfWin() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/win.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();
    }

    public static void soundOfButton() {
        Media sound = new Media("file:///C:/Users/Mars/Desktop/Project/src/media/audio/button-click.mp3");
        MediaPlayer media = new MediaPlayer(sound);
        media.play();
    }
}
