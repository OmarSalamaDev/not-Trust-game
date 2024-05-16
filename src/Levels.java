

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

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 1;
            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

            // upper border
            Block b1 = new Block(0, 0, 1200, 100);
            b1.setFill(Main.blockColor);

            // lower border
            Block b2 = new Block(0, 500, 700, 100);
            b2.setFill(Main.blockColor);

            Block b3 = new Block(750, 500, 450, 100);
            b3.setFill(Main.blockColor);

            Block b7 = new Block(700, 500, 51, 100);
            b7.setFill(Main.blockColor);
            b7.setupAnimation(500, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 670, 10);
            b7.animate(true);

            // left border
            Block b4 = new Block(0, 100, 100, 600-200);
            b4.setFill(Main.blockColor);

            // right border
            Block b5 = new Block(1200-100, 100, 100, 600-200);
            b5.setFill(Main.blockColor);

            Door door = new Door(1000, 455);

            // trap
            Trap t1 = new Trap(700, 670, 100, 50);
            t1.setFill(Color.TRANSPARENT);

            // add all blocks to the root
            levelRoot.getChildren().addAll(b1, b2, b3, b4, b5, t1, b7, door, Main.spirit);
        }


        /* >>>> level 2 <<<< */
        else if (level == 2) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 2;
            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

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

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, door, Main.spirit);
        }


        /* >>>> level 3 <<<< */
        else if (level == 3) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 3;
            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

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

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, door, Main.spirit);
        }

        /* >>>> level 4 <<<< */
        else if (level == 4) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 4;
            Main.spirit.mirror();
            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

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

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, door, Main.spirit);
        }

        /* >>>> level 5 <<<< */
        else if (level == 5) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 5;
            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

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

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, door, Main.spirit);
        }

        /* >>>> level 6 <<<< */
        else if (level == 6) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 6;

            Main.spirit.setCenterX(150);
            Main.spirit.setCenterY(490);

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



            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, Main.spirit);
        }

        return levelRoot;
    }




}
