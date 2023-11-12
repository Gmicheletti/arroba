package com.arroba.dominio;

import java.util.*;

public class ArrobaSocialMedia {

    // Mapa de usuários, onde a chave é o email
    private static Map<String, User> users = new HashMap<>();

    // Objeto Usuário que irá logar
    private static User currentUser;

    //Lista encadeada de usuários do sistema
    private static LinkedList<User> userList = new LinkedList<>();

    public static void main(String[] args) {

        //Tela inicial
        int opcao;
        Scanner scn = new Scanner(System.in);
        User user = new User();

        do {

            System.out.println("+++TELA INICIAL+++");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Fazer logout");
            System.out.println("4 - Adicionar amigo");
            System.out.println("5 - Remover amigo");
            System.out.println("6 - Consultar Amigo");
            System.out.println("7 - Sair");
            System.out.println("8 - Listar cadastros");
            System.out.println("9 - Sair");
            System.out.println("********************");
            System.out.println("Digite a opção desejada: ");
            opcao = scn.nextInt();
            scn.nextLine();

            switch (opcao) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    checkLogin();
                    break;
                case 3:
                    logout();
                case 4:
                    addFriend();
                case 5:
                    removeFriend();
                case 6:
                    searchFriend();
                case 7:
                    sendMessage();
                case 8:
                    listUsers();
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 9);

    }

    //MÉTODOS DO SISTEMA
    //Metodo para cadastrar novos usuários no sistema
    public static void registerUser() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Nome: ");
        String nomeRegister = scn.nextLine();

        System.out.print("Email: ");
        String emailRegister = scn.nextLine();

        System.out.print("Senha: ");
        String senhaRegister = scn.nextLine();

        System.out.print("Telefone: ");
        String telefoneRegister = scn.nextLine();

        System.out.print("Data de Nascimento: ");
        String nascimentoRegister = scn.nextLine();

        System.out.print("Nacionalidade: ");
        String nacionalidadeRegister = scn.nextLine();


        //Inicializar um objeto Usuário para cadastrar um novo perfil no sistema.
        //Passar as variáveis para a aclasse User
        //Colocá-lo no hashmap (lista de usuários).
        User newUser = new User(nomeRegister, emailRegister, senhaRegister, telefoneRegister, nascimentoRegister, nacionalidadeRegister);
        users.put(emailRegister, newUser);
        System.out.println("Cadastro realizado com sucesso!");
    }

    //Método para fazer login.
    public static void checkLogin() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Email: ");
        String emailLogin = scn.nextLine();

        System.out.print("Senha: ");
        String senhaLogin = scn.nextLine();

        //Verificar  se a chave de email existe no hashmap (usuário existente e cadastrado)
        if (users.containsKey(emailLogin) && users.get(emailLogin).getSenha().equals(senhaLogin)) {
            currentUser = users.get(emailLogin);
            System.out.println("Login efetuado! Bem-vindo " + currentUser.getNome() + "!");
        } else {
            System.out.println("Email ou senha incorretos. Tente novamente.");
        }
    }

    //Metodo para fazer o logout.
    public static void logout() {
        currentUser = null;
        System.out.println("Logout realizado.");
        //Conectar um pop up na tela com a mensagem e voltar para a home.
    }

    public static void addFriend() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Digite o email do usuário: ");
        String emailAmizade = scn.nextLine();

        if (users.containsKey(emailAmizade)) {
           User amigo = users.get(emailAmizade);
            System.out.println(amigo);
            currentUser.addFriend(amigo);
            System.out.println("Amigo adicionado com sucesso.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    public static void removeFriend(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Amigo a ser removido: ");
        String emailRemover = scn.nextLine();

        User amigo = users.get(emailRemover);

        if (amigo != null && currentUser.getAmigo().contains(amigo)) {
            currentUser.removeAmigo(amigo);
            System.out.println("Amigo removido.");
        } else {
            System.out.println("Amigo não encontrado na lista.");
        }
    }
    public static void searchFriend(){
        List<User> amigos = currentUser.getAmigo();

        if (amigos.isEmpty()) {
            System.out.println("Você não tem amigos.");
        } else {
            System.out.println("Seus amigos:");
            for (User amigo : amigos) {
                System.out.println(amigo.getNome() + " (" + amigo.getEmail() + ")");
            }
        }
    }
    public static void sendMessage(){
        Scanner scn = new Scanner(System.in);

        System.out.print("Email do amigo para enviar mensagem: ");
        String emailAmigo = scn.nextLine();

        // Verificar se o amigo existe e está na lista de amigos do usuário atual logado
        User amigo = users.get(emailAmigo);

        if (amigo != null && currentUser.getAmigo().contains(amigo)) {
            System.out.print("Digite a mensagem: ");
            String mensagem = scn.nextLine();
            System.out.println("Mensagem enviada para " + amigo.getNome() + ": " + mensagem);
        } else {
            System.out.println("Amigo não encontrado ou não está na sua lista de amigos.");
        }
    }
    private static void listUsers(){
        System.out.println("Lista de Usuários Cadastrados:");

        for (User user : users.values()) {
            System.out.println("Nome: " + user.getNome() + " | Email: " + user.getEmail());
        }
    }
}








