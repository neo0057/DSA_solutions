package assignments.task1;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    LeftPanel leftPanel;
    RightPanel rightPanel;

    public MyFrame(LeftPanel leftPanel, RightPanel rightPanel) {
        this.leftPanel = leftPanel;
        this.rightPanel = rightPanel;
    }

    //    LayoutManager layoutManager = new
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LeftPanel leftPanel = new LeftPanel();
                    RightPanel rightPanel = new RightPanel(600, 600);

                    MyFrame myFrame = new MyFrame(leftPanel, rightPanel);
                    myFrame.add(leftPanel, BorderLayout.WEST);
                    myFrame.add(rightPanel, BorderLayout.EAST);

                    myFrame.setBounds(50, 100, 600, 600);
                    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    myFrame.setVisible(true);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
            }
        });
    }
}
