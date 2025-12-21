import helpers.SendNotification;
import java.util.ArrayList;
import java.util.List;
import models.Staff;
import models.Student;

public class App {
    public static void main(String[] args) throws Exception {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Munees", "25PCA139", "MCA"));
        students.add(new Student("Karthik", "25PCA137", "MCA"));
        
        List<Staff> staffs = new ArrayList<>();

        staffs.add(new Staff("TJ", "SF096", "BCA"));
        staffs.add(new Staff("RV", "SF054", "MCA"));

        SendNotification<Student> studentNotification = new SendNotification<>(students, "Hello Students this is Pricipal");
        studentNotification.send();
        SendNotification<Staff> staffNotification = new SendNotification<>(staffs, "Hello Faculties this is Pricipal");
        staffNotification.send();
    }
}
