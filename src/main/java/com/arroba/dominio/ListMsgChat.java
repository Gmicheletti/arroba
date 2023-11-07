package com.arroba.dominio;

import java.util.HashMap;

public class ListMsgChat {
    public static HashMap<Integer, Object> main() {
        // Crie um HashMap com chave do tipo Integer e valor do tipo Object.
        HashMap<Integer, Object> hashMap = createAndPopulateHashMap();

        return hashMap;
    }

    // Método para criar e popular um HashMap com elementos.
    private static HashMap<Integer, Object> createAndPopulateHashMap() {
        // Crie um HashMap com chave do tipo Integer e valor do tipo Object.
        HashMap<Integer, Object> hashMap = new HashMap<>();

        // Adicione vários elementos ao HashMap.
        hashMap.put(1, createObject("Guilherme Micheletti", "Olá, tudo bem?",1));
        hashMap.put(2, createObject("Lucas Rodrigues", "Olá Guilherme, tudo certo?",2));

        return hashMap;
    }

    // Método para criar um objeto com os campos desejados.
    private static Object createObject(String Nome, String Desc, int idUser) {
        HashMap<String, Object> objetoAninhado = new HashMap<>();
        objetoAninhado.put("Nome", Nome);
        objetoAninhado.put("Desc", Desc);
        objetoAninhado.put("IdUser", idUser);
        return objetoAninhado;
    }
}
