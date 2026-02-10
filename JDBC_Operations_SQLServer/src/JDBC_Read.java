import db.DBConfig;
import java.sql.*;

public class JDBC_Read {
    public static void main(String[] args) {
        System.out.println("--- Real-Time JDBC: Read Records (Console) ---");

        try (Connection conn = DBConfig.getConnection()) {
            viewRecords(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewRecords(Connection conn) throws SQLException {
        System.out.println("--- Current Records in Students Table ---");
        String selectSql = "SELECT * FROM Students";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(selectSql)) {

            System.out.printf("%-5s %-15s %-5s %-10s%n", "ID", "Name", "Age", "Course");
            System.out.println("------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-5d %-10s%n",
                        rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getString("Course"));
            }
        }
    }
}
