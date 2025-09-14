
import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
public class NotepadFrame extends JFrame{
    private JTextArea textArea;
    private StatusBar statusBar;
    private UndoManager undoManager;
    private FileHandler fileHandler;
    private EditHandler editHandler;


    //constructor - sets up the window
    public NotepadFrame() {
        //setting up the window
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //components
        textArea = new JTextArea();
        statusBar = new StatusBar(textArea);
        fileHandler = new FileHandler(this, textArea);
        editHandler = new EditHandler(textArea);

        /*
        Layout of the notepad
        - center if the text editor
        - south is the status bar (what line/column you're on)
         */
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setJMenuBar(createMenuBar());

    }
    //creates and returns the menu bar with the "file" and "edit" menus
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        //file menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(fileHandler.createOpenAction());//open file
        fileMenu.add(fileHandler.createSaveAction());//save file
        fileMenu.addSeparator();
        fileMenu.add(new AbstractAction("Exit") {//exit
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                System.exit(0);
            }
        });

        //edit menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(editHandler.createCutAction());//cut text
        editMenu.add(editHandler.createCopyAction());//copy text
        editMenu.add(editHandler.createPasteAction());//paste text
        editMenu.add(editHandler.createSelectAllAction());//select all

        //adds the menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        return menuBar;
    }
}