package com.wtc.swingy.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Persistance {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("puapi");
    public static javax.persistence.EntityManager em = factory.createEntityManager();


    public void stopfactory() {
        if (em != null) {
            em.close();
        }
        if (factory != null) {
            factory.close();
        }
    }


    public static <T> void SaveEntity(final T entity) {
        try {
            System.out.println("SAVE ENTITY");
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();

            // em.flush();
        } catch (final Exception ex) {
            System.out.println("ERRPOR SAVING entity:" + ex);
            System.exit(-1);
        }
    }

    public static <T> void delete(final T entity) {
        try {

            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();

            // em.flush();
        } catch (final Exception ex)
        {         
            System.out.println("ERRPOR Removing entity:" + ex);
            System.exit(-1);
        }
    }
}
