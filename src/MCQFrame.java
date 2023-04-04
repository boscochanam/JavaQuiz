import javax.swing.*;
import java.awt.*;

public class MCQFrame extends JFrame {

    public MCQFrame() {
        super("Java Quiz");

        // Set up the question panel
        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        questionPanel.setLayout(new BorderLayout());

        // Set up the question label
        JLabel questionLabel = new JLabel("What is the capital of France?");
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        // Set up the answer choices
        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(4, 1));
        JRadioButton choice1 = new JRadioButton("New York");
        JRadioButton choice2 = new JRadioButton("London");
        JRadioButton choice3 = new JRadioButton("Paris");
        JRadioButton choice4 = new JRadioButton("Tokyo");
        ButtonGroup choicesGroup = new ButtonGroup();
        choicesGroup.add(choice1);
        choicesGroup.add(choice2);
        choicesGroup.add(choice3);
        choicesGroup.add(choice4);
        choicesPanel.add(choice1);
        choicesPanel.add(choice2);
        choicesPanel.add(choice3);
        choicesPanel.add(choice4);
        questionPanel.add(choicesPanel, BorderLayout.CENTER);

        // Set up the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            // Check if the correct answer is selected
            if (choice3.isSelected()) {
                JOptionPane.showMessageDialog(this, "Correct!");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect!");
            }
        });
        questionPanel.add(submitButton, BorderLayout.SOUTH);

        // Add the question panel to the frame
        add(questionPanel);

        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        MCQFrame frame = new MCQFrame();
    }
}
