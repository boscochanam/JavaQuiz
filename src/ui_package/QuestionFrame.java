package ui_package;

import javax.swing.*;
import java.awt.*;

public class QuestionFrame extends JFrame {

    private JLabel questionLabel;
    private int score = 0;
    private JTextField answerField;
    private JLabel scoreLabel;
    private JButton submitButton;
    private int questionNumber;

    public QuestionFrame() {
        super();
        questionNumber = 0;

        // Initialize GUI components
        questionLabel = new JLabel("Question " + questionNumber + ": ");
        answerField = new JTextField(10); // Set text box size to 10 columns
        submitButton = new JButton("Submit");
        scoreLabel = new JLabel("Score: " + score);

        // Layout components
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(10, 10)); // Use BorderLayout with 10px horizontal and vertical gaps
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Create panel for question label and score label
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(questionLabel, BorderLayout.NORTH);
        topPanel.add(scoreLabel, BorderLayout.SOUTH);
        content.add(topPanel, BorderLayout.NORTH);

        content.add(answerField, BorderLayout.CENTER); // Add answer field to center
        content.add(submitButton, BorderLayout.SOUTH); // Add submit button to bottom

        // Add content to frame
        getContentPane().add(content);

        // Set behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set preferred size
        Dimension preferredSize = new Dimension(500, 300);
        content.setPreferredSize(preferredSize);
        setPreferredSize(preferredSize);

        // Add ActionListener to submit button
        submitButton.addActionListener(e -> {
            // Handle submit button click here
        });

        pack();
    }

    public QuestionFrame(JPanel questionPanel) {
    }

    public String getQuestionText() {
        return questionLabel.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(String question) {
        questionNumber++;
        questionLabel.setText("Question " + questionNumber + ": " + question);
        scoreLabel.setText("Score: " + score);
    }

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public JButton getSubmit() {
        return submitButton;
    }

    public void setQuestionNumber(int i) {
        questionNumber = i;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int points) {
        score += points;
        scoreLabel.setText("Score: " + score);
    }


}
