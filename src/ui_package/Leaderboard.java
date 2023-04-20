package ui_package;

import java.sql.*;

public class Leaderboard {

    // custom class to hold name and score information
    static class ScoreEntry {
        String name;
        int score;

        public ScoreEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String db_url = "jdbc:mysql://localhost:3306/javaquiz";

    // Database credentials
    static final String username = "root";
    static final String password = "password";

    // method to retrieve highest 3 scores and return an array of ScoreEntry objects
    public static ScoreEntry[] getTopScores() {
        Connection conn = null;
        Statement stmt = null;
        ScoreEntry[] topScores = new ScoreEntry[3];
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(db_url, username, password);

            // Execute a query
            System.out.println("Retrieving highest 3 scores...");
            stmt = conn.createStatement();
            String sql = "SELECT name, score FROM leaderboard ORDER BY score DESC LIMIT 3";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set and store in array
            int i = 0;
            while (rs.next() && i < 3) {
                String name = rs.getString("name");
                int score = rs.getInt("score");
                topScores[i] = new ScoreEntry(name, score);
                i++;
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        return topScores;
    }
}
