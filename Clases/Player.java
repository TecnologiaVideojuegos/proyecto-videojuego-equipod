/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;

import java.util.ArrayList;

/**
 *
 * @author Danil
 */
public class Player {
    private int health;
    private ArrayList<Unit> p_deck;
    private ArrayList<Unit> p_hand;
    private ArrayList<Unit> p1_table;
    private int energy;

    public Player(int health, ArrayList<Unit> p_deck, ArrayList<Unit> p_hand, ArrayList<Unit> p1_table, int energy) {
        this.health = 30;
        this.p_deck = p_deck;
        this.p_hand = p_hand;
        this.p1_table = p1_table;
        this.energy = 0;
    }

    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Unit> getP_deck() {
        return p_deck;
    }

    public void setP_deck(ArrayList<Unit> p_deck) {
        this.p_deck = p_deck;
    }

    public ArrayList<Unit> getP_hand() {
        return p_hand;
    }

    public void setP_hand(ArrayList<Unit> p_hand) {
        this.p_hand = p_hand;
    }

    public ArrayList<Unit> getP1_table() {
        return p1_table;
    }

    public void setP1_table(ArrayList<Unit> p1_table) {
        this.p1_table = p1_table;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    
}
