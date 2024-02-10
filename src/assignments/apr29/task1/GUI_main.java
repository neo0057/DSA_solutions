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

public class GUI_main {

    static class MyFrame extends JFrame {
        private static final int MAIN_FRAME_WIDTH = 630;
        private static final int MAIN_FRAME_HEIGHT = 650;
        private static final int SIEGEL_WIDTH = 150;
        private static final int SIEGEL_HEIGHT = 150;
        private static final String SIEGEL_FILE_NAME = "siegel.jpg";

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
            final JPanel mainPanel = new JPanel(new GridBagLayout());
            mainPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH, MAIN_FRAME_HEIGHT));

            JPanel upperLeftPanel = new JPanel(new BorderLayout());
            upperLeftPanel.setPreferredSize(new Dimension((MAIN_FRAME_WIDTH / 3) * 2, MAIN_FRAME_HEIGHT / 10));
            upperLeftPanel.setBackground(Color.RED);

            String currDir = System.getProperty("user.dir");
            BufferedImage image = ImageIO.read(new File(currDir + "/src/assignments/apr29/task1" + "/" + SIEGEL_FILE_NAME));
            JLabel picLabel = new JLabel(new ImageIcon(image));

            picLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    picLabel.setVisible(false);
                    ActionListener taskPerformer = (e1) -> {
                        int x = picLabel.getX();
                        int y = picLabel.getY();
                        picLabel.setVisible(true);
                        picLabel.setBounds(x, y, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                        picLabel.repaint();
                    };
                    Timer timer = new Timer(SIEGEL_DISAPPEAR_TIME_IN_SECONDS * 1000, taskPerformer);
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            JButton leftButton = new JButton(leftButtonName);
            leftButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x - SIEGEL_SHIFT_IN_PIXEL, y, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });

            JButton rightButton = new JButton(rightButtonName);
            rightButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x + SIEGEL_SHIFT_IN_PIXEL, y, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });

            upperLeftPanel.add(leftButton, BorderLayout.WEST);
            upperLeftPanel.add(rightButton, BorderLayout.EAST);

            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBackground(Color.BLUE);
            leftPanel.setPreferredSize(new Dimension((MAIN_FRAME_WIDTH / 3) * 2, MAIN_FRAME_HEIGHT));
            leftPanel.add(upperLeftPanel, BorderLayout.NORTH);


            leftPanel.add(picLabel, BorderLayout.CENTER);
            leftPanel.repaint();

            JPanel rightPanel = new JPanel(new BorderLayout());

            JButton upButton = new JButton(upButtonName);
            upButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x, y - SIEGEL_SHIFT_IN_PIXEL, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });
            upButton.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, 30));

            JButton downButton = new JButton(downButtonName);
            downButton.addActionListener((e) -> {
                int x = picLabel.getX();
                int y = picLabel.getY();
                picLabel.setBounds(x, y + SIEGEL_SHIFT_IN_PIXEL, SIEGEL_WIDTH, SIEGEL_HEIGHT);
                picLabel.repaint();
            });
            downButton.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, 30));

            rightPanel.add(upButton, BorderLayout.NORTH);
            rightPanel.add(downButton, BorderLayout.SOUTH);
            rightPanel.setBackground(Color.GREEN);
            rightPanel.setPreferredSize(new Dimension(MAIN_FRAME_WIDTH / 3, MAIN_FRAME_HEIGHT));

            mainPanel.add(leftPanel);
            mainPanel.add(rightPanel);

            pane.add(mainPanel, BorderLayout.NORTH);
            pane.add(new JSeparator(), BorderLayout.CENTER);
        }
    }

    private static void createAndShowGUI() throws IOException {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            try {
                GUI_main.createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
