
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.File;


public class ScenesLoader {

    public static Stage primaryStage;

    public static Scene introScene;
    public static Scene mainMenu;
    public static Scene levelSelectMenu;
    public static Scene optionsMenu;
    public static Scene creditsMenu;
    public static Scene levelScene;
    public static StackPane inGameMenu;
    public static StackPane gameRoot = new StackPane();

    public static int currentScene = 0;
    public static int previousScene = 0;
    // 0 -> introScene
    // 1 -> mainMenu
    // 2 -> levelSelectMenu
    // 3 -> optionsMenu
    // 4 -> creditsMenu
    // 5 -> levelScene
    // 6 -> in game menu


    public static void setupMenus(Stage stage) {
        primaryStage = stage;
        introSceneSetup();
        mainMenuSetup();
        creditsMenuSetup();
        optionMenuSetup();
        levelSelectMenuSetup();
        gameOptions();
        levelSceneSetup();
    }


    private static void introSceneSetup() {

        StackPane introStackPane = new StackPane();
        introScene = new Scene(introStackPane, 1200, 600);
        String path = "src/media/videos/clip-1.mp4";
        Media introMedia = new Media(new File(path).toURI().toString());
        MediaPlayer introMediaPlayer = new MediaPlayer(introMedia);
        introMediaPlayer.play();
        MediaView introMediaView = new MediaView(introMediaPlayer);
        introStackPane.getChildren().add(introMediaView);
        introMediaPlayer.setOnEndOfMedia(() -> {
            primaryStage.setScene(mainMenu);
            previousScene = 0;
            currentScene = 1;
        });

    }


    private static void mainMenuSetup() {

    //--> menu elements <--//

        Button startBtn = new Button("Play");
        startBtn.setId("genericButton");
        startBtn.getStyleClass().add("genericButton");

        Button optionsBtn = new Button("Options");
        optionsBtn.setId("genericButton");
        optionsBtn.getStyleClass().add("genericButton");

        Button creditsBtn = new Button("Credits");
        creditsBtn.setId("genericButton");
        creditsBtn.getStyleClass().add("genericButton");

        Button exitBtn = new Button("Exit");
        exitBtn.setId("genericButton");
        exitBtn.getStyleClass().add("genericButton");

        VBox vBox = new VBox(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(startBtn, optionsBtn, creditsBtn, exitBtn);

        HBox root = new HBox(150);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(100));
        root.getChildren().addAll(vBox);
        root.setBackground(Background.fill(Color.BLACK));

        mainMenu = new Scene(root,1200,600);

        mainMenu.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

    //--> menu controls <--//

        startBtn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            switchSceneSmoothly(levelSelectMenu);
            previousScene = 1;
            currentScene = 2;
        });

        optionsBtn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            switchSceneSmoothly(optionsMenu);
            previousScene = 1;
            currentScene = 3;
        });

        creditsBtn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            switchSceneSmoothly(creditsMenu);
            previousScene = 1;
            currentScene = 4;
        });

        exitBtn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            primaryStage.close();
        });
    }


    private static void creditsMenuSetup() {

    //--> menu elements <--//

        Button backBtn = new Button("back");
        backBtn.setId("genericButton");
        backBtn.getStyleClass().add("genericButton");
        backBtn.setLayoutX(40);
        backBtn.setLayoutY(520);

        Label c = new Label("©");
        c.setFont(Font.font("Consolas",30));
        c.setTextFill(Color.WHITE);

        Label copyRight = new Label(" All rights reserved to the developers");
        copyRight.setFont(Font.font("Consolas",25));
        copyRight.setTextFill(Color.WHITE);

        HBox hbox = new HBox(c,copyRight);
        hbox.setAlignment(Pos.CENTER);
        hbox.setLayoutX(390);
        hbox.setLayoutY(480);

        Label label = new Label("Developed by");
        label.setFont(Font.font("Consolas",40));
        label.setTextFill(Color.WHITE);
        HBox h1 = new HBox(label);

        Label names = new Label(
                "Ahmed El-Sherbiny Othman"
                +"\n"+"Ayman Yasser Ahmed"
                +"\n"+"Hazem Sherif Mohamed"
                +"\n"+"Hamed Islam Ahmed"
                +"\n"+"Hamdi Emad Hamdi"
                +"\n"+"Omar Abdulaziz Muhammad"
                +"\n"+"Mazen Yasser Refaat"
                +"\n"+"Mohamed Adel Mohamed"
        );
        names.setFont(Font.font("Consolas",20));
        names.setTextFill(Color.WHITE);

        HBox h2=new HBox(names);
        h2.setAlignment(Pos.CENTER);
        VBox v1 = new VBox(20,h1,h2);
        v1.setLayoutX(450);
        v1.setLayoutY(110);

        Pane pane = new Pane(hbox,v1,backBtn);
        pane.setBackground(Background.fill(Color.BLACK));
        pane.setOpacity(0.5);

        creditsMenu = new Scene(pane,1200,600);
        creditsMenu.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

    //--> menu controls <--//

        backBtn.setOnMouseClicked(e->{
            Sounds.soundOfButton();
            switchSceneSmoothly(mainMenu);
            previousScene = 4;
            currentScene = 1;
        });

        creditsMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 4;
                currentScene = 1;
            }
        });
    }


    private static void optionMenuSetup() {

    //--> menu elements <--//

        Button backBtn = new Button("back");
        backBtn.setId("genericButton");
        backBtn.getStyleClass().add("genericButton");

        StackPane stackPane = new StackPane();
        stackPane.setBackground(Background.fill(Color.BLACK));
        stackPane.getChildren().add(backBtn);
        optionsMenu = new Scene(stackPane, 1200,600);
        optionsMenu.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

    //--> menu controls <--//

        backBtn.setOnMouseClicked(e->{
            Sounds.soundOfButton();
            if (previousScene == 1) {
                switchSceneSmoothly(mainMenu);
                previousScene = 3;
                currentScene = 1;
            }
            else if (previousScene == 6) {
                switchSceneSmoothly(levelScene);
                previousScene = 3;
                currentScene = 6;
            }
        });

        optionsMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Sounds.soundOfButton();
                if (previousScene == 1) {
                    switchSceneSmoothly(mainMenu);
                    previousScene = 3;
                    currentScene = 1;
                } else if (previousScene == 6) {
                    switchSceneSmoothly(levelScene);
                    previousScene = 3;
                    currentScene = 6;
                }
            }
        });

    }


    private static void levelSelectMenuSetup() {

    //--> menu elements <--//

        Button level1Btn = new Button("level 1");
        level1Btn.setId("genericButton");
        level1Btn.getStyleClass().add("genericButton");
        Button level2Btn = new Button("level 2");
        level2Btn.setId("genericButton");
        level2Btn.getStyleClass().add("genericButton");
        Button level3Btn = new Button("level 3");
        level3Btn.setId("genericButton");
        level3Btn.getStyleClass().add("genericButton");

        HBox row1 = new HBox();
        row1.setSpacing(20);
        row1.setAlignment(Pos.CENTER);
        row1.getChildren().addAll(level1Btn, level2Btn, level3Btn);

        Button level4Btn = new Button("level 4");
        level4Btn.setId("genericButton");
        level4Btn.getStyleClass().add("genericButton");
        Button level5Btn = new Button("level 5");
        level5Btn.setId("genericButton");
        level5Btn.getStyleClass().add("genericButton");
        Button level6Btn = new Button("level 6");
        level6Btn.setId("genericButton");
        level6Btn.getStyleClass().add("genericButton");

        HBox row2 = new HBox();
        row2.setSpacing(20);
        row2.setAlignment(Pos.CENTER);
        row2.getChildren().addAll(level4Btn, level5Btn, level6Btn);

        Button backBtn = new Button("back");
        backBtn.setId("genericButton");
        backBtn.getStyleClass().add("genericButton");
        backBtn.setLayoutX(40);
        backBtn.setLayoutY(520);

        VBox vbox = new VBox();
        vbox.setBackground(Background.fill(Color.BLACK));
        vbox.getChildren().addAll(row1, row2, backBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(50);
        levelSelectMenu = new Scene(vbox, 1200,600);
        levelSelectMenu.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

    //--> menu controls <--//

        level1Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(1));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        level2Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(2));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        level3Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(3));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        level4Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(4));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        level5Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(5));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        level6Btn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().clear();
            gameRoot.getChildren().add(Levels.level(6));
            switchSceneSmoothly(levelScene);
            previousScene = 2;
            currentScene = 5;
        });

        backBtn.setOnMouseClicked(e-> {
            Sounds.soundOfButton();
            switchSceneSmoothly(mainMenu);
            previousScene = 2;
            currentScene = 1;
        });

        levelSelectMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 2;
                currentScene = 1;
            }
        });
    }


    private static void levelSceneSetup() {

    //--> scene elements <--//

        gameRoot.setBackground(Background.fill(Main.backgroundColor));
        levelScene = new Scene(gameRoot, 1200, 600);
        levelScene.setRoot(gameRoot);
        levelScene.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

    //--> scene controls <--//

        levelScene.setOnKeyPressed(e -> {
            KeyCode thisKey = e.getCode();
            if (thisKey == KeyCode.RIGHT && currentScene == 5) {
                Main.spirit.setVx(Main.spirit.getxStep());
            }
            else if (thisKey == KeyCode.LEFT && currentScene == 5) {
                Main.spirit.setVx(-Main.spirit.getxStep());
            }
            else if (thisKey == KeyCode.SPACE && !Main.spirit.inAir && currentScene == 5) {
                Sounds.soundOfJump();
                Main.spirit.setVy(-Main.spirit.getyStep());
                Main.spirit.inAir = true;
            }
            else if (thisKey == KeyCode.SHIFT && currentScene == 5 && Levels.currentLevel == 3) {
                if (Main.spirit.isReversed) Sounds.downReverseGravity();
                else Sounds.upReverseGravity();
                Main.spirit.reverseGravity();
                Main.spirit.inAir = false;
            }
            else if (thisKey == KeyCode.ESCAPE && currentScene == 5) {
                Sounds.soundOfButton();
                gameRoot.getChildren().addAll(inGameMenu);
                previousScene = 5;
                currentScene = 6;
            }
            else if (e.getCode() == KeyCode.ESCAPE && currentScene == 6) {
                Sounds.soundOfButton();
                gameRoot.getChildren().remove(inGameMenu);
                previousScene = 6;
                currentScene = 5;
            }
        });

        levelScene.setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                Main.spirit.setVx(0.0);
            }
        });

    }


    private static void gameOptions() {

    //--> menu elements <--//

        Rectangle inGameMenuContainer = new Rectangle(350,50,500,500);
        inGameMenuContainer.setFill(Color.BLACK);
        inGameMenuContainer.setOpacity(0.5);

        Button resumeBtn = new Button("resume");
        resumeBtn.setId("genericButton");
        resumeBtn.getStyleClass().add("genericButton");

        Button optionsBtn = new Button("options");
        optionsBtn.setId("genericButton");
        optionsBtn.getStyleClass().add("genericButton");

        Button mainMenuBtn = new Button("main menu");
        mainMenuBtn.setId("genericButton");
        mainMenuBtn.getStyleClass().add("genericButton");

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(resumeBtn,optionsBtn,mainMenuBtn);
        vBox.setAlignment(Pos.CENTER);
        inGameMenu = new StackPane();
        inGameMenu.getChildren().addAll(inGameMenuContainer,vBox);

    //--> scene controls <--//

        resumeBtn.setOnMouseClicked(e -> {
            Sounds.soundOfButton();
            gameRoot.getChildren().remove(inGameMenu);
            previousScene = 6;
            currentScene = 5;
        });

        optionsBtn.setOnMouseClicked(e->{
            Sounds.soundOfButton();
            switchSceneSmoothly(optionsMenu);
            previousScene = 6;
            currentScene = 3;
        });

        mainMenuBtn.setOnMouseClicked(e->{
            Sounds.soundOfButton();
            switchSceneSmoothly(mainMenu);
            previousScene = 6;
            currentScene = 1;;
        });

    }


    static void switchSceneSmoothly(Scene newScene) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3), primaryStage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.5);
        fadeOut.setOnFinished(event -> {

            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newScene.getRoot());
            fadeIn.setFromValue(0.5);
            primaryStage.setScene(newScene);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }













}
