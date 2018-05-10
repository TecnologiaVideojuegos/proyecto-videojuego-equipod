/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;
import java.util.ArrayList;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;



public class PantallaJuego extends BasicGameState{

    private Image tablero;
    private Image cartaDePrueba;
    private Image iconoDePrueba;
    private Input raton;
    
    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        tablero = new Image("res/TABLEROREAL.jpg");
        cartaDePrueba = new Image("res/segadordorado.png");
        iconoDePrueba = new Image("res/1.png");
        raton = container.getInput();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        tablero.draw();
        iconoDePrueba.draw(250, 500);
        if((raton.getMouseX()>=250&&raton.getMouseX()<=381)&&(raton.getMouseY()>=500&&raton.getMouseY()<=639)){
             cartaDePrueba.draw(500,100);
        }

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }
    
}
