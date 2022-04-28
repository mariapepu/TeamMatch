package com.example.teammatch.model;

public class Player extends User {
    String tier;
    String main;
    String role;
    int rank;
    double valoration;
    //nos faltara la tabla de partidas (ultimas 3) i los reports.

    //constructor
    public Player(String name, String email, String pwd) {
        super(name, email, pwd);
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getValoration() {
        return valoration;
    }

    public void setValoration(double valoration) {
        this.valoration = valoration;
    }
}
