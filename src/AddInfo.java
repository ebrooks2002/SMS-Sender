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
    private GraphicsText nameFieldHeader = new GraphicsText("Enter a name:");
    
    private TextField numberField = new TextField();
    private GraphicsText numberFieldHeader = new GraphicsText("Enter a number:");
    
    private Button addButton = new Button("Add");
    
    public AddInfo(CanvasWindow canvas, GraphicsText result, HashMap<String, String> nameNumberMap, double x, double y) {
        super();
        this.nameNumberMap = nameNumberMap;
        this.result = result;
        Rectangle rect = new Rectangle(0, 0, 200, 160);
        rect.setStrokeColor(Color.BLACK);
        rect.setFillColor(Color.LIGHT_GRAY);
        add(rect);
        addNameObjects();
        addNumberObjects();
        add(addButton, 100, 110);
        onAddButton();
        canvas.add(this, x, y);
    }

    public void addNumberObjects() {
        add(numberField, 10, 28);
        add(numberFieldHeader, 15, 25);
    }

    public void addNameObjects() {
        add(nameField, 10, 80);
        add(nameFieldHeader, 15, 78);
    }


    public void onAddButton() {
        addButton.onClick(() -> {
            String number = numberField.getText();
            boolean correctSize = number.length() == 10;
            boolean onlyNumbers = number.matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                String name = nameField.getText();
                nameNumberMap.put(number, name);
                updateFields(Color.GREEN, "Added " + number + (name.length() != 0 ? " as " + name : ""));
            }
            else {
                updateFields(Color.RED, "Please enter in valid number");
            }
        });
    }


    private void updateFields(Color color, String results) {
        numberField.setBackground(color);
        nameField.setBackground(color);
        result.setFillColor(color);

        numberField.setText("");
        nameField.setText("");
        result.setText(results);

        Thread delay = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000); // Pauses this thread for 1 second before changing the color back to normal
                    // Still allows us to use the canvas while this is running
                    numberField.setBackground(Color.WHITE);
                    nameField.setBackground(Color.WHITE);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        delay.start();
    }
    
}
