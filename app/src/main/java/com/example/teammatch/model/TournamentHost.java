package com.example.teammatch.model;

public class TournamentHost implements User {
    String name;
    String email;
    String userID;
    String description;
    String pwd;

    public TournamentHost(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        this.userID = userID;
        this.description = "Empty description";
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPwd() {
        return this.pwd;
    }

    @Override
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void createTournament() {
        Tournament t = new Tournament();
    }
}
