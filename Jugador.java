    
package FightKnights.Classes;



public class Jugador {
    private int health;
    private int energy;
    public Jugador() {
        this.health = 30;
        this.energy = 0;
    }

    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public boolean estaMuerto(){
        return this.health<=0;
    }
    public void aumentarMana(){//metodo a ejecutar cada vez que se cambie de turno
        this.energy+=1;
    }
}
