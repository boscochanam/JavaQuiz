package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import question_package.DescQuestionManager;

public class SubmitListener implements ActionListener {
    private final DescQuestionManager descQuestionManager;
    private final int[] currentQuestionNumber;
    private final QuestionFrame frame;

    public SubmitListener(DescQuestionManager descQuestionManager, QuestionFrame frame, int[] currentQuestionNumber) {
        this.descQuestionManager = descQuestionManager;
        this.frame = frame;
        this.currentQuestionNumber = currentQuestionNumber;
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
                }

                if (correctAnswer) {
                    // Show the next question or end the quiz
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

    }
