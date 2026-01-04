import java.util.*;

class LowerBound<T extends Number> {
    private List<T> list;

    // Constructor
    public LowerBound(List<T> input) {
        this.list = new ArrayList<>(input);
    }

    // Remove duplicates
    public void removeDuplicates() {
        Set<T> set = new LinkedHashSet<>(list);
        list = new ArrayList<>(set);
        System.out.println("Duplicates removed.");
    }

    // Sort the list
    public void sortList() {
        list.sort((a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        System.out.println("List sorted.");
    }

    // Find lower bound index
    public int findLowerBound(T key) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid).doubleValue() < key.doubleValue()) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Print the current list
    public void printList() {
        System.out.println("Current list: " + list);
    }

    // Get element at index
    public T get(int index) {
        if (index >= 0 && index < list.size())
            return list.get(index);
        return null;
    }

    // Get list size
    public int size() {
        return list.size();
    }
}

public class LowerBoundCLI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Double> numbers = new ArrayList<>();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextDouble());
        }

        LowerBound<Double> lb = new LowerBound<>(numbers);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Remove duplicates");
            System.out.println("2. Sort list");
            System.out.println("3. Find lower bound");
            System.out.println("4. Print list");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    lb.removeDuplicates();
                    break;
                case 2:
                    lb.sortList();
                    break;
                case 3:
                    System.out.print("Enter number to find lower bound for: ");
                    double key = sc.nextDouble();
                    int index = lb.findLowerBound(key);
                    System.out.println("Lower bound index: " + index);
                    if (index < lb.size()) {
                        System.out.println("Number at lower bound: " + lb.get(index));
                    } else {
                        System.out.println("Number is greater than all elements, can be inserted at the end.");
                    }
                    break;
                case 4:
                    lb.printList();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        System.out.println("Program ended.");
        sc.close();
    }
}
