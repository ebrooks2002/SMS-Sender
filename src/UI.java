import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class UI {
    public static final int CANVAS_WIDTH = 500;
    public static final int CANVAS_HEIGHT = 500;
    //Text Fields:
    private static TextField numberField;
    private static TextField messageField;
    private static TextField nameField;
    
    //Buttons:
    private static Button addButton;
    private static Button sendButton;

    // GraphicsText fields
    private static GraphicsText result;

    // Other:
    private HashMap<String, String> nameNumberMap = new HashMap<String, String>();
    private static final String NAME_REPLACEMENT = "#####";

    public UI(int canvasSize) {
        CanvasWindow canvas = new CanvasWindow("SMS sender", canvasSize, canvasSize);
        // Text fields:
        nameField = new TextField();
        numberField = new TextField();
        messageField = new TextField();

        // Headers for each field:
        GraphicsText nameFieldHeader = new GraphicsText("Enter a name:");
        GraphicsText numberFieldHeader = new GraphicsText("Phone Number: ");
        GraphicsText messageFieldHeader = new GraphicsText("Message:");
        result = new GraphicsText("Result of previous action");

        // Buttons:
        addButton = new Button("Add name/number");
        sendButton = new Button("Send message");

        // Text fields:
        canvas.add(numberField, 100, 140);
        canvas.add(messageField, 100, 190);
        canvas.add(nameField, 100, 90);

        // Headers for each field:
        canvas.add(numberFieldHeader, 100, 135);
        canvas.add(messageFieldHeader, 105, 185);
        canvas.add(nameFieldHeader, 100, 80);
        canvas.add(result, 50, 50);

        // Buttons:
        canvas.add(addButton, 200, 190);
        canvas.add(sendButton, 100, 240);

        
        onNumberButton();
        onSendButton();
    }

    private void onNumberButton() {
        addButton.onClick(() -> {
            boolean correctSize = numberField.getText().length() == 10;
            boolean onlyNumbers = numberField.getText().matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                String name = nameField.getText();
                nameNumberMap.put(numberField.getText(), name);
                numberField.setBackground(Color.WHITE);
                nameField.setBackground(Color.WHITE);
                result.setText("Added " + (name.length() != 0 ? " with " + name : "")); // If a name was entered, then it includes that in the output description
            }
            else {
                numberField.setBackground(Color.RED);
                nameField.setBackground(Color.RED);
            }
        });
    }

    private void onSendButton() {
        sendButton.onClick(() -> {
            String message = messageField.getText();
            nameNumberMap.forEach((key, value) -> {
                texting.text(key, message.replaceAll(NAME_REPLACEMENT, value));
            });
        });
    }

    public static void main(String[] args) {
        new UI(500);
    }

}
