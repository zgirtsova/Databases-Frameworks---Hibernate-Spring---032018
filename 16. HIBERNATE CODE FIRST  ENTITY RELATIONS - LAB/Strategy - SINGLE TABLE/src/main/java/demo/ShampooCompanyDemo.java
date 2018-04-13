package demo;

import model.AmmoniumChloride;
import model.BasicIngredient;
import model.Mint;
import model.Nettle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class ShampooCompanyDemo {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ShampooSingleTable");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        BasicIngredient mint = new Mint();
        BasicIngredient nettle = new Nettle();
        BasicIngredient amm = new AmmoniumChloride();

        em.persist(mint);
        em.persist(nettle);
        em.persist(amm);

        List<BasicIngredient> bas = em.createQuery("FROM BasicIngredient bi").getResultList();
        bas.forEach(bi -> System.out.println(bi.getName()));




        em.getTransaction().commit();
        em.close();
    }
}
