import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {

    public static void main(String[] args) {

        QuizFrame quiz_frame = new QuizFrame();
        QuestionManager question_manager = new QuestionManager();
        final int[] currentQuestionNumber = {0};

        // Set the first question
        quiz_frame.setQuestion(question_manager.getQuestion(currentQuestionNumber[0]).getQuestion());

        JButton submit = quiz_frame.getSubmit();
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quiz_frame.isVisible()) {
                    String userAns = quiz_frame.getUserAnswer();
                    boolean correctAnswer = false;

                    // Check if user answer matches the correct answer
                    if (question_manager.getQuestion(currentQuestionNumber[0]).getAnswer().equalsIgnoreCase(userAns)) {
                        JOptionPane.showMessageDialog(quiz_frame, "Correct Answer");
                        correctAnswer = true;
                    } else {
                        JOptionPane.showMessageDialog(quiz_frame, "Incorrect Answer");
                    }

                    if (correctAnswer) {
                        // Show the next question or end the quiz
                        currentQuestionNumber[0]++;
                        if (currentQuestionNumber[0] < question_manager.getNumQuestions()) {
                            quiz_frame.setQuestion(question_manager.getQuestion(currentQuestionNumber[0]).getQuestion());
                            quiz_frame.clearAnswer();
                        } else {
                            quiz_frame.setVisible(false);
                        }
                    }
                }
            }
        });

        quiz_frame.setVisible(true);
    }
}
