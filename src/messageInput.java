import edu.macalester.graphics.CanvasWindow;

public class MessageInput extends TextArea {

    public MessageInput(CanvasWindow canvas, double x, double y, int width, int height) {
        super(width, height);
        canvas.add(this, x, y);
    }
}
