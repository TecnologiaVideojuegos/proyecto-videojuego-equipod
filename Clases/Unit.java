package FightKnights.Logic;

import java.util.ArrayList;


public class Unit 
{
	private String name;
	private int cost;
	private int damage;
	private int health;
        private int initial_health;
        private int initial_damage;
        private String type;
        private boolean guard=false;
        private boolean attackExecuted;
    
	// LAS UNIDADES SE CREAN AL INICIAR LA PARTIDA Y SE METEN AL ARRAY DE CADA JUGADOR
	
	public Unit(String card_name)
	{
            switch(card_name)
		{
                    case "Contramaestre":
                            this.name = "Contramaestre";
                            this.cost = 4;
                            this.initial_damage = 3;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                        
                    case "Caballero Sagrado":
                            this.name = "Caballero Sagarado";
                            this.cost = 6;
                            this.initial_damage = 5;
                            this.initial_health = 6;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            this.guard = true;
                        
                    case "Bola de Fuego":
                            this.name = "Bola de Fuego";
                            this.cost = 3;
                            this.initial_damage = 4;
                            this.initial_health = 0;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Spell";
                        
                    case "Acechador Oscuro":
                            this.name = "Acechador Oscuro";
                            this.cost = 2;
                            this.initial_damage = 3;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                        
                    case "Cazador":
                            this.name = "Cazador";
                            this.cost = 1;
                            this.initial_damage = 1;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                        
                    case "Druida":
                            this.name = "Druida";
                            this.cost = 4;
                            this.initial_damage = 1;
                            this.initial_health = 4;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Clerigo":
                            this.name = "Clerigo";
                            this.cost = 2;
                            this.initial_damage = 1;
                            this.initial_health = 4;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Asesino":
                            this.name = "Asesino";
                            this.cost = 1;
                            this.initial_damage = 2;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    
                    case "Ladron":
                            this.name = "Ladron";
                            this.cost = 2;
                            this.initial_damage = 1;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Lobo":
                            this.name = "Lobo";
                            this.cost = 1;
                            this.initial_damage = 1;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;

                    case "Mago del Tiempo":
                            this.name = "Mago del Tiempo";
                            this.cost = 3;
                            this.initial_damage = 2;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Heraldo del Caos":
                            this.name = "Heraldo del Caos";
                            this.cost = 5;
                            this.initial_damage = 2;
                            this.initial_health = 6;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Ninja":
                            this.name = "Ninja";
                            this.cost = 3;
                            this.initial_damage = 3;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Segador":
                            this.name = "Segador";
                            this.cost = 4;
                            this.initial_damage = 4;
                            this.initial_health = 4;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                            
                    case "Segador Dorado":
                            this.name = "Segador Dorado";
                            this.cost = 7;
                            this.initial_damage = 5;
                            this.initial_health = 6;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Dragon Maligno":
                            this.name = "Dragon Maligno";
                            this.cost = 4;
                            this.initial_damage = 4;
                            this.initial_health = 5;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Dragon Oscuro":
                            this.name = "Dragon Oscuro";
                            this.cost = 4;
                            this.initial_damage = 5;
                            this.initial_health = 5;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Arquero":
                            this.name = "Arquero";
                            this.cost = 1;
                            this.initial_damage = 2;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Samurai":
                            this.name = "Samurai";
                            this.cost = 4;
                            this.initial_damage = 3;
                            this.initial_health = 5;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Bruja":
                            this.name = "Bruja";
                            this.cost = 2;
                            this.initial_damage = 2;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Acolito":
                            this.name = "Acolito";
                            this.cost = 2;
                            this.initial_damage = 2;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Ronin":
                            this.name = "Ronin";
                            this.cost = 2;
                            this.initial_damage = 4;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Lancero":
                            this.name = "Lancero";
                            this.cost = 1;
                            this.initial_damage = 1;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Templario":
                            this.name = "Templario";
                            this.cost = 2;
                            this.initial_damage = 2;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Pirata":
                            this.name = "Pirata";
                            this.cost = 2;
                            this.initial_damage = 3;
                            this.initial_health = 1;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=false;
                    case "Caballero":
                            this.name = "Caballero";
                            this.cost = 2;
                            this.initial_damage = 1;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Caballero Oscuro":
                            this.name = "Caballero Oscuro";
                            this.cost = 3;
                            this.initial_damage = 4;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=false;
                    case "Vikingo":
                            this.name = "Vikingo";
                            this.cost = 3;
                            this.initial_damage = 3;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Valkiria":
                            this.name = "Valkiria";
                            this.cost = 3;
                            this.initial_damage = 2;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Piromantica":
                            this.name = "Piromantica";
                            this.cost = 3;
                            this.initial_damage = 2;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Hechizera":
                            this.name = "Hechizera";
                            this.cost = 3;
                            this.initial_damage = 3;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Gladiador":
                            this.name = "Gladiador";
                            this.cost = 3;
                            this.initial_damage = 1;
                            this.initial_health = 7;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Paladin":
                            this.name = "Paladin";
                            this.cost = 4;
                            this.initial_damage = 6;
                            this.initial_health = 3;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Guerrero":
                            this.name = "Guerrero";
                            this.cost = 1;
                            this.initial_damage = 1;
                            this.initial_health = 2;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Guardian":
                            this.name = "Guardian";
                            this.cost = 4;
                            this.initial_damage = 3;
                            this.initial_health = 7;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Vampiro":
                            this.name = "Vampiro";
                            this.cost = 5;
                            this.initial_damage = 4;
                            this.initial_health = 4;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Usurpador":
                            this.name = "Usurpador";
                            this.cost = 5;
                            this.initial_damage = 3;
                            this.initial_health = 7;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Mago":
                            this.name = "Mago";
                            this.cost = 5;
                            this.initial_damage = 5;
                            this.initial_health = 4;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Jinete de Dragon":
                            this.name = "Jinete de Dragon";
                            this.cost = 5;
                            this.initial_damage = 5;
                            this.initial_health = 5;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Dragon Infernal":
                            this.name = "Dragon Infernal";
                            this.cost = 6;
                            this.initial_damage = 6;
                            this.initial_health = 6;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Archimago":
                            this.name = "Archimago";
                            this.cost = 7;
                            this.initial_damage = 7;
                            this.initial_health = 8;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Sacerdote":
                            this.name = "Sacerdote";
                            this.cost = 8;
                            this.initial_damage = 8;
                            this.initial_health = 7;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
                    case "Rey":
                            this.name = "Rey";
                            this.cost = 8;
                            this.initial_damage = 9;
                            this.initial_health = 7;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.guard = true;
                            this.attackExecuted=true;
                    case "Devastador":
                            this.name = "Devastador";
                            this.cost = 10;
                            this.initial_damage = 10;
                            this.initial_health = 10;
                            this.damage = this.initial_damage;
                            this.health = this.initial_health;
                            this.type = "Minion";
                            this.attackExecuted=true;
            }
		
	}
	
	// AL CREAR LA UNIDAD SE EJECUTA INITSKILL Y ALIVESKILL PARA COMPROBAR
	// SI ESA CARTA TIENE EFECTOS DE ESOS.
	
	public void initSkill(Unit target) // Efecto que se ejecuta al invocar la carta.
	{
		switch(name)
		{
                    case "Bola de fuego":
                    {
                        Match match = Match.getMatchInstance();
                        int danio_incrementado;
                        
                        if(match.getP_turn()==1){
                            danio_incrementado = match.getP1_spellIncrement();
                        } else {
                            danio_incrementado = match.getP2_spellIncrement();
                        }  
                        target.setHealth(target.getHealth() - (this.damage+danio_incrementado));
                    }
                    case "Cazador":
                    {
                        Match match = Match.getMatchInstance();
                        Unit lobo = new Unit("Lobo");
                        GameMethods.specialInvokeCard(lobo, null, match.getP_turn()); //Invoca al primer lobo si cabe
                        GameMethods.specialInvokeCard(lobo, null, match.getP_turn()); //Invoca al segundo lobo si cabe
                    }
                    case "Clerigo":
                    {
                        target.setHealth(target.getHealth()+5);
                    }
                    case "Valkiria":
                    {
                        Match match = Match.getMatchInstance();
                        ArrayList<Unit> tablero_aliado;
                        
                        if(match.getP_turn()==1){
                            tablero_aliado = match.getP1_table();
                        } else {
                            tablero_aliado = match.getP2_table();
                        }
                        for (Unit unit : tablero_aliado) {
                            unit.setHealth(unit.getHealth()+1);
                        }                                
                    }
                    case "Sacerdote":{
                        Match match = Match.getMatchInstance();
                        ArrayList<Unit> tablero_aliado;
                        
                        if(match.getP_turn()==1){
                            tablero_aliado = match.getP1_table();
                        } else {
                            tablero_aliado = match.getP2_table();
                        }
                        for (Unit unit : tablero_aliado) {
                            unit.setHealth(unit.getHealth()+3);
                        }
                    }
                    case "Devastador":{
                        Match match = Match.getMatchInstance();
                        ArrayList<Unit> tablero_aliado;
                        ArrayList<Unit> tablero_enemigo;
                        ArrayList<Unit> mano_aliada;
                        if(match.getP_turn()==1){
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
                    }
                    case "Bruja":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getP_turn()==1){
                            match.setP1_spellIncrement(match.getP1_spellIncrement()+1);
                        } else {
                            match.setP2_spellIncrement(match.getP2_spellIncrement()+1);
                        }
                    }
                    case "Hechicera":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getP_turn()==1){
                            match.setP1_spellIncrement(match.getP1_spellIncrement()+1);
                        } else {
                            match.setP2_spellIncrement(match.getP2_spellIncrement()+1);
                        }
                    }
                    case "Mago":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getP_turn()==1){
                            match.setP1_spellIncrement(match.getP1_spellIncrement()+1);
                        } else {
                            match.setP2_spellIncrement(match.getP2_spellIncrement()+1);
                        }
                    }
                    case "Archimago":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getP_turn()==1){
                            match.setP1_spellIncrement(match.getP1_spellIncrement()+2);
                        } else {
                            match.setP2_spellIncrement(match.getP2_spellIncrement()+2);
                        }
                    }
                    default:
                                {
                                        System.out.println("No tiene skill al invocarse");
                                }
		}
	}
	
	public void attackSkill(Unit target) // Efecto que se ejecuta al atacar.
	{
		switch(name)
		{
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
                            this.setHealth(this.getHealth()+1);
                        }
                        
			default:
			{
				System.out.println("No tiene skill al atacar");
			}
		}
	}
	
	public void aliveSkill(Unit target) // Efecto que se ejecuta mientras esta en la mesa.
	{
		switch(name)
		{
                    case "Druida":{
                        target.setHealth(target.getHealth()+1);
                    }
                    case "Dragon Maligno":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getTurn_count()>10){
                            this.setDamage(this.getDamage()+2);
                        }
                    }
                    case "Samurai":
                    {
                        Match match = Match.getMatchInstance();
                        if(match.getTurn_count()>7){
                            this.setDamage(this.getDamage()+2);
                        }
                    }
                    case "Dragon Infernal":
                    {
                        if(this.getHealth()<this.getInitial_health()){
                            this.setDamage(this.getDamage()+2);
                        }
                    }
                    default:
			{
                            System.out.println("No tiene skill al estar vivo");
			}    
		}
	}
	
	public void deathSkill(Unit target) // Efecto que se ejecuta al ser destruda la carta.
	{
		switch(name)
		{
			case "Contramaestre":
			{
				Unit bolaFuego = new Unit("Bola de Fuego");
                                bolaFuego.initSkill(target);
			}
                        case "Caballero Sagrado":{
                                target.setHealth(target.getHealth()+2);
                        }
                        case "Piromantica":{
                                Match match = Match.getMatchInstance();
                                ArrayList<Unit> mano_aliada;
                        
                                if(match.getP_turn()==1){
                                    mano_aliada = match.getP1_hand();
                                } else {
                                    mano_aliada = match.getP2_hand();
                                }
                                if(mano_aliada.size()<10){
                                    mano_aliada.add(new Unit("Bola de Fuego"));
                                }
                        }
                        case "Usurpador":{
                                Match match = Match.getMatchInstance();
                                ArrayList<Unit> tablero_enemigo;
                        
                                if(match.getP_turn()==2){
                                    tablero_enemigo = match.getP1_table();
                                } else {
                                    tablero_enemigo = match.getP2_table();
                                }
                                for (Unit unit : tablero_enemigo) {
                                    unit.setHealth(unit.getHealth()-1);
                                }
                        }
			default:
			{
				System.out.println("No tiene skill al morir");
			}
		}
	}
	
	// GETTERS Y SETTERS
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	public int getDamage()
	{
		return damage;
	}
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	public int getHealth()
	{
		return health;
	}
	public void setHealth(int health)
	{
		if(health>this.initial_health){
                    this.health=this.initial_health;
                }
                else
                    this.health=health;
	}
    public String getType() 
    {
            return type;
    }
    public void setType(String type) 
    {
            this.type = type;
    }
    public boolean getGuard() 
    {
            return guard;
    }
    public void setGuard(Boolean state) 
    {
            this.guard = state;
    }
    public boolean isAttackExecuted() 
    {
        return attackExecuted;
    }
    public void setAttackExecuted(boolean attackExecuted) 
    {
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
      
}