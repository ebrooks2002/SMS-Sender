import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.*;

public class sendSection extends GraphicsGroup {

    private static final String NAME_REPLACEMENT = "#####";

    public sendSection(CanvasWindow canvas, GraphicsText result, HashMap<String, String> nameNumberMap, TextField messageField, double x, double y) {
        super();
        GraphicsText spamInstructions = new GraphicsText("Spam count: ");

        TextField spam = new TextField();
        spam.setText("1");

        // Button that sends everything
        Button send = new Button("Send Messages!");
        send.onClick(() -> {
            int num = 0;
            try {
                num = Integer.parseInt(spam.getText()); // Checks if user has given a valid number
            }
            catch (Exception e) {
                result.setText("Please enter in valid spam number");
                return;
            }
            String message = messageField.getText();
            for (int count = 0; count < num; count++) {
                nameNumberMap.forEach((key, value) -> {
                    texting.text(key, message.replaceAll(NAME_REPLACEMENT, value)); // Replaces all instances of NAME_REPLACEMENT with name to personalize text messages
                });
            }
        });

        Button clear = new Button("Clear all data"); // Clears names and numbers
        clear.onClick(() -> {
            nameNumberMap.clear();
        });

        // Bounding box
        Rectangle bounding = new Rectangle(0, 0, 250, 120);
        bounding.setFillColor(Color.GRAY);
        add(bounding);

        // Placemenet of all objects into group
        add(send);
        add(spamInstructions);
        add(spam);
        add(clear);

        // Sets the center
        send.setCenter(150, 30);
        spamInstructions.setCenter(50, 60);
        spam.setCenter(150, 60);
        clear.setCenter(150, 90);

        // Add group to canvas
        canvas.add(this, x, y);
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("testing", 800, 800);
        GraphicsText result = new GraphicsText("Result");
        canvas.add(result, 0, 0);
        TextField message = new TextField();
        canvas.add(message, 50, 50);

        new sendSection(canvas, result, new HashMap<>(), message, 100, 100);
    }


}
