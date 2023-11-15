package com.arroba.dominio;


import jakarta.persistence.EntityManager;

import java.util.List;

public class ListAllUsers {
    private List<User> users;

    public ListAllUsers(AuthBD auth) {

        EntityManager entityManager = auth.entityManagerFactory.createEntityManager();
        this.users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public List<User> getUsers() {
        return users;
    }


}



