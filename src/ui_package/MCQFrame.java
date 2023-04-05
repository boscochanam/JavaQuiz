package ui_package;

import javax.swing.*;
import java.awt.*;

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

    public MCQFrame(JPanel questionPanel) {
    }

    public String getQuestionText() {
        return questionLabel.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(String question, String optionA, String optionB, String optionC, String optionD) {
        questionNumber++;
        questionLabel.setText("Question " + questionNumber + ": " + question);
        optionAButton.setText(optionA);
        optionBButton.setText(optionB);
        optionCButton.setText(optionC);
        optionDButton.setText(optionD);
    }

    public String getUserAnswer() {
        return null; // This method should be overridden in a subclass that handles user input
    }

    public void clearAnswer() {
        // This method should be overridden in a subclass that handles user input
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

    public void setQuestionNumber(int i) {
        questionNumber = i;
    }
}
