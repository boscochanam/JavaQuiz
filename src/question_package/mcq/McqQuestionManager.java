package question_package.mcq;

import question_package.QuestionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class McqQuestionManager implements QuestionManager {

    private static List<McqType> questions;

    public McqQuestionManager() {
        questions = new ArrayList<>();
        try {
            // Establish a connection to the database
            String url = "jdbc:mysql://localhost:3306/javaquiz";
            String username = "root";
            String password = "password";
            Connection con = DriverManager.getConnection(url, username, password);

            // Execute an SQL query to retrieve the questions and answers
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM mcq_questions";
            ResultSet rs = stmt.executeQuery(sql);

            // Iterate through the result set and create McqType objects
            while (rs.next()) {
                String question = rs.getString("question");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                String correctAns = rs.getString("correctOption");
                questions.add(new McqType(question, option1, option2, option3, option4, correctAns));
            }

            // Close the resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public McqType getQuestion(int index) {
        return questions.get(index);
    }

    public int getNumQuestions() {
        return questions.size();
    }

    public void checkAnswer(int index, String selectedOption) {
        McqType question = questions.get(index);
        String correctAnswer = question.getCorrectAns();

        if (selectedOption.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer.");
        }
    }

    public static void main(String[] args) {
        McqQuestionManager mcq = new McqQuestionManager();
        for (int i = 0; i < mcq.getNumberOfQuestions(); i++) {
            System.out.println(mcq.getQuestion(i).getQuestion());
            mcq.getQuestion(i).printOptions();
            System.out.println("Correct answer: " + mcq.getQuestion(i).getCorrectAns());
            System.out.println();
        }
    }
}

