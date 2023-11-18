package com.arroba.dominio;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "@_chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codChat;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "codChats")
    private List<Message> message;

    public Chat() {
    }

    public Chat(Integer codChat, List<Message> message) {
        this.codChat = codChat;
        this.message = message;
    }

    public Integer getCodChat() {
        return codChat;
    }

    public void setCodChat(Integer codChat) {
        this.codChat = codChat;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(codChat, chat.codChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codChat);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "codChat=" + codChat +
                ", message=" + message +
                '}';
    }
}
