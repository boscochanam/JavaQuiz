import javax.swing.JButton;
import question_package.desc.DescQuestionManager;
import ui_package.*;

public class Main {
    public static void main(String[] args) {

        Cards cards = new Cards();

        DescQuestionManager desc_questions = new DescQuestionManager();

        final int[] currentQuestionNumber = {0};


        // Set the first question
        cards.setQuestion(desc_questions.getQuestion(currentQuestionNumber[0]).getQuestion());

        JButton submit = cards.getSubmit();

        cards.setVisible(true);

        SubmitListener submitListener = new SubmitListener(desc_questions, cards, currentQuestionNumber);
        submit.addActionListener(submitListener);



    }
}
