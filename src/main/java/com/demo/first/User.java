package com.demo.first;

public class User {
    private int Id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
