package com.arroba.dominio;

import com.arroba.ui.HomeUI;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class Service {
    private EntityManagerFactory factory;
    private User currentUser;
    public void setUp() {
        factory = Persistence.createEntityManagerFactory("arrob@-PU");
    }

    public Service() {
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
        var em = factory.createEntityManager();

        String jpql = "SELECT u FROM User u WHERE u.email = :email";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("email", email);

        User user = (User) query.getSingleResult();

        boolean checkPassword = Arrays.equals(senha, user.getSenha());

        if (user != null && checkPassword) {
            this.setCurrentUser(user);
            return user;

        } else {
            // Email ou senha incorretos
            return null;
        }


    }

    public User UpdateCurrentUser(String nome, String email, char[]  senha, User currentUser){
    var em = factory.createEntityManager();
    currentUser.setNome(nome);
    currentUser.setEmail(email);
    currentUser.setSenha(senha);

    em.getTransaction().begin();
    currentUser = em.merge(currentUser);
    em.getTransaction().commit();
    em.close();

    HomeUI homeUI = new HomeUI(currentUser);

    return currentUser;
}

    public List<User> AllUser(User currentUser){
        var em = factory.createEntityManager();
        String jpql = "SELECT u FROM User u WHERE u <> :currentUser";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("currentUser", currentUser);

        List<User> userList = query.getResultList();

        return userList;

    }
    public void addFriend(User currentUser, User friend){
        var em = factory.createEntityManager();
        List<User> amizade = currentUser.getAmizade();
        var amizade1 = amizade.add(friend);
        var amizade2 = friend.getAmizade().add(currentUser); // Adiciona o usuário atual à lista de amigos do amigo

            em.getTransaction().begin();
            em.persist(amizade1);
//            em.persist(amizade2);
            em.getTransaction().commit();
            em.close();
    }





}
