

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public final class Levels {

    public static int currentLevel;

    // level root
    public static Pane levelRoot = new Pane();
    private static AnimationTimer levelTimer;
    private static boolean isLeveltimerOn = false;


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
        if (isLeveltimerOn) {
            levelTimer.stop();
            isLeveltimerOn = false;
        }
        Main.spirit.setVx(0);
        Main.spirit.setVy(0);


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
            b7.setupAnimation(500, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 10);


            // left border
            Block b4 = new Block(0, 100, 100, 600-200);
            b4.setFill(Main.blockColor);

            // right border
            Block b5 = new Block(1200-100, 100, 100, 600-200);
            b5.setFill(Main.blockColor);

            Door door = new Door(1000, 456);

            // trap
            Trap t1 = new Trap(700, 670, 100, 50);
            t1.setFill(Color.TRANSPARENT);

            // add all blocks to the root


            levelTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() == 670) b7.animate(true);
                }
            };
            isLeveltimerOn = true;
            levelTimer.start();

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
            b3.setupAnimation(350, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 5);

            Block b4 = new Block(950, 300, 70, 25);
            b4.setFill(Main.blockColor);

            Trap t1 = new Trap(0, 650, 1200, 50);
            t1.setFill(Color.TRANSPARENT);

            Door door = new Door(990, 256);

            levelTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() == 790) b3.animate(true);
                }
            };
            isLeveltimerOn = true;
            levelTimer.start();

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

            Block b = new Block(1000, 0, 100, 100);
            b.setFill(Main.blockColor);
            b.setupAnimation(1000, 1100, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 10);

            Block b1 = new Block(1130, 0, 70, 440);
            b1.setFill(Main.blockColor);

            Block b2 = new Block(1130, 498, 70, 110);
            b2.setFill(Main.blockColor);

            Block s1 = new Spikes(1100, 100);
            s1.setRotate(270);
            Block s2 = new Spikes(1100, 150);
            s2.setRotate(270);
            Block s3 = new Spikes(1100, 200);
            s3.setRotate(270);
            Block s4 = new Spikes(1100, 250);
            s4.setRotate(270);
            Block s5 = new Spikes(1100, 300);
            s5.setRotate(270);
            Block s6 = new Spikes(1100, 350);
            s6.setRotate(270);
            Block s7 = new Spikes(1100, 400);
            s7.setRotate(270);
            Block s8 = new Spikes(1100, 528);
            s8.setRotate(270);
            Block s9 = new Spikes(1100, 578);
            s9.setRotate(270);

            Block b3 = new Block(330, 450, 70, 150);
            b3.setFill(Main.blockColor);

            Block b4 = new Block(530, 400, 70, 200);
            b4.setFill(Main.blockColor);

            Block b5 = new Block(700, 500, 120, 100);
            b5.setFill(Main.blockColor);

            Block s = new Spikes(700, 490);
            s.setupAnimation(700, 775, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 5);

            Block b6 = new Block(930, 300, 70, 30);
            b6.setFill(Main.blockColor);
            b6.setupAnimation(150, 550, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 5);
            b6.animate(true);

            Trap t = new Trap(0, 700, 1200, 50);
            t.setFill(Color.TRANSPARENT);

            Door door = new Door(1170, 454);


            levelTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() >= 0) b.animate(true);
                    if (Main.spirit.getCenterX() == 650) s.animate(true);
                }
            };
            isLeveltimerOn = true;
            levelTimer.start();


            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder,
                    s, s1, s2, s3, s4, s5, s6, s7, s8, s9,
                    b, b1, b2, b3, b4, b5, b6, t, door, Main.spirit);
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

            // lower border
            Block lowerBorder = new Trap(0, 650, 1200, 10);
            lowerBorder.setFill(Color.TRANSPARENT);

            // left border
            Block leftBorder = new Block(0, 0, 98, 600);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1100, 0, 100, 600);
            rightBorder.setFill(Main.blockColor);

            Block b1 = new Block(280, 0, 50, 50);
            b1.setFill(Main.blockColor);
            b1.setupAnimation(280, 340, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 5);

            Block b2 = new Block(135, 550, 50, 50);
            b2.setFill(Main.blockColor);

            Block b3 = new Block(400, 550, 50, 50);
            b3.setFill(Main.blockColor);
            b3.setupAnimation(400, 580, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 5);


            Block b4 = new Block(700, 550, 190, 50);
            b4.setFill(Main.blockColor);

            Block b5 = new Block(888, 550, 75, 50);
            b5.setFill(Main.blockColor);
            b5.setupAnimation(550, 700, Block.MotionDirection.VERTICAL, Block.MotionType.END, 10);


            Block b6 = new Block(960, 550, 40, 50);
            b6.setFill(Main.blockColor);

            Block s1 = new Spikes(940, 540);
            s1.setupAnimation(745, 940, Block.MotionDirection.HORIZONTAL, Block.MotionType.END , -10);

            Door door = new Door(710, 506);
            door.setupAnimation(710, 970, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 5);



            levelTimer = new AnimationTimer() {
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() == 260) b1.animate(true);
                    if (Main.spirit.getCenterX() == 400) b3.animate(true);
                    if (Main.spirit.getCenterX() == 860) b5.animate(true);
                    if (Main.spirit.getCenterX() == 670) s1.animate(true);
                    if (Main.spirit.getCenterX() == 670) door.animate(true);


                }
            };
            isLeveltimerOn = true;
            levelTimer.start();


            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, b1, b2, b3, b4, b5, b6, s1, door, Main.spirit);

        }


        /* >>>> level 5 <<<< */
        else if (level == 5) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 5;
            Main.spirit.setCenterX(175);
            Main.spirit.setCenterY(390);

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

            Spikes rotadedSpike;
            for (int i = 100; i <= 1100; i+=50) {
                rotadedSpike = new Spikes(i,100);
                rotadedSpike.setRotate(180);
                levelRoot.getChildren().addAll(new Spikes(i, 490), rotadedSpike);
            }

            Block b1 = new Block(150, 400, 50, 20);
            b1.setFill(Main.blockColor);

            Block b2 = new Block(230, 150, 60, 20);
            b2.setFill(Main.blockColor);
            b2.setupAnimation(230,500, Block.MotionDirection.HORIZONTAL, Block.MotionType.ENDLESS, 5);

            Block b3 = new Block(600, 300, 50, 20);
            b3.setFill(Main.blockColor);

            Block b4 = new Block(700, 350, 50, 20);
            b4.setFill(Main.blockColor);

            Block b5 = new Block(800, 400, 50, 20);
            b5.setFill(Main.blockColor);

            Block b6 = new Block(1200, 100, 50, 170);
            b6.setFill(Main.blockColor);
            Spikes s6 = new Spikes(1200,270);
            s6.setRotate(180);

            Block b7 = new Block(1200, 350, 50, 150);
            b7.setFill(Main.blockColor);
            Spikes s7 = new Spikes(1200,340);

            Block b8 = new Block(700, 900, 50, 20);
            b8.setFill(Main.blockColor);

            Block b9 = new Block(520, 900, 50, 20);
            b9.setFill(Main.blockColor);

            Block b10 = new Block(320, 900, 50, 20);
            b10.setFill(Main.blockColor);

            Door door = new Door(265, 455);

            levelTimer = new AnimationTimer() {
                boolean counter1 = false;
                boolean counter2 = false;
                boolean counter5 = false;
                boolean counter9 = false;
                boolean counter10 = false;
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() == 230 && !Main.spirit.isReversed && !counter1) {
                        Main.spirit.reverseGravity();
                        b2.animate(true);
                        door.setupAnimation(265, 500, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 10);
                        door.animate(true);
                        counter1 = true;
                    }
                    if (b2.isTouched && !counter2) {
                        Main.spirit.mirror();
                        counter2 = true;
                    }
                    if (Main.spirit.getCenterX() == 610 && Main.spirit.isReversed) {
                        Main.spirit.reverseGravity();
                        door.setupAnimation(500, 900, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 30);
                        door.animate(true);
                    }
                    if (Main.spirit.getCenterX() == 700) {
                        b4.setupAnimation(350, 900, Block.MotionDirection.VERTICAL, Block.MotionType.END, 10);
                        b4.animate(true);
                    }
                    if (Main.spirit.getCenterX() == 700) {
                        b6.setupAnimation(-100, 1200, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -8);
                        b6.animate(true);
                        s6.setupAnimation(-100, 1200, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -8);
                        s6.animate(true);
                        b7.setupAnimation(-100, 1200, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -8);
                        b7.animate(true);
                        s7.setupAnimation(-100, 1200, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -8);
                        s7.animate(true);
                        door.setupAnimation(265, 900, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -30);
                        door.animate(true);

                        b8.setupAnimation(450,900, Block.MotionDirection.VERTICAL, Block.MotionType.END, -5);
                        b9.setupAnimation(450,900, Block.MotionDirection.VERTICAL, Block.MotionType.END, -5);
                        b10.setupAnimation(450,900, Block.MotionDirection.VERTICAL, Block.MotionType.END, -5);
                        b8.animate(true);
                        b9.animate(true);
                        b10.animate(true);
                    }
                    if (b5.isTouched && !counter5) {
                        Main.spirit.mirror();
                        counter5 = true;
                    }
                    if (Main.spirit.getCenterX() == 680 && Main.spirit.getCenterY() >= 320 && Main.spirit.getCenterY() <= 450) {
                        b3.setupAnimation(300, 900, Block.MotionDirection.VERTICAL, Block.MotionType.END, 10);
                        b3.animate(true);
                    }
                    if (b9.isTouched && !counter9) {
                        Main.spirit.mirror();
                        counter9 = true;
                    }
                    if (b10.isTouched && !counter10) {
                        b10.setupAnimation(450, 900, Block.MotionDirection.VERTICAL, Block.MotionType.END, 1);
                        b10.animate(true);
                        counter10 = true;
                    }


                }
            };
            levelTimer.start();
            isLeveltimerOn = true;

            levelRoot.getChildren().addAll(upperBorder, lowerBorder, leftBorder, rightBorder, b1, b2,b3,b4,b5,b6,b7,s6,s7,b8,b9,b10, door, Main.spirit);
        }


        /* >>>> level 6 <<<< */
        else if (level == 6) {

            Main.spirit.setVx(0);
            Main.spirit.setVy(0);
            currentLevel = 6;
            Main.spirit.reverseGravity();
            Main.spirit.setCenterX(80);
            Main.spirit.setCenterY(80);

            // upper border
            Block upperBorder = new Trap(0, -10, 1200, 1);
            upperBorder.setFill(Color.TRANSPARENT);

            // left border
            Block leftBorder = new Block(0, 0, 50, 600);
            leftBorder.setFill(Main.blockColor);

            // right border
            Block rightBorder = new Block(1150, 0, 50, 600);
            rightBorder.setFill(Main.blockColor);

            Block B1 = new Block(300, 0, 50, 445.01);
            B1.setFill(Main.blockColor);

            Block B3 = new Block(800, 200, 50, 400);
            B3.setFill(Main.blockColor);

            Block b1 = new Block(50, 50, 50, 25);
            b1.setFill(Main.blockColor);

            Block b2 = new Block(150, 100, 150, 25);
            b2.setFill(Main.blockColor);

            Block s1 = new Spikes(250,125);
            s1.setRotate(180);
            s1.setupAnimation(150, 350, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -10);

            Block b3 = new Block(50, 190, 100, 25);
            b3.setFill(Main.blockColor);
            Block s2 = new Spikes(50,215);
            s2.setRotate(180);

            Block b4 = new Block(250, 280, 50, 25);
            b4.setFill(Main.blockColor);

            Block b5 = new Block(50, 320, 100, 25);
            b5.setFill(Main.blockColor);
            Block s3 = new Spikes(100,345);
            s3.setRotate(180);

            Block b6 = new Block(175, 350, 50, 50);
            b6.setFill(Main.blockColor);
            b6.setupAnimation(350, 470, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 3);
            b6.animate(true);

            Block s4 = new Spikes(175,340);
            s4.setupAnimation(340, 460, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 3);
            s4.animate(true);

            Block s5 = new Spikes(205,365);
            s5.setRotate(90);
            s5.setupAnimation(365, 485, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 3);
            s5.animate(true);

            Block s6 = new Spikes(145,365);
            s6.setRotate(270);
            s6.setupAnimation(365, 485, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 3);
            s6.animate(true);

            Block b7 = new Block(300, 421, 210, 25);
            b7.setFill(Main.blockColor);

            Block s7 = new Spikes(499,444.95);
            s7.setRotate(180);
            s7.setupAnimation(444, 499, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -5);

            Block s8 = new Spikes(399,444.95);
            s8.setRotate(180);
            s8.setupAnimation(344, 399, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, -5);

            Block b_7 = new Block(509, 421, 40, 24.7);
            b_7.setFill(Main.blockColor);
            b_7.setupAnimation(421, 445, Block.MotionDirection.VERTICAL, Block.MotionType.END, .3);

            Block b8 = new Block(399, 540, 50, 100);
            b8.setFill(Main.blockColor);
            b8.setupAnimation(500, 600, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b8.animate(true);
            Block s9 = new Spikes(399, 530);
            s9.setupAnimation(490, 590, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            s9.animate(true);

            Block b9 = new Block(449, 520, 50, 100);
            b9.setFill(Main.blockColor);
            b9.setupAnimation(500, 600, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b9.animate(true);
            Block s10 = new Spikes(449, 510);
            s10.setupAnimation(490, 590, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            s10.animate(true);

            Block b10 = new Block(499, 500, 50, 100);
            b10.setFill(Main.blockColor);
            b10.setupAnimation(500, 600, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b10.animate(true);
            Block s11 = new Spikes(499, 490);
            s11.setupAnimation(490, 590, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            s11.animate(true);

            Block b11 = new Block(650, 325, 50, 35);
            b11.setFill(Main.blockColor);
            b11.setupAnimation(250, 450, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2.5);
            b11.animate(true);

            Block b12 = new Block(350, 300, 200, 25);
            b12.setFill(Main.blockColor);
            b12.setupAnimation(-100, 300, Block.MotionDirection.VERTICAL, Block.MotionType.END, -10);

            Block b13 = new Block(580, 200, 220, 25);
            b13.setFill(Main.blockColor);

            Block s12 = new Spikes(580,225);
            s12.setRotate(180);

            Block s13 = new Spikes(628,225);
            s13.setRotate(180);

            Block s14 = new Spikes(675,225);
            s14.setRotate(180);

            Block s15 = new Spikes(721,225);
            s15.setRotate(180);

            Block s16 = new Spikes(750,225);
            s16.setRotate(180);

            Block b14 = new Block(620, -20, 50, 95);
            b14.setFill(Main.blockColor);
            b14.setupAnimation(-105, 3, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b14.animate(true);

            Block b15 = new Block(720, -40, 50, 95);
            b15.setFill(Main.blockColor);
            b15.setupAnimation(-105, 3, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b15.animate(true);

            Block b16 = new Block(820, -60, 50, 95);
            b16.setFill(Main.blockColor);
            b16.setupAnimation(-105, 3, Block.MotionDirection.VERTICAL, Block.MotionType.ENDLESS, 2);
            b16.animate(true);

            Block b17 = new Block(1000, 70, 65, 25);
            b17.setFill(Main.blockColor);

            b17.setupAnimation(-40, 70, Block.MotionDirection.VERTICAL, Block.MotionType.END, -5);

            Block b18 = new Block(849, 200, 150, 25);
            b18.setFill(Main.blockColor);

            Block b19 = new Block(1100, 150, 50, 25);
            b19.setFill(Main.blockColor);
            b19.setupAnimation(1100, 1200, Block.MotionDirection.HORIZONTAL, Block.MotionType.END, 10);

            Block b20 = new Block(1030, 290, 90, 25);
            b20.setFill(Main.blockColor);

            Block b21 = new Block(1120, 290, 30, 25);
            b21.setFill(Main.blockColor);
            b21.setupAnimation(290, 466, Block.MotionDirection.VERTICAL, Block.MotionType.END, 15);

            Door door = new Door(1120, 314);
            door.setRotate(180);
            door.setupAnimation(290, 490, Block.MotionDirection.VERTICAL, Block.MotionType.END, 15);



            levelTimer = new AnimationTimer() {
                boolean created = true;
                boolean blockCreated = true;
                @Override
                public void handle(long l) {
                    if (Main.spirit.getCenterX() == 120) s1.animate(true);
                    if (Main.spirit.getCenterX() >= 420 && Main.spirit.getCenterX() <= 430)s7.animate(true);
                    if (Main.spirit.getCenterX() >= 420 && Main.spirit.getCenterX() <= 430) s8.animate(true);
                    if (Main.spirit.getCenterX() ==  515) b_7.animate(true);
                    if ((Main.spirit.getCenterX() <= 550&& Main.spirit.getCenterX() >=500 )&& (Main.spirit.getCenterY() >= 325 && Main.spirit.getCenterY() <= 340) )b12.animate(true);
                    if (!Main.spirit.isMirrored) {
                        if ((Main.spirit.getCenterX() >= 1000) && (Main.spirit.getCenterY() >= 90 && Main.spirit.getCenterY() <= 115))
                            Main.spirit.mirror();
                    }
                    if ((Main.spirit.getCenterX() >= 1055) && (Main.spirit.getCenterY() >= 290 && Main.spirit.getCenterY() <= 350)){

                        b17.animate(true);
                        b19.animate(true);

                        b21.animate(true);
                        door.animate(true);
                        Block b22 = new Block(849,315,80,25);
                        b22.setFill(Main.blockColor);
                        levelRoot.getChildren().add(b22);
                    }
                    if((Main.spirit.getCenterX()>=850&&Main.spirit.getCenterX()<=980)&&(Main.spirit.getCenterY()>=345&&Main.spirit.getCenterY()<=450)&&created){
                        Block s17 = new Spikes(880,340);
                        s17.setRotate(180);
                        created = false;
                        levelRoot.getChildren().add(s17);
                    }
                    if((Main.spirit.getCenterX()>=850&&Main.spirit.getCenterX()<=890)&&(Main.spirit.getCenterY()>=345&&Main.spirit.getCenterY()<=360)&&blockCreated){

                        Block b23 = new Block(945,405,90,25);
                        b23.setFill(Main.blockColor);
                        levelRoot.getChildren().add(b23);
                    }


                }
            };
            isLeveltimerOn = true;
            levelTimer.start();

            levelRoot.getChildren().addAll(upperBorder, leftBorder, rightBorder,
                    B1,B3,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,
                    b16,b17,b18,b19,b20,b21,
                    s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,
                    b_7,
                    door,
                    Main.spirit);
        }


        return levelRoot;
    }

}