package question_package.integer_type;

import question_package.Question;

public class IntType implements Question {
    private String question;
    private String correctAns;

    private int correctInt;

    @Override
    public void setQuestion(String s) {
        this.question = s;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setCorrectAns(String ans) {
        try {
            correctInt = Integer.parseInt(ans);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, not an Integer");
        }
    }

    @Override
    public String getCorrectAns() {
        return Integer.toString(correctInt);
    }

    @Override
    public boolean isCorrect(String ans) {
        int ansInt = Integer.parseInt(ans);
        return ansInt == correctInt;
    }

    public static void main(String[] args) {
        IntType intType = new IntType();
        intType.setQuestion("What is 2 + 2?");
        intType.setCorrectAns("4");
        System.out.println(intType.isCorrect("4"));
    }
}
