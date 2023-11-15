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
            System.out.println("7 - Enviar mensagem");
            System.out.println("8 - Abrir o chat");
            System.out.println("9 - Listar cadastros");
            System.out.println("10 - Encerrar");
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
                    break;
                case 4:
                    addFriend();
                    break;
                case 5:
                    removeFriend();
                    break;
                case 6:
                    searchFriend();
                    break;
                case 7:
                    sendMessage();
                    break;
                case 8:
                    openChat();
                    break;
                case 9:
                    listUsers();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 10);

    }

    //MÉTODOS DO SISTEMA
    //Metodo para cadastrar novos usuários no sistema.
    public static void registerUser() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Nome: ");
        String nomeRegister = scn.nextLine();

        System.out.print("Email: ");
        String emailRegister = scn.nextLine();

        System.out.print("Senha: ");
        char[] senhaRegister = scn.next().toCharArray();

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
        if (currentUser == null) {
            System.out.println("Você não está logado no sistema.");

        } else {
            currentUser = null;
            System.out.println("Logout realizado.");
        }
        //Conectar um pop up na tela com a mensagem e voltar para a home.
    }

    public static void addFriend() {
        if (currentUser == null) {
            System.out.println("Faça login antes de adicionar amigos.");
        } else {

            Scanner scn = new Scanner(System.in);

            System.out.println("Digite o email do usuário: ");
            String emailAmizade = scn.nextLine();

            if (users.containsKey(emailAmizade)) {
                User amigo = users.get(emailAmizade);
                currentUser.addFriend(amigo);
                System.out.println("Amigo adicionado com sucesso.");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        }
    }

    public static void removeFriend() {
        if (currentUser == null) {
            System.out.println("Faça login antes remover amigos.");

        } else {

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
    }

    public static void searchFriend() {
        if (currentUser == null) {
            System.out.println("Faça login antes de consultar amigos.");

        } else {

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
    }

    public static void sendMessage() {
        if (currentUser == null) {
            System.out.println("Faça login antes de enviar mensagens.");

        } else {

            Scanner scn = new Scanner(System.in);

            System.out.print("Email do amigo para enviar mensagem: ");
            String emailAmigo = scn.nextLine();

            // Verificar se o amigo existe e está na lista de amigos do usuário atual logado
            User amigo = users.get(emailAmigo);

            if (amigo != null && currentUser.getAmigo().contains(amigo)) {
                System.out.print("Digite a mensagem: ");
                String textoEnviado = scn.nextLine();

                //Criar uma instancia do ojeto mensagem para adicionar o historico
                Message mensagem = new Message(currentUser, amigo, textoEnviado);

                // Adiciona a mensagem ao histórico do usuário atual
                currentUser.addMessage(mensagem);

                // Adiciona a mensagem ao histórico do amigo
                amigo.addMessage(mensagem);

                System.out.println("Mensagem enviada para " + amigo.getNome() + ": " + textoEnviado);
            } else {
                System.out.println("Amigo não encontrado ou não está na sua lista de amigos.");
            }
        }
    }
    public static void openChat() {
        if (currentUser == null) {
            System.out.println("Faça login antes de exibir o chat.");
        } else {
            Scanner scn = new Scanner(System.in);

            System.out.print("Email do amigo para exibir o chat: ");
            String emailAmigo = scn.nextLine();

            // Verificar se o amigo existe e está na lista de amigos do usuário atual logado
            User amigo = users.get(emailAmigo);

            if (amigo != null && currentUser.getAmigo().contains(amigo)) {
                // Obter o histórico de mensagens entre os usuários
                List<Message> historico = getHistorico(currentUser, amigo);

                if (!historico.isEmpty()) {
                    System.out.println("=== Chat com " + amigo.getNome() + " ===");
                    // Imprimir apenas as mensagens do remetente e destinatário
                    for (Message mensagem : historico) {
                        if ((mensagem.getRemetente().equals(currentUser) && mensagem.getDestinatario().equals(amigo)) ||
                                (mensagem.getRemetente().equals(amigo) && mensagem.getDestinatario().equals(currentUser))) {
                            System.out.println(mensagem.getRemetente().getNome() + ": " + mensagem.getConversa());
                        }
                    }
                } else {
                    System.out.println("Chat vazio. Não há mensagens entre você e " + amigo.getNome() + ".");
                }
            } else {
                System.out.println("Amigo não encontrado ou não está na sua lista de amigos.");
            }
        }
    }


    private static List<Message> getHistorico(User currentUser, User amigo) {
        List<Message> historico = new ArrayList<>();

        // Obter todas as mensagens do usuário atual
        List<Message> mensagensUser1 = currentUser.historicoMensagem();

        // Iterar sobre as mensagens do usuário atual
        for (Message mensagem : mensagensUser1) {
            // Verificar se a mensagem envolve o amigo especificado
            if (mensagem.envolvente(amigo)) {
                historico.add(mensagem);
            }
        }

        return historico;
    }

    private static void listUsers() {
        System.out.println("Lista de Usuários Cadastrados:");

        for (User user : users.values()) {
            System.out.println("Nome: " + user.getNome() + " | Email: " + user.getEmail());
        }
    }
}








