package com.example.ainurbayanova.retrofit.mvp.model;

public class User {
    public int id;
    public String email;
    public String Token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Token;
    }

    public void setPassword(String Token) {
        this.Token = Token;
    }
}
