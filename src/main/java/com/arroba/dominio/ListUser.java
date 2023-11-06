package com.arroba.dominio;

import java.util.HashMap;

public class ListUser {
    public static HashMap<Integer, Object> main() {
        // Crie um HashMap com chave do tipo Integer e valor do tipo Object.
        HashMap<Integer, Object> hashMap = createAndPopulateHashMap();


//        for (Integer idUser : hashMap.keySet()) {
//            HashMap<String, Object> dadosUser = (HashMap<String, Object>) hashMap.get(idUser);
//            int idChat = (int) dadosUser.get("idChat");
//            String nome = (String) dadosUser.get("Nome");
//            System.out.println("ID USER: " + idUser + ", ID Chat: " + idChat + ", Nome: " + nome);
//        }

        return hashMap;
    }

    // Método para criar e popular um HashMap com elementos.
    private static HashMap<Integer, Object> createAndPopulateHashMap() {
        // Crie um HashMap com chave do tipo Integer e valor do tipo Object.
        HashMap<Integer, Object> hashMap = new HashMap<>();

        // Adicione vários elementos ao HashMap.
        hashMap.put(1, createObject(11, "Guilherme Micheletti"));
        hashMap.put(2, createObject(22, "Lucas Rodrigues"));
        hashMap.put(3, createObject(33, "Lorena Nobre"));
        hashMap.put(4, createObject(44, "Jefferson Caetano"));
        hashMap.put(5, createObject(55, "Carlos Jardel"));

        return hashMap;
    }

    // Método para criar um objeto com os campos desejados.
    private static Object createObject(int idChat, String Nome) {
        HashMap<String, Object> objetoAninhado = new HashMap<>();
        objetoAninhado.put("idChat", idChat);
        objetoAninhado.put("Nome", Nome);
        return objetoAninhado;
    }
}
