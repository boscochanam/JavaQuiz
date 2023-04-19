package questions;

import java.sql.*;
import java.util.Scanner;

public class Desc_Updt {

    private static final String url = "jdbc:mysql://localhost:3306/javaquiz";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();

            // Display all questions before user interaction
            String selectQuery = "SELECT * FROM desc_type_questions";
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int qNumber = rs.getInt("qNumber");
                String question = rs.getString("question");
                String correctAnswer = rs.getString("correctAnswer");

                System.out.println("Question " + qNumber + ": " + question);
                System.out.println("Correct Answer: " + correctAnswer);
                System.out.println("----------------------");
            }

            int choice = 0;
            while (choice != 4) {
                System.out.println("Enter your choice:");
                System.out.println("1. Add a new question");
                System.out.println("2. Update an existing question");
                System.out.println("3. Remove a question");
                System.out.println("4. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // User interaction to add a new question
                        System.out.println("Enter the new question:");
                        String newQuestion = scanner.nextLine();
                        System.out.println("Enter the correct answer for the new question:");
                        String newAnswer = scanner.nextLine();
                        String addQuery = "INSERT INTO desc_type_questions (question, correctAnswer) VALUES ('" + newQuestion + "', '" + newAnswer + "')";
                        stmt.executeUpdate(addQuery);
                        System.out.println("New question added successfully.");
                        break;
                    case 2:
                        // User interaction to update an existing question
                        System.out.println("Enter the question number to update:");
                        int questionNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the updated correct answer:");
                        String updatedAnswer = scanner.nextLine();
                        String updateQuery = "UPDATE desc_type_questions SET correctAnswer = '" + updatedAnswer + "' WHERE qNumber = " + questionNumber;
                        stmt.executeUpdate(updateQuery);
                        System.out.println("Question updated successfully.");
                        break;
                    case 3:
                        // User interaction to remove a question
                        System.out.println("Enter the question number to remove:");
                        int removeNumber = scanner.nextInt();
                        String removeQuery = "DELETE FROM desc_type_questions WHERE qNumber = " + removeNumber;
                        stmt.executeUpdate(removeQuery);
                        System.out.println("Question removed successfully.");
                        break;
                    case 4:
                        // Exit the program
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid choice.");
                }

                // Display all questions after each action
                selectQuery = "SELECT * FROM desc_type_questions";
                rs = stmt.executeQuery(selectQuery);

                while (rs.next()) {
                    int qNumber = rs.getInt("qNumber");
                    String question = rs.getString("question");
                    String correctAnswer = rs.getString("correctAnswer");

                    System.out.println("Question " + qNumber + ": " + question);
                    System.out.println("Correct Answer: " + correctAnswer);
                    System.out.println("----------------------");
                }

                rs.close();
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connections: " + e.getMessage());
            }
        }
    }
}
