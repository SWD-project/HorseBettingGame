package com.example.horsebetting.entity;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private List<User> userList = new ArrayList<>();
    private int currentUser = -1;
    private static UserManagement instance;
    private static final int DEFAULT_MONEY = 100;

    private UserManagement() {
        userList.add(new User("user", "1", DEFAULT_MONEY));
    }

    public static UserManagement getInstance() {
        if (instance == null) {
            instance = new UserManagement();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        int position = findUser(username);
        if (position > -1 && userList.get(position).getPassword().equals(password)) {
            currentUser = position;
            return true;
        }
        return false;
    }
    public boolean signup(String username, String password) {
        int position = findUser(username);
        if (position > -1) {
            return false;
        }

        userList.add(new User(username, password, DEFAULT_MONEY));
        return true;
    }

    public void logout() {
        currentUser = -1;
    }

    public User getCurrentUser() {
        if (!isValidUser()) {
            return null;
        }

        return userList.get(currentUser);
    }

    public void updateMoney(int money) {
        if (!isValidUser()) {
            return;
        }

        if (money < 0) {
            return;
        }

        userList.get(currentUser).setStore(money);
    }

    private boolean isValidUser() {
        if (currentUser < 0 || currentUser >= userList.size()) {
            return false;
        }
        return true;
    }

    private int findUser(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
