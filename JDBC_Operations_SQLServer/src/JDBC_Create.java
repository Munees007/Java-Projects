import db.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Create {
    public static void main(String[] args) {
        String sql = "INSERT INTO Students (Name, Age, Course) VALUES (?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Munees");
            pstmt.setInt(2, 22);
            pstmt.setString(3, "MCA");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Record Created: " + rowsAffected + " rows impacted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
