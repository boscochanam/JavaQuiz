package ui_package;

import javax.swing.*;

public class NewUITemp extends JFrame {
    private JLabel question;
    private JButton submitButton;
    private JTextField answerField;
    private JProgressBar progressBar1;
    private JLabel scoreLabel;

    private int questionNumber;

    public NewUITemp() {
        questionNumber = 0;
    }

    public String getQuestionText() {
        return question.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }
    public void setQuestion(String questionText) {
        questionNumber++;
        question.setText("Question " + questionNumber + ": " + questionText);
        scoreLabel.setText("Score: " + scoreLabel);
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

    public JLabel getScore() {
        return scoreLabel;
    }

    public void updateScore(int points) {
        scoreLabel.setText("Score: " + points);
    }
}
