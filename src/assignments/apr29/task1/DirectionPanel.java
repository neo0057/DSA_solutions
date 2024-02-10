package assignments.apr29.task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DirectionPanel extends JPanel {
    private final int X = 200;
    private Point point = null;

    private final int WIDTH = 400, HEIGHT = 200;
    private final int JUMP = 10;  // increment for image movement

    private final int IMAGE_SIZE = 31;

    private ImageIcon up, down, right, left, currentImage;
    private int x, y;

    //-----------------------------------------------------------------
    //  Constructor: Sets up this panel and loads the images.
    //-----------------------------------------------------------------
    public DirectionPanel() {
        addKeyListener(new DirectionListener());

        x = WIDTH / 2;
        y = HEIGHT / 2;

        up = new ImageIcon("arrowUp.gif");
        down = new ImageIcon("arrowDown.gif");
        left = new ImageIcon("arrowLeft.gif");
        right = new ImageIcon("arrowRight.gif");

        currentImage = right;

        setBackground(Color.black);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
    }

    //-----------------------------------------------------------------
    //  Draws the image in the current location.
    //-----------------------------------------------------------------
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        currentImage.paintIcon(this, page, x, y);
    }

    //*****************************************************************
    //  Represents the listener for keyboard activity.
    //*****************************************************************
    private class DirectionListener implements KeyListener {
        //--------------------------------------------------------------
        //  Responds to the user pressing arrow keys by adjusting the
        //  image and image location accordingly.
        //--------------------------------------------------------------
        public void keyPressed(KeyEvent event) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    currentImage = up;
                    y -= JUMP;
                    break;
                case KeyEvent.VK_DOWN:
                    currentImage = down;
                    y += JUMP;
                    break;
                case KeyEvent.VK_LEFT:
                    currentImage = left;
                    x -= JUMP;
                    break;
                case KeyEvent.VK_RIGHT:
                    currentImage = right;
                    x += JUMP;
                    break;
            }

            point = new Point(x, y);

            if (point.x < 200 && point.y < 100) {
                setBackground(Color.red);
            } else if (point.x < 200 && point.y > 100) {
                setBackground(Color.green);
            } else if (point.y > 100 && point.x > 200) {
                setBackground(Color.cyan);
            } else if (point.y < 100 && point.x > 200) {
                setBackground(Color.yellow);
            }

            repaint();
        }

        //--------------------------------------------------------------
        //  Provide empty definitions for unused event methods.
        //--------------------------------------------------------------
        public void keyTyped(KeyEvent event) {
        }

        public void keyReleased(KeyEvent event) {
        }
    }
}
