package ui_package;

import javax.swing.*;
import java.awt.*;

public class QuestionFrame extends JFrame {

    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private int questionNumber;

    public QuestionFrame() {
        super("Quiz");

        questionNumber = 0;

        // Initialize GUI components
        questionLabel = new JLabel();
        answerField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Layout components
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(questionLabel);
        content.add(answerField);
        content.add(submitButton);

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

    public QuestionFrame(JPanel questionPanel) {
    }

    public String getQuestionText() {
        return questionLabel.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(String question) {
        System.out.println(questionLabel + " old ");
        questionNumber++;
        questionLabel.setText("Question " + questionNumber + ": " + question);
        System.out.println(questionLabel + " new ");
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

    public static void main(String[] args) {
        //QuestionFrame q1 = new QuestionFrame();
        //q1.setQuestion("Hello");
        //q1.setVisible(true);
    }
}
