package com.arroba.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CreateAccount {
    public static void registerUser(String email, String nacionalidade, String nome, char[] senha, String sexo, String sobrenome, String telefone, String nascimento, Auth auth){

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
            String sql = "INSERT INTO User (codUser, nome, sobrenome, email, senha, telefone, sexo, nascimento, nacionalidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);

            //Lista todos os usuários, pega o último e o codigo do ultimo e soma mais um para a criacao do proximo
            ListAllUsers listUser = new ListAllUsers(auth);
            List<User> users = listUser.getUsers();
            User lastUser = users.get(users.size()-1);
            Integer lastNumber = lastUser.getCodUser();
            Integer codUser = lastNumber + 1;

            // Definir os parâmetros
            statement.setInt(1, codUser);
            statement.setString(2, nome);
            statement.setString(3, sobrenome);
            statement.setString(4, email);
            statement.setString(5, new String(senha));
            statement.setString(6, telefone);
            statement.setString(7, sexo);
            statement.setString(8, nascimento);
            statement.setString(9, nacionalidade);

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
