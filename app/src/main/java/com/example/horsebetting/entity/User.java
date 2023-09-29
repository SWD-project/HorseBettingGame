package com.example.horsebetting.entity;

public class User {
    private String username;
    private String password;
    private int store;

    public static final String CURRENT_USER = "CURRENT_USER_KEY";
    public User(String username, String password, int store) {
        this.username = username;
        this.password = password;
        this.store = store;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.store = 300;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}
