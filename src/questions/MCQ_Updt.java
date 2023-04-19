package questions;

import java.sql.*;
import java.util.Scanner;

public class MCQ_Updt {

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
            String selectQuery = "SELECT * FROM mcq_questions";
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                int id = rs.getInt("id");
                String question = rs.getString("question");
                String option1 = rs.getString("option1");
                String option2 = rs.getString("option2");
                String option3 = rs.getString("option3");
                String option4 = rs.getString("option4");
                String correctOption = rs.getString("correctOption");

                System.out.println("Question " + id + ": " + question);
                System.out.println("Option 1: " + option1);
                System.out.println("Option 2: " + option2);
                System.out.println("Option 3: " + option3);
                System.out.println("Option 4: " + option4);
                System.out.println("Correct Option: " + correctOption);
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
                        System.out.println("Enter option 1:");
                        String option1 = scanner.nextLine();
                        System.out.println("Enter option 2:");
                        String option2 = scanner.nextLine();
                        System.out.println("Enter option 3:");
                        String option3 = scanner.nextLine();
                        System.out.println("Enter option 4:");
                        String option4 = scanner.nextLine();
                        System.out.println("Enter the correct option number (1-4):");
                        String correctOption = scanner.nextLine();
                        String addQuery = "INSERT INTO mcq_questions (question, option1, option2, option3, option4, correctOption) VALUES ('" + newQuestion + "', '" + option1 + "', '" + option2 + "', '" + option3 + "', '" + option4 + "', '" + correctOption + "')";
                        stmt.executeUpdate(addQuery);
                        System.out.println("New question added successfully.");
                        break;
                    case 2:
                        // User interaction to update an existing question
                        System.out.println("Enter the question id to update:");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the updated correct option number (1-4):");
                        String updatedOption = scanner.nextLine();
                        String updateQuery = "UPDATE mcq_questions SET correctOption = '" + updatedOption + "' WHERE id = " + id;
                        stmt.executeUpdate(updateQuery);
                        System.out.println("Question updated successfully.");
                        break;
                    case 3:
                        // User interaction to
                        System.out.println("Enter the question id to delete:");
                        int deleteId = scanner.nextInt();
                        String deleteQuery = "DELETE FROM mcq_questions WHERE id = " + deleteId;
                        stmt.executeUpdate(deleteQuery);
                        System.out.println("Question deleted successfully.");
                        break;
                    case 4:
// User interaction to view all questions
                        rs = stmt.executeQuery("SELECT * FROM mcq_questions");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" + rs.getString("question") + "\t" + rs.getString("option1") + "\t" + rs.getString("option2") + "\t" + rs.getString("option3") + "\t" + rs.getString("option4") + "\t" + rs.getString("correctOption"));
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