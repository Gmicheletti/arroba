package com.arroba.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
    @Id
    private Integer idMessage;
    private String descMessage;
    @ManyToOne
    private User user;
}
