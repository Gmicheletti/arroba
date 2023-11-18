package com.arroba.dominio;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Service {
    private EntityManagerFactory factory;
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("arrob@-PU");
    }


    public User cadastrarUser(String nome, String email, char[] senha){
        var em = factory.createEntityManager();

            User user = new User(null, nome, email, senha);

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();

            return user;

    }


}
