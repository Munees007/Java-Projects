import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ProductMenuFrame extends JFrame {
    private Map<String, Double> productMap;
    private JList<String> productList;
    private JLabel priceLabel;

    public ProductMenuFrame() {
        setTitle("Product Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        productMap = new HashMap<>();
        productMap.put("Laptop", 55000.0);
        productMap.put("Mobile", 20000.0);
        productMap.put("Headphones", 1500.0);
        productMap.put("Tablet", 30000.0);
        productMap.put("Monitor", 12000.0);

        buildUI();
        setVisible(true);
    }

    private void buildUI() {
        String[] products = productMap.keySet().toArray(new String[0]);
        productList = new JList<>(products);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        priceLabel = new JLabel("Select a product to see price", JLabel.CENTER);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        priceLabel.setPreferredSize(new Dimension(400, 50));
        add(priceLabel, BorderLayout.SOUTH);

        productList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selected = productList.getSelectedValue();
                    if (selected != null) {
                        double price = productMap.get(selected);
                        priceLabel.setText("Price of " + selected + ": ₹" + price);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        new ProductMenuFrame();
    }
}
