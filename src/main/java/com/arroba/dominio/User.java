package com.arroba.dominio;


import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;
@Entity
public class User {
@Id
    private Integer codUser;
    private String nome;
    private String email;
    private String senha;
    @OneToMany
    private List<User> listFriends;

    public User() {
    }

    public User(String nome, String email, String senha) {

        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;

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

    public void setNome(String s) {
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
                ", senha='" + senha + '\'' +
                '}';
    }


}
