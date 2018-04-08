package core;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class P02_Remove_Objects {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        // persist all towns from the DB
        List<Town> townsList = em.createQuery("SELECT t FROM Town AS t").getResultList();

        for (Town town : townsList) {
            if (town.getName().length() > 5) {
                em.detach(town);
            }
        }
        em.getTransaction().begin();
        for (Town town : townsList) {
            if (em.contains(town)) {
                town.setName(town.getName().toLowerCase());
                em.persist(town);
            }
        }
        em.getTransaction().commit();

        em.close();
        factory.close();
    }
}