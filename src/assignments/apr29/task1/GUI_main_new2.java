package assignments.apr29.task1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Diese Klasse darf nicht veraendert werden.
public class GUI_main_new2 {

    static class MyFrame extends JFrame {
        private static final int MAIN_FRAME_WIDTH = 630;
        private static final int MAIN_FRAME_HEIGHT = 650;
        private static final int SIEGEL_WIDTH = 150;
        private static final int SIEGEL_HEIGHT = 150;
        private static final String SIEGEL_FILE_NAME = "/src/assignments/apr29/task1/siegel.jpg";

        private static final String upButtonName = "oben";
        private static final String downButtonName = "unten";
        private static final String leftButtonName = "links";
        private static final String rightButtonName = "rechts";

        private static final int SIEGEL_SHIFT_IN_PIXEL = 50;
        private static final int SIEGEL_DISAPPEAR_TIME_IN_SECONDS = 3;

        public MyFrame() {
            super();
            setResizable(true);
        }

        public void addComponentsToPane(final Container pane) throws IOException {
            // using GridBagLayout manager to add left and right panel of non-equal width
            final JPanel mainPanel = new JPanel(new GridBagLayout());
            mainPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));

            // define upper left panel with Border layout manger to add left and right button
            JPanel upperLeftPanel = new JPanel(new BorderLayout());
            upperLeftPanel.setPreferredSize(new Dimension((MAIN_FRAME_WIDTH / 3) * 2, MAIN_FRAME_HEIGHT / 10));
            upperLeftPanel.setBackground(Color.RED);

            // get current directory to read image file
            String currDir = System.getProperty("user.dir");
            BufferedImage image = ImageIO.read(new File(currDir + SIEGEL_FILE_NAME));
            JLabel picLabel = new JLabel(new ImageIcon(image));

            // add mouse click listener on logo label
            picLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // set visible to false to make logo disappear
                    picLabel.setVisible(false);
                    // create an actionListner to display logo again
                    ActionListener taskPerformer = e1 -> picLabel.setVisible(true);
                    // creater timer of 3 seconds and attach action listener defined above
                    Timer timer = new Timer(SIEGEL_DISAPPEAR_TIME_IN_SECONDS * 1000, taskPerformer);
                    timer.setRepeats(false);
                    // start the timer, after timer is expired taskPerformer will execute
                    timer.start();
                }
            });

            // define left button with action listener
            JButton leftButton = new JButton(leftButtonName);
            leftButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x - SIEGEL_SHIFT_IN_PIXEL, y, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });

            // define right button with action listener
            JButton rightButton = new JButton(rightButtonName);
            rightButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x + SIEGEL_SHIFT_IN_PIXEL, y, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });

            // add left and right button to upper left panel
            upperLeftPanel.add(leftButton, BorderLayout.WEST);
            upperLeftPanel.add(rightButton, BorderLayout.EAST);

            // define left panel with Border layout manager
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBackground(Color.BLUE);
            leftPanel.setPreferredSize(new Dimension((MAIN_FRAME_WIDTH / 3) * 2, MAIN_FRAME_HEIGHT));

            // add upper left panel to the left panel
            leftPanel.add(upperLeftPanel, BorderLayout.NORTH);

            // add logo label in left panel in center of it
            leftPanel.add(picLabel, BorderLayout.CENTER);
            // paint to left panel with logo
            leftPanel.repaint();

            // define right panel with border layout
            JPanel rightPanel = new JPanel(new BorderLayout());

            // define up button with action listener
            JButton upButton = new JButton(upButtonName);
            upButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x, y - SIEGEL_SHIFT_IN_PIXEL, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });
            upButton.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, 30));

            // define down button with action listener
            JButton downButton = new JButton(downButtonName);
            downButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x, y + SIEGEL_SHIFT_IN_PIXEL, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });
            downButton.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, 30));

            // now add up and down button to right panel
            rightPanel.add(upButton, BorderLayout.NORTH);
            rightPanel.add(downButton, BorderLayout.SOUTH);
            rightPanel.setBackground(Color.GREEN);
            rightPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, MAIN_FRAME_HEIGHT));

            // add both left and right panel to main JFrame panel
            mainPanel.add(leftPanel);
            mainPanel.add(rightPanel);

            // add main panel to container pane to JFrame center
            pane.add(mainPanel, BorderLayout.NORTH);
            pane.add(new JSeparator(), BorderLayout.CENTER);
        }
    }

    private static void createAndShowGUI() throws IOException {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());

        frame.pack();
        // set location to middle of screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            // use system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            try {
                // invoke create and show GUI function
                GUI_main_new2.createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
