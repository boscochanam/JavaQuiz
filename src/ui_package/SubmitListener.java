package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import question_package.desc.DescQuestionManager;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final int[] currentQuestionNumber;
    private final NewUI frame;
    private int score = 0;
    private JProgressBar progressBar1;


    public SubmitListener(DescQuestionManager descQuestionManager, NewUI frame, int[] currentQuestionNumber) {
        this.descQuestionManager = descQuestionManager;
        this.frame = frame;
        this.currentQuestionNumber = currentQuestionNumber;
        progressBar1 = (JProgressBar) frame.getProgressBar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (frame.isVisible()) {
            String userAns = frame.getUserAnswer();
            boolean correctAnswer = false;

            // Check if user answer matches the correct answer
            if (descQuestionManager.getQuestion(currentQuestionNumber[0]).getAnswer().equalsIgnoreCase(userAns)) {
                JOptionPane.showMessageDialog(frame, "Correct Answer");
                correctAnswer = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Incorrect Answer");
                correctAnswer = false;
            }
                // Update the score and show the next question or end the quiz
                if(correctAnswer) {
                    score++;
                    progressBar1.setValue(score);
                }
                frame.updateScore(score); // Call a method to update the score display in the frame
                currentQuestionNumber[0]++;
                if (currentQuestionNumber[0] < descQuestionManager.getNumQuestions()) {
                    frame.setQuestion(descQuestionManager.getQuestion(currentQuestionNumber[0]).getQuestion());
                    frame.clearAnswer();
                } else {
                    frame.setVisible(false);
                }

        }
    }


}
