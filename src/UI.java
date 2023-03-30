import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    String question;
    int qNo;
    public static void main(String[] args) {

        // Descriptive Type Frame
        JFrame quiz_frame = new JFrame("Java Quiz");
        quiz_frame.setSize(500,500);

        quiz_frame.setLayout(new GridLayout(3,1));
        JLabel question = new JLabel("This is a question");
        quiz_frame.add(question);

        JTextPane answer = new JTextPane();
        quiz_frame.add(answer);

        JButton submit = new JButton("Submit");
        quiz_frame.add(submit);

        // MCQ Type Frame
        JFrame quiz_frame_mcq = new JFrame("MCQ Quiz");
        quiz_frame_mcq.setSize(400,400);
        quiz_frame_mcq.setLayout(new GridLayout(5,1));

        JLabel mcqQuestion = new JLabel("This is an mcq question");
        JButton mcqA = new JButton("A: ");
        JButton mcqB = new JButton("B: ");
        JButton mcqC = new JButton("C: ");
        JButton mcqD = new JButton("D: ");

        quiz_frame_mcq.add(mcqQuestion);
        quiz_frame_mcq.add(mcqA);
        quiz_frame_mcq.add(mcqB);
        quiz_frame_mcq.add(mcqC);
        quiz_frame_mcq.add(mcqD);

        DescType q1 = new DescType();
        q1.setQuestion("Is Java a programming language? (Yes/No)");
        q1.setCorrectAns("Yes");

        MCQ q2 = new MCQ();
        q2.setQuestion("Which of these is a number\n A. 2\n B. A\n C. L\n D. W");
        q2.setCorrectOption("A");

        question.setText(q1.getQuestion());


        submit.addActionListener(  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quiz_frame.isVisible()){
                    String userAns = answer.getText();
                    if(q1.getCorrectAns().equals(userAns)) {
                        JOptionPane.showMessageDialog(quiz_frame, "Correct Answer");
                        quiz_frame.setVisible(false);
                        quiz_frame_mcq.setVisible(true);
                    }
                }
                else if (quiz_frame_mcq.isVisible()){
                    
                    if(q2.isCorrect()) {
                        JOptionPane.showMessageDialog(quiz_frame, "Correct Answer");
                        quiz_frame.setVisible(false);
                        quiz_frame_mcq.setVisible(true);
                    }
                }
                else
                    JOptionPane.showMessageDialog(quiz_frame, "Incorrect Answer");
            }
        });

        quiz_frame.setVisible(true);
    }
}
