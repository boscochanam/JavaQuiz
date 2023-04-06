package question_package;

import java.util.ArrayList;
import java.util.List;

public class MCQQuestionManager {

    private List<MCQ> questions;

    public MCQQuestionManager() {
        questions = new ArrayList<>();
        questions.add(new MCQ("Is Java a programming language? \nA. Yes\nB. No \nC. Maybe", "A"));
        questions.add(new MCQ("Is this Question 2? \nA. Yes\nB. No \nC. Maybe", "B"));
        questions.add(new MCQ("Does this question have numbers in it? \nA. Yes\nB. No \nC. Maybe", "B"));
        questions.add(new MCQ("Does int hold integer type data? \nA. Yes\nB. No \nC. Maybe", "A"));
        questions.add(new MCQ("Is CSGO a good game? \nA. Yes\nB. No \nC. Maybe", "B"));
    }

    public MCQ getQuestion(int index) {
        return questions.get(index);
    }


    public String getAnswer(int index) {
        return questions.get(index).getCorrectAns();
    }

    public int getNumQuestions() {
        return questions.size();
    }

    public boolean checkAnswer(int index, String selectedOption) {
        MCQ question = questions.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            return true;
        } else {
            return false;
        }
    }

    public int getQuestionCount() {
        return questions.size();
    }
}
