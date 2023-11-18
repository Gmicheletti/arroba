package com.arroba.dominio;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;



@Entity
@Table(name = "@_user")
public class User {
    @Id
    @Column(name = "codUser", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUser;
    private String nome;
    private String email;
    private String senha;

    @OneToMany
    @JoinColumn(name = "codAmigos")
    private List<User> amizade;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codChats")
    private List<Chat> chat;

    public User() {

    }

    public User(Integer codUser, String nome, String email, char[] senha) {
    }

    public User(Integer codUser, String nome, String email, String senha) {
        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(Integer codUser, String nome, String email, String senha, List<User> amizade, List<Chat> chat) {
        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.amizade = amizade;
        this.chat = chat;
    }



    public Integer getCodUser() {
        return codUser;
    }

    public void setCodUser(Integer codUser) {
        this.codUser = codUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<User> getAmizade() {
        return amizade;
    }

    public void setAmizade(List<User> amizade) {
        this.amizade = amizade;
    }

    public List<Chat> getChat() {
        return chat;
    }

    public void setChat(List<Chat> chat) {
        this.chat = chat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha);
    }


    @Override
    public String toString() {
        return "User{" +
                "codUser=" + codUser +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", amizade=" + amizade +
                ", chat=" + chat +
                '}';
    }
}
