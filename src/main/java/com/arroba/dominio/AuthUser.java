package com.arroba.dominio;

import java.util.Objects;

public class AuthUser {
    private User currentUser;

    public AuthUser() {
    }

    public AuthUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void removeCurrentUser(){
         currentUser = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return Objects.equals(currentUser, authUser.currentUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentUser);
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "currentUser=" + currentUser +
                '}';
    }
}
