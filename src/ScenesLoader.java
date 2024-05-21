import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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
import java.util.Objects;


public final class ScenesLoader {

    public static Stage primaryStage;

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
    // 7 -> outroScene


    static int themeNum;
    

    public static void setupMenus(Stage stage) {
        primaryStage = stage;
        mainMenuSetup();
        creditsMenuSetup();
        optionMenuSetup();
        levelSelectMenuSetup();
        gameOptions();
        levelSceneSetup();
    }


    public static Scene introScene() {

        StackPane introStackPane = new StackPane();
        Scene introScene = new Scene(introStackPane, 1200, 600);
        Media introMedia = new Media(new File("src/media/videos/clip-1.mp4").toURI().toString());
        MediaPlayer introMediaPlayer = new MediaPlayer(introMedia);
        introMediaPlayer.play();
        MediaView introMediaView = new MediaView(introMediaPlayer);
        introStackPane.getChildren().add(introMediaView);
        introMediaPlayer.setOnEndOfMedia(() -> {
            primaryStage.setScene(mainMenu);
            previousScene = 0;
            currentScene = 1;
        });
        return introScene;
    }



    public static Scene outroScene() {

        StackPane introStackPane = new StackPane();
        Scene introScene = new Scene(introStackPane, 1200, 600);
        Media introMedia = new Media(new File("src/media/videos/clip-2.mp4").toURI().toString());
        MediaPlayer introMediaPlayer = new MediaPlayer(introMedia);
        introMediaPlayer.play();
        MediaView introMediaView = new MediaView(introMediaPlayer);
        introStackPane.getChildren().add(introMediaView);
        introMediaPlayer.setOnEndOfMedia(() -> {
            primaryStage.setScene(mainMenu);
            previousScene = 5;
            currentScene = 1;
        });
        return introScene;
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

        mainMenu.getStylesheets().add(Objects.requireNonNull(ScenesLoader.class.getResource("style.css")).toExternalForm());

        //--> menu controls <--//

        startBtn.setOnMouseClicked(e -> {
            if (currentScene == 1) {
                Sounds.soundOfButton();
                switchSceneSmoothly(levelSelectMenu);
                previousScene = 1;
                currentScene = 2;
            }
        });

        optionsBtn.setOnMouseClicked(e -> {
            if(currentScene == 1) {
                Sounds.soundOfButton();
                switchSceneSmoothly(optionsMenu);
                previousScene = 1;
                currentScene = 3;
            }
        });

        creditsBtn.setOnMouseClicked(e -> {
            if(currentScene == 1) {
                Sounds.soundOfButton();
                switchSceneSmoothly(creditsMenu);
                previousScene = 1;
                currentScene = 4;
            }
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
        hbox.setLayoutX(300);
        hbox.setLayoutY(480);

        Label label = new Label("Developed by");
        label.setFont(Font.font("Consolas",40));
        label.setTextFill(Color.WHITE);
        HBox h1 = new HBox(label);

        Label names = new Label(
                "Ahmed El-Sherbiny"
                        +"\n"+"Ayman Yasser"
                        +"\n"+"Hazem Radwan"
                        +"\n"+"Hamed El-Shabrawiny"
                        +"\n"+"Hamdi Al-Gohary"
                        +"\n"+"Omar Salama"
                        +"\n"+"Mazen Mashaal"
                        +"\n"+"Mohamed Adel"
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
        creditsMenu.getStylesheets().add(Objects.requireNonNull(ScenesLoader.class.getResource("style.css")).toExternalForm());

        //--> menu controls <--//

        backBtn.setOnMouseClicked(e->{
            if(currentScene == 4) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 4;
                currentScene = 1;
            }
        });

        creditsMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Sounds.soundOfButton();
                if(currentScene == 4) {
                    switchSceneSmoothly(mainMenu);
                    previousScene = 4;
                    currentScene = 1;
                }
            }
        });
    }


    private static void optionMenuSetup() {

        //--> menu elements <--//

        Label audio = new Label("Audio");
        audio.setFont(Font.font("Consolas",40));
        audio.setTextFill(Color.WHITE);

        CheckBox checkBox = new CheckBox();
        checkBox.setId("checkBox");
        checkBox.getStyleClass().add("checkBox");
        checkBox.setSelected(Sounds.audioState);

        HBox hBox1 = new HBox(30);
        hBox1.getChildren().addAll(audio,checkBox);
        hBox1.setAlignment(Pos.CENTER);

        Label themes = new Label("Themes");
        themes.setFont(Font.font("Consolas",40));
        themes.setTextFill(Color.WHITE);

        RadioButton theme1Btn = new RadioButton("Theme 1");
        theme1Btn.setTextFill(Color.WHITE);

        RadioButton theme2Btn = new RadioButton("Theme 2");
        theme2Btn.setTextFill(Color.WHITE);

        RadioButton theme3Btn = new RadioButton("Theme 3");
        theme3Btn.setTextFill(Color.WHITE);

        ToggleGroup themesGroup = new ToggleGroup();
        theme1Btn.setToggleGroup(themesGroup);
        theme2Btn.setToggleGroup(themesGroup);
        theme3Btn.setToggleGroup(themesGroup);

        HBox hBox2 = new HBox(30);
        hBox2.getChildren().addAll(themes,theme1Btn,theme2Btn,theme3Btn);
        hBox2.setAlignment(Pos.CENTER);

        StackPane preview = new StackPane();

        ImageView image1 = new ImageView("media/images/theme-1.png");
        image1.setFitWidth(512.25);
        image1.setFitHeight(291.75);

        ImageView image2 = new ImageView("media/images/theme-2.png");
        image2.setFitWidth(512.25);
        image2.setFitHeight(291.75);

        ImageView image3 = new ImageView("media/images/theme-3.png");
           image3.setFitWidth(512.25);
        image3.setFitHeight(291.75);



        if(themeNum == 1) {
            theme1Btn.setSelected(true);
            preview.getChildren().add(image1);
        }
        else if(themeNum == 2) {
            theme2Btn.setSelected(true);
            preview.getChildren().add(image2);
        }
        else if(themeNum == 3) {
            theme3Btn.setSelected(true);
            preview.getChildren().add(image3);
        }

        Button backBtn = new Button("back");
        backBtn.setId("genericButton");
        backBtn.getStyleClass().add("genericButton");

        Button applyBtn = new Button("Apply");
        applyBtn.setDisable(true);
        applyBtn.setId("genericButton");
        applyBtn.getStyleClass().add("genericButton");

        HBox hBox3 = new HBox(450);
        hBox3.getChildren().addAll(backBtn,applyBtn);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(30);
        vBox.getChildren().addAll(hBox1,hBox2,preview,hBox3);
        vBox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.setBackground(Background.fill(Color.BLACK));
        stackPane.getChildren().add(vBox);
        optionsMenu = new Scene(stackPane, 1200,600);
        optionsMenu.getStylesheets().add(ScenesLoader.class.getResource("style.css").toExternalForm());

        //--> menu controls <--//

        theme1Btn.setOnAction(e1 -> {
            Sounds.soundOfButton();
            preview.getChildren().clear();
            preview.getChildren().add(image1);
            applyBtn.setDisable(false);
            applyBtn.setOnAction(e -> {
                Sounds.soundOfButton();
                Main.theme1();
                themeNum = 1;
                Main.writeToFile(ScenesLoader.themeNum,Sounds.audioState);
                applyBtn.setDisable(true);
            });
        });

        theme2Btn.setOnAction(e1 -> {
            Sounds.soundOfButton();
            preview.getChildren().clear();
            preview.getChildren().add(image2);
            applyBtn.setDisable(false);
            applyBtn.setOnAction(e2->{
                Sounds.soundOfButton();
                Main.theme2();
                themeNum = 2;
                Main.writeToFile(ScenesLoader.themeNum,Sounds.audioState);
                applyBtn.setDisable(true);
            });
        });

        theme3Btn.setOnAction(e1 -> {
            Sounds.soundOfButton();
            preview.getChildren().clear();
            preview.getChildren().add(image3);
            applyBtn.setDisable(false);
            applyBtn.setOnAction(e2->{
                Sounds.soundOfButton();
                Main.theme3();
                themeNum = 3;
                Main.writeToFile(ScenesLoader.themeNum,Sounds.audioState);
                applyBtn.setDisable(true);
            });
        });

        checkBox.setOnAction(e -> {
            Sounds.soundOfButton();
            Sounds.audioState = !Sounds.audioState;
            Sounds.soundOfButton();
            Main.writeToFile(ScenesLoader.themeNum,Sounds.audioState);
        });

        backBtn.setOnMouseClicked(e -> {
            if (previousScene == 1 && currentScene == 3) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 3;
                currentScene = 1;
            }
            else if (previousScene == 6 && currentScene == 3) {
                Sounds.soundOfButton();
                switchSceneSmoothly(levelScene);
                previousScene = 3;
                currentScene = 6;
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(Levels.currentLevel));
                gameOptions();
                gameRoot.getChildren().addAll(inGameMenu);
            }
        });

        optionsMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                if (previousScene == 1 && currentScene == 3) {
                    Sounds.soundOfButton();
                    switchSceneSmoothly(mainMenu);
                    previousScene = 3;
                    currentScene = 1;
                } else if (previousScene == 6 && currentScene == 3) {
                    Sounds.soundOfButton();
                    switchSceneSmoothly(levelScene);
                    previousScene = 3;
                    currentScene = 6;
                    gameRoot.getChildren().clear();
                    gameRoot.getChildren().add(Levels.level(Levels.currentLevel));
                    gameOptions();
                    gameRoot.getChildren().addAll(inGameMenu);
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
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(1));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        level2Btn.setOnMouseClicked(e -> {
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(2));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        level3Btn.setOnMouseClicked(e -> {
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(3));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        level4Btn.setOnMouseClicked(e -> {
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(4));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        level5Btn.setOnMouseClicked(e -> {;
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(5));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        level6Btn.setOnMouseClicked(e -> {
            if(currentScene == 2) {
                Sounds.soundOfButton();
                gameRoot.getChildren().clear();
                gameRoot.getChildren().add(Levels.level(6));
                switchSceneSmoothly(levelScene);
                previousScene = 2;
                currentScene = 5;
            }
        });

        backBtn.setOnMouseClicked(e-> {
            if(currentScene == 2) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 2;
                currentScene = 1;
            }
        });

        levelSelectMenu.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE) {
                Sounds.soundOfButton();
                if(currentScene == 2) {
                    switchSceneSmoothly(mainMenu);
                    previousScene = 2;
                    currentScene = 1;
                }
            }
        });
    }


    private static void levelSceneSetup() {

        //--> scene elements <--//

        levelScene = new Scene(gameRoot, 1200, 600);
        levelScene.setRoot(gameRoot);
        levelScene.getStylesheets().add(Objects.requireNonNull(ScenesLoader.class.getResource("style.css")).toExternalForm());

        //--> scene controls <--//

        levelScene.setOnKeyPressed(e -> {
            KeyCode thisKey = e.getCode();
            if (thisKey == KeyCode.RIGHT && currentScene == 5) {
                Main.spirit.setVx(Main.spirit.getxStep());
            }
            else if (thisKey == KeyCode.LEFT && currentScene == 5) {
                Main.spirit.setVx(-Main.spirit.getxStep());
            }
            else if (thisKey == KeyCode.SPACE && !Main.spirit.inAir && currentScene == 5 && (Main.spirit.isOnBlock || Main.spirit.isUnderBlock)) {
                Sounds.soundOfJump();
                Main.spirit.setVy(-Main.spirit.getyStep());
                Main.spirit.inAir = true;
            }
            else if (thisKey == KeyCode.SHIFT && currentScene == 5 && Levels.currentLevel == 4 && (Main.spirit.isOnBlock || Main.spirit.isUnderBlock)) {
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
            if(currentScene == 6) {
                Sounds.soundOfButton();
                switchSceneSmoothly(optionsMenu);
                previousScene = 6;
                currentScene = 3;
            }
        });

        mainMenuBtn.setOnMouseClicked(e->{
            if(currentScene == 6) {
                Sounds.soundOfButton();
                switchSceneSmoothly(mainMenu);
                previousScene = 6;
                currentScene = 1;
            }
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
