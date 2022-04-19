
import java.awt.Color;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class UI {
    private TextField numberField;
    private TextField messageField;
    private GraphicsText numberFieldHeader;
    private GraphicsText messageFieldHeader;
    private Button enterNumber;
    private Button enterMessage;
    private ArrayList<String> numberList;
    private CanvasWindow canvas;
    private String message;

    public UI(int canvasSize) {
        canvas = new CanvasWindow("SMS sender", canvasSize, (int) (canvasSize * .8));
        numberField = new TextField();
        messageField = new TextField();
        numberFieldHeader = new GraphicsText("Phone Number(s): ");
        messageFieldHeader = new GraphicsText("Message:");
        enterNumber = new Button("Enter");
        enterMessage = new Button("Enter");
        numberList = new ArrayList<String>();

        canvas.add(numberField, 100, 100);
        canvas.add(numberFieldHeader, 100, 95);
        canvas.add(messageField, 100, 150);
        canvas.add(messageFieldHeader, 105, 145);
        canvas.add(enterNumber, 200, 100);
        canvas.add(enterMessage, 200, 150);

        this.onEnterNumber();
        this.onEnterNumber();
    }

    private void onEnterNumber() {
        enterNumber.onClick(() -> {
            Boolean correctSize = numberField.getText().length() == 10;
            Boolean onlyNumbers = numberField.getText().matches("[0-9]+");
            if (correctSize && onlyNumbers) {
                numberList.add(numberField.getText());
                System.out.println(numberList);
                numberField.setBackground(Color.GREEN);
            } 
            else {
                System.out.println("Please Enter a valid phone number:");
                numberField.setBackground(Color.RED);
            }
        });
    }

    private void onEnterMessage() {
        enterNumber.onClick(() -> {
            message = new String();
            Boolean notEmpty = messageField.getText().length() != 0;
            if (notEmpty) {
                message = messageField.getText();
            }
            else {
                messageField.setBackground(Color.RED);
                System.out.println("enter a valid message.");
            }
        });
    }

    public static void main(String[] args) {
        new UI(500);
    }

}
