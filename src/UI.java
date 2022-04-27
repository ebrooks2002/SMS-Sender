import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class UI {
    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 500;
   
    
    // GraphicsText fields
    private static GraphicsText result = new GraphicsText("asdf");
    private HashMap<String, String> nameNumberMap = new HashMap<String, String>();
   

    public UI(int canvasSize) {
        CanvasWindow canvas = new CanvasWindow("SMS sender", canvasSize, canvasSize);
        canvas.add(result, 300, 300);
        new AddInfo(canvas, result, nameNumberMap);
        // Text fields:
        
        // numberField = new TextField();
        // messageField = new TextField();

        // // Headers for each field:
        
        // GraphicsText numberFieldHeader = new GraphicsText("Phone Number: ");
        // GraphicsText messageFieldHeader = new GraphicsText("Message:");
        // result = new GraphicsText("Result of previous action");

        // // Buttons:
        
        // sendButton = new Button("Send message");

        // // Text fields:
        // canvas.add(numberField, 100, 140);
        // canvas.add(messageField, 100, 190);
        // canvas.add(nameField, 100, 90);

        // // Headers for each field:
        // canvas.add(numberFieldHeader, 100, 135);
        // canvas.add(messageFieldHeader, 105, 185);
        
        // canvas.add(result, 50, 50);

        // // Buttons:
        // canvas.add(addButton, 200, 190);
        // canvas.add(sendButton, 100, 240);

        
        
        
    }

   

    public static void main(String[] args) {
        new UI(500);
    }

}
