import java.util.ArrayList;
import java.util.List;

public class LowerBoundWildcard {
    // Generic method with lower bound wildcard (<? super Integer>)
    // This allows adding Integers or its supertypes (Number, Object) to the list
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        // List of Integers (Exact match)
        List<Integer> intList = new ArrayList<>();
        addNumbers(intList);
        System.out.println("Integer List: " + intList);

        // List of Numbers (Supertype of Integer)
        List<Number> numList = new ArrayList<>();
        addNumbers(numList);
        System.out.println("Number List: " + numList);

        // List of Objects (Supertype of Integer)
        List<Object> objList = new ArrayList<>();
        addNumbers(objList);
        System.out.println("Object List: " + objList);
    }
}
