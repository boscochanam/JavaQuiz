package question_package.mcq;

import question_package.Question;

import java.util.ArrayList;

public class McqType implements Question {

    private String userAns;
    private String questionDesc;
    private ArrayList<String> options;
    private String correctAns;
    private int correctIndex;

    McqType() {
        super();
        options = new ArrayList<>(); // Initialize the options list
        String q = "Empty Question";
        setQuestion(q);
        System.out.println(getQuestion());
        setCorrectAns("hello");

        options.add("Option 1");
        options.add("Option 2");
        options.add("Option 3");
        options.add("Option 4");
    }

    public McqType(String que, String ans) {
        setCorrectAns(ans);
        setQuestion(que);
    }

    public String getAnswer() {
        return getCorrectAns();
    }

    public void printOptions() {
        char optionLabel = 'a'; // Initialize option label with 'a'
        for (String option : options) {
            System.out.println(optionLabel + ". " + option); // Concatenate option label with option string
            optionLabel++; // Increment option label for the next iteration
        }
    }

    @Override
    public void setQuestion(String s) {
        questionDesc = s;
    }

    @Override
    public String getQuestion() {
        return questionDesc;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public void setCorrectAns(String ans) {
        correctIndex = options.indexOf(ans);
        if (correctIndex == -1) {
            System.out.println("Error: Correct answer not found in options list");
        }
    }

    @Override
    public String getCorrectAns() {
        if (correctIndex >= 0 && correctIndex < options.size()) {
            return options.get(correctIndex);
        } else {
            System.out.println("Error: Correct answer index out of bounds");
            return null;
        }
    }

    @Override
    public boolean isCorrect(String ans) {
        return ans.equals(getCorrectAns());
    }


    McqType(String que, String a1, String a2, String a3, String a4, String correctAns) {
        options = new ArrayList<>();
        this.setQuestion(que);
        options.add(a1);
        options.add(a2);
        options.add(a3);
        options.add(a4);
        this.setCorrectAns(correctAns);
    }

    public static void main(String[] args) {

        McqType m1 =  new McqType("What is the capital of India?", "New Delhi", "Mumbai", "Kolkata", "Chennai", "New Delhi");

        m1.setCorrectAns("New Delhi"); // Call setCorrectAns method to set the correct answer
        System.out.println(m1.getQuestion());
        System.out.println(m1.getCorrectIndex());
        //System.out.println(m1.getCorrectIndex());

    }

    public String getChoiceA() {
        return options.get(0);
    }

    public String getChoiceB() {
        return options.get(1);
    }

    public String getChoiceC() {
        return options.get(2);
    }

    public String getChoiceD() {
        return options.get(3);
    }

    public int getCorrectChoice() {
        return correctIndex;
    }

    public int getCorrectAnswerIndex() {
        return correctIndex;
    }

    public String getAnswerA() {
        return options.get(0);
    }

    public String getAnswerB() {
        return options.get(1);
    }

    public String getAnswerC() {
        return options.get(2);
    }

    public String getAnswerD() {
        return options.get(3);
    }
}
