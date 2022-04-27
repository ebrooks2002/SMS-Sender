import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.TextAlignment;

public class Instructions extends GraphicsGroup {

    private GraphicsText result = new GraphicsText("Results displayed here");

    public Instructions(CanvasWindow canvas, double x, double y) {
        super();

        result.setFillColor(Color.BLUE);
        result.setFontSize(20);
        result.setAlignment(TextAlignment.CENTER);

        GraphicsText instruction = new GraphicsText(
            "1. In the upper right hand corner, input number in format: 1234567891 \n" +
            "Optional: input name in lower box to personalize messages \n" +
            "2. In lower left hand corner, type message. To personalize messages, \n" +
            "put " + SendSection.NAME_REPLACEMENT + " every place you want to replace with name \n" +
            "Ex. Hello " + SendSection.NAME_REPLACEMENT + "! -> Hello Irene! \n" +
            "3. To send message, click send in lower right corner. \n" +
            "4. To spam, increase spam count. \n" +
            "5. To clear all data, click Clear All Data button to remove all inputs. \n" +
            "6. All results from actions will be displayed above this panel."
            );

        Rectangle bounding = new Rectangle(0, 0, instruction.getWidth() + 20, instruction.getHeight() + 70);
        bounding.setFillColor(Color.GRAY);

        // Adds all componenets in
        add(bounding);
        add(instruction, 10, 60);
        add(result);

        // Places result text right above the instructions
        result.setCenter(instruction.getCenter().getX(), 30);

        canvas.add(this, x, y);
    }

    public GraphicsText getResults() {
        return result;
    }

    public static void main(String[] args) {
        new Instructions(new CanvasWindow("testing", 500, 500), 0, 0);
    }
}
