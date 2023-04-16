package question_package.desc;

import java.util.ArrayList;
import java.util.List;

public class DescQuestionManager {

    private final List<DescType> questionArray;

    public DescQuestionManager() {
        questionArray = new ArrayList<>();
        // Add your questions here
        questionArray.add(new DescType("What does CSE Stand for?", "Computer Science Engineering"));
        questionArray.add(new DescType("What is the capital of India", "New Delhi"));
        questionArray.add(new DescType("How many digits are in the binary number system?", "2"));
        questionArray.add(new DescType("What does int stand for?", "Integer"));
        questionArray.add(new DescType("Who is the PM of India? (Last Name)", "Modi"));
    }

    public int getNumberOfQuestions() {
        return questionArray.size();
    }

    public DescType getQuestion(int index) {
        return questionArray.get(index);
    }

    public String getAnswer(int index) {
        return questionArray.get(index).getCorrectAns();
    }

    public int getNumQuestions() {
        return questionArray.size();
    }

    public int getQuestionCount() {
        return questionArray.size();
    }

    public void checkAnswer(int index, String selectedOption) {
        DescType question = questionArray.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer.");
        }
    }
}