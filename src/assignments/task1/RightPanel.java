package assignments.task1;

import javax.swing.*;
import java.awt.*;

public class RightPanel extends JPanel {
    public RightPanel(int width, int height) {
//        JFrame f = new JFrame("Right Panel");
        JPanel panel = new JPanel();
        panel.setBounds(100, 100, width, height);
        panel.setBackground(Color.GREEN);
//        return panel;
    }
}
