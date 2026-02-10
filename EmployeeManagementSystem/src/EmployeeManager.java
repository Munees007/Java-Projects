import models.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        // Add Employees
        employeeList.add(new Employee(101, "Alice", "IT", 75000));
        employeeList.add(new Employee(102, "Bob", "HR", 60000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 80000));

        // Display Employees
        System.out.println("Employee List:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        // Search Employee by ID
        int searchId = 102;
        System.out.println("\nSearching for Employee with ID " + searchId + ":");
        employeeList.stream()
                .filter(e -> e.getId() == searchId)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));
    }
}
