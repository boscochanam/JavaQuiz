package question_package;

// import java.util.*;

public abstract class Question {
    private int qNo;
    private String questionDesc;
    private String correctAns;

    // Question Description Getter / Setter Functions
    public void setQuestion(String q){
        questionDesc = q;
    }
    public String getQuestion(){
        return questionDesc;
    }


    public void setCorrectAns(String ans) {
        correctAns = ans;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    protected abstract String getAnswer();
    protected abstract boolean isCorrect(String ans);

}
