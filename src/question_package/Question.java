package question_package;

public interface Question {

    // Member variables
    String questionDesc = null;
    String correctAns = null;

    // Getter and Setter for questions
    void setQuestion(String s);
    String getQuestion();

    // Getter and Setter for answers
    void setCorrectAns(String ans);
    String getCorrectAns();

    // Answer Checker
    boolean isCorrect(String ans);

}
