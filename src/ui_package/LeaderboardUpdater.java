package ui_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaderboardUpdater {

    public void updateLeaderboard(String name, int score) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/javaquiz";
        String username = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE leaderboard SET score = ? WHERE name = ?";
        PreparedStatement p1 = conn.prepareStatement(sql);
        p1.setInt(1, score);
        p1.setString(2, name);

        int rowsAffected = p1.executeUpdate();

        p1.close();
        conn.close();
    }

    public static void main(String [] args)
    {

        LeaderboardUpdater l1 = new LeaderboardUpdater();
        l1.updateLeaderboard(name, score);
    }

}
