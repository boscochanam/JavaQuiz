import javax.swing.JButton;
import question_package.desc.DescQuestionManager;
import question_package.mcq.McqQuestionManager;
import ui_package.*;

public class Main {



    public static void main(String[] args) {

        // Making a new Card Object holding different frames for different question types
        Cards cards = new Cards();
        cards.setVisible(true);

        // Making objects for the different question types
        DescQuestionManager desc_questions = new DescQuestionManager();
        McqQuestionManager mcq_questions = new McqQuestionManager();

        // Making a new array to hold the current question number
        int currentQuestionNumber = 0;

        // Setting the first question
        cards.setQuestion(desc_questions.getQuestion(currentQuestionNumber).getQuestion(),currentQuestionNumber);

        // Adding a listener to the submit button
        JButton submit = cards.getSubmit();
        SubmitListener submitListener = new SubmitListener(desc_questions, mcq_questions,cards, currentQuestionNumber);
        submit.addActionListener(submitListener);

    }
}
