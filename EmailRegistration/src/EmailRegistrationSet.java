import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EmailRegistrationSet {
    public static void main(String[] args) {
        Set<String> emailSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Register Email\n2. Show Registered Emails\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter email to register: ");
                    String email = sc.nextLine();
                    if (emailSet.add(email)) {
                        System.out.println("Email registered successfully.");
                    } else {
                        System.out.println("Email already registered!");
                    }
                    break;
                case 2:
                    System.out.println("Registered Emails:");
                    for (String e : emailSet) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("Exiting Email Registration.");
        sc.close();
    }
}

