import java.awt.Color;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class UI {
    //Text Fields:
    private TextField numberField;
    private TextField messageField;
    private TextField nameField;
    private TextField yourNumberField;
    //Headers for each field:
    private GraphicsText yourNumberFieldHeader;
    private GraphicsText numberFieldHeader;
    private GraphicsText messageFieldHeader;
    private GraphicsText nameFieldHeader;
    //Buttons:
    private Button yourNumberButton;
    private Button nameButton;
    private Button numberButton;
    private Button messageButton;
    private Button sendButton;
    //Other:
    private ArrayList<String> numberList;
    private CanvasWindow canvas;
    private String message;

    public UI(int canvasSize) {
        canvas = new CanvasWindow("SMS sender", canvasSize, (int) (canvasSize * .8));
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

        numberList = new ArrayList<String>();
        //Text fields:
        canvas.add(numberField, 100, 140);
        canvas.add(messageField, 100, 190);
        canvas.add(nameField, 100,90);
        //Headers for each field:
        canvas.add(numberFieldHeader, 100, 135);
        canvas.add(messageFieldHeader, 105, 185);
        canvas.add(nameFieldHeader, 100, 80);
        //Buttons:
        canvas.add(nameButton, 200, 90);
        canvas.add(numberButton, 200, 140);
        canvas.add(messageButton, 200, 190);
        canvas.add(sendButton, 100, 240);
        
        this.onNumberButton();
        this.onMessageButton();
        this.onSendButton();
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
