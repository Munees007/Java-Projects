import models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionTrackingExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Open session
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Student s1 = new Student("Munees", "MCA");
        session.save(s1);

        t.commit();
        System.out.println("Data saved successfully!");

        // Track session state
        System.out.println("Is session open? " + session.isOpen());

        session.close();
        System.out.println("Is session closed? " + !session.isOpen());
        factory.close();
    }
}
