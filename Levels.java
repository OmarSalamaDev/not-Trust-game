import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Levels {


// level root
static Pane root = new Pane();


    public static Parent level(int level) {


        /* >>>> level 1 <<<< */
        if (level == 1) {

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
            Block b4 = new Block(0, 100, 100, Main.screenHeight-200);
            b4.setFill(Main.blockColor);

            // right border
            Block b5 = new Block(Main.screenWidth-100, 100, 100, Main.screenHeight-200);
            b5.setFill(Main.blockColor);

            // ..
            Block b6 = new Block(720, 450, 50, 20);
            b6.setFill(Main.blockColor);

            // trap
            Trap t1 = new Trap(600, 590, 300, 10);
            t1.setFill(Main.trapColor);

            // add all blocks to the root
            root.getChildren().addAll(b1, b2, b3, b4, b5, b6, t1, Main.spirit);

        }


        /* >>>> level 2 <<<< */
        else if (level == 2) {

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
            a6.setupAnimation(200, 350, Block.MotionType.VERTICAL, 1);
            a6.animate(true);

            // test block 7
            Block a7 = new Block(500, 270, 70, 25);
            a7.setFill(Main.blockColor);

            // test block 7
            Trap t1 = new Trap(300, 300, 50, 50);
            t1.setupAnimation(300, 350, Block.MotionType.HORIZONTAL, 1);
            t1.animate(true);
            t1.setFill(Main.trapColor);
            t1.setStartingPos(300, 200);

            root.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, Main.spirit, a6, a7, t1);
        }


        /* >>>> level 3 <<<< */
        else if (level == 3) {
        }
        return root;
    }


    // clear level root
    public static void clearRoot() {
        root.getChildren().clear();
    }



}
