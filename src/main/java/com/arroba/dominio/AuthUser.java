package com.arroba.dominio;

import com.arroba.ui.HomeUI;

import java.util.Arrays;
import java.util.List;

public class AuthUser {

    public boolean checkUser(String email, char[] senha, AuthBD auth) {

        ListAllUsers listUser = new ListAllUsers(auth);
        List<User> users = listUser.getUsers();
        for (User user : users) {

            if (user.getEmail().equals(email) && Arrays.equals(user.getSenha(), senha)) {
                HomeUI homeUI = new HomeUI(auth);
                return true; // Encontrou um usuário correspondente
            }
        }
        return false; // Não encontrou um usuário correspondente
    }


}
