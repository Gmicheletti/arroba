package com.arroba.dominio;

import com.arroba.ui.HomeUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class AccountUpdate {
    public static void updateUser(String nome, String email, char[] senha, User currentUser, AuthDB auth){

        //Começa com a conexão nula com o banco
        Connection conn = null;
        PreparedStatement statement = null;
        int codUser = currentUser.getCodUser();

        try {
            // Estabelecer a conexão com o banco de dados
            String url = "jdbc:mysql://srv485.hstgr.io:3306/u914202645_arroba";
            String user = "u914202645_arrootba";
            String password = "12118855Arroba";
            conn = DriverManager.getConnection(url, user, password);

            String updateSql = "UPDATE User SET nome=?, email=?, senha=? WHERE codUser=?";
            statement = conn.prepareStatement(updateSql);
            statement.setString(1, nome);
            statement.setString(2, email);
            statement.setString(3, new String(senha));
            statement.setInt(4, codUser);

            // Executar a inserção
            statement.executeUpdate();


             ListUsers listUser = new ListUsers(auth);
             List<User> users = listUser.getUsers();

            for (User currentUsers : users) {
                if (currentUsers.getEmail().equals(email) && Arrays.equals(currentUsers.getSenha().toCharArray(), senha)) {
                    currentUser = currentUsers;
                    HomeUI homeUI = new HomeUI(auth, currentUser);
                }
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar os recursos mesmo se uma exceção ocorrer
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
