import entities.Student;
import entities.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;


public class DemoPojo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Teacher joro = new Teacher("Joro", LocalDate.parse("2018-03-17"));
        session.save(joro);
        Teacher ivan = new Teacher("Ivan", LocalDate.parse("2018-03-18"));
        session.save(ivan);
        Teacher raya = new Teacher("Raya", LocalDate.parse("2018-03-19"));
        session.save(raya);
        Teacher gaya = new Teacher("Gaya", LocalDate.parse("2018-03-20"));
        session.save(gaya);

        // retrieve data by query
        List<Student> studentList = session.createQuery("FROM Student ").list();

        for(Student st : studentList) {
            System.out.println(st.toString());
        }

         // retrieve Student from DB by get method
        Student ex = session.get(Student.class, 3);
        System.out.println(ex);


        session.getTransaction().commit();
        session.close();

    }
}
