package question_package;

import java.util.ArrayList;
import java.util.List;

public class DescQuestionManager {

    private List<DescType> questions;

    public DescQuestionManager() {
        questions = new ArrayList<>();
        // Add your questions here
        questions.add(new DescType("What does CSE Stand for?", "Computer Science Engineering"));
        questions.add(new DescType("What is the capital of India", "New Delhi"));
        questions.add(new DescType("How many digits are in the binary number system?", "2"));
        questions.add(new DescType("What does int stand for?", "Integer"));
        questions.add(new DescType("Who is the PM of India? (Last Name)", "Modi"));
    }

    public DescType getQuestion(int index) {
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
        DescType question = questions.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer.");
        }
    }

}
