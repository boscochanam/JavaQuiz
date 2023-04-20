package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import question_package.desc.DescQuestionManager;
import question_package.integer_type.IntQuestionManager;
import question_package.mcq.McqQuestionManager;
import question_package.mcq.McqType;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final McqQuestionManager mcqQuestionManager;
    public static int currentQuestionNumber = 0;
    private final Cards cards;
    static int score = 0;
    private JProgressBar progressBar1;
    boolean correctAnswer;

    public SubmitListener(DescQuestionManager descQuestionManager, McqQuestionManager mcqQuestionManager, Cards cards, int currentQuestionNumber, IntQuestionManager intQuestionManager) {
        this.descQuestionManager = descQuestionManager;
        this.mcqQuestionManager = mcqQuestionManager;
        this.cards = cards;
        SubmitListener.currentQuestionNumber = currentQuestionNumber;
        progressBar1 = (JProgressBar) cards.getProgressBar();
    }

    public SubmitListener() {
        this.descQuestionManager = null;
        this.mcqQuestionManager = null;
        this.cards = null;
        currentQuestionNumber = 0;
        progressBar1 = null;
    }

    // Action Listener for Submit Button
    @Override
    public void actionPerformed(ActionEvent e) {
        if (cards.isVisible()) {

            // Getting Descriptive Type From the Text Field
            String userAns = cards.getUserAnswer();

            // Initialising Answer as False
            correctAnswer = false;

            // Check if user answer matches the correct answer for descriptive question
            if (descQuestionManager.getQuestion(currentQuestionNumber).getAnswer().equalsIgnoreCase(userAns)) {
                JOptionPane.showMessageDialog(cards, "Correct Answer");
                correctAnswer = true;
            } else {
                JOptionPane.showMessageDialog(cards, "Incorrect Answer");
                correctAnswer = false;
            }

            progressBar1.setValue(currentQuestionNumber+2);

            // Incrementing Score if Correct Answer
            if (correctAnswer) {
                score++;
            }


            // Clearing the Text Field
            cards.clearAnswer();

            // Updating Score
            cards.updateScore(score);

            // Moving to Next Question
            currentQuestionNumber++;

            // Setting the next Question
            if (currentQuestionNumber < descQuestionManager.getNumQuestions()) {
                cards.setQuestion(descQuestionManager.getQuestion(currentQuestionNumber).getQuestion(), currentQuestionNumber);
            } else {
                cards.nextCard();
                currentQuestionNumber = 0;
                cards.mcqScore.setText("Score: " + score);
                McqQuestionManager mcq_questions = new McqQuestionManager();
                McqType currentQuestion = mcq_questions.getQuestion(currentQuestionNumber);
                cards.setQuestionMcq(mcq_questions.getQuestion(currentQuestionNumber).getQuestion(), currentQuestionNumber);
                cards.getAButton().setText(currentQuestion.getAnswerOptions()[0]);
                cards.getBButton().setText(currentQuestion.getAnswerOptions()[1]);
                cards.getCButton().setText(currentQuestion.getAnswerOptions()[2]);
                cards.getDButton().setText(currentQuestion.getAnswerOptions()[3]);
                cards.mcqProgress.setValue(1);
                System.out.println("Question Description: " + currentQuestion.getQuestion());
                System.out.println("Answer Options: " + currentQuestion.getAnswerOptions()[0] + ", " + currentQuestion.getAnswerOptions()[1] + ", " + currentQuestion.getAnswerOptions()[2] + ", " + currentQuestion.getAnswerOptions()[3]);
            }
        }

    }

    static int getScore(){
        return score;
    }

    static void setScore(int n) {
        score = n;
    }
    }




