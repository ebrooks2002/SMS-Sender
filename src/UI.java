import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class UI {
    //Text Fields:
    private static TextField numberField;
    private static TextField messageField;
    private static TextField nameField;
    private static TextField yourNumberField;
    //Headers for each field:
    private static GraphicsText yourNumberFieldHeader;
    private static GraphicsText numberFieldHeader;
    private static GraphicsText messageFieldHeader;
    private static GraphicsText nameFieldHeader;
    //Buttons:
    private static Button yourNumberButton;
    private static Button nameButton;
    private static Button numberButton;
    private static Button messageButton;
    private static Button sendButton;
    //Other:
    private ArrayList<String> numberList;
    private CanvasWindow canvas;
    private String message;
    private ArrayList<String> nameList;
    private HashMap<String, String> nameNumberMap = new HashMap<String, String>();

    public UI(int canvasSize) {
        this.canvas = new CanvasWindow("SMS sender", canvasSize, (int) (canvasSize * .8));
        //Text fields:
        yourNumberField = new TextField();
        nameField = new TextField();
        numberField = new TextField();
        messageField = new TextField();
        //Headers for each field:
        yourNumberFieldHeader = new GraphicsText("Enter your phone number");
        nameFieldHeader = new  GraphicsText("Enter a name:");
        numberFieldHeader = new GraphicsText("Phone Number: ");
        messageFieldHeader = new GraphicsText("Message:");
        //Buttons:
        yourNumberButton = new Button("Enter");
        nameButton = new Button("Enter");
        numberButton = new Button("Enter");
        messageButton = new Button("Enter");
        sendButton = new Button("Send message");
        //Lists;
        nameList = new ArrayList<String>();
        numberList = new ArrayList<String>();

        //Text fields:
        canvas.add(yourNumberField, 100,40);
        canvas.add(numberField, 100, 140);
        canvas.add(messageField, 100, 190);
        canvas.add(nameField, 100,90);
        //Headers for each field:
        canvas.add(yourNumberFieldHeader, 100, 30);
        canvas.add(numberFieldHeader, 100, 135);
        canvas.add(messageFieldHeader, 105, 185);
        canvas.add(nameFieldHeader, 100, 80);
        //Buttons:
        canvas.add(yourNumberButton, 200, 40);
        canvas.add(nameButton, 200, 90);
        canvas.add(numberButton, 200, 140);
        canvas.add(messageButton, 200, 190);
        canvas.add(sendButton, 100, 240);

        onNameButton();
        onNumberButton();
        onMessageButton();
        onSendButton();
        onYourNumberButton();
    }

    private void onNumberButton() {
        numberButton.onClick(() -> {
            Boolean correctSize = numberField.getText().length() == 10;
            Boolean onlyNumbers = numberField.getText().matches("[0-9]+");
            Boolean notEnteredYet = !numberList.contains(numberField.getText());
            if (correctSize && onlyNumbers && notEnteredYet) {
                numberList.add(numberField.getText());
                System.out.println(numberList);
                numberField.setBackground(Color.GREEN);
            } 
            else {
                System.out.println("Please Enter a valid phone number.");
                numberField.setBackground(Color.RED);
            }
        });
    }

    private void onYourNumberButton() {
        yourNumberButton.onClick(() -> {
            Boolean correctSize = yourNumberField.getText().length() == 10;
            Boolean onlyNumbers = yourNumberField.getText().matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                numberField.setBackground(Color.GREEN);
            } 
            else {
                System.out.println("Please Enter a valid phone number.");
                numberField.setBackground(Color.RED);
            }
        });
    }

    private void onNameButton() {
        nameButton.onClick(() -> {
            Boolean notEmpty = messageField.getText().length() != 0;
            Boolean notEnteredYet = !nameList.contains(nameField.getText());
            if (notEmpty && notEnteredYet) {
                nameList.add(nameField.getText());
                System.out.println(nameList);
                nameField.setBackground(Color.GREEN);
            }
            else {
                System.out.println("Please enter a valid name: ");
                nameField.setBackground(Color.RED);
            }
        });
    }

    private void onMessageButton() {
        messageButton.onClick(() -> {
            message = new String();
            Boolean notEmpty = messageField.getText().length() != 0;
            if (notEmpty) {
                message = messageField.getText();
            }
            else {
                System.out.println("Enter a valid message.");
                messageField.setBackground(Color.RED);
            }
        });
    }

    private void onSendButton() {
        sendButton.onClick(() -> {
            
        });
    }

    public static void main(String[] args) {
        new UI(500);
    }

}
