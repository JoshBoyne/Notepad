
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new NotepadFrame().setVisible(true);//shows the main window
        });
    }
}