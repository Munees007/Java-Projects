import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductPriceMap {
    public static void main(String[] args) {
        Map<String, Double> productMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // sample products
        productMap.put("Laptop", 55000.0);
        productMap.put("Mobile", 20000.0);
        productMap.put("Headphones", 1500.0);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Product\n2. Search Product\n3. Show Products\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    productMap.put(name, price);
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.print("Enter product name to search: ");
                    String search = sc.nextLine();
                    if (productMap.containsKey(search)) {
                        System.out.println("Price of " + search + ": " + productMap.get(search));
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("All Products:");
                    for (Map.Entry<String, Double> entry : productMap.entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("Exiting Product Price Map.");
        sc.close();
    }
}
