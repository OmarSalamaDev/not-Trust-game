import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import java.io.*;
import java.util.Scanner;


public class Main extends Application {


    // global objects and variables

    public static Spirit spirit;

    public static Paint backgroundColor;
    public static Paint blockColor;
    public static Paint spiritColor;
    public static Paint trapColor;
    public static String spikeImagePath;


    @Override
    public void start(Stage primaryStage) {

        theme1();
        loadOptionsFile();

        // setup stage
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("!Trust");
        Image icon = new Image("media/icons/icon1.png");
         primaryStage.getIcons().add(icon);


        // instantiate spirit object
        spirit = new Spirit(10, spiritColor);
        spirit.setDefaultBorders(-10, 700, 1200, 0);

        // setup menus and scenes
        ScenesLoader.setupMenus(primaryStage);

        // play intro scene
        primaryStage.setScene(ScenesLoader.introScene());
        //to skip intro
//        ScenesLoader.currentScene = 2;
//        ScenesLoader.previousScene = 1;
//        primaryStage.setScene(ScenesLoader.levelSelectMenu);

    }


    public static void loadOptionsFile() {
        try {
            Scanner input = new Scanner(new File("src/options.txt"));
            if (input.hasNext()) {
                switch (input.next()) {
                    case "2":
                        theme2();
                        break;
                    case "3":
                        theme3();
                        break;
                    default:
                        theme1();
                }
                if (input.hasNext()) {
                    Sounds.audioState = !"0".equals(input.next());
                }
                else {
                    Sounds.audioState = true;
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            writeToFile(ScenesLoader.themeNum,Sounds.audioState);
        }
    }


    public static void writeToFile ( int themeNumber, boolean audioState) {
        String audio;
        if (audioState) audio = "1";
        else {
            audio = "0";
        }
        try {
            PrintWriter output = new PrintWriter(new FileOutputStream(new File("src/options.txt"), false));
            output.append(themeNumber + " " + audio);
            output.close();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("There is no file");
            alert.show();
        }
    }


    public static void theme1() {
        ScenesLoader.themeNum = 1;
        spiritColor = Color.rgb(255, 255, 255);
        backgroundColor = Color.rgb(76, 75, 76);
        blockColor = Color.BLACK;
        trapColor = Color.rgb(163, 163, 163);
        spikeImagePath = "media/images/trap-1.png";
    }


    public static void theme2() {
        ScenesLoader.themeNum = 2;
        spiritColor = Color.rgb(255, 255, 255);
        backgroundColor = Color.rgb(138, 67, 132);
        blockColor = Color.rgb(64, 2, 58);
        trapColor = Color.rgb(249, 115, 0);
        spikeImagePath = "media/images/trap-2.png";
    }


    public static void theme3() {
        ScenesLoader.themeNum = 3;
        spiritColor = Color.rgb(255, 255, 255);
        backgroundColor = Color.rgb(136, 156, 191);
        blockColor = Color.rgb(0, 32, 84);
        trapColor = Color.rgb(224, 7, 13);
        spikeImagePath = "media/images/trap-3.png";
    }


    /* >>>> launcher  <<<< */


    public static void main (String[]args){
        launch(args);
    }

}