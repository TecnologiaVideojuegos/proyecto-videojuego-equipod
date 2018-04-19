package FightKnights.Logic;

import java.util.ArrayList;


public class Unit 
{
	private String name;
	private int cost;
	private int damage;
	private int health;
    private String type;
    private String state;
    private boolean attackExecuted;
    
	// LAS UNIDADES SE CREAN AL INICIAR LA PARTIDA Y SE METEN AL ARRAY DE CADA JUGADOR
	
	public Unit(String card_name)
	{
            switch(card_name)
		{
                    case "Contramaestre":
                            this.name = "Contramaestre";
                            this.cost = 4;
                            this.damage = 3;
                            this.health = 3;
                            this.type = "Minion";
                        
                    case "Caballero Sagrado":
                            this.name = "Caballero Sagarado";
                            this.cost = 3;
                            this.damage = 3;
                            this.health = 3;
                            this.type = "Minion";
                        
                    case "Bola de Fuego":
                            this.name = "Bola de Fuego";
                            this.cost = 3;
                            this.damage = 4;
                            this.health = 0;
                            this.type = "Spell";
                        
                    case "Acechador Oscuro":
                            this.name = "Acechador Oscuro";
                            this.cost = 2;
                            this.damage = 3;
                            this.health = 2;
                            this.type = "Minion";
                        
                    case "Cazador":
                            this.name = "Cazador";
                            this.cost = 1;
                            this.damage = 1;
                            this.health = 1;
                            this.type = "Minion";
                        
                    case "Druida":
                            this.name = "Druida";
                            this.cost = 4;
                            this.damage = 1;
                            this.health = 4;
                            this.type = "Minion";
                            
                    case "Clerigo":
                            this.name = "Clerigo";
                            this.cost = 2;
                            this.damage = 1;
                            this.health = 4;
                            this.type = "Minion";
                            
                    case "Asesino":
                            this.name = "Asesino";
                            this.cost = 3;
                            this.damage = 3;
                            this.health = 3;
                            this.type = "Minion";
                    
                    case "Ladron":
                            this.name = "Ladron";
                            this.cost = 2;
                            this.damage = 1;
                            this.health = 1;
                            this.type = "Minion";
                            
                    case "Lobo":
                            this.name = "Lobo";
                            this.cost = 1;
                            this.damage = 1;
                            this.health = 2;
                            this.type = "Minion";

                    case "Mago del Tiempo":
                            this.name = "Mago del Tiempo";
                            this.cost = 3;
                            this.damage = 2;
                            this.health = 2;
                            this.type = "Minion";
                            
                    case "Heraldo del Caos":
                            this.name = "Heraldo del Caos";
                            this.cost = 5;
                            this.damage = 2;
                            this.health = 6;
                            this.type = "Minion";
                            
                    case "Ninja":
                            this.name = "Ninja";
                            this.cost = 3;
                            this.damage = 3;
                            this.health = 2;
                            this.type = "Minion";
                            
                    case "Segador":
                            this.name = "Segador";
                            this.cost = 4;
                            this.damage = 4;
                            this.health = 4;
                            this.type = "Minion";
                            
                    case "Segador Dorado":
                            this.name = "Segador Dorado";
                            this.cost = 7;
                            this.damage = 5;
                            this.health = 6;
                            this.type = "Minion";
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
                target.setHealth(target.getHealth() - damage);
            }
            case "Caballero Sagrado":
            {
                state = "Guard"; //estado de "Provocar"
            }
            case "Cazador":
            {
                Match match = Match.getMatchInstance();
                
                Unit lobo = new Unit("Lobo");
                GameMethods.specialInvokeCard(lobo, null, match.getP_turn()); //Invoca al primer lobo si cabe
                GameMethods.specialInvokeCard(lobo, null, match.getP_turn()); //Invoca al segundo lobo si cabe
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
			case "Acechador Oscuro":
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
		this.health = health;
	}
    public String getType() 
    {
            return type;
    }
    public void setType(String type) 
    {
            this.type = type;
    }
    public String getState() 
    {
            return state;
    }
    public void setState(String state) 
    {
            this.state = state;
    }
    public boolean isAttackExecuted() 
    {
        return attackExecuted;
    }
    public void setAttackExecuted(boolean attackExecuted) 
    {
        this.attackExecuted = attackExecuted;
    }
        
}