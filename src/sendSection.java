import java.awt.Color;
import java.util.HashMap;

import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.*;

public class SendSection extends GraphicsGroup {

    public static final String NAME_REPLACEMENT = "#####";

    public SendSection(CanvasWindow canvas, GraphicsText result, HashMap<String, String> nameNumberMap, MessageInput messageField, double x, double y) {
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
                result.setFillColor(Color.RED);
                return;
            }
            result.setText("Sending messages...");
            result.setFillColor(Color.BLUE);

            String message = messageField.getText();
            for (int count = 0; count < num; count++) {
                nameNumberMap.forEach((key, value) -> {
                    text(key, message.replaceAll(NAME_REPLACEMENT, value)); // Replaces all instances of NAME_REPLACEMENT with name to personalize text messages
                });
            }
            result.setText("Sent all messages!");
            result.setFillColor(Color.GREEN);
            messageField.setText("Input message here: ");
        });

        Button clear = new Button("Clear all data"); // Clears names and numbers
        clear.onClick(() -> {
            nameNumberMap.clear();
            result.setText("Cleared all data");
            result.setFillColor(Color.BLUE);
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

    public void text(String number, String message) {
        String[] launchCmd = {"osascript", "-e",    "on run argv\n" +
                                                        "tell application \"Messages\"\n" +
                                                            "set targetBuddy to (item 1 of argv)\n" +
                                                            "set targetService to id of 1st account whose service type = SMS\n" +
                                                            "set textMessage to (item 2 of argv)\n" +
                                                            "set theBuddy to participant targetBuddy of account id targetService\n" +
                                                            "send textMessage to theBuddy\n" +
                                                        "end tell\n" +
                                                    "end run", number, message
                                                };
        try {
            Runtime.getRuntime().exec(launchCmd);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
