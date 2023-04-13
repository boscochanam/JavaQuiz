package ui_package;

import javax.swing.*;
import java.awt.*;

public class DescFrame extends QuestionFrame {

    private JLabel questionLabel;
    private int score = 0;
    private JTextField answerField;
    private JLabel scoreLabel;

    private JButton submitButton;

    private int questionNumber;

    public DescFrame() {
        super();

        questionNumber = 0;

        // Initialize GUI components
        questionLabel = new JLabel("Question/n" + questionNumber + ": ");
        answerField = new JTextField(20);
        submitButton = new JButton("Submit");
        scoreLabel = new JLabel("Score: " + score);

        // Layout components
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(questionLabel);
        content.add(answerField);
        content.add(submitButton);
        content.add(scoreLabel);

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

    public DescFrame(JPanel questionPanel) {
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
