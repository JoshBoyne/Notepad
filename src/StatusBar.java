
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.JTextComponent;
import java.awt.*;

//basic status bar that displays the current line/column at the bottom of the notepad
public class StatusBar extends JPanel {
    private JLabel positionLabel;//display line/column text

    public StatusBar(JTextComponent textComponent) {
        setLayout(new BorderLayout());
        positionLabel = new JLabel("Line: 1, Col: 1");
        add(positionLabel, BorderLayout.WEST);

        //listens for movement then updates accordingly
        textComponent.addCaretListener(e -> {
            try {
                int caretPos = e.getDot();
                int line = textComponent.getDocument().getDefaultRootElement().getElementIndex(caretPos) + 1;
                int col = caretPos - textComponent.getDocument()
                        .getDefaultRootElement()
                        .getElement(line - 1)
                        .getStartOffset() + 1;
                positionLabel.setText("Line: " + line + ", Col: " + col);
            } catch (Exception ex) {
                positionLabel.setText("Line: -, Col: -");
            }
        });
    }
}
