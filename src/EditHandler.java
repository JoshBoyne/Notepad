import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionEvent;

/*
    handles editing options: cut, copy, paste and select all
    uses built in methods of JTextComponent
 */
public class EditHandler {
    private JTextComponent textComponent;

    public EditHandler(JTextComponent textComponent) {
        this.textComponent = textComponent;
    }

    public Action createCutAction() {
        return new AbstractAction("Cut") {
            @Override
            public void actionPerformed(ActionEvent e) {
                textComponent.cut();
            }
        };
    }

    public Action createCopyAction() {
        return new AbstractAction("Copy") {
            @Override
            public void actionPerformed(ActionEvent e) {
                textComponent.copy();
            }
        };
    }

    public Action createPasteAction() {
        return new AbstractAction("Paste") {
            @Override
            public void actionPerformed(ActionEvent e) {
                textComponent.paste();
            }
        };
    }

    public Action createSelectAllAction() {
        return new AbstractAction("Select All") {
            @Override
            public void actionPerformed(ActionEvent e) {
                textComponent.selectAll();
            }
        };
    }
}
