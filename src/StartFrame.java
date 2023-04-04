import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartFrame extends JFrame {

    public StartFrame() {
        // Set the title and size of the JFrame
        setTitle("Java Quiz Start Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the JPanel to hold the logo, buttons, and label
        JPanel panel = new JPanel(new BorderLayout());

        // Load the Java logo image
        ImageIcon icon = new ImageIcon("F:\\JavaQuiz\\JavaQuiz\\src\\java_logo.png");
        // Add the Java logo to the center of the JPanel
        JLabel logoLabel = new JLabel(icon);
        panel.add(logoLabel, BorderLayout.CENTER);

        // Create the Start and LeaderBoard buttons and add them to the bottom of the JPanel
        JButton startButton = new JButton("Start");
        JButton leaderBoardButton = new JButton("LeaderBoard");
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(leaderBoardButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the JPanel to the JFrame
        getContentPane().add(panel);

        // Set the JFrame to be visible
        setVisible(true);

        // Add an action listener to the Start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the StartFrame and show the next frame
                dispose();
                new TestUI();
            }
        });

        // Add an action listener to the LeaderBoard button
        leaderBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message dialog with the LeaderBoard information
                JOptionPane.showMessageDialog(null, "LeaderBoard is coming soon!", "LeaderBoard", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add a component listener to the panel to listen for size changes
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Scale the image to fit within the bounds of the JPanel
                int panelWidth = panel.getWidth();
                int panelHeight = panel.getHeight();
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(panelWidth/2, panelHeight/2, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                logoLabel.setIcon(scaledIcon);
            }
        });
    }

    public StartFrame(TestUI testUI) {
    }

    public static void main(String[] args) {
        StartFrame startFrame = new StartFrame();
    }
}
