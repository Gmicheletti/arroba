package com.arroba.dominio;

import java.util.Objects;

public class User {
    private String nome;
    private String nascimento;
    private String email;
    private String senha;
    private User amigo;


    public User() {
    }

    public User(String nome, String email, String senha, String nascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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
                "nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public boolean checkUser() {
        User[] userList = new User[0];
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return true; // Encontrou um usuário correspondente
            }
        }
        return false; // Não
    }
}
