package question_package;

public interface Question {

    // Member variables
    String questionDesc = null;
    String correctAns = null;

    // Getter and Setter for questions
    public void setQuestion(String s);
    public String getQuestion();

    // Getter and Setter for answers
    public void setCorrectAns(String ans);

    public String getCorrectAns();

    // Answer Checker
    abstract boolean isCorrect(String ans);

}
