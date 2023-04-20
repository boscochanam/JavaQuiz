package question_package;

public abstract class Question {
    // Member variables
    protected String questionDesc;
    protected String correctAns;

    public Question()
    {
        String q = "Empty Question";
        setQuestion(q);
    }

    public abstract void setQuestion(String s);
    public abstract String getQuestion();
    public abstract void setCorrectAns(String ans);
    public abstract String getCorrectAns();
}
