package question_package.mcq;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class McqQuestionManager {

    private static List<McqType> questions;

    public McqQuestionManager() {
        questions = new ArrayList<>();
        // Add your questions here
        questions.add(new McqType("What is the capital of India?", "New Delhi", "Mumbai", "Kolkata", "Chennai", "New Delhi"));
        questions.add(new McqType("How is the first letter of the alphabet?", "a", "b", "c", "d", "a"));
        questions.add(new McqType("What is the largest country in the world?", "India", "Russia", "China", "USA", "Russia"));
        questions.add(new McqType("What is the capital of China?", "Beijing", "Shanghai", "Hong Kong", "Taipei", "Beijing"));
    }

    public static int getNumberOfQuestions() {
        return questions.size();
    }

    public McqType getQuestion(int index) {
        return questions.get(index);
    }

    public String getAnswer(int index) {
        return questions.get(index).getCorrectAns();

    }

    public int getNumQuestions() {
        return questions.size();
    }

    public int getQuestionCount() {
        return questions.size();
    }

    public void checkAnswer(int index, String selectedOption) {
        McqType question = questions.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer.");
        }
    }

    public static void main(String[] args) {

        // Testing Code
        McqQuestionManager m = new McqQuestionManager();
        //System.out.println("View Questions or Check Answers? \n 1. View Questions \n 2. Check Answers");
        //Scanner sc = new Scanner(System.in);

        System.out.println(m.getQuestion(1).getAnswerOptions()[0]);
        System.out.println(m.getQuestion(1).getAnswerOptions()[1]);
        System.out.println(m.getQuestion(1).getAnswerOptions()[2]);
        System.out.println(m.getQuestion(1).getAnswerOptions()[3]);


    }
}
