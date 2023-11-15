package com.arroba.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AccountCreate {
    public static void registerUser(String email, String nome, char[] senha, String telefone, AuthDB auth){

        //Começa com a conexão nula com o banco
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            // Estabelecer a conexão com o banco de dados
            String url = "jdbc:mysql://srv485.hstgr.io:3306/u914202645_arroba";
            String user = "u914202645_arrootba";
            String password = "12118855Arroba";
            conn = DriverManager.getConnection(url, user, password);

            // Preparar a declaração SQL com um PreparedStatement
            String sql = "INSERT INTO User (codUser, nome, email, senha) VALUES (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);

            //Lista todos os usuários, pega o último e o codigo do ultimo e soma mais um para a criacao do proximo
            ListUsers listUser = new ListUsers(auth);
            List<User> users = listUser.getUsers();

            int codUser;

            if(users.size() > 0){
                User lastUser = users.get(users.size()-1);
                Integer lastNumber = lastUser.getCodUser();
                codUser = lastNumber + 1;
            }else{
                codUser = 1;
            }

            // Definir os parâmetros

            statement.setInt(1, codUser);
            statement.setString(2, nome);
            statement.setString(3, email);
            statement.setString(4, new String(senha));

            // Executar a inserção
            statement.executeUpdate();


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
