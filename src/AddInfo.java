import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class AddInfo extends GraphicsGroup{

    private TextField nameField = new TextField();
    private GraphicsText nameFieldHeader = new GraphicsText("Enter a number:");
    private Button nameButton = new Button("Enter");

    private TextField numberField = new TextField();
    private GraphicsText numberFieldHeader = new GraphicsText("Enter a name:");
    private Button numberButton = new Button("Enter");

    private TextField messageField = new TextField();
    private GraphicsText messageFieldHeader = new GraphicsText("Enter message:");
    private Button messageButton = new Button("Enter");
    
    public AddInfo(CanvasWindow canvas) {
        super();
        Rectangle rect = new Rectangle(10, 5, 200, 160);
        rect.setStrokeColor(Color.BLACK);
        canvas.add(rect);
        canvas.add(this, 30, 0);
        this.addNameObjects();
        this.addNumberObjects();
        this.addMessageObjects();
    }

    public void addNumberObjects() {
        super.add(nameField, 0, 28);
        super.add(nameFieldHeader, 5, 25);
        super.add(nameButton,100, 30);
    }

    public void addNameObjects() {
        super.add(numberField, 0, 80);
        super.add(numberFieldHeader, 5, 80);
        super.add(numberButton,100, 80);
    }

    public void addMessageObjects() {
        super.add(messageField, 0, 130);
        super.add(messageFieldHeader, 5, 128);
        super.add(messageButton, 100, 130);
    }

}
