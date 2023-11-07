import javax.swing.SwingUtilities;

public class WordCountController {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountGUI();
            }
        });
    }
}
