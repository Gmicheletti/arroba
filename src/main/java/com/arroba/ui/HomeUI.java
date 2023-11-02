package com.arroba.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionHome = new JPanel();
    private JLabel jLabelTitulo = new JLabel("Home"); //MENSAGEM
    private JButton previousButton = new JButton("Voltar");


    public static void main(String[] args) {
        new HomeUI();
    }
    public HomeUI(){

        sectionHome.setLayout(new GridLayout(3, 3, 20, 25));
        sectionHome.setBackground(new Color(255, 255, 255));
        sectionHome.add(jLabelTitulo);
        sectionHome.add(previousButton);

        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionHome);

        this.setTitle("arrob@ - Home");
        this.setSize(1100,800);
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

    }


}