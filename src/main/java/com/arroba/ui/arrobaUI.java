package com.arroba.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class arrobaUI extends JFrame {

    //ELEMENTS LOGIN

    private JPanel windowLogin = new JPanel();
    private JPanel divCredential = new JPanel();
    private JPanel divUser = new JPanel();
    private JPanel divPassword = new JPanel();
    private JLabel loginPlaceHolderUser= new JLabel("Usuário");
    private JTextField loginUserName = new JTextField();

    private JLabel loginPlaceHolderPassword = new JLabel("Senha");
    private JPasswordField loginPassword = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton loginCreateAccount = new JButton("Criar conta");




    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/logorz.png"));    //LOGOS DO SISTEMA

    public arrobaUI(){

        this.setTitle("arrob@");
        this.setSize(600,600);


        windowLogin.setLayout(new FlowLayout(FlowLayout.CENTER,200,50));
        windowLogin.setBackground(new Color(255, 255, 255));
        divUser.setBackground(new Color(255, 255, 255));
        divPassword.setBackground(new Color(255, 255, 255));
        divCredential.setBackground(new Color(255, 255, 255));

        windowLogin.add(logoArroba);

        loginUserName.setColumns(20);
        divUser.add(loginPlaceHolderUser);
        divUser.add(loginUserName);

        loginPassword.setColumns(20);
        divPassword.add(loginPlaceHolderPassword);
        divPassword.add(loginPassword);

        divCredential.add(divUser);
        divCredential.add(divPassword);
        windowLogin.add(divCredential);

        windowLogin.add(loginButton);
        windowLogin.add(loginCreateAccount);

        this.getContentPane().add(windowLogin);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowLogin.setVisible(false);
            }
        });


    }


    public static void main(String[] args) {
        new arrobaUI();
    }

}
