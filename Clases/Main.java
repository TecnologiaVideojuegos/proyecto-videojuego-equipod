/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.AlphaMapTest;

/**
 *
 * @author Adrian
 */
public class Main extends BasicGame 
{
    private float deltaTime = 0.07f;
    private Match match;

    public static void main(String args[]) 
    {
        try 
        {
            AppGameContainer container = new AppGameContainer(new Main("FightKnights"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } 
        catch (SlickException e) 
        {
            e.printStackTrace();
        }
    }

    public Main(String title) 
    {
        super(title);
    }

    @Override
    public void init(GameContainer container) throws SlickException 
    {
        //****init Match
        
        //****init Array cartas player 1 (20) RANDOM
        //****init Array cartas player 2 (20) RANDOM
        //****init turno RANDOM
        
        
        //image = new Image("res/gsw1.png");
        //posx = 0;
        //posy = 0;
        //match = Match.getMatchInstance();
        //match.setP_turn(1);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException 
    {
        //posx += deltaTime;
        //posy += deltaTime;
        //if(posy>300)
        //{
        //    match.setP_turn(2);
        //}
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException 
    {    
        //image.draw(posx, posy, 20, 20);
        //g.drawString(match.getP_turn()+"", 300, 300);
    }
   
}
