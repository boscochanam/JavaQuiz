import java.util.ArrayList;
import java.util.List;

public class QuestionManager {

    private List<DescType> questions;

    public QuestionManager() {
        questions = new ArrayList<>();
        // Add your questions here
        questions.add(new DescType("Is Java a programming language? (Yes/No)", "Yes"));
        questions.add(new DescType("Is this Question 2? (Yes/No)", "Yes"));
        questions.add(new DescType("Does this question have numbers in it? (Yes/No)", "No"));
        questions.add(new DescType("Does int hold integer type data? (Yes/No)", "Yes"));
        questions.add(new DescType("Is CSGO a good game? (Yes/No)", "No"));
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
}
