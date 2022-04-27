import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class AddInfo extends GraphicsGroup{
    
    public AddInfo(CanvasWindow canvas) {
        super();
        canvas.add(this, 30, 0);
        this.addNameObjects();
        this.addNumberObjects();
        this.addMessageObjects();
    }

    public void addNumberObjects() {
        TextField nameField = new TextField();
        GraphicsText nameFieldHeader = new GraphicsText("Enter a number:");
        Button nameButton = new Button("Enter");
        super.add(nameField, 0, 28);
        super.add(nameFieldHeader, 5, 25);
        super.add(nameButton,100, 30);
    }

    public void addNameObjects() {
        TextField nameField = new TextField();
        GraphicsText nameFieldHeader = new GraphicsText("Enter a name:");
        Button nameButton = new Button("Enter");
        super.add(nameField, 0, 80);
        super.add(nameFieldHeader, 5, 80);
        super.add(nameButton,100, 80);
    }

    public void addMessageObjects() {
        TextField messageField = new TextField();
        GraphicsText messageFieldHeader = new GraphicsText("Enter message:");
        Button messageButton = new Button("Enter");
        super.add(messageField, 0, 130);
        super.add(messageFieldHeader, 5, 128);
        super.add(messageButton, 100, 130);
    }

}
