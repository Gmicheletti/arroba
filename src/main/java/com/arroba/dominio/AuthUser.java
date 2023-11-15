package com.arroba.dominio;

import com.arroba.ui.HomeUI;

import java.util.Arrays;
import java.util.List;

public class AuthUser {

    private List<User> users;

    User currentUser;
    public boolean checkUser(String email, char[] senha, AuthDB auth) {

        ListUsers listUser = new ListUsers(auth);
        List<User> users = listUser.getUsers();

        for (User user : users) {
            if (user.getEmail().equals(email) && Arrays.equals(user.getSenha().toCharArray(), senha)) {
                currentUser = user;
                HomeUI homeUI = new HomeUI(auth, currentUser);
                return true; // Encontrou um usuário correspondente
            }
        }
        return false; // Não encontrou um usuário correspondente

    }

}
