import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.TextField;

public class UI {
    private TextField numberField;
    private GraphicsText numberFieldHeader;
    private TextField nameField;
    private GraphicsText nameFieldHeader;

    public UI(int canvasSize) {
        CanvasWindow canvas = new CanvasWindow("SMS sender", canvasSize, (int) (canvasSize*.8));

        numberField = new TextField();
        nameField = new TextField();  

        numberFieldHeader = new GraphicsText("Phone Number: ");
        nameFieldHeader = new GraphicsText("Name: ");

        canvas.add(numberField, 100, 100);
        canvas.add(nameField, 100, 200);
        canvas.add(numberFieldHeader, 100, 80);
        canvas.add(nameFieldHeader, 100, 180);

        
    }
    
    public static void main(String[] args) {
        new UI(800);
    }

}
