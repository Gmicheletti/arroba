package com.arroba.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateAccountUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionCreateAccount = new JPanel();
    private JLabel jLabelTitulo = new JLabel("Cadastre-se. É rápido e fácil."); //MENSAGEM
    private JPanel divCredential = new JPanel();
    private JPanel divName = new JPanel();
    private JPanel divDate = new JPanel();
    private JPanel divEmail = new JPanel();
    private JPanel divPassword = new JPanel();
    private JPanel divBtns = new JPanel();
    private JLabel loginPlaceHolderName= new JLabel("Nome");
    private JTextField loginUserName = new JTextField();
    private JLabel loginPlaceHolderDate= new JLabel("Data Nascimento");
    private JTextField loginUserDate = new JTextField();
    private JLabel loginPlaceHolderEmail= new JLabel("Email");
    private JTextField loginUserEmail = new JTextField();
    private JLabel loginPlaceHolderPassword = new JLabel("Senha");
    private JPasswordField loginPassword = new JPasswordField();
    private JButton createButton = new JButton("Criar Conta");
    private JButton previousButton = new JButton("Voltar");

    JLabel logoAccount = new JLabel(new ImageIcon("./src/main/resources/img/createaccount.png"));    //LOGOS DO SISTEMA



    public static void main(String[] args) {
        new CreateAccountUI();
    }
    public CreateAccountUI(){

        divName.setBackground(new Color(255, 255, 255));
        divName.add(loginPlaceHolderName);
        divName.add(loginUserName);
        loginUserName.setColumns(20);

        divDate.setBackground(new Color(255, 255, 255));
        divDate.add(loginPlaceHolderDate);
        divDate.add(loginUserDate);
        loginUserDate.setColumns(14);

        divEmail.setBackground(new Color(255, 255, 255));
        divEmail.add(loginPlaceHolderEmail);
        divEmail.add(loginUserEmail);
        loginUserEmail.setColumns(20);

        divPassword.setBackground(new Color(255, 255, 255));
        divPassword.add(loginPlaceHolderPassword);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        divCredential.setLayout(new GridLayout(4, 1));
        divCredential.setBackground(new Color(255, 255, 255));
        divCredential.add(divName);
        divCredential.add(divDate);
        divCredential.add(divEmail);
        divCredential.add(divPassword);

        divBtns.setLayout(new GridLayout(3, 2, 10, 15));
        divBtns.setBackground(new Color(255, 255, 255));
        divBtns.add(createButton);
        divBtns.add(previousButton);

        sectionCreateAccount.setLayout(new GridLayout(3, 3, 20, 25));
        sectionCreateAccount.setBackground(new Color(255, 255, 255));
        sectionCreateAccount.add(logoAccount);
        sectionCreateAccount.add(divCredential);
        sectionCreateAccount.add(divBtns);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionCreateAccount);



        this.setTitle("arrob@ - Criar Conta");
        this.setSize(500,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI loginUI = new LoginUI();
                dispose();
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUI = new HomeUI();
                dispose();
            }
        });



    }


}
