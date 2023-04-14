
// NOT IN USE RIGHT NOW
// NOT IN USE RIGHT NOW
// NOT IN USE RIGHT NOW
// NOT IN USE RIGHT NOW
// NOT IN USE RIGHT NOW
// NOT IN USE RIGHT NOW













//package ui_package;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.*;
//
//import question_package.desc.DescQuestionManager;
//import question_package.mcq.McqQuestionManager;
//
//public class MCQListener implements ActionListener {
//    private final McqQuestionManager mcqQuestionManager;
//    private final int[] currentQuestionNumber;
//    private final Cards frame;
//    private int score = 0;
//    private JProgressBar progressBar1;
//
//
//    public MCQListener(McqQuestionManager mcqQuestionManager, Cards frame, int[] currentQuestionNumber) {
//        this.mcqQuestionManager = mcqQuestionManager;
//        this.frame = frame;
//        this.currentQuestionNumber = currentQuestionNumber;
//        progressBar1 = (JProgressBar) frame.getProgressBar();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        JButton buttonPressed = (JButton) e.getSource();
//        int button_pressed = -1;
//
//        if (buttonPressed == frame.getAButton()) {
//            button_pressed = 0;
//        } else if (buttonPressed == frame.getBButton()) {
//            button_pressed = 1;
//        } else if (buttonPressed == frame.getCButton()) {
//            button_pressed = 2;
//        } else if (buttonPressed == frame.getDButton()) {
//            button_pressed = 3;
//        }
//
//            // String userAns = frame.getUserAnswer();
//            boolean correctAnswer = false;
//
//            // Check if user answer matches the correct answer
//            if (mcqQuestionManager.getQuestion(currentQuestionNumber[0]).getCorrectIndex() == button_pressed) {
//                JOptionPane.showMessageDialog(frame, "Correct Answer");
//                correctAnswer = true;
//            } else {
//                JOptionPane.showMessageDialog(frame, "Incorrect Answer");
//                correctAnswer = false;
//            }
//            // Update the score and show the next question or end the quiz
//            if(correctAnswer) {
//                score++;
//                progressBar1.setValue(score);
//            }
//            frame.updateScore(score); // Call a method to update the score display in the frame
//            currentQuestionNumber[0]++;
//            if (currentQuestionNumber[0] < mcqQuestionManager.getNumQuestions() + 10) {
//                frame.setQuestion(mcqQuestionManager.getQuestion(currentQuestionNumber[0]).getQuestion());
//            } else {
//                frame.setVisible(false);
//            }
//
////            if(currentQuestionNumber[0] == 5) {
////                JOptionPane.showMessageDialog(frame, "You have completed the descriptive quiz. Your score is " + score + "/5");
////
////                frame.nextCard();
////                frame.setVisible(true);
////            }
//
//        }
//    }
