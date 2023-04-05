package question_package;

class MCQ extends Question {

    private String correctOption;
    private String userOption;
    MCQ(){
        super();
        String q = "Empty Question\n Option 1\n Option 2\n Option 3\n Option 4";
        setQuestion(q);
        System.out.println(getQuestion());

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