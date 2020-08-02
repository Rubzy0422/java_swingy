package com.wtc.swingy.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager<T> {
    public static javax.persistence.EntityManager em;
    private static EntityManagerFactory factory;

    public EntityManager() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("puapi");
            em = factory.createEntityManager();
        }
    };

    public void close() {
        em.close();
        factory.close();
    }

    public void CreateField(T object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
}
