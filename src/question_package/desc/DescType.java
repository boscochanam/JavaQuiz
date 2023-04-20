package question_package.desc;

import question_package.Question;

public class DescType extends Question {

    private String questionDesc;
    private String correctAns;

    DescType() {
        super();
        setCorrectAns("hello");
    }

    public DescType(String que, String ans) {
        setCorrectAns(ans);
        setQuestion(que);
    }

    public String getAnswer() {
        return getCorrectAns();
    }


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

    public static void main(String[] args) {}

}
