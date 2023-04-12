package ui_package;

import javax.swing.*;
import java.awt.*;

public class NewUI extends JFrame {
    private JLabel question;
    private JButton submitButton;
    private JTextField answerField;
    private JProgressBar progressBar1;
    private JLabel scoreLabel;
    private JPanel panelName;

    private int questionNumber;
    private int score;

    public NewUI() {
        questionNumber = 1;
        add(panelName);
        progressBar1.setMinimum(0);
        progressBar1.setMaximum(5);
        progressBar1.setValue(0);
    }

    public String getQuestionText() {
        return question.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(String questionText) {
        question.setText("Question " + questionNumber  + ": " + questionText);
        scoreLabel.setText("Score: " + score);
        questionNumber++;
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
        score = points;
        scoreLabel.setText("Score: " + score);
    }


    public static void main(String[] args) {



        };

    public Object getProgressBar() {
        return progressBar1;
    }

}