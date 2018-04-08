package core;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P04_Employees_with_Salary_Over_50k {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        String query = "SELECT e FROM Employee AS e WHERE e.salary > 50000";

        List<Employee> employees = em.createQuery(query).getResultList();
        for (Employee empl : employees) {
            System.out.println(empl.getFirstName());
        }

        em.close();
        factory.close();
    }
}
