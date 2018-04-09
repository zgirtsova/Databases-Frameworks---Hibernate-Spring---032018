package core;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class P07_Get_Employee_with_Projects {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        System.out.println("Enter employee ID: ");
        int employeeID = Integer.parseInt(reader.readLine());

        String hqlQuery = "SELECT e FROM Employee AS e WHERE e.id = " + employeeID;
        // takes one single employee - could throw Exception if there is more than one
        Employee e = (Employee) entityManager.createQuery(hqlQuery).getSingleResult();

        System.out.println(String.format("%s %s - %s", e.getFirstName(), e.getLastName(), e.getJobTitle()));
        // Stream on employee's projects, which are a Set
        e.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.println(String.format("      %s", p.getName()));
                });


        entityManager.close();
        factory.close();
    }
}
