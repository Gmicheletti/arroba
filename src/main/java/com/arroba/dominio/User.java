package com.arroba.dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class User {

    private Integer codUser;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String nascimento;
    private String nacionalidade;
    private LinkedList<User> amizade = new LinkedList<>();


    public User() {
    }

    public User(String nome, String email, String senha, String telefone, String nascimento, String nacionalidade) {

        this.codUser = codUser;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
//        this.amigo = new LinkedList<>();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<User> getAmigo() {
        return amizade;
    }

    public void setAmigo(LinkedList<User> amizade) {
        this.amizade = amizade;
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
                ", telefone=" + telefone +
                ", nascimento='" + nascimento + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
//                ", amigo=" + amigo +
                '}';
    }

    public void addFriend(User amigo) {
        amizade.add(amigo);
    }

    public void removeAmigo(User amigo) {
        amigo.removeAmigo(amigo);
    }
}
