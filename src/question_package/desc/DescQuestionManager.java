package question_package.desc;

import question_package.Question;
import question_package.QuestionManager;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DescQuestionManager implements QuestionManager {
    private List<DescType> questionArray;

    public DescQuestionManager() {
        questionArray = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            String url = "jdbc:mysql://localhost:3306/javaquiz";
            String username = "root";
            String password = "password";
            con = DriverManager.getConnection(url, username, password);

            // Prepare the SQL statement to retrieve the questions from the table
            String sql = "SELECT question, correctAnswer FROM desc_type_questions";
            stmt = con.prepareStatement(sql);

            // Execute the SQL statement and get the result set
            rs = stmt.executeQuery();

            // Iterate over the result set and add the questions to the list
            while (rs.next()) {
                String questionText = rs.getString("question");
                String answerText = rs.getString("correctAnswer");
                questionArray.add(new DescType(questionText, answerText));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getNumberOfQuestions() {
        return questionArray.size();
    }

    public DescType getQuestion(int index) {
        return questionArray.get(index);
    }

    public int getNumQuestions() {
        return questionArray.size();
    }

    public void checkAnswer(int index, String selectedOption) {
        DescType question = questionArray.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }
    }

    public static void main(String[] args) {
        DescQuestionManager manager = new DescQuestionManager();
        System.out.println("Number of questions: " + manager.getNumberOfQuestions());
        DescType question = manager.getQuestion(0);
        System.out.println("Question: " + question.getQuestion());
        System.out.println("Correct answer: " + question.getCorrectAns());
        manager.checkAnswer(0, "hello");
    }
}