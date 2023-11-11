package com.arroba.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;
@Entity
public class User {
    @Id
    private Integer codUser;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Integer telefone;
    private char sexo;
    private String nascimento;
    private String nacionalidade;

    public User() {
    }

    public User(Integer codUser,String nome, String sobrenome, String email, String senha, Integer telefone, char sexo, String nascimento, String nacionalidade) {

        this.codUser = codUser;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

//    public Date getNascimento() {
//        return nascimento;
//    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
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
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone=" + telefone +
                ", sexo=" + sexo +
                ", nascimento=" + nascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
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
