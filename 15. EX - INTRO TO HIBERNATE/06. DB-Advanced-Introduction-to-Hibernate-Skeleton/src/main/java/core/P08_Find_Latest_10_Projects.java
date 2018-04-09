package core;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;

public class P08_Find_Latest_10_Projects {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery = "SELECT p FROM Project AS p ORDER BY p.startDate DESC";
        List<Project> projects = entityManager.createQuery(hqlQuery).setMaxResults(10).getResultList();

        projects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> {
                    System.out.println(String.format("Project name: %s", p.getName()));
                    System.out.println(String.format("        Project Description: %s", p.getDescription()));
                    System.out.println(String.format("        Project Start Date: %s", p.getStartDate()));
                    System.out.println(String.format("        Project End Date: %s", p.getEndDate()));
                });
        entityManager.close();
        factory.close();
    }
}
