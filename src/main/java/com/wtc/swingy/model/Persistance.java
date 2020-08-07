package com.wtc.swingy.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;


public final class Persistance <T> {
    private static EntityManagerFactory factory;
    public javax.persistence.EntityManager em;


    public Persistance()
    {
        try {
            factory = Persistence.createEntityManagerFactory("puapi");
            em = factory.createEntityManager();
        }
        catch (Exception ex) {
            System.err.println("ERROR Creating Factory: " + ex.getMessage());
           System.exit(-1);
        }
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
            System.err.println(ex.getMessage());
            System.err.println(ex.getCause().getMessage());
        }
    }

    public void delete(final T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (final Exception ex)
        {         
            System.err.println("ERRPOR Removing entity:" + ex);
        }
    }
}
