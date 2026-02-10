
import helper.DataViewer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Unbounded Generic Data Storage Manager ---");

        // Integer array
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        DataViewer<Integer> intViewer = new DataViewer<>(intArray);
        System.out.println("Integer Data:");
        intViewer.print();

        // String array
        String[] strArray = { "Java", "Python", "C++" };
        DataViewer<String> strViewer = new DataViewer<>(strArray);
        System.out.println("\nString Data:");
        strViewer.print();

        // Double array
        Double[] doubleArray = { 10.5, 20.7, 30.9 };
        DataViewer<Double> doubleViewer = new DataViewer<>(doubleArray);
        System.out.println("\nDouble Data:");
        doubleViewer.print();
    }
}
