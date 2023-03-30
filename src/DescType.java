import java.util.Scanner;
public class DescType extends Question {

    private String correctAns; 
    private String userAns;
    
    DescType(){
        super();
        String q = "Empty Question";
        setQuestion(q);
        System.out.println(getQuestion());
        correctAns = "hello";

    }
    String getAnswer()
    {
        System.out.print("Enter your answer: ");
        Scanner sc = new Scanner(System.in);
        userAns = sc.next();
        sc.close();
        return userAns;
    }

    boolean isCorrect(String userOption) {
        if (userOption.equals(correctAns)) return true;
        else return false;
    }

    public static void main(String [] args)
    {
        String ans;
        
        DescType d1 = new DescType();
        ans = d1.getAnswer();
        if(d1.isCorrect(ans) == true)
        {
            System.out.println("Correct Answer!");
        } 
        else
        {
            System.out.println("Wrong Answer!");
        }
    }

}
