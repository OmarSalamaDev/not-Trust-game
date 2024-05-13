

import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Scenes {
    static boolean flag = true;
    static byte count = 1;
    static MediaPlayer mediaPlayer;
    static Spirit spirit;
    static Scene xyz;
    static CustomButton back;
    static Block b1;
    static Block b2;
    static Block b3;
    static Block b4;
    static Block b5;
    static Block b6;
    static Block b7;
    static Block b8;
    static Block b9;
    static Rectangle q;

    //Sounds sound = new Sounds();
    static void controls(KeyEvent e,Pane Root,Pane menu){
        KeyCode thisKey = e.getCode();

        if (thisKey == KeyCode.RIGHT && flag) {
            spirit.setVx(spirit.getxStep());
//            if(spirit.isOnBlock && !spirit.isOnLeft)
//                Sounds.soundOfWalk();
        }
        else if (thisKey == KeyCode.LEFT && flag) {
            spirit.setVx(-spirit.getxStep());
//            if(spirit.isOnBlock && !spirit.isOnRight)
//                Sounds.soundOfWalk();
        }

        else if (thisKey == KeyCode.SPACE && !spirit.inAir && flag) {
            spirit.setVy(-spirit.getyStep());
            spirit.inAir = true;
        }
        else if (thisKey == KeyCode.SHIFT && flag) {
            spirit.reverseGravity();
            spirit.inAir = false;
        }
        else if (thisKey == KeyCode.ESCAPE && flag) {
            Root.getChildren().addAll(menu);
            flag = false;
        }
        else if (e.getCode() == KeyCode.ESCAPE && !flag) {
            Root.getChildren().remove(menu);
            flag = true;
        }
        else if (e.getCode() == KeyCode.S && flag) b6.animate(false);
        else if (e.getCode() == KeyCode.D ) b6.animate(true);
    }


    static Scene mainMenu(Stage primaryStage)
    {
        CustomButton start = new CustomButton(270, 40, Color.GOLD, "Start", Color.BLACK);
        CustomButton options = new CustomButton(270, 40, Color.GOLD, "Options", Color.BLACK);
        CustomButton credits = new CustomButton(270, 40, Color.GOLD, "Credits", Color.BLACK);
        CustomButton exit = new CustomButton(270, 40, Color.GOLD, "Exit", Color.BLACK);

        VBox vBox = new VBox(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(start, options, credits, exit);

        Media media = new Media("file:/C:/Users/Mars/Desktop/Project/src/media/videos/clip-1.mp4");
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setOnReady(primaryStage::sizeToScene);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(800);
        mediaView.setFitWidth(600);

        HBox root = new HBox(150);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(100));
        root.getChildren().addAll(vBox, mediaView);
        root.setBackground(Background.fill(Color.PURPLE));
        start.setOnMouseClicked(e -> {
            if (Scenes.count == 1) {
                Scenes.count = 2;
                switchSceneSmoothly(primaryStage, levelOne(primaryStage));
                mediaPlayer.stop();
            }
        });
        options.setOnMouseClicked(e -> {

        });
        credits.setOnMouseClicked(e -> {
            if (Scenes.count == 1) {
                Scenes.count = 4;
                switchSceneSmoothly(primaryStage, credits(primaryStage));
                mediaPlayer.stop();
            }
        });

        exit.setOnMouseClicked(e -> primaryStage.close());
        return new Scene(root,1200,600);
    }

    static Scene levels(){
        Pane root = new Pane();
        // adding the nodes to the root
        return new Scene(root);
    }
    static Scene MainOptions(){
        Pane root = new Pane();
        // adding the nodes to the root
        return new Scene(root);
    }
    static Scene credits(Stage primaryStage) {
        back = new CustomButton(150,50,Color.PURPLE,"Back",Color.BLACK);
        back.setLayoutX(40);
        back.setLayoutY(520);
        back.setOnMouseClicked(e->{
            if(Scenes.count == 4) {
                count = 1;
                Block.stopAnimationTimers();
                switchSceneSmoothly(primaryStage, mainMenu(primaryStage));
                mediaPlayer.play();
            }

        });

        Label c = new Label("©");
        c.setFont(Font.font("Trebuchet MS", FontWeight.BOLD,50));
        Label copyRight = new Label(" All rights reserved to the developers");
        HBox hbox = new HBox(c,copyRight);
        hbox.setAlignment(Pos.CENTER);
        hbox.setLayoutX(390);
        hbox.setLayoutY(480);

        copyRight.setFont(Font.font("Trebuchet MS",25));

        Label label=new Label("Developed by");
        label.setFont(Font.font("Constantia",60));
        HBox h1=new HBox(label);

        Label names=new Label("Ahmed El-Sherbiny Othman"
                +"\n"+"Ayman Yasser Ahmed"
                +"\n"+"Hazem Sherif Mohamed"
                +"\n"+"Hamed Islam Ahmed"
                +"\n"+"Hamdi Emad Hamdi"
                +"\n"+"Omar Abdulaziz Muhammad"
                +"\n"+"Mazen Yasser Refaat"
                +"\n"+"Mohamed Adel Mohamed");
        names.setFont(Font.font("Verdana",20));
        names.setStyle("-fx-font-family: cursive;");

        HBox h2=new HBox(names);
        h2.setAlignment(Pos.CENTER);
        VBox v1=new VBox(20,h1,h2);
        v1.setLayoutX(450);
        v1.setLayoutY(110);


        Pane pane=new Pane(hbox,v1,back);
        pane.setBackground(Background.fill(Color.GOLD));
        xyz =new Scene(pane,1200,600);



        // adding the nodes to the root
        pane.setOpacity(0.5);
        return xyz;
    }
    static Scene levelOne(Stage primaryStage){
        StackPane Root = new StackPane();
        // adding the nodes to the root
        Scene primaryScene = gameOptions(primaryStage,Root);
        Pane root = gameRoot(Root,primaryScene);
        spirit.setCenterX(400);
        spirit.setCenterY(spirit.getLowerBorder() - 100 - spirit.getRadius());


        // set default spirit for the block class
        Main.spirit = spirit;

        // test block 1
        b1 = new Block(0, 0, 1200, 100);
        b1.setFill(Color.rgb(19, 47, 99));
        b1.checkBlock(true);
        root.getChildren().add(b1);

        // test block 2
        b2 = new Block(0, 500, 1200, 100);
        b2.setFill(Color.rgb(19, 47, 99));
        b2.checkBlock(true);
        root.getChildren().add(b2);

        // test block 3
        b3 = new Block(0, 100, 100, 400);
        b3.setFill(Color.rgb(19, 47, 99));
        b3.checkBlock(true);
        root.getChildren().add(b3);

        // test block 4
        b4 = new Block(1100, 100, 100, 400);
        b4.setFill(Color.rgb(19, 47, 99));
        b4.checkBlock(true);
        root.getChildren().add(b4);

        // test block 5
        b5 = new Block(900, 420, 70, 25);
        b5.setFill(Color.rgb(19, 47, 99));
        b5.checkBlock(true);
        root.getChildren().add(b5);

        // test block 6
        b6 = new Block(700, 200, 70, 80);
        b6.setFill(Color.rgb(19, 47, 99));
        b6.checkBlock(true);
        root.getChildren().add(b6);

        // test block 7
        b7 = new Block(500, 270, 70, 25);
        b7.setFill(Color.rgb(19, 47, 99));
        b7.checkBlock(true);
        root.getChildren().add(b7);

        // test block 8
        b8 = new Block(400, 190, 70, 250);
        b8.setFill(Color.rgb(19, 47, 99));
        b8.checkBlock(true);
        root.getChildren().add(b8);

        // block 6 animation
        b6.setupAnimation(200, 350, Block.MotionType.VERTICAL, 1);
        b6.animate(true);

        Root.setOpacity(0.5);

        return primaryScene;
    }
    static Scene levelTwo(Stage primaryStage){

        StackPane Root = new StackPane();

        // adding the nodes to the root
        Scene primaryScene = gameOptions(primaryStage,Root);
        Pane root = gameRoot(Root,primaryScene);


        spirit.setCenterX(400);
        spirit.setCenterY(spirit.getLowerBorder() - 100 - spirit.getRadius());
        // set default spirit for the block class

        Main.spirit = spirit;

        // test block 1
        b1 = new Block(0, 0, 1200, 100);
        b1.setFill(Color.rgb(19, 47, 99));
        b1.checkBlock(true);
        root.getChildren().add(b1);

        // test block 2
        b2 = new Block(0, 500, 1200, 100);
        b2.setFill(Color.rgb(19, 47, 99));
        b2.checkBlock(true);
        root.getChildren().add(b2);

        // test block 3
        b3 = new Block(0, 100, 100, 400);
        b3.setFill(Color.rgb(19, 47, 99));
        b3.checkBlock(true);
        root.getChildren().add(b3);

        // test block 4
        b4 = new Block(1100, 100, 100, 400);
        b4.setFill(Color.rgb(19, 47, 99));
        b4.checkBlock(true);
        root.getChildren().add(b4);

        // test block 5
        b5 = new Block(900, 420, 70, 25);
        b5.setFill(Color.rgb(19, 47, 99));
        b5.checkBlock(true);
        root.getChildren().add(b5);

        // test block 6
        b6 = new Block(700, 200, 70, 80);
        b6.setFill(Color.rgb(19, 47, 99));
        b6.checkBlock(true);
        root.getChildren().add(b6);

        // test block 7
        b7 = new Block(500, 270, 70, 25);
        b7.setFill(Color.rgb(19, 47, 99));
        b7.checkBlock(true);
        root.getChildren().add(b7);

        // test block 8
        b8 = new Block(400, 190, 70, 250);
        b8.setFill(Color.rgb(19, 47, 99));
        b8.checkBlock(true);
        root.getChildren().add(b8);

        // block 6 animation




        return primaryScene;
    }
    static Scene levelThree(){
        Pane root = new Pane();
        // adding the nodes to the root
        return new Scene(root);
    }




    static Scene gameOptions(Stage primaryStage,StackPane Root){


        Scene primaryScene = new Scene(Root,1200,600);
        Root.setBackground(Background.fill( Color.rgb(91, 233, 240)));
        gameRoot(Root,primaryScene);


        q = new Rectangle(350,50,500,500);
        q.setFill(Color.BLACK);
        q.setOpacity(0.5);



        CustomButton resume = new CustomButton(270,40,Color.GOLD,"Resume", Color.BLACK);
        CustomButton options = new CustomButton(270,40,Color.GOLD,"Options", Color.BLACK);
        back = new CustomButton(270,40,Color.GOLD,"Back", Color.BLACK);
        CustomButton exit = new CustomButton(270,40,Color.GOLD,"Exit", Color.BLACK);


        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(resume,options,back,exit);
        vBox.setAlignment(Pos.CENTER);
        StackPane menu = new StackPane();
        menu.getChildren().addAll(q,vBox);


        // handel keyboard actions
        primaryScene.setOnKeyPressed(e -> controls(e,Root,menu));

        spirit.getScene().setOnKeyReleased(e -> {
            KeyCode key = e.getCode();
            if (key == KeyCode.RIGHT || key == KeyCode.LEFT){
                spirit.setVx(0.0);
            }
        });
        resume.setOnMouseClicked(e -> {
            Root.getChildren().remove(menu);
            flag = true;
        });
        options.setOnMouseClicked(e->{
            System.out.println("mazen");
        });
        exit.setOnMouseClicked(e-> {
            primaryStage.close();
        });
        back.setOnMouseClicked(e->{
            if(count == 2)
            {
                count = 1;
                Block.stopAnimationTimers();
                switchSceneSmoothly(primaryStage, mainMenu(primaryStage));
                mediaPlayer.play();
                flag = true;
            }
        });

        return primaryScene;
    }

    static Pane gameRoot(StackPane Root,Scene primaryScene){
        Pane root = new Pane();
        Root.getChildren().add(root);
        spirit = new Spirit(10, Color.RED);
        spirit.setDefaultBorders(0, primaryScene.getHeight(), primaryScene.getWidth(),0);
        root.getChildren().add(spirit);
        return root;
    }
    static void switchSceneSmoothly(Stage stage, Scene newScene) {
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3), stage.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.5);
        fadeOut.setOnFinished(event -> {

            FadeTransition fadeIn = new FadeTransition(Duration.millis(500), newScene.getRoot());
            fadeIn.setFromValue(0.5);
            stage.setScene(newScene);
            fadeIn.setToValue(1.0);
            fadeIn.play();
        });
        fadeOut.play();
    }



}
