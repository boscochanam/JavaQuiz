import javax.swing.*;
import java.awt.*;

public class IntFrame extends JFrame {
    private TestUI ui;

    public IntFrame(TestUI ui) {
        super("Java Quiz");

        this.ui = ui;

        // Set up the question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        questionPanel.setLayout(new BorderLayout());

        // Set up the question label
        JLabel questionLabel = new JLabel("What is 10 + 5?");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Set up the answer text field
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BorderLayout());
        JTextField answerTextField = new JTextField();
        answerPanel.add(answerTextField, BorderLayout.CENTER);
        questionPanel.add(answerPanel, BorderLayout.CENTER);

        // Set up the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String userAnsStr = answerTextField.getText();

            try {
                int userAns = Integer.parseInt(userAnsStr);
                // Check if the correct answer is entered
                if (userAns == 15) {
                    JOptionPane.showMessageDialog(this, "Correct!");
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter an integer value!");
                return;
            }

            // Close the current frame and open the next one
            ui.showNextFrame();
            dispose();
        });
        questionPanel.add(submitButton, BorderLayout.SOUTH);

        // Add the question panel to the frame
        add(questionPanel);

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new IntFrame(new TestUI());
    }
}
