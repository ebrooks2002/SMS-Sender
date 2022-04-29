import java.awt.Color;
import java.util.ArrayList;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;

/**
 * Displays the 12 most recent additions of numbers and names to to hashmap.
 */
public class RecipientsList {

    private static GraphicsText nameHeader = new GraphicsText("Names");
    private static GraphicsText numberHeader = new GraphicsText("Numbers");
    private static ArrayList<GraphicsText> numbersList = new ArrayList<>();
    private static ArrayList<GraphicsText> nameList = new ArrayList<>();

    private static GraphicsGroup group = new GraphicsGroup();

    public RecipientsList(CanvasWindow canvas, double x, double y) {
        Rectangle rect = new Rectangle(0, 0, 400, 280);
        rect.setStrokeColor(Color.BLACK);
        rect.setFillColor(Color.LIGHT_GRAY);
        group.add(rect);
        nameHeader.setFillColor(Color.BLUE);
        nameHeader.setFontSize(15);
        group.add(nameHeader);
        nameHeader.setCenter(35, 20);

        numberHeader.setFillColor(Color.BLUE);
        numberHeader.setFontSize(15);
        group.add(numberHeader);
        numberHeader.setCenter(rect.getWidth() - 40, 20);

        canvas.add(group, x, y);
    }

    /**
     * Adds two new GraphicsTexts containing the name and the number to the displayed data. Replaces the name
     * if the displayed data already has a copy of the number on it
     */
    public static void addNewTextField(String number, String name) {
        for (int textNum = 0; textNum < numbersList.size(); textNum++) {
            if (numbersList.get(textNum).getText().equals(number)) {
                GraphicsText changeName = nameList.get(textNum);
                double previousWidth = changeName.getWidth();
                changeName.setText(name.equals("") ? "NO NAME" : name);
                double newWidth = changeName.getWidth();
                changeName.moveBy(previousWidth - newWidth, 0); // Shifts name over so that it still fits on screen

                return;
            }
        }

        addNumber(number);
        addName(name.equals("") ? "NO NAME" : name);

        if (numbersList.size() > 12) {
            
            // Removes the last element added to fit all elements on screen
            group.remove(numbersList.remove(0)); 
            group.remove(nameList.remove(0));
        }

        // Shifts all the elements downward to make room for new elements
        numbersList.forEach(text -> {
            text.moveBy(0, 20);
        });
        nameList.forEach(text -> {
            text.moveBy(0, 20);
        });
    }

    private static void addNumber(String number) {
        GraphicsText newNumber = new GraphicsText(number);
        newNumber.setCenter(50, 30);
        newNumber.setFillColor(Color.BLUE);
        newNumber.setFontSize(15);
        group.add(newNumber);
        numbersList.add(newNumber);
    }

    private static void addName(String name) {
        GraphicsText newName = new GraphicsText(name);
        newName.setCenter(390 - newName.getWidth() / 2, 30);
        newName.setFillColor(Color.BLUE);
        newName.setFontSize(15);
        group.add(newName);
        nameList.add(newName);
    }

    /**
     * Clears all GraphicsText names and numbers from the group and from their respective lists
     */
    public static void clear() {
        // Removes all text elements of names and numbers from screen
        numbersList.forEach(group::remove);
        nameList.forEach(group::remove);
        numbersList.clear();
        nameList.clear();
    }
}
