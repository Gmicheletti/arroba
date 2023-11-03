package com.arroba.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionLogin = new JPanel();
    private JPanel divCredential = new JPanel();
    private JPanel divUser = new JPanel();
    private JPanel divPassword = new JPanel();
    private JPanel divBtns = new JPanel();
    private JLabel loginPlaceHolderUser= new JLabel("Usuário");
    private JTextField loginUserName = new JTextField();
    private JLabel loginPlaceHolderPassword = new JLabel("Senha");
    private JPasswordField loginPassword = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    private JButton loginCreateAccount = new JButton("Criar conta");

    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/logorz.png"));    //LOGOS DO SISTEMA



    public static void main(String[] args) {
        new LoginUI();
    }
    public LoginUI(){

        Color color = new Color(220, 223, 255);

        divUser.setBackground(color);
        divUser.add(loginPlaceHolderUser);
        divUser.add(loginUserName);
        loginUserName.setColumns(20);

        divPassword.setBackground(color);
        divPassword.add(loginPlaceHolderPassword);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        divCredential.setLayout(new GridLayout(2, 1));
        divCredential.setBackground(color);
        divCredential.add(divUser);
        divCredential.add(divPassword);

        divBtns.setLayout(new GridLayout(2, 2, 20, 15));
        divBtns.setBackground(color);
        divBtns.add(loginButton);
        divBtns.add(loginCreateAccount);


        sectionLogin.setLayout(new GridLayout(3, 3, 20, 25));
        sectionLogin.setBackground(color);
        sectionLogin.add(logoArroba);
        sectionLogin.add(divCredential);
        sectionLogin.add(divBtns);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(color);
        body.add(sectionLogin);



        this.setTitle("arrob@ - Login");
        this.setSize(500,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                index();
            }
        });


        loginCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
    }

    private void index() {
        HomeUI homeUI = new HomeUI();
        dispose();
    }


    private void createAccount() {
        CreateAccountUI createAccountUI = new CreateAccountUI();
        dispose();
    }




}
