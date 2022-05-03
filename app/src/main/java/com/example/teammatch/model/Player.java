package com.example.teammatch.model;

import android.media.Image;

import java.util.Objects;

public class Player extends User {
    String tier;
    String main;
    String role;
    int rank;
    double valoration;
    Image profile_pic;

    //nos faltara la tabla de partidas (ultimas 3) i los reports.

    //constructor
    public Player(String name, String email, String userID) {
        super(name, email, userID);
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
        if (this.main != null) {
            if (this.main.equals("Sage") || Objects.equals(this.main, "Chamber") || this.main.equals("Cypher") || this.main.equals("Killjoy")) {
                this.role = "Centinela"; //igl/support
            }
            if (this.main.equals("Brimstone") || this.main.equals("Viper") || this.main.equals("Omen") || this.main.equals("Astra")) {
                this.role = "Controlador"; //controller
            }
            if (this.main.equals("Phoenix") || this.main.equals("Reyna") || this.main.equals("Jett") || this.main.equals("Raze") || this.main.equals("Yoru") || this.main.equals("Neon") || this.main.equals("Fade")) {
                this.role = "Duelista"; //entry fragger
            }
            if (this.main.equals("Sova") || this.main.equals("Breach") || this.main.equals("Skye") || this.main.equals("Kayo")) {
                this.role = "Iniciador"; //second entry
            }
        }
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
