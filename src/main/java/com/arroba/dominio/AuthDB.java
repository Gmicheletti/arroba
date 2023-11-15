package com.arroba.dominio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AuthDB {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arrob@-PU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


}


