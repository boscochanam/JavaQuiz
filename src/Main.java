import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import question_package.*;
import ui_package.*;

public class Main {
    public static void main(String[] args) {

        QuestionFrame desc_frame = new QuestionFrame();
        MCQFrame mcq_frame = new MCQFrame();

        QuestionManager question_manager = new QuestionManager();

        final int[] currentQuestionNumber = {0};

        // Set the first question
        desc_frame.setQuestion(question_manager.getQuestion(currentQuestionNumber[0]).getQuestion());
        //frame.setQuestion("Hello");
        JButton submit = desc_frame.getSubmit();

        ArrayList<QuestionFrame> frames = new ArrayList<>();
        frames.add(desc_frame);
        frames.add(mcq_frame);

        System.out.println(question_manager.getQuestion(currentQuestionNumber[0]).getQuestion());
        System.out.println(question_manager.getQuestion(currentQuestionNumber[0]).getAnswer());

        for(QuestionFrame frame : frames)
        {
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (frame.isVisible()) {
                        String userAns = frame.getUserAnswer();
                        boolean correctAnswer = false;

                        // Check if user answer matches the correct answer
                        if (question_manager.getQuestion(currentQuestionNumber[0]).getAnswer().equalsIgnoreCase(userAns)) {
                            System.out.println(question_manager.getQuestion(currentQuestionNumber[0]).getAnswer());
                            JOptionPane.showMessageDialog(frame, "Correct Answer");
                            correctAnswer = true;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Answer");
                        }

                        if (correctAnswer) {
                            // Show the next question or end the quiz
                            currentQuestionNumber[0]++;
                            if (currentQuestionNumber[0] < question_manager.getNumQuestions()) {
                                frame.setQuestion(question_manager.getQuestion(currentQuestionNumber[0]).getQuestion());
                                frame.clearAnswer();
                            } else {
                                frame.setVisible(false);
                            }
                        }
                    }
                }
            });


            frame.setVisible(true);
        }
        }
    }
