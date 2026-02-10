import db.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Delete {
    public static void main(String[] args) {
        String sql = "DELETE FROM Students WHERE Name = ?";

        try (Connection conn = DBConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Munees");

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Record Deleted: " + rowsAffected + " rows impacted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
