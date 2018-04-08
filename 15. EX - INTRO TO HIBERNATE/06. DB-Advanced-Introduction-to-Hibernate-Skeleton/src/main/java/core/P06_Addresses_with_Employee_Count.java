package core;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P06_Addresses_with_Employee_Count {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        String hqlQuery =
                "SELECT a FROM Address AS a " +
                        "ORDER BY size(a.employees) DESC, a.town.id ASC";
        List<Address> addresses = entityManager.createQuery(hqlQuery).setMaxResults(10).getResultList();

        addresses.forEach(a -> {
            System.out.println(String.format("%s, %s - %d employees",
                    a.getText(), a.getTown().getName(), a.getEmployees().size()));
        });

        entityManager.close();
        factory.close();
    }
}