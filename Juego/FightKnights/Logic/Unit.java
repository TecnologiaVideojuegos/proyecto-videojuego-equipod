package FightKnights.Logic;

import java.util.ArrayList;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Unit {

    private String name;
    private int cost;
    private int damage;
    private int health;
    private int initial_health;
    private int initial_damage;
    private String type;
    private boolean guard = false;
    private boolean attackExecuted;
    private int x;
    private int y;
    private int escalaX;
    private int escalaY;
    private Image rutaImagenTablero;
    private Image rutaImagenMesa; //meter en el constructor a cada carta
    // LAS UNIDADES SE CREAN AL INICIAR LA PARTIDA Y SE METEN AL ARRAY DE CADA JUGADOR

    public Unit(String card_name) throws SlickException {
        switch (card_name) {
            case "1":
                this.name = "Contramaestre";
                this.cost = 4;
                this.initial_damage = 3;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/1.png");
                this.rutaImagenMesa = new Image("res/r1.png");
                break;
            case "2":
                this.name = "Caballero Sagrado";
                this.cost = 6;
                this.initial_damage = 5;
                this.initial_health = 6;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.guard = true;
                this.rutaImagenTablero = new Image("res/2.png");
                this.rutaImagenMesa = new Image("res/r2.png");
                break;
            case "25":
                this.name = "Bola de Fuego";
                this.cost = 3;
                this.initial_damage = 4;
                this.initial_health = 0;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Spell";
                this.rutaImagenTablero = new Image("res/25.png");
                this.rutaImagenMesa = new Image("res/r25.png");
                break;
            case "24":
                this.name = "Acechador Oscuro";
                this.cost = 2;
                this.initial_damage = 3;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/24.png");
                this.rutaImagenMesa = new Image("res/r24.png");
                break;
            case "7":
                this.name = "Cazador";
                this.cost = 1;
                this.initial_damage = 1;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/7.png");
                this.rutaImagenMesa = new Image("res/r7.png");
                break;
            case "41":
                this.name = "Druida";
                this.cost = 4;
                this.initial_damage = 1;
                this.initial_health = 4;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/41.png");
                this.rutaImagenMesa = new Image("res/r41.png");
                break;
            case "39":
                this.name = "Clerigo";
                this.cost = 2;
                this.initial_damage = 1;
                this.initial_health = 4;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/39.png");
                this.rutaImagenMesa = new Image("res/r39.png");
                break;
            case "23":
                this.name = "Asesino";
                this.cost = 1;
                this.initial_damage = 2;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/23.png");
                this.rutaImagenMesa = new Image("res/r23.png");
                break;
            case "44":
                this.name = "Ladron";
                this.cost = 2;
                this.initial_damage = 1;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/44.png");
                this.rutaImagenMesa = new Image("res/r44.png");
                break;
            /*case "10":
                            this.name = "Lobo";
                            this.cost = 1;
                            this.initial_damage = 1;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            this.rutaImagenTablero = new Image("res/999.jpeg");*/
            case "37":
                this.name = "Mago del Tiempo";
                this.cost = 3;
                this.initial_damage = 2;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/37.png");
                this.rutaImagenMesa = new Image("res/r37.png");
                break;
            case "3":
                this.name = "Heraldo del Caos";
                this.cost = 5;
                this.initial_damage = 2;
                this.initial_health = 6;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/3.png");
                this.rutaImagenMesa = new Image("res/r3.png");
                break;               
            case "35":
                this.name = "Ninja";
                this.cost = 3;
                this.initial_damage = 3;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/35.png");
                this.rutaImagenMesa = new Image("res/r35.png");
                break;
            case "4":
                this.name = "Segador";
                this.cost = 4;
                this.initial_damage = 4;
                this.initial_health = 4;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/4.png");
                this.rutaImagenMesa = new Image("res/r4.png");
                break;
            case "42":
                this.name = "Segador Dorado";
                this.cost = 7;
                this.initial_damage = 5;
                this.initial_health = 6;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/42.png");
                this.rutaImagenMesa = new Image("res/r42.png");
                break;
            case "16":
                this.name = "Dragon Maligno";
                this.cost = 4;
                this.initial_damage = 4;
                this.initial_health = 5;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/16.png");
                this.rutaImagenMesa = new Image("res/r16.png");
                break;
            case "5":
                this.name = "Dragon Oscuro";
                this.cost = 4;
                this.initial_damage = 5;
                this.initial_health = 5;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/5.png");
                this.rutaImagenMesa = new Image("res/r5.png");
                break;
            case "18":
                this.name = "Arquero";
                this.cost = 1;
                this.initial_damage = 2;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/18.png");
                this.rutaImagenMesa = new Image("res/r18.png");
                break;
            case "30":
                this.name = "Samurai";
                this.cost = 4;
                this.initial_damage = 3;
                this.initial_health = 5;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/30.png");
                this.rutaImagenMesa = new Image("res/r30.png");
                break;
            case "17":
                this.name = "Bruja";
                this.cost = 2;
                this.initial_damage = 2;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/17.png");
                this.rutaImagenMesa = new Image("res/r17.png");
                break;
            case "19":
                this.name = "Acolito";
                this.cost = 2;
                this.initial_damage = 2;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/19.png");
                this.rutaImagenMesa = new Image("res/r19.png");
                break;
            case "32":
                this.name = "Ronin";
                this.cost = 2;
                this.initial_damage = 4;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/32.png");
                this.rutaImagenMesa = new Image("res/r32.png");
                break;
            case "36":
                this.name = "Lancero";
                this.cost = 1;
                this.initial_damage = 1;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/36.png");
                this.rutaImagenMesa = new Image("res/r36.png");
                break;
            case "27":
                this.name = "Templario";
                this.cost = 2;
                this.initial_damage = 2;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/27.png");
                this.rutaImagenMesa = new Image("res/r27.png");
                break;
            case "8":
                this.name = "Pirata";
                this.cost = 2;
                this.initial_damage = 3;
                this.initial_health = 1;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = false;
                this.rutaImagenTablero = new Image("res/8.png");
                this.rutaImagenMesa = new Image("res/r8.png");
                break;
            case "38":
                this.name = "Caballero";
                this.cost = 2;
                this.initial_damage = 1;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/38.png");
                this.rutaImagenMesa = new Image("res/r38.png");
                break;
            case "9":
                this.name = "Caballero Oscuro";
                this.cost = 3;
                this.initial_damage = 4;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = false;
                this.rutaImagenTablero = new Image("res/9.png");
                this.rutaImagenMesa = new Image("res/r9.png");
                break;
            case "21":
                this.name = "Vikingo";
                this.cost = 3;
                this.initial_damage = 3;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/21.png");
                this.rutaImagenMesa = new Image("res/r21.png");
                break;
            case "26":
                this.name = "Valkiria";
                this.cost = 3;
                this.initial_damage = 2;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/26.png");
                this.rutaImagenMesa = new Image("res/r26.png");
                break;
            case "6":
                this.name = "Piromantica";
                this.cost = 3;
                this.initial_damage = 2;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/6.png");
                this.rutaImagenMesa = new Image("res/r6.png");
                break;
            case "34":
                this.name = "Hechizera";
                this.cost = 3;
                this.initial_damage = 3;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/34.png");
                this.rutaImagenMesa = new Image("res/r34.png");
                break;
            case "14":
                this.name = "Gladiador";
                this.cost = 3;
                this.initial_damage = 1;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/14.png");
                this.rutaImagenMesa = new Image("res/r14.png");
                break;
            case "33":
                this.name = "Paladin";
                this.cost = 4;
                this.initial_damage = 6;
                this.initial_health = 3;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/33.png");
                this.rutaImagenMesa = new Image("res/r33.png");
                break;
            case "43":
                this.name = "Guerrero";
                this.cost = 1;
                this.initial_damage = 1;
                this.initial_health = 2;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/43.png");
                this.rutaImagenMesa = new Image("res/r43.png");
                break;
            case "11":
                this.name = "Guardian";
                this.cost = 4;
                this.initial_damage = 3;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/11.png");
                this.rutaImagenMesa = new Image("res/r11.png");
                break;
            case "22":
                this.name = "Vampiro";
                this.cost = 5;
                this.initial_damage = 4;
                this.initial_health = 4;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/22.png");
                this.rutaImagenMesa = new Image("res/r22.png");
                break;
            case "28":
                this.name = "Usurpador";
                this.cost = 5;
                this.initial_damage = 3;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/28.png");
                this.rutaImagenMesa = new Image("res/r28.png");
                break;
            case "13":
                this.name = "Mago";
                this.cost = 5;
                this.initial_damage = 5;
                this.initial_health = 4;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/13.png");
                this.rutaImagenMesa = new Image("res/r13.png");
                break;
            case "12":
                this.name = "Jinete de Dragon";
                this.cost = 5;
                this.initial_damage = 5;
                this.initial_health = 5;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/12.png");
                this.rutaImagenMesa = new Image("res/r12.png");
                break;
            case "15":
                this.name = "Dragon Infernal";
                this.cost = 6;
                this.initial_damage = 6;
                this.initial_health = 6;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/15.png");
                this.rutaImagenMesa = new Image("res/r15.png");
                break;
            case "20":
                this.name = "Archimago";
                this.cost = 7;
                this.initial_damage = 7;
                this.initial_health = 8;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/20.png");
                this.rutaImagenMesa = new Image("res/r20.png");
                break;
            case "29":
                this.name = "Sacerdote";
                this.cost = 8;
                this.initial_damage = 8;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/29.png");
                this.rutaImagenMesa = new Image("res/r29.png");
                break;
            case "31":
                this.name = "Rey";
                this.cost = 8;
                this.initial_damage = 9;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.guard = true;
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/31.png");
                this.rutaImagenMesa = new Image("res/r31.png");
                break;
            case "10":
                this.name = "Devastador";
                this.cost = 10;
                this.initial_damage = 10;
                this.initial_health = 10;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/10.png");
                this.rutaImagenMesa = new Image("res/r10.png");
                break;
            default: {
                this.name = "Sacerdote";
                this.cost = 8;
                this.initial_damage = 8;
                this.initial_health = 7;
                this.damage = this.initial_damage;
                this.health = this.initial_health;
                this.type = "Minion";
                this.attackExecuted = true;
                this.rutaImagenTablero = new Image("res/29.png");
                this.rutaImagenMesa = new Image("res/r29.png");
                break;
            }
        }

    }

    // AL CREAR LA UNIDAD SE EJECUTA INITSKILL Y ALIVESKILL PARA COMPROBAR
    // SI ESA CARTA TIENE EFECTOS DE ESOS.
    public void initSkill() throws SlickException // Efecto que se ejecuta al invocar la carta.
    {
        switch (name) {
            case "Bola de Fuego": {
                Match match = Match.getMatchInstance();
                int danio_incrementado;

                if (match.getP_turn() == 1) {
                    danio_incrementado = match.getP1_spellIncrement();
                } else {
                    danio_incrementado = match.getP2_spellIncrement();
                }
                
                if(match.getP_turn() == 1)
                {
                    for(Unit unit : match.getP2_table())
                    {
                        unit.setHealth(unit.getHealth() - (1 + danio_incrementado));
                    }
                }
                else
                {
                    for(Unit unit : match.getP1_table())
                    {
                        unit.setHealth(unit.getHealth() - (1 + danio_incrementado));
                    }
                }
                
                
                //target.setHealth(target.getHealth() - (this.damage + danio_incrementado));
                break;
            }
            case "Clerigo": {
                Match match = Match.getMatchInstance();
                if(match.getP_turn() == 1)
                {
                    match.setP1_health(match.getP1_health() + 5);
                }
                else
                {
                    match.setP2_health(match.getP2_health() + 5);
                }
                //target.setHealth(target.getHealth() + 5);
                break;
            }
            case "Valkiria": {
                Match match = Match.getMatchInstance();

                if (match.getP_turn() == 1) 
                {
                    for(int i = 0; i < match.getP1_table().size(); i++)
                    {
                        match.getP1_table().get(i).setHealth(match.getP1_table().get(i).getHealth() + 1);
                    }
                } 
                else 
                {
                    for(int i = 0; i < match.getP2_table().size(); i++)
                    {
                        match.getP2_table().get(i).setHealth(match.getP2_table().get(i).getHealth() + 1);
                    }
                }
                
                break;
            }
            case "Sacerdote": {
                Match match = Match.getMatchInstance();

                if (match.getP_turn() == 1) 
                {
                    for(int i = 0; i < match.getP1_table().size(); i++)
                    {
                        match.getP1_table().get(i).setHealth(match.getP1_table().get(i).getHealth() + 3);
                    }
                } 
                else 
                {
                    for(int i = 0; i < match.getP2_table().size(); i++)
                    {
                        match.getP2_table().get(i).setHealth(match.getP2_table().get(i).getHealth() + 3);
                    }
                }
                break;
            }
            case "Devastador": {
                Match match = Match.getMatchInstance();
                ArrayList<Unit> tablero_aliado;
                ArrayList<Unit> tablero_enemigo;
                ArrayList<Unit> mano_aliada;
                
                if (match.getP_turn() == 1) {
                    tablero_aliado = match.getP1_table();
                    tablero_enemigo = match.getP2_table();
                    mano_aliada = match.getP1_hand();
                } else {
                    tablero_aliado = match.getP2_table();
                    tablero_enemigo = match.getP1_table();
                    mano_aliada = match.getP2_hand();
                }
                tablero_aliado.clear();
                tablero_enemigo.clear();
                mano_aliada.clear();
                
                tablero_aliado.add(new Unit("10"));
                break;
            }
            case "Bruja": {
                Match match = Match.getMatchInstance();
                if (match.getP_turn() == 1) {
                    match.setP1_spellIncrement(match.getP1_spellIncrement() + 1);
                } else {
                    match.setP2_spellIncrement(match.getP2_spellIncrement() + 1);
                }
                break;
            }
            case "Hechicera": {
                Match match = Match.getMatchInstance();
                if (match.getP_turn() == 1) {
                    match.setP1_spellIncrement(match.getP1_spellIncrement() + 1);
                } else {
                    match.setP2_spellIncrement(match.getP2_spellIncrement() + 1);
                }
                break;
            }
            case "Mago": {
                Match match = Match.getMatchInstance();
                if (match.getP_turn() == 1) {
                    match.setP1_spellIncrement(match.getP1_spellIncrement() + 1);
                } else {
                    match.setP2_spellIncrement(match.getP2_spellIncrement() + 1);
                }
                break;
            }
            case "Archimago": {
                Match match = Match.getMatchInstance();
                if (match.getP_turn() == 1) {
                    match.setP1_spellIncrement(match.getP1_spellIncrement() + 2);
                } else {
                    match.setP2_spellIncrement(match.getP2_spellIncrement() + 2);
                }
                break;
            }
            default: {
                System.out.println("No tiene skill al invocarse");
            }
        }
    }

    public void attackSkill() // Efecto que se ejecuta al atacar.
    {
        switch (name) {
            /*case "Acechador Oscuro":
			{
				Match match = Match.getMatchInstance();
				
				if(target.getName().equals("Acechador Oscuro"))
				{
					this.setHealth(0);
					if(match.getP_turn() == 1)
					{
						ArrayList<Unit> array = match.getP1_table();
						array.remove(this);
						match.setP1_table(array);
					}
					else
					{
						ArrayList<Unit> array = match.getP2_table();
						array.remove(this);
						match.setP1_table(array);
					}
				}
			}*/
            case "Vampiro": 
            {
                this.setHealth(this.getHealth() + 1);
                break;
            }

            default: 
            {
                System.out.println("No tiene skill al atacar");
                break;
            }
        }
    }

    public void aliveSkill() // Efecto que se ejecuta mientras esta en la mesa.
    {
        switch (name) {
            case "Druida": {
                Match match = Match.getMatchInstance();
                for(Unit unit : match.getP1_table())
                {
                    unit.setHealth(unit.getHealth() + 1);
                }
                for(Unit unit : match.getP2_table())
                {
                    unit.setHealth(unit.getHealth() + 1);
                }
                //target.setHealth(target.getHealth() + 1);
                break;
            }
            case "Dragon Maligno": {
                Match match = Match.getMatchInstance();
                if (match.getTurn_count() > 10) {
                    this.setHealth(this.getHealth() + 2);
                }
                break;
            }
            case "Samurai": {
                Match match = Match.getMatchInstance();
                if (match.getTurn_count() > 7) {
                    this.setDamage(this.getDamage() + 2);
                }
                break;
            }
            case "Dragon Infernal": {
                if (this.getHealth() < this.getInitial_health()) {
                    this.setDamage(this.getDamage() + 2);
                }
                break;
            }
            default: {
                System.out.println("No tiene skill al estar vivo");
                break;
            }

        }
    }

    public void deathSkill() throws SlickException // Efecto que se ejecuta al ser destruda la carta.
    {
        switch (name) {
            case "Contramaestre": {
                Unit bolaFuego = new Unit("Bola de Fuego");
                bolaFuego.initSkill();
                break;
            }
            case "Caballero Sagrado": {
                //target.setHealth(target.getHealth() + 2);
                break;
            }
            case "Piromantica": {
                Match match = Match.getMatchInstance();

                if (match.getP_turn() == 1) 
                {
                    if (match.getP2_hand().size() < 4) 
                    {
                        match.getP2_hand().add(new Unit("Bola de Fuego"));
                    }
                } 
                else 
                {
                    if (match.getP1_hand().size() < 4) 
                    {
                        match.getP1_hand().add(new Unit("Bola de Fuego"));
                    }
                }
                
                break;
            }
            case "Usurpador": {
                Match match = Match.getMatchInstance();
                
                if(match.getP_turn() == 1)
                {
                    for(Unit unit : match.getP2_table())
                    {
                        unit.setHealth(unit.getHealth() - 1);
                        if(unit.getHealth() <= 0)
                        {
                            match.getP2_table().remove(unit);
                        }
                    }
                }
                else
                {
                    for(Unit unit : match.getP1_table())
                    {
                        unit.setHealth(unit.getHealth() - 1);
                        if(unit.getHealth() <= 0)
                        {
                            match.getP1_table().remove(unit);
                        }
                    }
                }
                break;
            }
            default: {
                System.out.println("No tiene skill al morir");
                break;
            }
        }
    }

    // GETTERS Y SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > this.initial_health) {
            this.health = this.initial_health;
        } else {
            this.health = health;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getGuard() {
        return guard;
    }

    public void setGuard(Boolean state) {
        this.guard = state;
    }

    public boolean isAttackExecuted() {
        return attackExecuted;
    }

    public void setAttackExecuted(boolean attackExecuted) {
        this.attackExecuted = attackExecuted;
    }

    public int getInitial_health() {
        return initial_health;
    }

    public void setInitial_health(int initial_health) {
        this.initial_health = initial_health;
    }

    public int getInitial_damage() {
        return initial_damage;
    }

    public void setInitial_damage(int initial_damage) {
        this.initial_damage = initial_damage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getEscalaX() {
        return escalaX;
    }

    public void setEscalaX(int escalaX) {
        this.escalaX = escalaX;
    }

    public int getEscalaY() {
        return escalaY;
    }

    public void setEscalaY(int escalaY) {
        this.escalaY = escalaY;
    }

    public Image getRutaImagenTablero() {
        return rutaImagenTablero;
    }

    public void setRutaImagenTablero(Image rutaImagenTablero) {
        this.rutaImagenTablero = rutaImagenTablero;
    }
    
    public Image getRutaImagenMesa() {
        return rutaImagenMesa;
    }

    public void setRutaImagenMesa(Image rutaImagenMesa) {
        this.rutaImagenMesa = rutaImagenMesa;
    }
    
}