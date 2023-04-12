import javax.swing.JButton;
import question_package.desc.DescQuestionManager;
import ui_package.NewUI;
import ui_package.QuestionFrame;
import ui_package.SubmitListener;
import ui_package.please_work;

public class Main {
    public static void main(String[] args) {

        //QuestionFrame desc_frame = new QuestionFrame();

        NewUI newUI = new NewUI();


        DescQuestionManager desc_questions = new DescQuestionManager();

        final int[] currentQuestionNumber = {0};

        // Set the first question
        newUI.setQuestion(desc_questions.getQuestion(currentQuestionNumber[0]).getQuestion());

        JButton submit = newUI.getSubmit();

        //desc_frame.setVisible(true);

        //frame.setVisible(true);
//        please_work pleaseWork = new please_work();
//        pleaseWork.setVisible(true);
        newUI.setVisible(true);
//
        SubmitListener submitListener = new SubmitListener(desc_questions, newUI, currentQuestionNumber);
        submit.addActionListener(submitListener);



    }
}
