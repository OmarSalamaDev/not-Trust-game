import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;


public class Sounds {


    static MediaPlayer media;
    public static boolean audioState = true;


    public static void soundOfJump() {
        Media sound = new Media(new File("src/media/audio/jump.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        if(audioState) {
            media.play();
        }
        else {
            media.pause();
        }
    }


    public static void soundOfDeath() {
        Media sound = new Media(new File("src/media/audio/death.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        media.setVolume(0.2);
        if(audioState){
            media.play();
        }
        else{
            media.pause();
        }
    }


    public static void downReverseGravity() {
        Media sound = new Media(new File("src/media/audio/revflip.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        if(audioState){
            media.play();
        }
        else{
            media.pause();
        }

    }


    public static void upReverseGravity() {
        Media sound = new Media(new File("src/media/audio/up.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        if(audioState){
            media.play();
        }
        else{
            media.pause();
        }
    }


    public static void soundOfWin() {
        Media sound = new Media(new File("src/media/audio/Win.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        if(audioState){
            media.play();
        }
        else{
            media.pause();
        }
    }


    public static void soundOfButton() {
        Media sound = new Media(new File("src/media/audio/button-click.mp3").toURI().toString());
        media = new MediaPlayer(sound);
        if(audioState){
            media.play();
        }
        else{
            media.pause();
        }
    }


}
