package question_package;

public class DescType extends Question {

    private String userAns;

    DescType() {
        super();
        String q = "Empty Question";
        setQuestion(q);
        System.out.println(getQuestion());
        setCorrectAns("hello");
    }

    public DescType(String que, String ans) {
        setCorrectAns(ans);
        setQuestion(que);
    }

    public String getAnswer() {
        return getCorrectAns();
    }


    public boolean isCorrect(String userOption) {
        if (userOption.equals(getCorrectAns()))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String ans;

        DescType d1 = new DescType();
        ans = d1.getAnswer();
        if (d1.isCorrect(ans) == true) {
            System.out.println("Correct Answer!");
        } else {
            System.out.println("Wrong Answer!");
        }
    }

}
