package questions;

import java.sql.*;
import java.util.Scanner;

public class Int_Updt {

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
            String selectQuery = "SELECT * FROM int_type_questions";
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                int correctAnswer = rs.getInt("correctAnswer");

                System.out.println("Question " + id + ": " + question);
                System.out.println("Answer: " + correctAnswer);
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
                        System.out.println("Enter the answer:");
                        int newAnswer = scanner.nextInt();
                        String addQuery = "INSERT INTO int_type_questions (question, answer) VALUES ('" + newQuestion + "', " + newAnswer + ")";
                        stmt.executeUpdate(addQuery);
                        System.out.println("New question added successfully.");
                        break;
                    case 2:
                        // User interaction to update an existing question
                        System.out.println("Enter the question id to update:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the updated answer:");
                        int updatedAnswer = scanner.nextInt();
                        String updateQuery = "UPDATE int_type_questions SET answer = " + updatedAnswer + " WHERE id = " + id;
                        stmt.executeUpdate(updateQuery);
                        System.out.println("Question updated successfully.");
                        break;
                    case 3:
                        // User interaction to delete a question
                        System.out.println("Enter the question id to delete:");
                        int deleteId = scanner.nextInt();
                        String deleteQuery = "DELETE FROM int_type_questions WHERE id = " + deleteId;
                        stmt.executeUpdate(deleteQuery);
                        System.out.println("Question deleted successfully.");
                        break;
                    case 4:
                        // User interaction to view all questions
                        rs = stmt.executeQuery("SELECT * FROM int_type_questions");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" + rs.getString("question") + "\t" + rs.getInt("correctAnswer"));
                        }
                        break;
                    case 5:
                        // Exit the program
                        System.out.println("Exiting program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL Exception: " + e.getMessage());
            }
        }
    }
}
