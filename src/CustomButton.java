import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import javax.swing.text.Style;


public class CustomButton extends StackPane {


    /* >>>> class attributes <<<< */


    private Rectangle button;
    private Text text;
    private Font font;
    private Paint buttonColor;
    private ScaleTransition scaleTransition;



    /* >>>> constructors <<<< */


    CustomButton(double width, double height, Paint buttonColor, String text, Paint textColor) {
        this.buttonColor = buttonColor;
        button = new Rectangle(width, height, buttonColor);
        //button.setArcHeight(0.1*Math.max(height, width));
        //button.setArcWidth(0.1*Math.max(height, width));
        //font = Font.loadFont(getClass().getResourceAsStream("fonts & icons/SpaceGrotesk-VariableFont_wght.ttf"), FontWeight.BOLD, 0.2*Math.max(height, width));
        font = Font.font("Arial", FontWeight.BOLD, 0.25*Math.min(height, width));
        this.text = new Text("text");
        this.text.setFont(font);
        this.text.setFill(textColor);
        getChildren().addAll(button, this.text);
        setHover();
    }

    private void setHover() {
        scaleTransition = new ScaleTransition(Duration.millis(20), button);
        scaleTransition.setCycleCount(1);

        button.setOnMouseEntered(e -> {
            button.setOpacity(0.9);
            scaleTransition.setFromX(1);
            scaleTransition.setFromY(1);
            scaleTransition.setToX(1.02);
            scaleTransition.setToY(1.02);
            scaleTransition.play();

        });
        button.setOnMouseExited(e -> {
            button.setOpacity(1);
            scaleTransition.setFromX(1.02);
            scaleTransition.setFromY(1.02);
            scaleTransition.setToX(1);
            scaleTransition.setToY(1);
            scaleTransition.play();
        });






    }









}
