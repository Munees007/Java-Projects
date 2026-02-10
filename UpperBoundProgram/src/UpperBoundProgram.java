import java.util.List;

public class UpperBoundProgram {
    // Generic method with upper bound (Numbers only)
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 20, 30);
        System.out.println("Sum of integers: " + sumOfList(intList));

        List<Double> doubleList = List.of(1.5, 2.5, 3.5);
        System.out.println("Sum of doubles: " + sumOfList(doubleList));

        // List<String> strList = List.of("A", "B"); // Error: String is not a subclass
        // of Number
    }
}
