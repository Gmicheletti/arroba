package com.arroba.dominio;

import jakarta.persistence.*;


import java.util.Arrays;
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
    private char[] senha;
    @OneToMany
    private List<User> amizade;


    public User() {

    }
    public User(Integer codUser, String nome, String email, char[] senha) {
        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public User(Integer codUser, String nome, String email, char[] senha, List<User> amizade) {
        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.amizade = amizade;
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

    public char[] getSenha() {
        return senha;
    }

    public void setSenha(char[] senha) {
        this.senha = senha;
    }

    public List<User> getAmizade() {
        return amizade;
    }

    public void setAmizade(List<User> amizade) {
        this.amizade = amizade;
    }
    public boolean checkPassword(char[] password) {
        String senhaDigitada = new String(password);
        return senhaDigitada.equals(senha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Arrays.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(email);
        result = 31 * result + Arrays.hashCode(senha);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "codUser=" + codUser +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", amizade=" + amizade +
                '}';
    }
}
