import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WordCountGUI {
    private JFrame frame;
    private JTextField textField;
    private JButton countButton;
    private JLabel wordCountLabel;

    public WordCountGUI() {
        frame = new JFrame("Word Count Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(20, 20, 300, 30);

        countButton = new JButton("Count Words");
        countButton.setBounds(20, 60, 120, 30);

        wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setBounds(150, 60, 150, 30);

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                WordCounter wordCounter = new WordCounter();
                int wordCount = wordCounter.countWords(inputText);
                wordCountLabel.setText("Word Count: " + wordCount);

                // Save inputText to a file
                JFileChooser fileChooser = new JFileChooser();
                int userChoice = fileChooser.showSaveDialog(null);
                if (userChoice == JFileChooser.APPROVE_OPTION) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                        writer.write(inputText);
                        JOptionPane.showMessageDialog(null, "Text saved to: " + fileChooser.getSelectedFile().getAbsolutePath());
                    } catch (IOException exception) {
                        JOptionPane.showMessageDialog(null, "Error occurred while saving the file.");
                    }
                }
            }
        });

        frame.add(textField);
        frame.add(countButton);
        frame.add(wordCountLabel);
        frame.setSize(350, 150);
        frame.setVisible(true);
    }
}
