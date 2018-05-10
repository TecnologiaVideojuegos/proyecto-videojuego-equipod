/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 *
 * @author hp
 */
public class Menu extends BasicGameState {

    private Image fondo;
    private Image botonJugar,botonSalir, puntero;
    private Input raton;
    public Menu() throws SlickException {
        
    }
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
       fondo = new Image("res/INICIOjuego.jpg");
       botonJugar = new Image("res/press start.png");
       raton = container.getInput();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {        
        
        fondo.draw();
        g.drawImage(botonJugar, 800, 500);
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(raton.isMouseButtonDown(0)){
            if((raton.getMouseX()>=800&&1110>=raton.getMouseX())&&(raton.getMouseY()>=500&&raton.getMouseY()<=565)){
                game.enterState(1);
            }
        }
    }
    
}
