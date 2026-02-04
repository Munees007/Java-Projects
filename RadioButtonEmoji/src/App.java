import java.sql.*;
public class App {
    
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/javadb";
        String username = "root";
        String pass = "Muneesw@r@n8072.p";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url,username,pass);

            if(con != null)
            {
                System.out.println("Connection success");
                String query = "Select * from Customers";
                pst = con.prepareStatement(query);
                res = pst.executeQuery();
                while (res.next()) {
                    System.out.println("ID: " + res.getInt("ID"));
                    System.out.println("CustomerID: " + res.getString("CustomerID"));
                    System.out.println("Name: " + res.getString("Name"));
                    System.out.println("-------------------");
                }

            }
            else
            {
                System.out.println("Connection not success");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
