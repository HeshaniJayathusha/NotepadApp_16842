import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleNotepad16842 extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JFileChooser fileChooser;

    public SimpleNotepad16842() {
        // 1. Set up the main window (JFrame)
        setTitle("Simple Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2. Create the text editing area (JTextArea) and add scroll support
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // 3. Create the menu bar, menus, and menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // 4. Add action listeners to menu items to handle user clicks
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        // 5. Build the menu hierarchy
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        // 6. Set up the file chooser for opening and saving files
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        // 7. Make the window visible
        setVisible(true);
    }

    // 8. Implement the ActionListener to handle events
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("Open".equals(command)) {
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if ("Save".equals(command)) {
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".txt")) {
                    file = new File(file.getAbsolutePath() + ".txt");
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(writer);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if ("Exit".equals(command)) {
            System.exit(0);
        }
    }

    // 9. Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleNotepad16842::new);
    }
}
