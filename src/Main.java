import javax.swing.JButton;
import question_package.DescQuestionManager;
import question_package.MCQQuestionManager;
import ui_package.QuestionFrame;
import ui_package.MCQFrame;
import ui_package.SubmitListener;

public class Main {
    public static void main(String[] args) {

        QuestionFrame desc_frame = new QuestionFrame();
        MCQFrame mcq_frame = new MCQFrame();

        DescQuestionManager desc_questions = new DescQuestionManager();
        MCQQuestionManager mcq_questions = new MCQQuestionManager();

        final int[] currentQuestionNumber = {0};

        // Set the first question
        desc_frame.setQuestion(desc_questions.getQuestion(currentQuestionNumber[0]).getQuestion());

        JButton submit = desc_frame.getSubmit();

        desc_frame.setVisible(true);

        SubmitListener submitListener = new SubmitListener(desc_questions, desc_frame, currentQuestionNumber);
        submit.addActionListener(submitListener);

        mcq_frame.getOptionAButton().addActionListener(e -> {
            checkAnswerAndProceed(desc_questions, desc_frame, mcq_frame, currentQuestionNumber, "A");
        });

        mcq_frame.getOptionBButton().addActionListener(e -> {
            checkAnswerAndProceed(desc_questions, desc_frame, mcq_frame, currentQuestionNumber, "B");
        });

        mcq_frame.getOptionCButton().addActionListener(e -> {
            checkAnswerAndProceed(desc_questions, desc_frame, mcq_frame, currentQuestionNumber, "C");
        });

        mcq_frame.getOptionDButton().addActionListener(e -> {
            checkAnswerAndProceed(desc_questions, desc_frame, mcq_frame, currentQuestionNumber, "D");
        });

    }

    private static void checkAnswerAndProceed(DescQuestionManager mcq_questions, QuestionFrame desc_frame, MCQFrame mcq_frame, int[] currentQuestionNumber, String selectedOption) {
        String correctAnswer = mcq_questions.getQuestion(currentQuestionNumber[0]).getAnswer();
        mcq_questions.checkAnswer(currentQuestionNumber[0], selectedOption);
        currentQuestionNumber[0]++;
        if (currentQuestionNumber[0] < mcq_questions.getQuestionCount()) {
            // If there are more questions, update frames with next question
            desc_frame.setQuestion(mcq_questions.getQuestion(currentQuestionNumber[0]).getQuestion());
//            mcq_frame.setQuestion(mcq_questions.getQuestion(currentQuestionNumber[0]).getQuestion(),
//                    mcq_questions.getQuestion(currentQuestionNumber[0]).getOptionA(),
//                    mcq_questions.getQuestion(currentQuestionNumber[0]).getOptionB(),
//                    mcq_questions.getQuestion(currentQuestionNumber[0]).getOptionC(),
//                    mcq_questions.getQuestion(currentQuestionNumber[0]).getOptionD());
        } else {
            // If no more questions, display final score
            //String scoreMessage = "Quiz Complete! Your Score: " + mcq_questions.getScore() + "/" + mcq_questions.getQuestionCount();
            //desc_frame.setQuestion(scoreMessage);
            mcq_frame.setVisible(false);
            desc_frame.getSubmit().setEnabled(false);
        }

        // Update MCQFrame visibility based on current question number
        if (currentQuestionNumber[0] == 0) {
            mcq_frame.setVisible(false);
            desc_frame.setVisible(true);
        } else {
            mcq_frame.setVisible(true);
            desc_frame.setVisible(false);
        }
    }
}
