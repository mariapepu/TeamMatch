package com.example.teammatch.model;


public class User {
    String name;
    String email;
    String pwd;
    String description;
    String userID;

    public User(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        //this.pwd = pwd;
        this.userID = userID;
        this.description = "Empty description";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
