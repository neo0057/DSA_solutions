package assignments.apr18.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class GUI_main {

    static class LeftPanel extends JPanel {
        public LeftPanel() {
            super();
        }

        static class TriangleShape extends Path2D.Double {
            public TriangleShape(Point2D... points) {
                moveTo(points[0].getX(), points[0].getY());
                lineTo(points[1].getX(), points[1].getY());
                lineTo(points[2].getX(), points[2].getY());
                closePath();
            }
        }

        public void paintComponent(Graphics g) {
            TriangleShape triangleShape = new TriangleShape(new Point2D.Double(148, 2), new Point2D.Double(298, 298), new Point2D.Double(2, 298));
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.draw(triangleShape);
        }
    }

    static class RightPanel extends JPanel {
        public RightPanel() {
            super();
        }
    }

    static class MyFrame extends JFrame {
        // using Grid LayoutManager
        GridLayout experimentLayout = new GridLayout(0, 2);

        public MyFrame() {
            super();
            setResizable(false);
        }

        public void addComponentsToPane(final Container pane) {
            final JPanel compsToExperiment = new JPanel();
            compsToExperiment.setLayout(experimentLayout);
            JPanel controls = new JPanel();
            controls.setLayout(new GridLayout(1, 2));

            compsToExperiment.setPreferredSize(new Dimension(600, 600));
            compsToExperiment.add(new LeftPanel());

            RightPanel rightPanel = new RightPanel();
            rightPanel.setBackground(Color.GREEN);
            compsToExperiment.add(rightPanel);

            pane.add(compsToExperiment, BorderLayout.NORTH);
            pane.add(new JSeparator(), BorderLayout.CENTER);
            pane.add(controls, BorderLayout.SOUTH);
        }
    }

    private static void createAndShowGUI() {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            /* Using windows Look and Feel */
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        javax.swing.SwingUtilities.invokeLater(GUI_main::createAndShowGUI);
    }
}
