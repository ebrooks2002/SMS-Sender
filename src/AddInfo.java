import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.TextField;

public class AddInfo extends GraphicsGroup{
    
    public AddInfo(CanvasWindow canvas) {
        super();
        canvas.add(this);
    }

    public void addNameFieldandHeader() {
        TextField nameField = new TextField();
        GraphicsText nameFieldHeader = new GraphicsText("Enter a name:");
        super.add(nameField,0,50);
        super.add(nameFieldHeader, 0, 0);

    }

    public void addNumber() {

    }

    public void addMessage() {

    }

}
