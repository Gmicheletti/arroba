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
    private JLabel jLabelPageHome = new JLabel(""); //MENSAGEM
    private JButton homeButton = new JButton("Home");
    private JButton perfilButton = new JButton("Meu Perfil");
    private JButton msgButton = new JButton("Mensagens");
    private JButton listUsereButton = new JButton("Meus amigos");
    private JButton findUsereButton = new JButton("Buscar Usuários");
    private JButton deleteAccountUsereButton = new JButton("Deletar Conta");
    private JButton logoutButton = new JButton("Logout");
    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/arrobaicon.png"));    //LOGOS DO SISTEMA

    public static void main(String[] args) {
        new HomeUI();
    }
    public HomeUI(){

        homeButton();//INICIA A PAGINA COM O SECTION HOME VISIVEL
        menu();//METODO RESPONSAVEL POR CONSTRUIR O MENU

        divContent.setBackground(new Color(255, 255, 255));
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

        //BOTOES
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

    //METODOS
    private void menu() {//METODO RESPONSAVEL POR CONSTRUIR O MENU

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(20);
        divMenu.setLayout(layout);
        divMenu.setPreferredSize(new Dimension(200, 0));
        divMenu.setBorder(new EmptyBorder(10, 10, 10, 10));
        divMenu.setBackground(new Color(220, 223, 255));

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
    }
    private void homeButton() {

        divContent.removeAll();
        divContent.revalidate();
        jLabelPageHome.setText("Home");

        divContent.add(jLabelPageHome);


    }
    private void perfilButton() {

        divContent.removeAll();
        divContent.revalidate();

        jLabelPageHome.setText("Meu Perfil");

        divContent.add(jLabelPageHome);

    }
    private void msgButton() {

        divContent.removeAll();
        divContent.revalidate();

        jLabelPageHome.setText("Mensagens");

        divContent.add(jLabelPageHome);

    }
    private void listUsereButton() {

        divContent.removeAll();
        divContent.revalidate();

        jLabelPageHome.setText("Meus amigos");

        divContent.add(jLabelPageHome);

    }
    private void findUsereButton() {

        divContent.removeAll();
        divContent.revalidate();

        jLabelPageHome.setText("Buscar Usuários");

        divContent.add(jLabelPageHome);

    }
    private void deleteAccountUsereButton() {

        divContent.removeAll();
        divContent.revalidate();

        jLabelPageHome.setText("Deletar Conta");

        divContent.add(jLabelPageHome);

    }
    private void logoutButton() {
        LoginUI loginUI = new LoginUI();
        dispose();
    }

}
