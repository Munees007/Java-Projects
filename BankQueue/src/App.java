
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import models.Customer;


public class App {
    private final Queue<Customer> bankTokenQueue = new LinkedList<>();
    private int tokenCounter = 1; // auto token number

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    // Main program loop
    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Bank Token System ---");
            System.out.println("1. Add Customer (Get Token)");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Waiting Customers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    addCustomer(sc);
                    break;
                case 2:
                    serveCustomer();
                    break;
                case 3:
                    viewQueue();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    // Add customer to queue
    private void addCustomer(Scanner sc) {
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        String tokenId = "T" + tokenCounter++; // Auto token like T1, T2, T3...
        Customer c = new Customer(tokenId, name);
        bankTokenQueue.add(c);
        System.out.println("Customer added. Token issued: " + tokenId);
    }

    // Serve customer
    private void serveCustomer() {
        if (bankTokenQueue.isEmpty()) {
            System.out.println("No customers in queue.");
        } else {
            Customer c = bankTokenQueue.poll(); // remove first customer
            System.out.println("Serving customer: " + c);
        }
    }

    // View waiting customers
    private void viewQueue() {
        if (bankTokenQueue.isEmpty()) {
            System.out.println("No customers waiting.");
        } else {
            System.out.println("Customers waiting in queue:");
            for (Customer c : bankTokenQueue) {
                System.out.println(c);
            }
        }
    }
}
