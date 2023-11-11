package com.arroba.dominio;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Arroba {
    private List<User> listaUser = new LinkedList<>();

    //Metodo para registrar novos usuários
    public static void registerUser() {
        Scanner scn = new Scanner(System.in);
        LinkedList<User> userList = new LinkedList<>();

        // Criar um novo objeto User e registre as informações do usuário.
        User user = new User();

        // Adicionar o objeto User à lista encadeada.
        userList.add(user);

        // UserList contém o objeto User inserido pelo usuário.

        System.out.print("Nome: ");
        user.setNome(scn.nextLine());

        System.out.print("Email: ");
        user.setEmail(scn.nextLine());

        System.out.print("Senha: ");
        user.setSenha(scn.nextLine());

        System.out.print("Data de Nascimento: ");
        user.setNascimento(scn.nextLine());

        System.out.println("Usuário c2astarado com sucesso.");

    }
    public boolean checkUser(String email, String senha, LinkedList<User> userList) {
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getSenha().equals(senha)) {
                return true; // Encontrou um usuário correspondente
            }
        }
        return false; // Não encontrou um usuário correspondente
    }


    //Método para verificar o login
    public static boolean checkUserlogin() {
        LinkedList<User> userList = new LinkedList<>();

        String emailCheck;
        String senhaCheck;

        Scanner scn = new Scanner(System.in);

        System.out.print("Email: ");
        emailCheck = scn.nextLine();

        System.out.print("Senha: ");
        senhaCheck = scn.nextLine();

        User user = new User();
        boolean userExists = user.checkUser();

        if (userExists) {
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Email e/ou senha incorretos. Tente novamente.");
        }

        return userExists;
    }

    public static void main(String[] args) {
        //Tela inicial
        int opcao;
        Scanner scn = new Scanner(System.in);

        System.out.println("+++TELA INICIAL+++");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Fazer login");
        System.out.println("********************");
        System.out.println("Digite a opção desejada: ");
        opcao = scn.nextInt();

        switch (opcao) {
            case 1:
                registerUser();
                break;
            case 2:
                checkUserlogin();
                break;
        }
    }





}
