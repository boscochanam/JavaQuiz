package question_package;

import java.util.ArrayList;
import java.util.List;

class MCQ extends Question {

    private String correctOption;
    private String userOption;
    private ArrayList<String> options;
    MCQ(){
        super();
        String q = "Empty Question";
        setQuestion(q);
        System.out.println(getQuestion());

    }

    public MCQ(String s, String a) {
        super();
        setQuestion(s);
        setCorrectAns(a);
    }

    @Override
    public boolean isCorrect(String userOption) {
        if (userOption.equals(correctOption)) return true;
        else return false;
    }

    @Override
    public String getAnswer() {
        return null;
    }

    public static void main(String[] args) {
        MCQ m1 = new MCQ();
        
    }
}