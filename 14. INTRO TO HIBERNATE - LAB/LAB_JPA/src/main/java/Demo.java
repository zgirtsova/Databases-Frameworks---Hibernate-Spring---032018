import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //retrieve single entity
        Teacher t = new Teacher("Teo", LocalDate.now());
        em.persist(t);


        //delete object
        Teacher te = new Teacher("Teodor", LocalDate.now());
        em.remove(te);



        em.getTransaction().commit();
    }

}


