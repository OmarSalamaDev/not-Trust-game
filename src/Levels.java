

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Levels {

    public static int currentLevel;

    // level root
    public static Pane levelRoot = new Pane();


    public static Pane level(int level) {

        // reset everything ;)
        levelRoot.getChildren().clear();
        Block.stopAnimationTimers();
        Main.spirit.resetBorders();
        if (Main.spirit.isReversed) {
            Main.spirit.reverseGravity();
        }
        if (Main.spirit.isMirrored) {
            Main.spirit.mirror();
        }


        /* >>>> level 1 <<<< */
        if (level == 1) {
            currentLevel = 1;
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(Main.spirit.getLowerBorder() - 100 - Main.spirit.getRadius());
            /*
                  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                  @                               @
                  @                               @
                  @                               @
                  @                               @
                  @                               @
                  @                  @@@          @
                  @@@@@@@@@@@@@@@@         @@@@@@@@
            */

            // upper border
            Block b1 = new Block(0, 0, 1200, 100);
            b1.setFill(Main.blockColor);

            // lower border
            Block b2 = new Block(0, 500, 600, 100);
            b2.setFill(Main.blockColor);

            Block b3 = new Block(900, 500, 300, 100);
            b3.setFill(Main.blockColor);

            // left border
            Block b4 = new Block(0, 100, 100, 600-200);
            b4.setFill(Main.blockColor);

            // right border
            Block b5 = new Block(1200-100, 100, 100, 600-200);
            b5.setFill(Main.blockColor);

            // ..
            Block b6 = new Block(720, 450, 50, 20);
            b6.setFill(Main.blockColor);

            Block b7 = new Block(600, 500, 300, 100);
            b7.setFill(Color.RED);
            b7.setupAnimation(500, 600, Block.MotionDirection.VERTICAL, Block.MotionType.END, 500, 10);
            b7.animate(true);

            Door door = new Door(1000, 455);

            // trap
            Trap t1 = new Trap(600, 590, 300, 10);
            t1.setFill(Main.trapColor);


            // add all blocks to the root
            levelRoot.getChildren().addAll(b1, b2, b3, b4, b5, b6, t1, b7, door, Main.spirit);

        }


        /* >>>> level 2 <<<< */
        else if (level == 2) {
            currentLevel = 2;
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(200);

            // upper border
            Block upperBorder = new Block(0, 0, 1200, 100);
            upperBorder.setFill(Main.blockColor);

            // lower border
            Block lowerBorder = new Block(0, 500, 1200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 400);
            rightBorder.setFill(Main.blockColor);

            // test block 6
            Block a6 = new Block(700, 200, 70, 80);
            a6.setFill(Main.blockColor);
            a6.setupAnimation(200, 600, Block.MotionDirection.VERTICAL, Block.MotionType.END, 500, 1);
            a6.animate(true);

            Door door = new Door(1000, 455);

            // test block 7
            Block a7 = new Block(500, 270, 70, 25);
            a7.setFill(Main.blockColor);

            // test block 7
            Trap t1 = new Trap(300, 300, 50, 50);
            t1.setupAnimation(300, 350, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 0, 1);
            t1.animate(true);
            t1.setFill(Main.trapColor);
            t1.setStartingPos(300, 200);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, a6, a7, t1, door, Main.spirit);
        }


        /* >>>> level 3 <<<< */
        else if (level == 3) {
            currentLevel = 3;
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(Main.spirit.getLowerBorder() - 100 - Main.spirit.getRadius());

            // upper border
            Block upperBorder = new Block(0, 0, 1200, 100);
            upperBorder.setFill(Main.blockColor);

            // lower border
            Block lowerBorder = new Block(0, 500, 1200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 400);
            rightBorder.setFill(Main.blockColor);

            Door door = new Door(1000, 455);

            // test block 7
            Block a7 = new Block(200, 270, 70, 25);
            a7.setFill(Main.blockColor);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, a7, door, Main.spirit);
        }

        /* >>>> level 4 <<<< */
        else if (level == 4) {
            currentLevel = 4;
            Main.spirit.mirror();
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(Main.spirit.getLowerBorder() - 100 - Main.spirit.getRadius());

            // upper border
            Block upperBorder = new Block(0, 0, 1200, 100);
            upperBorder.setFill(Main.blockColor);

            // lower border
            Block lowerBorder = new Block(0, 500, 1200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 400);
            rightBorder.setFill(Main.blockColor);

            Door door = new Door(1000, 455);

            // test block 7
            Block a7 = new Block(300, 270, 70, 25);
            a7.setFill(Main.blockColor);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, a7, door, Main.spirit);
        }

        /* >>>> level 5 <<<< */
        else if (level == 5) {
            currentLevel = 5;
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(Main.spirit.getLowerBorder() - 100 - Main.spirit.getRadius());

            // upper border
            Block upperBorder = new Block(0, 0, 1200, 100);
            upperBorder.setFill(Main.blockColor);

            // lower border
            Block lowerBorder = new Block(0, 500, 1200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 400);
            rightBorder.setFill(Main.blockColor);

            Door door = new Door(1000, 455);

            // test block 7
            Block a7 = new Block(400, 270, 70, 25);
            a7.setFill(Main.blockColor);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, door, a7, Main.spirit);
        }

        /* >>>> level 6 <<<< */
        else if (level == 6) {
            currentLevel = 6;
            Main.spirit.setCenterX(400);
            Main.spirit.setCenterY(Main.spirit.getLowerBorder() - 100 - Main.spirit.getRadius());

            // upper border
            Block upperBorder = new Block(0, 0, 1200, 100);
            upperBorder.setFill(Main.blockColor);

            // lower border
            Block lowerBorder = new Block(0, 500, 1200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 400);
            rightBorder.setFill(Main.blockColor);

            // test block 7
            Block a7 = new Block(600, 270, 70, 25);
            a7.setFill(Main.blockColor);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, a7, Main.spirit);
        }

        return levelRoot;
    }




}
