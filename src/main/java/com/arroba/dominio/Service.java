package com.arroba.dominio;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
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

    return currentUser;
}

    // TODO: 20/11/23 Não pode aparecer os usuários que já são amigos
    public List<User> AllUser(User currentUser){
        var em = factory.createEntityManager();
        String jpql = "SELECT u FROM User u WHERE u <> :currentUser";
        Query query = em.createQuery(jpql, User.class);
        query.setParameter("currentUser", currentUser);

        List<User> userList = query.getResultList();

        return userList;

    }

    public List<User> ListUsersFriends(User currentUser){
        var em = factory.createEntityManager();

        List<User> userList = currentUser.getAmizade();

        return userList;

    }

    // TODO: 20/11/23 Está duplicando a amizade quando se adiciona uma segunda pessoa
    public void addFriend(User currentUser, User friend){
        var em = factory.createEntityManager();

        em.getTransaction().begin();
        currentUser.addAmizade(friend);

        currentUser = em.merge(currentUser);

        em.persist(currentUser);
        em.getTransaction().commit();
        em.close();

    }

    // TODO: 20/11/23 Não está removendo o registro de amizade para os dois usuarios
    public void removeFriend(User currentUser, User friend){
        var em = factory.createEntityManager();

        em.getTransaction().begin();
        currentUser.getAmizade().remove(friend);
        friend.getAmizade().remove(currentUser);
        em.merge(currentUser);
        em.merge(friend);
        em.getTransaction().commit();
        em.close();
    }

    // TODO: 20/11/23 Criar condição para que se o chat ja estiver criado, nao criar outro e só levar o usuario para o chat existente
    public Chat openCreateChat(User currentUser, User friend){
        var em = factory.createEntityManager();

        Chat newChat = new Chat(null, currentUser, friend);

        em.getTransaction().begin();
        em.persist(newChat);
        em.getTransaction().commit();

        return newChat;
    }

    // TODO: 20/11/23 Terminar o listar chat pelo currentUser logado, ele atualmente vai puxar todos os chats 
    public List<Chat> listChats(){
        var em = factory.createEntityManager();
        String jpql = "SELECT c FROM Chat c";
        Query query = em.createQuery(jpql, Chat.class);
        List<Chat> chatList = query.getResultList();
        return chatList;
    }
    public List<Message> listMessageChat(Integer codChat){
        var em = factory.createEntityManager();
        String jpql = "SELECT m FROM Message m WHERE m.chat.codChat = :codChat";
        Query query = em.createQuery(jpql, Message.class);
        query.setParameter("codChat", codChat);

        List<Message> messages = query.getResultList();

        return messages;
    }

    // TODO: 20/11/23 Revisar codigo, pois nao deixa enviar mais de uma mensagem por chat, retorna que o codigo do chat nao pode ser duplicado por que é uma FK unica 
    public Message sendMessage(Chat chat, String descMessage, User currentUser){
        var em = factory.createEntityManager();

        Message novaMensagem = new Message();
        novaMensagem.setRemetente(currentUser);
        novaMensagem.setChat(chat);
        novaMensagem.setDescMensagem(descMessage);

        em.getTransaction().begin();
        em.persist(novaMensagem);
        em.getTransaction().commit();

        return novaMensagem;
    }

}
