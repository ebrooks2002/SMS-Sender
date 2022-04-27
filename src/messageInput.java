import edu.macalester.graphics.ui.TextField;

import edu.macalester.graphics.CanvasWindow;

public class messageInput extends TextField {

    public messageInput(CanvasWindow canvas, double x, double y) {
        super();
        this.setScale(3, 3);
        canvas.add(this, x, y);

    }

    public static void main(String[] args) {
        // new messageInput(new CanvasWindow("Testing", 800, 800), 0, 0);
        CanvasWindow canvas = new CanvasWindow("testing", 400, 400);
        TextField text = new TextField();
        text.setScale(10);
        canvas.add(text);
    }
}
