import db.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Update {
    public static void main(String[] args) {
        String sql = "UPDATE Students SET Course = ? WHERE Name = ?";

        try (Connection conn = DBConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "M.Tech");
            pstmt.setString(2, "Munees");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Record Updated: " + rowsAffected + " rows impacted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
