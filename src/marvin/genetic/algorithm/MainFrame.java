package marvin.genetic.algorithm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
    
    
    
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        
        SwingUtilities.invokeLater(() -> {
            frame.pack();
            frame.setVisible(true);
        });
    }
}
