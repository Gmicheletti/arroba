package com.arroba.dominio;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ListAllUsers {
    private List<User> users;

    public ListAllUsers(Auth auth) {

        EntityManager entityManager = auth.entityManagerFactory.createEntityManager();
        this.users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public List<User> getUsers() {
        return users;
    }


}



