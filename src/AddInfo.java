import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class AddInfo extends GraphicsGroup{

    private GraphicsText result;
    private HashMap<String, String> nameNumberMap;

    private TextField nameField = new TextField();
    private GraphicsText nameFieldHeader = new GraphicsText("Enter a number:");
    

    private TextField numberField = new TextField();
    private GraphicsText numberFieldHeader = new GraphicsText("Enter a name:");
    
    private Button addButton = new Button("Add");
    
    public AddInfo(CanvasWindow canvas, GraphicsText result, HashMap<String, String> nameNumberMap) {
        super();
        Rectangle rect = new Rectangle(10, 5, 200, 160);
        rect.setStrokeColor(Color.BLACK);
        rect.setFillColor(Color.LIGHT_GRAY);
        canvas.add(rect);
        canvas.add(this, 30, 0);
        addNameObjects();
        addNumberObjects();
        add(addButton, 100, 130);
        onAddButton();

    }

    public void addNumberObjects() {
        add(nameField, 0, 28);
        add(nameFieldHeader, 5, 25);
    }

    public void addNameObjects() {
        add(numberField, 0, 80);
        add(numberFieldHeader, 5, 78);
    }


    public void onAddButton() {
        addButton.onClick(() -> {
            boolean correctSize = numberField.getText().length() == 10;
            boolean onlyNumbers = numberField.getText().matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                String name = nameField.getText();
                nameNumberMap.put(numberField.getText(), name);
                numberField.setBackground(Color.WHITE);
                nameField.setBackground(Color.WHITE);
                System.out.println("hi");
                result.setText("Added " + (name.length() != 0 ? " with " + name : "")); // If a name was entered, then it includes that in the output description
            }
            else {
                numberField.setBackground(Color.RED);
                nameField.setBackground(Color.RED);
            }
        });
    }

}
