package com.arroba.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class arrobaUI extends JFrame {

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

    public arrobaUI(){

        divCredential.setLayout(new GridLayout(2, 1));
        divCredential.setBackground(new Color(255, 255, 255));
        divCredential.add(divUser);
        divCredential.add(divPassword);

        divBtns.setLayout(new GridLayout(2, 2, 20, 25));
        divBtns.setBackground(new Color(255, 255, 255));
        divBtns.add(loginButton);
        divBtns.add(loginCreateAccount);


        divUser.setBackground(new Color(255, 255, 255));
        divUser.add(loginPlaceHolderUser);
        divUser.add(loginUserName);
        loginUserName.setColumns(20);

        divPassword.setBackground(new Color(255, 255, 255));
        divPassword.add(loginPlaceHolderPassword);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        sectionLogin.setLayout(new GridLayout(3, 3, 20, 25));
        sectionLogin.setBackground(new Color(255, 255, 255));
        sectionLogin.add(logoArroba);
        sectionLogin.add(divCredential);
        sectionLogin.add(divBtns);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionLogin);



        this.setTitle("arrob@");
        this.setSize(1100,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                body.setVisible(false);
            }
        });


    }


    public static void main(String[] args) {
        new arrobaUI();
    }

}
