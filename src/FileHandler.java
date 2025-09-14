import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

/*
    handles file operations like opening and saving
    uses JFileChooser to let the user pick files
 */
public class FileHandler {
    private JFrame frame;//reference to main window
    private JTextArea textArea;//text area to r/w from

    public FileHandler(JFrame frame, JTextArea textArea) {
        this.frame = frame;
        this.textArea = textArea;
    }

    //allows the user to open a file and load it onto the TA
    public Action createOpenAction() {
        return new AbstractAction("Open...") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                        textArea.read(reader, null);
                        frame.setTitle("Notepad - " + chooser.getSelectedFile().getName());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
    }

    //allows user to save file
    public Action createSaveAction() {
        return new AbstractAction("Save...") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(chooser.getSelectedFile()))) {
                        textArea.write(writer);
                        frame.setTitle("Notepad - " + chooser.getSelectedFile().getName());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Could not save file", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
    }
}
