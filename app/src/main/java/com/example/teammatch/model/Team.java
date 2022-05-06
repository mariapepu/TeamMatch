package com.example.teammatch.model;

import java.util.ArrayList;

class Team {
    String name;
    ArrayList<Player> integrants;
    int maxIntegrants = 5;
    int numIntegrants;
    Player owner;

    public Team(Player owner, String name) {
        this.numIntegrants = 1;
        this.name = name;
        this.owner = owner;
        this.integrants.add(owner);
    }

    public void addIntegrant(Player player) throws Exception {
        if ((numIntegrants + 1) <= maxIntegrants) {
            integrants.add(player);
        } else {
            throw new Exception("Màximo 5 miembros");
        }
    }

    public void deleteIntegrant(Player player) {
        integrants.remove(player);
    }

    public void deleteTeam() {
        integrants.clear();
    }
}
