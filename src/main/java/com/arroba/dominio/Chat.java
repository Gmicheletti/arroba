package com.arroba.dominio;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Chat {
    @Id
    private Integer idChat;
    @OneToMany
    private List<Message> Mensagens;
    @ManyToMany
    private List<User> User;
}
