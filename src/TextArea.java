import java.awt.Color;
import java.awt.Dimension;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextArea extends EmbeddedSwingComponent {
    private final JTextArea field;

    public TextArea(int width, int height) {
        super(new JTextArea());
        this.field = (JTextArea) getEmbeddedComponent();
        field.setMinimumSize(new Dimension(width, height));
        field.setLineWrap(true);
        field.setWrapStyleWord(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        field.setBorder(BorderFactory.createCompoundBorder(border, 
        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        field.setText("Input Message Here: ");

        changed();
    }

    public String getText() {
        return field.getText();
    }

    public void setText(String text) {
        if (!getText().equals(text)) {
            field.setText(text);
        }
    }

    public void onChange(Consumer<String> callback) {
        field.getDocument().addDocumentListener(
            new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    triggerCallback();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    triggerCallback();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    triggerCallback();
                }

                private void triggerCallback() {
                    if (getCanvas() == null) {
                        return;
                    }

                    getCanvas().performEventAction(() ->
                        callback.accept(field.getText()));
                }
            }
        );
    }

    @Override
    public String toString() {
        return "Text area at " + getPosition() + " with text " + getText();
    }

    public void setBackground(Color color) {
        field.setBackground(color);
    }
}
