package com.arroba.ui;

import javax.swing.*;
import java.awt.*;

public class CreateAccountUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionHome = new JPanel();

    private JLabel jLabelTitulo = new JLabel("Create Account"); //MENSAGEM



    public static void main(String[] args) {
        new CreateAccountUI();
    }
    public CreateAccountUI(){



        sectionHome.setLayout(new GridLayout(3, 3, 20, 25));
        sectionHome.setBackground(new Color(255, 255, 255));
        sectionHome.add(jLabelTitulo);


        body.setLayout(new FlowLayout(FlowLayout.CENTER,200,190));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionHome);



        this.setTitle("arrob@");
        this.setSize(1100,800);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);





    }


}
