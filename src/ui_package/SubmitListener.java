package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

import question_package.desc.DescQuestionManager;
import question_package.mcq.McqQuestionManager;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final McqQuestionManager mcqQuestionManager;
    public static int[] currentQuestionNumber = new int[0];
    private final Cards frame;
    private int score = 0;
    private String current = "card1";
    private JProgressBar progressBar1;
    boolean correctAnswer;

    public SubmitListener(DescQuestionManager descQuestionManager, McqQuestionManager mcqQuestionManager, Cards frame, int[] currentQuestionNumber) {
        this.descQuestionManager = descQuestionManager;
        this.mcqQuestionManager = mcqQuestionManager;
        this.frame = frame;
        this.currentQuestionNumber = currentQuestionNumber;
        progressBar1 = (JProgressBar) frame.getProgressBar();
    }

    // Action Listener for Submit Button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.isVisible()) {

            // Getting Descriptive Type From the Text Field
            String userAns = frame.getUserAnswer();

            // Initialising Answer as False
            correctAnswer = false;

            // Check if user answer matches the correct answer for descriptive question
            if (descQuestionManager.getQuestion(currentQuestionNumber[0]).getAnswer().equalsIgnoreCase(userAns)) {
                JOptionPane.showMessageDialog(frame, "Correct Answer");
                correctAnswer = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect Answer");
                correctAnswer = false;
            }

            // Incrementing Score if Correct Answer
            if (correctAnswer) {
                score++;
                progressBar1.setValue(currentQuestionNumber[0]);
            }

            // Clearing the Text Field
            frame.clearAnswer();

            // Updating Score
            frame.updateScore(score);

            // Moving to Next Question
            currentQuestionNumber[0]++;

            // Setting the next Question
            if (currentQuestionNumber[0] < descQuestionManager.getNumQuestions()) {
                frame.setQuestion(descQuestionManager.getQuestion(currentQuestionNumber[0]).getQuestion());
            } else {
                frame.nextCard();
                currentQuestionNumber[0] = 0;
            }
        }

    }
    static int getQno(){
        return currentQuestionNumber[0];
    }

    static int setQno(){
        return currentQuestionNumber[0];
    }

}


