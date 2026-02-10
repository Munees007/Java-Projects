import db.DBConfig;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class JDBC_Update extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField idField, courseField;
    private JButton updateButton;

    public JDBC_Update() {
        setTitle("Real-Time JDBC: Update Records (GUI)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[] { "ID", "Name", "Age", "Course" }, 0);
        table = new JTable(tableModel);
        loadData();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Control Panel
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID to Update:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("New Course:"));
        courseField = new JTextField();
        panel.add(courseField);

        updateButton = new JButton("Update Record");
        panel.add(updateButton);

        add(panel, BorderLayout.SOUTH);

        updateButton.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    private void loadData() {
        tableModel.setRowCount(0);
        try (Connection conn = DBConfig.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Students")) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("ID"));
                row.add(rs.getString("Name"));
                row.add(rs.getInt("Age"));
                row.add(rs.getString("Course"));
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateRecord() {
        int id = Integer.parseInt(idField.getText());
        String newCourse = courseField.getText();

        String sql = "UPDATE Students SET Course = ? WHERE ID = ?";
        try (Connection conn = DBConfig.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newCourse);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                loadData();
            } else {
                JOptionPane.showMessageDialog(this, "Record Not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JDBC_Update());
    }
}
