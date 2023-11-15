package com.arroba.ui;

import com.arroba.dominio.Auth;
import com.arroba.dominio.ListAllUsers;
import com.arroba.dominio.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class HomeUI extends JFrame {

    //ELEMENTS LOGIN
    private JPanel body = new JPanel();
    private JPanel sectionHome = new JPanel(new BorderLayout());
    private JPanel divMenu = new JPanel();
    private JPanel divContent = new JPanel();
    private JLabel jLabelTitulo = new JLabel("Bem-vindo, Nome Usuário"); //MENSAGEM
    private JLabel jLabelPageHome = new JLabel(""); //MENSAGEM
    private JButton chatButton = new JButton("Chat");
    private JPanel divRepeatingGroup = new JPanel();
    private JButton perfilButton = new JButton("Meu Perfil");
    private JButton listUsereButton = new JButton("Meus amigos");
    private JButton findUsereButton = new JButton("Buscar Usuários");
    private JButton logoutButton = new JButton("Logout");

    JLabel logoArroba = new JLabel(new ImageIcon("./src/main/resources/img/arrobaiconwhite.png"));    //LOGOS DO SISTEMA


    public static void main(String[] args, Auth auth) {
        new HomeUI(auth);
    }

    public HomeUI(Auth auth){

        chatButton(auth);//INICIA A PAGINA COM O SECTION HOME VISIVEL
        menu();//METODO RESPONSAVEL POR CONSTRUIR O MENU

        Font fonte = jLabelPageHome.getFont();
        Font fonteMaior = new Font(fonte.getName(), fonte.getStyle(), 24);
        jLabelPageHome.setFont(fonteMaior);

        divContent.setBackground(new Color(255, 255, 255));
        sectionHome.add(divMenu, BorderLayout.WEST);
        sectionHome.add(divContent, BorderLayout.CENTER);

        body.setLayout(new GridLayout(1, 1, 20, 0));
        body.setBackground(new Color(255, 255, 255));
        body.add(sectionHome);


        this.setTitle("arrob@ - Home");
        this.setSize(1100,800);
        this.setResizable(false);
        this.getContentPane().add(body);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        //DEFINE PARAMETROS DE LAYOUT DO SHOW MENSAGEM DIALOG
        UIManager.put("OptionPane.background", new Color(255, 255, 255));
        UIManager.getLookAndFeelDefaults().put("Panel.background", new Color(255, 255, 255));

        //BOTOES

        perfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                perfilButton(auth);
            }

        });
        chatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatButton(auth);
            }
        });
        listUsereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUsereButton(auth);
            }
        });
        findUsereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findUsereButton(auth);
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Icon iconLogout = new ImageIcon("./src/main/resources/img/exit.gif");
                UIManager.put("OptionPane.questionIcon", iconLogout);
                int confirmLogout = JOptionPane.showConfirmDialog(HomeUI.this, "Tem certeza de que deseja fazer logout?", "Confirmação de Logout", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (confirmLogout == JOptionPane.YES_OPTION) {
                    // O usuário clicou em "Sim", faça o logout
                    logoutButton(auth);
                }


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
        divMenu.setBackground(new Color(59, 74, 178));

        divMenu.add(logoArroba).setPreferredSize(new Dimension(100, 100));
        divMenu.add(jLabelTitulo).setForeground(Color.white);
        jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        divMenu.add(chatButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(perfilButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(listUsereButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(findUsereButton).setPreferredSize(new Dimension(150, 35));
        divMenu.add(logoutButton).setPreferredSize(new Dimension(150, 35));


    }
    private void chatButton(Auth auth) {
        removeContent();

        jLabelPageHome.setText("Chat");
        jLabelPageHome.setBackground(new Color(15, 173, 53));

        divContent.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divContent.add(jLabelPageHome);
        divContent.add(divRepeatingGroup);

        divRepeatingGroup.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divRepeatingGroup.setPreferredSize(new Dimension(800, 700));
        divRepeatingGroup.setBackground(new Color(255, 255, 255));

        //DISPLAY LIST
        ListAllUsers listUser = new ListAllUsers(auth);
        List<User> users = listUser.getUsers();

        //DISPLAY LIST

        for (User user : users) {
            int idUser = user.getCodUser();
            String nome = user.getNome();
            String sobrenome = user.getSobrenome();
            String email = user.getEmail();
            char sexo = user.getSexo();
            String nacionalidade = user.getNacionalidade();

            JLabel imgUser = new JLabel(new ImageIcon("./src/main/resources/img/imguser.png"));    //LOGOS DO SISTEMA

            JPanel divRGCellPerfil = new JPanel();
            divRGCellPerfil.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
            divRGCellPerfil.setPreferredSize(new Dimension(390, 70));
            divRGCellPerfil.setBackground(new Color(240, 244, 253));

            JPanel divRGCellBtns = new JPanel();
            divRGCellBtns.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
            divRGCellBtns.setPreferredSize(new Dimension(390, 70));
            divRGCellBtns.setBackground(new Color(240, 244, 253));

            JPanel divRGCell = new JPanel();
            divRGCell.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            divRGCell.setPreferredSize(new Dimension(800, 75));
            divRGCell.setBackground(new Color(240, 244, 253));

            JLabel jLabelNameUser = new JLabel(nome); //MENSAGEM
            JButton chatUserButton = new JButton(String.valueOf("Chat"));

            divRGCellPerfil.add(imgUser);
            divRGCellPerfil.add(jLabelNameUser);
            divRGCellBtns.add(chatUserButton);
            divRGCell.add(divRGCellPerfil);
            divRGCell.add(divRGCellBtns);
            divRepeatingGroup.add(divRGCell);

            chatUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chatInButton(auth);
                }
            });


        }

        refreshUI();
    }
    private void chatInButton(Auth auth) {
        removeContent();

        jLabelPageHome.setText("Chat");
        jLabelPageHome.setBackground(new Color(15, 173, 53));

        divContent.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divContent.add(jLabelPageHome);
        divContent.add(divRepeatingGroup);

        divRepeatingGroup.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divRepeatingGroup.setPreferredSize(new Dimension(800, 600));
        divRepeatingGroup.setBackground(new Color(255, 255, 255));

        //DISPLAY LIST



        ListAllUsers listUser = new ListAllUsers(auth);
        List<User> users = listUser.getUsers();

        //DISPLAY LIST

        for (User user : users) {
            int idUser = user.getCodUser();
            String nome = user.getNome();
            String sobrenome = user.getSobrenome();
            String email = user.getEmail();
            char sexo = user.getSexo();
            String nacionalidade = user.getNacionalidade();

            if(idUser == 1){

                JLabel imgUser = new JLabel(new ImageIcon("./src/main/resources/img/imguser.png"));    //LOGOS DO SISTEMA

                JPanel divRGCellPerfil = new JPanel();
                divRGCellPerfil.setLayout(new FlowLayout(FlowLayout.RIGHT,10,0));
                divRGCellPerfil.setPreferredSize(new Dimension(800, 70));
                divRGCellPerfil.setBackground(new Color(240, 244, 253));

                JPanel divRGCellDesc = new JPanel();
                divRGCellDesc.setLayout(new GridLayout(2, 1, 0, 0));
                divRGCellDesc.setPreferredSize(new Dimension(300, 40));
                divRGCellDesc.setBackground(new Color(240, 244, 253));

                JPanel divRGCell = new JPanel();
                divRGCell.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                divRGCell.setPreferredSize(new Dimension(800, 75));
                divRGCell.setBackground(new Color(240, 244, 253));

                JLabel jLabelNameUser = new JLabel(nome); //MENSAGEM
                JLabel jLabelDescMsg = new JLabel(sobrenome); //MENSAGEM
                jLabelNameUser.setHorizontalAlignment(SwingConstants.RIGHT);
                jLabelDescMsg.setHorizontalAlignment(SwingConstants.RIGHT);


                divRGCellDesc.add(jLabelNameUser);
                divRGCellDesc.add(jLabelDescMsg);
                divRGCell.add(divRGCellPerfil);
                divRGCellPerfil.add(divRGCellDesc);
                divRGCellPerfil.add(imgUser);
                divRepeatingGroup.add(divRGCell);

            } else{
                JLabel imgUser = new JLabel(new ImageIcon("./src/main/resources/img/imguser.png"));    //LOGOS DO SISTEMA

                JPanel divRGCellPerfil = new JPanel();
                divRGCellPerfil.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
                divRGCellPerfil.setPreferredSize(new Dimension(800, 70));
                divRGCellPerfil.setBackground(new Color(240, 244, 253));

                JPanel divRGCellDesc = new JPanel();
                divRGCellDesc.setLayout(new GridLayout(2, 1, 0, 0));
                divRGCellDesc.setPreferredSize(new Dimension(300, 40));
                divRGCellDesc.setBackground(new Color(240, 244, 253));

                JPanel divRGCell = new JPanel();
                divRGCell.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
                divRGCell.setPreferredSize(new Dimension(800, 75));
                divRGCell.setBackground(new Color(240, 244, 253));

                JLabel jLabelNameUser = new JLabel(nome); //MENSAGEM
                JLabel jLabelDescMsg = new JLabel(sobrenome); //MENSAGEM



                divRGCellPerfil.add(imgUser);
                divRGCellDesc.add(jLabelNameUser);
                divRGCellDesc.add(jLabelDescMsg);
                divRGCell.add(divRGCellPerfil);
                divRGCellPerfil.add(divRGCellDesc);
                divRepeatingGroup.add(divRGCell);
            }


        }

        JPanel divsendmsg = new JPanel();
        divsendmsg.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        divsendmsg.setBackground(new Color(255,255,255));

        JTextField sendMsgBox = new JTextField();
        sendMsgBox.setColumns(60);

        JButton searchButton = new JButton("Enviar");

        divsendmsg.add(sendMsgBox);
        divsendmsg.add(searchButton);

        divContent.add(divsendmsg);

        refreshUI();

    }
    private void perfilButton(Auth auth) {

        removeContent();

        jLabelPageHome.setText("Meu Perfil");

         JPanel sectionCreateAccount = new JPanel();
         JPanel divCredential = new JPanel();
         JPanel divName = new JPanel();
         JPanel divDate = new JPanel();
         JPanel divEmail = new JPanel();
         JPanel divPassword = new JPanel();
         JPanel divBtns = new JPanel();
         JLabel loginPlaceHolderName= new JLabel("Nome:");
         JTextField loginUserName = new JTextField();
         JLabel loginPlaceHolderDate= new JLabel("Data Nascimento:");
         JTextField loginUserDate = new JTextField();
         JLabel loginPlaceHolderEmail= new JLabel("Email:");
         JTextField loginUserEmail = new JTextField();
         JLabel loginPlaceHolderPassword = new JLabel("Senha:");
         JPasswordField loginPassword = new JPasswordField();
         JButton createButton = new JButton("Salvar Alterações");


        JLabel logoAccount = new JLabel(new ImageIcon("./src/main/resources/img/arrobaicon.png"));    //LOGOS DO SISTEMA

        Color color = new Color(255, 255, 255);

        divName.setBackground(color);
        divName.add(loginPlaceHolderName);
        divName.add(loginUserName);
        loginUserName.setColumns(20);

        divDate.setBackground(color);
        divDate.add(loginPlaceHolderDate);
        divDate.add(loginUserDate);
        loginUserDate.setColumns(14);

        divEmail.setBackground(color);
        divEmail.add(loginPlaceHolderEmail);
        divEmail.add(loginUserEmail);
        loginUserEmail.setColumns(20);

        divPassword.setBackground(color);
        divPassword.add(loginPlaceHolderPassword);
        divPassword.add(loginPassword);
        loginPassword.setColumns(20);

        divCredential.setLayout(new GridLayout(4, 1));
        divCredential.setBackground(color);
        divCredential.add(divName);
        divCredential.add(divDate);
        divCredential.add(divEmail);
        divCredential.add(divPassword);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setVgap(20);
        divBtns.setLayout(layout);
        divBtns.setBackground(color);
        divBtns.add(createButton).setPreferredSize(new Dimension(150, 35));

        sectionCreateAccount.setLayout(new GridLayout(3, 3, 20, 25));
        sectionCreateAccount.setBackground(color);
        sectionCreateAccount.add(logoAccount);
        sectionCreateAccount.add(divCredential);
        sectionCreateAccount.add(divBtns);

        divContent.add(jLabelPageHome);
        divContent.add(sectionCreateAccount);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatButton(auth);
            }
        });

        refreshUI();

    }
    private void listUsereButton(Auth auth) {
        removeContent();

        jLabelPageHome.setText("Meus Amigos");
        jLabelPageHome.setBackground(new Color(15, 173, 53));


        divContent.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divContent.add(jLabelPageHome);
        divContent.add(divRepeatingGroup);

        divRepeatingGroup.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divRepeatingGroup.setPreferredSize(new Dimension(800, 700));
        divRepeatingGroup.setBackground(new Color(255, 255, 255));



        ListAllUsers listUser = new ListAllUsers(auth);
        List<User> users = listUser.getUsers();

        //DISPLAY LIST

        for (User user : users) {
            int idUser = user.getCodUser();
            String nome = user.getNome();
            String sobrenome = user.getSobrenome();
            String email = user.getEmail();
            char sexo = user.getSexo();
            String nacionalidade = user.getNacionalidade();


            JLabel imgUser = new JLabel(new ImageIcon("./src/main/resources/img/imguser.png"));    //LOGOS DO SISTEMA

            JPanel divRGCellPerfil = new JPanel();
            divRGCellPerfil.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
            divRGCellPerfil.setPreferredSize(new Dimension(390, 70));
            divRGCellPerfil.setBackground(new Color(240, 244, 253));

            JPanel divRGCellBtns = new JPanel();
            divRGCellBtns.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
            divRGCellBtns.setPreferredSize(new Dimension(390, 70));
            divRGCellBtns.setBackground(new Color(240, 244, 253));

            JPanel divRGCell = new JPanel();
            divRGCell.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            divRGCell.setPreferredSize(new Dimension(800, 75));
            divRGCell.setBackground(new Color(240, 244, 253));

            JLabel jLabelNameUser = new JLabel(nome + " " + sobrenome); //MENSAGEM
            JButton removeButton = new JButton(String.valueOf("Remover"));
            JButton chatUserButton = new JButton(String.valueOf("Chat"));

            divRGCellPerfil.add(imgUser);
            divRGCellPerfil.add(jLabelNameUser);
            divRGCellBtns.add(removeButton);
            divRGCellBtns.add(chatUserButton);
            divRGCell.add(divRGCellPerfil);
            divRGCell.add(divRGCellBtns);
            divRepeatingGroup.add(divRGCell);

            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Icon iconRemoveUser = new ImageIcon("./src/main/resources/img/removeUser.gif");
                    UIManager.put("OptionPane.questionIcon", iconRemoveUser);
                    int confirmRemoveUser = JOptionPane.showConfirmDialog(HomeUI.this, "Tem certeza de que deseja remover amizade?", "Confirmação de exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (confirmRemoveUser == JOptionPane.YES_OPTION) {
                        // O usuário clicou em "Sim", faça o logout

                    }
                }
            });

            chatUserButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chatInButton(auth);
                }
            });
        }

        refreshUI();



    }
    private void findUsereButton(Auth auth) {
        removeContent();

        jLabelPageHome.setText("Buscar Usuários: ");

        JPanel divsearchBox = new JPanel();
        divsearchBox.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        divsearchBox.setBackground(new Color(255,255,255));

        JTextField searchBox = new JTextField();
        searchBox.setColumns(30);

        JButton searchButton = new JButton("Buscar");
        JButton resetSearchButton = new JButton("Limpar");

        divsearchBox.add(jLabelPageHome);
        divsearchBox.add(searchBox);
        divsearchBox.add(searchButton);
        divsearchBox.add(resetSearchButton);

        divContent.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divContent.add(divsearchBox);
        divContent.add(divRepeatingGroup);

        divRepeatingGroup.setLayout(new FlowLayout(FlowLayout.CENTER,400,20));
        divRepeatingGroup.setPreferredSize(new Dimension(800, 500));
        divRepeatingGroup.setBackground(new Color(255, 255, 255));

        //DISPLAY LIST
        ListAllUsers listUser = new ListAllUsers(auth);
        List<User> users = listUser.getUsers();

        //DISPLAY LIST

        for (User user : users) {
            int idUser = user.getCodUser();
            String nome = user.getNome();
            String sobrenome = user.getSobrenome();
            String email = user.getEmail();
            char sexo = user.getSexo();
            String nacionalidade = user.getNacionalidade();

            JLabel imgUser = new JLabel(new ImageIcon("./src/main/resources/img/imguser.png"));    //LOGOS DO SISTEMA

            JPanel divRGCellPerfil = new JPanel();
            divRGCellPerfil.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
            divRGCellPerfil.setPreferredSize(new Dimension(390, 70));
            divRGCellPerfil.setBackground(new Color(240, 244, 253));

            JPanel divRGCellBtns = new JPanel();
            divRGCellBtns.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
            divRGCellBtns.setPreferredSize(new Dimension(390, 70));
            divRGCellBtns.setBackground(new Color(240, 244, 253));

            JPanel divRGCell = new JPanel();
            divRGCell.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            divRGCell.setPreferredSize(new Dimension(800, 75));
            divRGCell.setBackground(new Color(240, 244, 253));

            JLabel jLabelNameUser = new JLabel(nome); //MENSAGEM
            JButton addUserButton = new JButton(String.valueOf("Adicionar"));

            divRGCellPerfil.add(imgUser);
            divRGCellPerfil.add(jLabelNameUser);
            divRGCellBtns.add(addUserButton);
            divRGCell.add(divRGCellPerfil);
            divRGCell.add(divRGCellBtns);
            divRepeatingGroup.add(divRGCell);
        }

        refreshUI();




    }
    private void logoutButton(Auth auth) {

        LoginUI loginUI = new LoginUI();
        dispose();
    }
    private void removeContent() {
        divContent.removeAll();
        divRepeatingGroup.removeAll();
    }
    private void refreshUI() {
        divContent.revalidate();
        divContent.repaint();
    }

}




