package com.example.teammatch.model;

import java.net.URL;
import java.util.ArrayList;

public class Player implements User {
    String name;
    String email;
    String userID;
    String pwd;
    String description;
    String tier;
    String main;
    String role;
    int rank;
    double valoration;
    int numValorations;
    URL profile_pic;
    ArrayList<Team> teams;

    //nos faltara la tabla de partidas (ultimas 3) i los reports.

    //constructor
    public Player(String name, String email, String userID) {
        this.name = name;
        this.email = email;
        this.userID = userID;
        this.description = "Empty description";
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

    public void setRole() {
        if (this.main != null) {
            if (this.main.equals("Sage") || this.main.equals("Chamber") || this.main.equals("Cypher") || this.main.equals("Killjoy")) {
                this.role = "Sentinel"; //igl/support
            }
            if (this.main.equals("Brimstone") || this.main.equals("Viper") || this.main.equals("Omen") || this.main.equals("Astra")) {
                this.role = "Controller"; //controller
            }
            if (this.main.equals("Phoenix") || this.main.equals("Reyna") || this.main.equals("Jett") || this.main.equals("Raze") || this.main.equals("Yoru") || this.main.equals("Neon")) {
                this.role = "Duelist"; //entry fragger
            }
            if (this.main.equals("Sova") || this.main.equals("Breach") || this.main.equals("Skye") || this.main.equals("Kayo") || this.main.equals("Fade")) {
                this.role = "Initiator"; //second entry
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
        this.numValorations += 1;
        this.valoration = (this.valoration + valoration) / numValorations; //media de las valoraciones
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

    /*******************************************************
     TEAM
     *******************************************************/
    public void createTeam(String teamName) {
        Team t = new Team(this, teamName);
        teams.add(t);
    }

    public void addTeamMember(Player player, Team team) throws Exception {
        if (this.equals(team.owner)) {
            team.addIntegrant(player);
            player.teams.add(team);
        } else {
            throw new Exception("No eres el Admin del equipo.");
        }
    }

    public void deleteTeamMember(Player player, Team team) throws Exception {
        if (this.equals(team.owner)) {
            team.deleteIntegrant(player);
            player.teams.remove(team);
        } else {
            throw new Exception("No eres el Admin del equipo.");
        }
    }

    public void leaveTeam(Team team) {
        team.deleteIntegrant(this);
        this.teams.remove(team);
    }

    public void deleteTeam(Team team) throws Exception {
        if (this.equals(team.owner)) {
            team.deleteTeam();
            this.teams.remove(team);

        } else {
            throw new Exception("No eres el Admin del equipo.");
        }
    }


}
