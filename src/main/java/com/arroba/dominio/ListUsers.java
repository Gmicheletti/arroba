package com.arroba.dominio;


import jakarta.persistence.EntityManager;

import java.util.List;

public class ListUsers {
    private List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public ListUsers(AuthDB auth) {

        EntityManager entityManager = auth.entityManagerFactory.createEntityManager();
        this.users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }



}



