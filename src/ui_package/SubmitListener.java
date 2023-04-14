package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import question_package.desc.DescQuestionManager;
import question_package.mcq.McqQuestionManager;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final McqQuestionManager mcqQuestionManager;
    private final int[] currentQuestionNumber;
    private final Cards frame;
    private int score = 0;
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
            if(currentQuestionNumber[0] < descQuestionManager.getNumQuestions())
            {
                frame.setQuestion(descQuestionManager.getQuestion(currentQuestionNumber[0]).getQuestion());
            }
            else{
                    frame.nextCard();
            }



        }

//            } else {
//                // Check if user answer matches the correct answer for MCQ question
//                frame.setQuestion(descQuestionManager.getQuestion(currentQuestionNumber[0]).getQuestion());
//                int choice = frame.getChoice();
//                if (mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getCorrectChoice() == choice) {
//                    JOptionPane.showMessageDialog(frame, "Correct Answer");
//                    correctAnswer = true;
//                } else {
//                    JOptionPane.showMessageDialog(frame, "Incorrect Answer");
//                    correctAnswer = false;
//                }
//
//                // Update score and progress bar based on user's answer
//                if (correctAnswer) {
//                    score++;
//                    progressBar1.setValue(currentQuestionNumber[0]);
//                }
//                currentQuestionNumber[0]++;
//                frame.clearAnswer();
//                frame.updateScore(score);
//
//                // Move to next question or end the game
//                if (currentQuestionNumber[0] <= 9) {
//                    frame.setQuestion(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getQuestion());
//                    frame.getAButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceA());
//                    frame.getBButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceB());
//                    frame.getCButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceC());
//                    frame.getDButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceD());
//                } else {
//                    JOptionPane.showMessageDialog(frame, "Game Over! Your final score is: " + score);
//                }
//                // Check if user answer matches the correct answer for MCQ question
//                // Move to next question or end the game
//                if (currentQuestionNumber[0] <= 9) {
//                    frame.setQuestionmcq(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getQuestion());
//                    frame.getAButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceA());
//                    frame.getBButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceB());
//                    frame.getCButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceC());
//                    frame.getDButton().setText(mcqQuestionManager.getQuestion(currentQuestionNumber[0] - 6).getChoiceD());
//                } else {
//                    JOptionPane.showMessageDialog(frame, "Game Over! Your final score is: " + score);
//                }
//            }
            // Update score and progress bar based on user's answer

        }
    }


