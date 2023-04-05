package question_package;

import java.util.*;

public abstract class Question {
    private int qNo;
    private float marks;
    private int difficulty;
    private String qType;
    private String questionDesc;
    private String correctAns;
    static int currentQNo = 0;

    // Question Description Getter / Setter Functions
    public void setQuestion(String q){
        questionDesc = q;
    }
    public String getQuestion(){
        return questionDesc;
    }

    // Marks Getter / Setter
    public void setMarks(float mark){
        marks = mark;
    }
    public float getMarks(){
        return marks;
    }

    // Difficulty Getter / Setter
    public void setDifficulty(int diff){
        difficulty = diff;
    }
    public int getDifficulty(){
        return difficulty;
    }

    // Get QNo
    static int getQNo(){
        return currentQNo;
    }

    Question(){
        qNo = 0;
        marks = 0;
        difficulty = 0;
        questionDesc = "Empty Question";
        qType = "None";
        correctAns = "None";
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
