import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;


public class UI {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    
    // Other:
    private HashMap<String, String> nameNumberMap = new HashMap<String, String>();

    public UI() {
        CanvasWindow canvas = new CanvasWindow("SMS sender", CANVAS_WIDTH, CANVAS_HEIGHT);

        Instructions instruct = new Instructions(canvas, 0, 0);
        GraphicsText result = instruct.getResults();

        MessageInput message = new MessageInput(canvas, 0, instruct.getHeight(), (int) instruct.getWidth(), 100);

        new AddInfo(canvas, result, nameNumberMap, instruct.getWidth(), 0);

        new SendSection(canvas, result, nameNumberMap, message, message.getWidth(), instruct.getHeight());
    }
    public static void main(String[] args) {
        new UI();
    }

}
