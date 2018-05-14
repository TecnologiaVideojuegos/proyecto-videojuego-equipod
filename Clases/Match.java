package FightKnights.Logic;

import java.util.ArrayList;

public class Match {

    private static Match match;

    private static int turn_count = 0; //Numero de turnos... MAXIMO 20 o algo asi
    private static int p_turn; // 1 o 2 segun el jugador al ue le toque.

    private static ArrayList<Unit> p1_deck = new ArrayList <Unit> (); //Todas las cartas del jugador 1.
    private static ArrayList<Unit> p1_hand = new ArrayList <Unit> (); //Cartas de la mano del jugador 1.
    private static ArrayList<Unit> p1_table = new ArrayList <Unit> (); //Cartas de la mesa del jugador 1.
    private static int p1_energy; //Energia del jugador 1.
    private static int p1_health=20; //Vida del jugador 1.
    private static int p1_spellIncrement; //Incremento de daño de hechizos del jugador 1.

    private static ArrayList<Unit> p2_deck = new ArrayList <Unit> (); //Todas las cartas del jugador 2.
    private static ArrayList<Unit> p2_hand = new ArrayList <Unit> (); //Cartas de la mano del jugador 2.
    private static ArrayList<Unit> p2_table = new ArrayList <Unit> (); //Cartas de la mesa del jugador 2.
    private static int p2_energy; //Energia del jugador 2.
    private static int p2_health=20; //Vida del jugador 2.
    private static int p2_spellIncrement; //Incremento de daño de hechizps del jugador 2.

    private Match() {
        //No lo usaremos de momento...
    }

    public static Match getMatchInstance() {
        // ESTO CREA UNA CLASE SI NO ESTA CREADA, Y SI YA LO ESTA DEVUELVE LA QUE YA HAY,
        // LO UE CONSIGUE QUE SE GUARDEN LOS DATOS MIENTRAS DURA LA PARTIDA ENTERA.

        if (match == null) {
            match = new Match();
        }

        return match;
    }

    // GETTERS Y SETTERS
    //********************************************
    public synchronized ArrayList<Unit> getP1_deck() {
        return p1_deck;
    }

    public synchronized ArrayList<Unit> getP1_hand() {
        return p1_hand;
    }

    public synchronized ArrayList<Unit> getP1_table() {
        return p1_table;
    }

    public void setP1_deck(ArrayList<Unit> p1_deck) {
        this.p1_deck = p1_deck;
    }

    public void setP1_hand(ArrayList<Unit> p1_hand) {
        this.p1_hand = p1_hand;
    }

    public void setP1_table(ArrayList<Unit> p1_table) {
        this.p1_table = p1_table;
    }

    public synchronized int getP1_energy() {
        return p1_energy;
    }

    public void setP1_energy(int p1_energy) {
        this.p1_energy = p1_energy;
    }

    public synchronized int getP1_health() {
        return p1_health;
    }

    public synchronized void setP1_health(int p1_health) {
        Match.p1_health = p1_health;
    }

    //********************************************
    public synchronized ArrayList<Unit> getP2_deck() {
        return p2_deck;
    }

    public synchronized ArrayList<Unit> getP2_hand() {
        return p2_hand;
    }

    public synchronized ArrayList<Unit> getP2_table() {
        return p2_table;
    }

    public void setP2_deck(ArrayList<Unit> p2_deck) {
        this.p2_deck = p2_deck;
    }

    public void setP2_hand(ArrayList<Unit> p2_hand) {
        this.p2_hand = p2_hand;
    }

    public void setP2_table(ArrayList<Unit> p2_table) {
        this.p2_table = p2_table;
    }

    public synchronized int getP2_energy() {
        return p2_energy;
    }

    public void setP2_energy(int p2_energy) {
        this.p2_energy = p2_energy;
    }

    public synchronized int getP2_health() {
        return p2_health;
    }

    public void setP2_health(int p2_health) {
        Match.p2_health = p2_health;
    }

    //********************************************
    public void setTurn_count(int turn_count) {
        this.turn_count = turn_count;
    }

    public synchronized int getTurn_count() {
        return turn_count;
    }

    public void setP_turn(int p_turn) {
        this.p_turn = p_turn;
    }

    public synchronized int getP_turn() {
        return p_turn;
    }

    public synchronized int getP1_spellIncrement() {
        return p1_spellIncrement;
    }

    public void setP1_spellIncrement(int p1_spellIncrement) {
        this.p1_spellIncrement = p1_spellIncrement;
    }

    public synchronized int getP2_spellIncrement() {
        return p2_spellIncrement;
    }

    public void setP2_spellIncrement(int p2_spellIncrement) {
        this.p2_spellIncrement = p2_spellIncrement;
    }

}


