import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    // global objects and variables
    public static Scene introScene;
    public static Scene mainMenu;
    public static Scene mainMenu2;

    public static Scene inGameMenu;
    public static Scene levelScenes;
    public static Spirit spirit;

    public static double screenWidth = 1200;
    public static double screenHeight = 600;


    public Paint[] theme1 = new Paint[3];
    public Paint[] theme2 = new Paint[3];
    public Paint[] theme3 = new Paint[3];
    public static Paint backgroundColor;
    public static Paint blockColor;
    public static Paint spiritColor;
    public static Paint trapColor;


    @Override
    public void start(Stage primaryStage) {
        
        // color setup
//        backgroundColor = Color.rgb(91, 233, 240);
//        blockColor = Color.rgb(19, 47, 99);
//        spiritColor = Color.RED;
//        trapColor = Color.GOLD;

//        backgroundColor = Color.rgb(76, 75, 76);
//        blockColor = Color.BLACK;
//        spiritColor = Color.WHITE;
//        trapColor = Color.rgb(163, 163, 163);

//        backgroundColor = Color.rgb(138, 67, 132);
//        blockColor = Color.rgb(64, 2, 58);
//        spiritColor = Color.rgb(255, 255, 255);
//        trapColor = Color.rgb(249, 115, 0);

        backgroundColor = Color.rgb(136, 156, 191);
        blockColor = Color.rgb(0, 32, 84);
        spiritColor = Color.rgb(255, 255, 255);
        trapColor = Color.rgb(224, 7, 13);

        // stage setup
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Balled");
        Image icon = new Image("media/icons/icon-1.png");
        primaryStage.getIcons().add(icon);


        // intro scene
        StackPane introStackPane = new StackPane();
        introScene = new Scene(introStackPane,screenWidth, screenHeight);
        String path = "src/media/videos/clip-1.mp4";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        MediaView mediaView = new MediaView(mediaPlayer);
        introStackPane.getChildren().add(mediaView);
        primaryStage.setScene(introScene);
         mediaPlayer.setOnEndOfMedia(() -> primaryStage.setScene(Scenes.mainMenu(primaryStage)));
        //mediaPlayer.setOnEndOfMedia(() -> primaryStage.setScene(mainMenu));



        // main menu
        StackPane main = new StackPane();
        mainMenu = new Scene(main, screenWidth, screenHeight, Color.DARKBLUE);
        CustomButton btn = new CustomButton(200,100,Color.RED,"play",Color.WHITE);
        main.getChildren().add(btn);
        btn.setOnMouseClicked(e -> primaryStage.setScene(levelScenes));


        // spirit object
        spirit = new Spirit(10, spiritColor);
        spirit.setDefaultBorders(100, screenHeight, screenWidth-100, 100);
        spirit.setCenterX(150);
        spirit.setCenterY(550);


        // primary scene
        levelScenes = new Scene(Levels.level(1), screenWidth, screenHeight, backgroundColor);
        //primaryStage.setScene(primaryScene);
        Control.spiritControls(primaryStage);


        // in-game main menu
        VBox d = new VBox();
        inGameMenu = new Scene(d,screenWidth,screenHeight, Color.BLACK);
        d.setAlignment(Pos.CENTER);
        d.setSpacing(20);
        CustomButton btn1 = new CustomButton(200,100,Color.BLUE,"nothing", Color.WHITE);
        CustomButton btn2 = new CustomButton(200,100,Color.RED,"back", Color.WHITE);
        d.getChildren().addAll(btn1, btn2);


        inGameMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                primaryStage.setScene(spirit.getScene());
            }
        });

        btn2.setOnMouseClicked(e -> primaryStage.setScene(mainMenu));







    }


    /* >>>> launcher  <<<< */


    public static void main(String[] args) {
        launch(args);
    }
}