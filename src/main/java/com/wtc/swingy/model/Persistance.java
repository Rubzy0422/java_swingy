package com.wtc.swingy.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;


public final class Persistance <T> {
    private static EntityManagerFactory factory;
    public javax.persistence.EntityManager em;


    public Persistance()
    {
        factory = Persistence.createEntityManagerFactory("puapi");
        em = factory.createEntityManager();
    }

    public void CompletePersist() {
        if (em != null) {
            
            em.close();
        }
        if (factory != null) {
            factory.close();
        }
    }


    public void SaveEntity(final T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        // em.flush();
        try {
            em.getTransaction().commit();
        }
        catch (RollbackException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(final T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (final Exception ex)
        {         
            System.out.println("ERRPOR Removing entity:" + ex);
            System.exit(-1);
        }
    }
}
