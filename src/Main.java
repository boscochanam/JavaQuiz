import javax.swing.JButton;
import question_package.DescQuestionManager;
import ui_package.QuestionFrame;
import ui_package.SubmitListener;

public class Main {
    public static void main(String[] args) {

        QuestionFrame desc_frame = new QuestionFrame();

        DescQuestionManager desc_questions = new DescQuestionManager();

        final int[] currentQuestionNumber = {0};

        // Set the first question
        desc_frame.setQuestion(desc_questions.getQuestion(currentQuestionNumber[0]).getQuestion());

        JButton submit = desc_frame.getSubmit();

        desc_frame.setVisible(true);

        SubmitListener submitListener = new SubmitListener(desc_questions, desc_frame, currentQuestionNumber);
        submit.addActionListener(submitListener);

    }
}
