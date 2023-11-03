package com.arroba.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionHome = new JPanel(new BorderLayout());
    private JPanel divMenu = new JPanel();
    private JPanel divContent = new JPanel();
    private JLabel jLabelTitulo = new JLabel("Bem-vindo, Nome Usuário"); //MENSAGEM
    private JButton homeButton = new JButton("Home");
    private JButton perfilButton = new JButton("Meu Perfil");
    private JButton msgButton = new JButton("Mensagens");
    private JButton listUsereButton = new JButton("Meus amigos");
    private JButton findUsereButton = new JButton("Buscar Usuários");
    private JButton deleteAccountUsereButton = new JButton("Deletar Contar");
    private JButton logoutButton = new JButton("Logout");

    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/arrobaicon.png"));    //LOGOS DO SISTEMA



    public static void main(String[] args) {
        new HomeUI();
    }
    public HomeUI(){

        Color color = new Color(220, 223, 255);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(20);
        divMenu.setLayout(layout);
        divMenu.setPreferredSize(new Dimension(200, 0));
        divMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
        divMenu.setBackground(color);

        divMenu.add(logoArroba).setPreferredSize(new Dimension(100, 100));
        divMenu.add(jLabelTitulo);
        jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        divMenu.add(homeButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(perfilButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(msgButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(listUsereButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(findUsereButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(deleteAccountUsereButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(logoutButton).setPreferredSize(new Dimension(150, 35));

        sectionHome.add(divMenu, BorderLayout.WEST);
        sectionHome.add(divContent, BorderLayout.CENTER);

        body.setLayout(new GridLayout(1, 1, 20, 0));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionHome);

        this.setTitle("arrob@ - Home");
        this.setSize(1100,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             homeButton();
            }

        });
        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perfilButton();
            }

        });
        msgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgButton();
            }
        });
        listUsereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUsereButton();
            }
        });
        findUsereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findUsereButton();
            }
        });
        deleteAccountUsereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccountUsereButton();
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logoutButton();
            }
        });

    }
    public void homeButton() {
        divContent.setBackground(new Color(245, 0, 0));
    }
    private void perfilButton() {
        divContent.setBackground(new Color(11, 171, 39));
    }
    private void msgButton() {
        divContent.setBackground(new Color(42, 15, 131));
    }
    private void listUsereButton() {
        divContent.setBackground(new Color(250, 162, 2));
    }
    private void findUsereButton() {
        divContent.setBackground(new Color(188, 2, 250));
    }
    private void deleteAccountUsereButton() {
        divContent.setBackground(new Color(2, 250, 192));
    }
    private void logoutButton() {
        LoginUI loginUI = new LoginUI();
        dispose();
    }






}
