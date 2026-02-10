import db.DBConfig;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class JDBC_Delete extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField idField;
    private JButton deleteButton;

    public JDBC_Delete() {
        setTitle("Real-Time JDBC: Delete Records (GUI)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[] { "ID", "Name", "Age", "Course" }, 0);
        table = new JTable(tableModel);
        loadData();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Control Panel
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("ID to Delete:"));
        idField = new JTextField(10);
        panel.add(idField);

        deleteButton = new JButton("Delete Record");
        panel.add(deleteButton);

        add(panel, BorderLayout.SOUTH);

        deleteButton.addActionListener(e -> deleteRecord());

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

    private void deleteRecord() {
        try {
            int id = Integer.parseInt(idField.getText());

            String sql = "DELETE FROM Students WHERE ID = ?";
            try (Connection conn = DBConfig.getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    JOptionPane.showMessageDialog(this, "Record Deleted Successfully!");
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Record Not Found!");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric ID!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JDBC_Delete());
    }
}
