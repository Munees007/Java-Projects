import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ProductMenuFrame extends JFrame {
    private Map<String, Double> productMap;

    public ProductMenuFrame() {
        setTitle("Product Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productMap = new HashMap<>();
        productMap.put("Laptop", 55000.0);
        productMap.put("Mobile", 20000.0);
        productMap.put("Headphones", 1500.0);

        buildMenuBar();
        setVisible(true);
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(java.awt.Color.CYAN);

        JMenu productMenu = new JMenu("Products");
        menuBar.add(productMenu);

        for (String product : productMap.keySet()) {
            JMenuItem item = new JMenuItem(product);
            productMenu.add(item);

            item.addActionListener(e -> {
                double price = productMap.get(product);
                JOptionPane.showMessageDialog(this, product + " Price: " + price);
            });
        }

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new ProductMenuFrame();
    }
}
