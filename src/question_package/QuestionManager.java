package question_package;

public interface QuestionManager {
    int getNumberOfQuestions();
    Question getQuestion(int index);
    int getNumQuestions();
    void checkAnswer(int index, String selectedOption);
}
