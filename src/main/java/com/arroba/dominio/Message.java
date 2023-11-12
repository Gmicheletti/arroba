package com.arroba.dominio;

import java.util.Objects;

public class Message {
    private User remetente;
    private User destinatario;
    private String conversa;

    public Message() {
    }

    public Message(User remetente, User destinatario, String conversa) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conversa = conversa;
    }

    public User getRemetente() {
        return remetente;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public User getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(User destinatario) {
        this.destinatario = destinatario;
    }

    public String getConversa() {
        return conversa;
    }

    public void setConversa(String conversa) {
        this.conversa = conversa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(remetente, message.remetente) && Objects.equals(destinatario, message.destinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remetente, destinatario);
    }

    @Override
    public String toString() {
        return "Message{" +
                "remetente=" + remetente +
                ", destinatario=" + destinatario +
                ", conversa='" + conversa + '\'' +
                '}';
    }


    public boolean envolvente(User amigo) {
        return remetente.equals(amigo) || destinatario.equals(amigo);

    }
}
