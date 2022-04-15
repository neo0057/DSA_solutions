package assignments.task1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class Gui1Tester {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui1Tester window = new Gui1Tester();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Gui1Tester() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel upPanel = new JPanel();
        upPanel.setLayout(new GridLayout(2, 3));

        JLabel data = new JLabel("Data Source Name:");
        upPanel.add(data);
        JTextField dataText = new JTextField();
        upPanel.add(dataText);
        JLabel desc = new JLabel("Description:");
        upPanel.add(desc);
        JTextField descText = new JTextField();
        upPanel.add(descText);

        JPanel midPanel = new JPanel();
        midPanel.setBorder(new TitledBorder(null, "Database", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        JLabel dbTitle = new JLabel("Database");
        JButton select = new JButton("Select...");
        JButton create = new JButton("Create...");
        JButton repair = new JButton("Repair...");
        JButton compact = new JButton("Compact...");

        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1));

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");
        JButton help = new JButton("Help");
        JButton advanced = new JButton("Advanced...");
        eastPanel.add(ok);
        eastPanel.add(cancel);
        eastPanel.add(help);
        eastPanel.add(advanced);

        frame.getContentPane().add(upPanel, BorderLayout.NORTH);
        frame.getContentPane().add(midPanel, BorderLayout.WEST);
        midPanel.setLayout(new BorderLayout(0, 0));
        midPanel.add(dbTitle);
        midPanel.add(select);
        midPanel.add(create);
        midPanel.add(repair);
        midPanel.add(compact);
        frame.getContentPane().add(eastPanel, BorderLayout.EAST);

    }

}
