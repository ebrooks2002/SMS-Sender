import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.TextAlignment;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;


public class RecipientsList extends GraphicsGroup {

    private static HashMap<String, String> nameNumberMap;
    private static GraphicsText nameHeader = new GraphicsText("Names");
    private static CanvasWindow canvas;
    private static GraphicsText numberHeader = new GraphicsText("Numbers");
    private static GraphicsText newNumber;
    private static double newNumSize = 580;
    private static GraphicsText newName;
    private static double newNameSize = 580;
    private static List<String> numbersList = new ArrayList<>();
    private static List<String> nameList = new ArrayList<>();
    private static Queue<GraphicsText> numbersQueue = new ArrayDeque<>();
    private static Queue<GraphicsText> nameQueue = new ArrayDeque<>();
    private static int counter = 0;

    private static Rectangle rect;

    public RecipientsList(CanvasWindow canvas, HashMap<String, String> nameNumberMap, double x, double y) {
        super();
        this.nameNumberMap = nameNumberMap;
        this.canvas = canvas;
        rect = new Rectangle(0, 0, 400, 280);
        rect.setStrokeColor(Color.BLACK);
        rect.setFillColor(Color.LIGHT_GRAY);
        add(rect);
        canvas.add(this, x, y);
        nameHeader.setFillColor(Color.BLUE);
        nameHeader.setFontSize(15);
        add(nameHeader);
        nameHeader.setCenter(35, 20);

        numberHeader.setFillColor(Color.BLUE);
        numberHeader.setFontSize(15);
        add(numberHeader);
        numberHeader.setCenter(rect.getWidth() - 40, 20);


    }

    public static void addNewTextField(String number, String name) {
        if (!numbersList.contains(number) && !nameList.contains(name) && !name.equals("") && !number.equals("")) {
            addNumber(number);
            addName(name);
            counter++;

        }
        if (name.equals("")) {
            addNumber(number);
            name = "NO NAME";
            addName(name);
            counter++;
        }
        if(counter>=12){
            canvas.remove(nameQueue.poll());
            canvas.remove(numbersQueue.poll());
        }

    }

    public static void addNumber(String number) {
        newNumber = new GraphicsText(number);
        newNumber.setCenter(35, 20);
        newNumber.setFillColor(Color.BLUE);
        newNumber.setFontSize(15);
        canvas.add(newNumber);
        newNumber.setCenter(rect.getWidth() - 65, newNumSize);
        newNumSize -= 20;
        numbersList.add(number);
        numbersQueue.add(newNumber);
    }

    public static void addName(String name) {
        newName = new GraphicsText(name);
        newName.setCenter(35, 20);
        newName.setFillColor(Color.BLUE);
        newName.setFontSize(15);
        canvas.add(newName);
        newName.setCenter(40, newNameSize);
        newNameSize -= 20;
        nameList.add(name);
        nameQueue.add(newName);
    }
}
