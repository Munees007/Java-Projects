import db.DBConfig;
import java.sql.*;
import java.util.Scanner;

public class JDBC_Create {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Real-Time JDBC: Create Records (Console) ---");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        String insertSql = "INSERT INTO Students (Name, Age, Course) VALUES (?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(insertSql)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, course);

            int rows = pstmt.executeUpdate();
            System.out.println(rows + " record created successfully!\n");

            // View records
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
