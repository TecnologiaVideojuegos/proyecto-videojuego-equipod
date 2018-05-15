package FightKnights.Logic;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.SlickException;

public class GameMethods 
{
    public static void swichTurn(int player) //Se encarga de cambiar el turno y actualiza el contador
    {
        Match match = Match.getMatchInstance();
        ArrayList<Unit> tablePlayer1 = match.getP1_table();
        ArrayList<Unit> tablePlayer2 = match.getP2_table();
        
        // Resetea el booleano de ataque para cada carta de la mesa del jugador.
        
        for(Unit units : tablePlayer1)
            units.setAttackExecuted(false);
        for(Unit units : tablePlayer2)
            units.setAttackExecuted(false);
        
        // Incrementa el turno de la partida.
        
        if(player == 1)
        {
            match.setP_turn(2);
            int i = match.getP2_deck().size() - 1;
            Unit unit = match.getP2_deck().get(i);
            ArrayList aux = match.getP2_hand();
            aux.add(unit);
            match.setP2_hand(aux);
            match.getP2_deck().remove(unit);
        }
        else
        {
            match.setP_turn(1);
            int i = match.getP1_deck().size() - 1;
            Unit unit = match.getP1_deck().get(i);
            ArrayList aux = match.getP1_hand();
            aux.add(unit);
            match.setP1_hand(aux);
            match.getP1_deck().remove(unit);
        }
        
        match.setTurn_count(match.getTurn_count() + 1);
    }
    
    // Ataques basicos de cada unidad a unidades enemigas.
    
    public static void executeAttack(Unit unit, Unit target, int player) //Ejecutamos un ataque a otra carta
    {
        Match match = Match.getMatchInstance();
        ArrayList<Unit> tablePlayer1 = match.getP1_table();
        ArrayList<Unit> tablePlayer2 = match.getP2_table();
        
        if(!unit.isAttackExecuted())
        {
			 if(player == 1)
		     {
		         boolean isGuarded = false;
		         for(Unit units : tablePlayer2)
		         {
		             if(units.getGuard())
		             {
		                 isGuarded = true;
		                 if (units.equals(target))
		                 {
		                     target.setHealth(target.getHealth() - unit.getDamage());
		                     unit.setHealth(unit.getHealth() - target.getDamage());
		                     unit.setAttackExecuted(true);
		                 }
		                 else
		                     System.out.println("No puedes atacar, alguien lo protege.");
		             }
		         }
		         if(!isGuarded)
		         {
		             target.setHealth(target.getHealth() - unit.getDamage());
		             unit.setHealth(unit.getHealth() - target.getDamage());
		             unit.setAttackExecuted(true);
		         }
		     }
		     else
		     {
		     	boolean isGuarded = false;
		         for(Unit units : tablePlayer1)
		         {
		             if(units.getGuard())
		             {
		                 isGuarded = true;
		                 if (units.equals(target))
		                 {
		                     target.setHealth(target.getHealth() - unit.getDamage());
		                     unit.setHealth(unit.getHealth() - target.getDamage());
		                     unit.setAttackExecuted(true);
		                 }
		                 else
		                     System.out.println("No puedes atacar, alguien lo protege.");
		             }
		         }
		         if(!isGuarded)
		         {
		             target.setHealth(target.getHealth() - unit.getDamage());
		             unit.setHealth(unit.getHealth() - target.getDamage());
		             unit.setAttackExecuted(true);
		         }
		         
		     }
        	 
            if(target.getHealth() <= 0)
            {
                if(player == 1)
                    tablePlayer2.remove(target);
                else
                    tablePlayer1.remove(target);
            }
            if(unit.getHealth() <= 0)
            {
                if(player == 1)
                    tablePlayer2.remove(unit);
                else
                    tablePlayer1.remove(unit);
            }
        }
    }
    
    public static void executeAttackToPlayer(Unit unit, int player) //Ejecutamos un ataque al otro jugador
    {
        Match match = Match.getMatchInstance();
        
        if(player == 1)
            match.setP2_health(match.getP2_health() - unit.getDamage());
        else
            match.setP1_health(match.getP1_health() - unit.getDamage());
    }
    
    // Invocaciones a la mesa de cada jugador
    
    public static void invokeCard(Unit unit, Unit target, int player) throws SlickException //Invocamos a una carta a la mesa
    {
        Match match = Match.getMatchInstance();
        
        switch(unit.getType())
        {
            case "Minion":
            {
                if(player == 1)
                {
                    ArrayList<Unit> handPlayer1 = match.getP1_hand();
                    ArrayList<Unit> tablePlayer1 = match.getP1_table();
                    
                    if(tablePlayer1.size() <= 4 )
                    {
                        if(match.getP1_energy() >= unit.getCost())
                        {
                            tablePlayer1.add(unit);
                            handPlayer1.remove(unit);
                            
                            match.setP1_energy(match.getP1_energy() - unit.getCost());
                            unit.initSkill();
                            
                            System.out.println("Invocado");
                            
                        } 
                        else
                            System.out.println("No tienes suficiente energia");
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
                else
                {
                    ArrayList<Unit> handPlayer2 = match.getP2_hand();
                    ArrayList<Unit> tablePlayer2 = match.getP2_table();
                    
                    if(tablePlayer2.size() <= 4 )
                    {
                        if(match.getP2_energy() >= unit.getCost())
                        {
                            tablePlayer2.add(unit);
                            handPlayer2.remove(unit);
                            
                            match.setP2_energy(match.getP2_energy() - unit.getCost());
                            unit.initSkill();
                            
                            System.out.println("Invocado");
                            
                        }  
                        else
                            System.out.println("No tienes suficiente energia");
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
                break;
            }
            case "Spell":
            {
                if(player == 1)
                {
                    ArrayList<Unit> handPlayer1 = match.getP1_hand();
                    
                    if(match.getP1_energy() >= unit.getCost())
                    {
                        handPlayer1.remove(unit);

                        match.setP1_energy(match.getP1_energy() - unit.getCost());
                        unit.initSkill();
                        
                        System.out.println("Invocado");
                            
                    }   
                    else
                        System.out.println("No tienes suficiente energia");
                }
                
                else
                {
                    ArrayList<Unit> handPlayer2 = match.getP2_hand();
                    
                    if(match.getP2_energy() >= unit.getCost())
                    {
                        handPlayer2.remove(unit);

                        match.setP2_energy(match.getP2_energy() - unit.getCost());
                        unit.initSkill();
                        
                        System.out.println("Invocado");
                            
                    }   
                    else
                        System.out.println("No tienes suficiente energia");
                }
                break;
            }
            default:
            {
                
            }
        }
    }

    /*public static void specialInvokeCard(Unit unit, Unit target, int player) throws SlickException //Invocacion realizada sin estar una carta en la mano.
    {
    	Match match = Match.getMatchInstance();
        
        switch(unit.getType())
        {
            case "Minion":
            {
                if(player == 1)
                {
                    ArrayList<Unit> tablePlayer1 = match.getP1_table();
                    
                    if(tablePlayer1.size() < 4 )
                    {
                            tablePlayer1.add(unit);
                            unit.initSkill();
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
                else
                {
                	ArrayList<Unit> tablePlayer2 = match.getP2_table();
                    
                    if(tablePlayer2.size() < 4 )
                    {
                            tablePlayer2.add(unit);
                            unit.initSkill();
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
            }
            case "Spell":
            {
                if(player == 1)
                {
                	ArrayList<Unit> tablePlayer1 = match.getP1_table();
                    
                    if(tablePlayer1.size() < 4 )
                    {
                            unit.initSkill();
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
                
                else
                {
                	ArrayList<Unit> tablePlayer2 = match.getP2_table();
                    
                    if(tablePlayer2.size() < 4 )
                    {
                            unit.initSkill();
                    }
                    else
                        System.out.println("No cabe ninguna carta mas en tu mesa");
                }
            }
        }
    }*/
    
}
