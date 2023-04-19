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

    public int getNumQuestions() {
        return questionArray.size();
    }

    public static void main(String[] args) {
        IntQuestionManager intQuestionManager = new IntQuestionManager();
        System.out.println(intQuestionManager.getQuestion(0).getQuestion());
        System.out.println(intQuestionManager.getQuestion(0).getCorrectAns());

    }
}
