import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

/**
 * Class that adds textfields and graphicstexts to instruct the user where to input the phone number
 * and names.
 */
public class AddInfo extends GraphicsGroup{

    private GraphicsText result;
    private HashMap<String, String> nameNumberMap;

    private TextField nameField = new TextField();
    private GraphicsText nameFieldHeader = new GraphicsText("Enter a name:");
    
    private TextField numberField = new TextField();
    private GraphicsText numberFieldHeader = new GraphicsText("Enter a number:");
    
    private Button addButton = new Button("Add");
    
    /**
     * Sets up the creation of the addinfo section.
     * @param result = GraphicsText object that gets updated for every action, explaining the results of that action
     * @param nameNumberMap = Hashmap with keys being numbers and values being the connected name.
     */
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

    private void addNumberObjects() {
        add(numberField, 10, 28);
        add(numberFieldHeader, 15, 25);
    }

    private void addNameObjects() {
        add(nameField, 10, 80);
        add(nameFieldHeader, 15, 78);
    }

    /**
     * Programs so that on button click, checks if there's a valid number. If there is, then adds it to the 
     * hashmap and updates components to notify user if it successfully added component or not.
     */
    private void onAddButton() {
        addButton.onClick(() -> {
            String number = numberField.getText();
            boolean correctSize = number.length() == 10;
            boolean onlyNumbers = number.matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                String name = nameField.getText();
                nameNumberMap.put(number, name);
                RecipientsList.addNewTextField(number, name);
                updateFields(Color.GREEN, "Added " + number + (name.length() != 0 ? " as " + name : ""));
            }
            else {
                updateFields(Color.RED, "Please enter in valid number");
            }
        });
    }

    /**
     * Sets a timer delay before reverting the text fields back to white. Text fields first set to input color
     */
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
