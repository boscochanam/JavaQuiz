package question_package.integer_type;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntQuestionManager {
    private static List<IntegerType> questionArray;

    public IntQuestionManager() {
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
            String sql = "SELECT question, correctAnswer FROM int_type_questions";
            stmt = con.prepareStatement(sql);

            // Execute the SQL statement and get the result set
            rs = stmt.executeQuery();

            // Iterate over the result set and add the questions to the list
            while (rs.next()) {
                String questionText = rs.getString("question");
                int answerInt = rs.getInt("correctAnswer");
                questionArray.add(new IntegerType(questionText, answerInt));
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

    public static int getNumberOfQuestions() {
        return questionArray.size();
    }

    public IntegerType getQuestion(int index) {
        return questionArray.get(index);
    }

    public String getAnswer(int index) {
        return questionArray.get(index).getCorrectAns();
    }

    public int getNumQuestions() {
        return questionArray.size();
    }

    public int getQuestionCount() {
        return questionArray.size();
    }

    public void checkAnswer(int index, int selectedOption) {
        IntegerType question = questionArray.get(index);
        int correctAnswer = Integer.parseInt(question.getCorrectAns());

        if (selectedOption == correctAnswer) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }
    }

    public static void main(String[] args) {

//        IntQuestionManager manager = new IntQuestionManager();
//        System.out.println("Number of questions: " + manager.getNumberOfQuestions());
//        System.out.println("Question 1: " + manager.getQuestion(0).getQuestion());
//        System.out.println("Answer 1: " + manager.getAnswer(0));
//        System.out.println("Question 2: " + manager.getQuestion(1).getQuestion());
//        System.out.println("Answer 2: " + manager.getAnswer(1));

    }
}
