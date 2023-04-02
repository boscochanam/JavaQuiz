import javax.swing.*;
import java.awt.*;

public class QuizFrame extends JFrame {

    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton;

    private int questionNumber;

    public QuizFrame() {
        super("Quiz");

        questionNumber = 0;

        // Initialize GUI components
        questionLabel = new JLabel();
        answerField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Layout components
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(questionLabel);
        content.add(answerField);
        content.add(submitButton);

        // Add content to frame
        getContentPane().add(content);

        // Set behavior
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        // Set preferred size
        Dimension preferredSize = new Dimension(500, 300);
        content.setPreferredSize(preferredSize);
        setPreferredSize(preferredSize);
        pack();
    }

    public String getQuestionText() {
        return questionLabel.getText();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestion(String question) {
        questionNumber++;
        questionLabel.setText("Question " + questionNumber + ": " + question);
    }

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public JButton getSubmit() {
        return submitButton;
    }

    public void setQuestionNumber(int i) {
        questionNumber = i;
    }
}
