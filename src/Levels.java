
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Levels {

    public static int currentLevel;

    // level root
    public static Pane levelRoot = new Pane();


    public static Pane level(int level) {

        // reset everything ;)
        ScenesLoader.gameRoot.setBackground(Background.fill(Main.backgroundColor));
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
            Block lowerBorder = new Block(0, 500, 200, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 100, 100, 600);
            rightBorder.setFill(Main.blockColor);

            Block b1 = new Block(350, 450, 70, 25);
            b1.setFill(Main.blockColor);

            Block b2 = new Block(550, 400, 70, 25);
            b2.setFill(Main.blockColor);

            Block b3 = new Block(750, 350, 70, 25);
            b3.setFill(Main.blockColor);
            b3.setupAnimation(350, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 790, 5);
            b3.animate(true);

            Block b4 = new Block(950, 300, 70, 25);
            b4.setFill(Main.blockColor);

            Trap t1 = new Trap(0, 700, 1200, 50);
            t1.setFill(Color.TRANSPARENT);

            Door door = new Door(990, 256);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, b1, b2, b3, b4, t1, door, Main.spirit);
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
            Block lowerBorder = new Block(0, 500, 180, 100);
            lowerBorder.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 100, 100, 400);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Trap(1200, 0, 10, 600);
            rightBorder.setFill(Main.blockColor);

            Block b1 = new Block(330, 450, 70, 150);
            b1.setFill(Main.blockColor);

            Block b2 = new Block(530, 400, 70, 200);
            b2.setFill(Main.blockColor);

            Block b3 = new Block(700, 500, 120, 100);
            b3.setFill(Main.blockColor);

            Block s1 = new Spikes(700, 490);
            s1.setupAnimation(700, 775, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 650, 5);
            s1.animate(true);

            Block b4 = new Block(930, 300, 70, 30);
            b4.setFill(Main.blockColor);
            b4.setupAnimation(150, 550, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 0, 5);
            b4.animate(true);

            Block b5 = new Block(1170, 494, 30, 25);
            b5.setFill(Main.blockColor);

            Trap t1 = new Trap(0, 700, 1200, 50);
            t1.setFill(Color.TRANSPARENT);

            Door door = new Door(1170, 450);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, b1, b2, s1, b3, b4, b5, t1, door, Main.spirit);
        }

        /* >>>> level 4 <<<< */
        else if (level == 4) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 4;
            Main.spirit.setCenterX(145);
            Main.spirit.setCenterY(490);

            // upper border
            Block upperBorder = new Trap(0, 0, 1200, 1);
            upperBorder.setFill(Color.TRANSPARENT);

            Block b1 = new Block(280, 0, 50, 50);
            b1.setFill(Main.blockColor);
            b1.setupAnimation(280, 370, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 260, 5);
            b1.animate(true);

            // lower border
            Block lowerBorder = new Trap(0, 650, 1200, 10);
            lowerBorder.setFill(Color.TRANSPARENT);

            Block b2 = new Block(120, 550, 50, 50);
            b2.setFill(Main.blockColor);

            // left border
            Block leftBorder = new Block(0, 0, 98, 600);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 0, 100, 600);
            rightBorder.setFill(Main.blockColor);

            Block b3 = new Block(400, 550, 50, 50);
            b3.setFill(Main.blockColor);
            b3.setupAnimation(400, 580, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 425, 5);
            b3.animate(true);

            Block b4 = new Block(700, 550, 190, 50);
            b4.setFill(Main.blockColor);

            Block b5 = new Block(888, 550, 75, 50);
            b5.setFill(Main.blockColor);
            b5.setupAnimation(550, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 860, 10);
            b5.animate(true);

            Block b6 = new Block(960, 550, 40, 50);
            b6.setFill(Main.blockColor);

            Block s1 = new Spikes(940, 540);
            s1.setupAnimation(745, 940, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 670, -10);
            s1.animate(true);

            Door door = new Door(710, 506);
            door.setupAnimation(710, 970, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 670, 5);
            door.animate(true);

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, b1, b2, b3, b4, b5, b6, s1, door, Main.spirit);
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
