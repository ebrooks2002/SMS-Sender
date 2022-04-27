import edu.macalester.graphics.CanvasWindow;
/**
 * Simple class that creates the textArea of width and height on the canvas at x, y
 */
public class MessageInput extends TextArea {

    public MessageInput(CanvasWindow canvas, double x, double y, int width, int height) {
        super(width, height);
        canvas.add(this, x, y);
    }
}
