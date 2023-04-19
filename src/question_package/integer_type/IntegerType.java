package question_package.integer_type;

import question_package.Question;

public class IntegerType implements Question {

    private int userAns;
    private String questionDesc;
    private int correctAns;

    IntegerType() {
        super();
        String q = "Empty Question";
        setQuestion(q);
        //System.out.println(getQuestion());
        setCorrectAns(0);
    }

    public IntegerType(String que, int ans) {
        setCorrectAns(ans);
        setQuestion(que);
    }

    public boolean isCorrect(int userOption) {
        if (userOption == correctAns)
            return true;
        else
            return false;
    }

    public void setQuestion(String q){
        questionDesc = q;
    }

    public String getQuestion(){
        return questionDesc;
    }

    @Override
    public void setCorrectAns(String ans) {
        try {
            correctAns = Integer.parseInt(ans);
        } catch (NumberFormatException e) {
            // Handle exception when ans is not a valid integer
            System.out.println("Error: Invalid integer format for correct answer.");
            e.printStackTrace();
        }
    }

    public void setCorrectAns(int ans) {
        correctAns = ans;
    }

    public String getCorrectAns() {
        return Integer.toString(correctAns);
    }

    @Override
    public boolean isCorrect(String ans) {
        try {
            int userOption = Integer.parseInt(ans);
            return isCorrect(userOption);
        } catch (NumberFormatException e) {
            // Handle exception when ans is not a valid integer
            System.out.println("Error: Invalid integer format for user answer.");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        IntegerType integerType = new IntegerType();
        integerType.setQuestion("What is the answer to life, the universe and everything?");
        integerType.setCorrectAns(42);
        System.out.println(integerType.getQuestion());
        System.out.println(integerType.getCorrectAns());
    }

}
