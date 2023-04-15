package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

import question_package.desc.DescQuestionManager;
import question_package.mcq.McqQuestionManager;
import question_package.mcq.McqType;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final McqQuestionManager mcqQuestionManager;
    public static int[] currentQuestionNumber = new int[0];
    private final Cards frame;
    private static int score = 0;
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

    public SubmitListener() {
        this.descQuestionManager = null;
        this.mcqQuestionManager = null;
        this.frame = null;
        this.currentQuestionNumber = null;
        progressBar1 = null;
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
                frame.mcqScore.setText("Score: " + score);
                McqQuestionManager mcq_questions = new McqQuestionManager();
                McqType currentQuestion = mcq_questions.getQuestion(currentQuestionNumber[0]);
                frame.setQuestionmcq(mcq_questions.getQuestion(currentQuestionNumber[0]).getQuestion());
                frame.getAButton().setText(currentQuestion.getAnswerOptions()[0]);
                frame.getBButton().setText(currentQuestion.getAnswerOptions()[1]);
                frame.getCButton().setText(currentQuestion.getAnswerOptions()[2]);
                frame.getDButton().setText(currentQuestion.getAnswerOptions()[3]);
                currentQuestionNumber[0]++;
            }
        }

    }
    static int getQno(){
        return currentQuestionNumber[0];
    }

    static int setQno(){
        return currentQuestionNumber[0];
    }

    static int getScore(){
        return score;
    }

    static void setScore(int n) {
        score = n;
    }
    }




