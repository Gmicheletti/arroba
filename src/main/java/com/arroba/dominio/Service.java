package com.arroba.dominio;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;

public class Service {
    private EntityManagerFactory factory;
    private User currentUser;
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("arrob@-PU");
    }
    public Service() {
    }

    public Service(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
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

    public User loginUser(String email, char[] senha) {
        try (var em = factory.createEntityManager()) {
            var user = em.find(User.class, email);

            if (user != null && user.checkPassword(senha)) {
                return user;
            } else {
                // Email ou senha incorretos
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Lida com exceções, por exemplo, relacionadas ao EntityManager
            return null;
        }


    }



}
