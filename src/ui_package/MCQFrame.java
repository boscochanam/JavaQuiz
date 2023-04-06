package ui_package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCQFrame extends QuestionFrame {

    private JLabel questionLabel;
    private JButton optionAButton;
    private JButton optionBButton;
    private JButton optionCButton;
    private JButton optionDButton;

    private int questionNumber;

    public MCQFrame() {
        super();

        questionNumber = 0;

        // Initialize GUI components
        questionLabel = new JLabel();
        optionAButton = new JButton();
        optionBButton = new JButton();
        optionCButton = new JButton();
        optionDButton = new JButton();

        // Set action listeners for buttons
        optionAButton.addActionListener(new OptionButtonListener());
        optionBButton.addActionListener(new OptionButtonListener());
        optionCButton.addActionListener(new OptionButtonListener());
        optionDButton.addActionListener(new OptionButtonListener());

        // Layout components
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(5, 1, 10, 10)); // 5 rows, 1 column
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(questionLabel);
        content.add(optionAButton);
        content.add(optionBButton);
        content.add(optionCButton);
        content.add(optionDButton);

        // Add content to frame
        getContentPane().add(content);

        // Set behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        // Set preferred size
        Dimension preferredSize = new Dimension(500, 300);
        content.setPreferredSize(preferredSize);
        setPreferredSize(preferredSize);
        pack();
    }

    public JButton getOptionAButton() {
        return optionAButton;
    }

    public JButton getOptionBButton() {
        return optionBButton;
    }

    public JButton getOptionCButton() {
        return optionCButton;
    }

    public JButton getOptionDButton() {
        return optionDButton;
    }

    // ActionListener for option buttons
    private class OptionButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource(); // Get the source button

            // Check which button is pressed
            if (source == optionAButton) {
                // Handle option A button pressed
                String selectedOption = "A";
                checkAnswer(selectedOption);
            } else if (source == optionBButton) {
                // Handle option B button pressed
                String selectedOption = "B";
                checkAnswer(selectedOption);
            } else if (source == optionCButton) {
                // Handle option C button pressed
                String selectedOption = "C";
                checkAnswer(selectedOption);
            } else if (source == optionDButton) {
                // Handle option D button pressed
                String selectedOption = "D";
                checkAnswer(selectedOption);
            }
        }
    }

    // Method to check if the selected answer is correct
    private void checkAnswer(String selectedOption) {
        // Get the correct answer for the current question
        // You can implement this logic based on your requirements
        String correctAnswer = ""; // Replace this with the correct answer for the current question

        // Compare the selected option with the correct answer
        if (selectedOption.equals(correctAnswer)) {
            // Handle correct answer
            System.out.println("Correct answer!");
        } else {
            // Handle incorrect answer
            System.out.println("Incorrect answer.");
        }
    }
}
