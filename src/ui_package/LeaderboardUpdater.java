package ui_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaderboardUpdater {

    public static void updateLeaderboard(String name, int score) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/javaquiz";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "INSERT INTO leaderboard (name, score) VALUES ('"+ name + "', '"+ score + "')";
        System.out.println(name + score + " OK ");
        PreparedStatement p1 = conn.prepareStatement(sql);
        p1.executeUpdate();

        p1.close();
        conn.close();
    }


    public static void main(String [] args) throws SQLException {
        Cards c1 = new Cards();
        String name = "John";
        int score = 10;

        LeaderboardUpdater l1 = new LeaderboardUpdater();
        l1.updateLeaderboard(name, score);
    }

}