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
    private Image botonJugar, botonSonido, puntero;
    private Input raton;
    private Music musica;

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
        botonSonido = new Image("res/soundon.png");
        raton = container.getInput();
        musica = new Music("res/Galway.ogg");
        musica.play();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        fondo.draw();
       
        g.drawImage(botonJugar, 800, 500);
        g.drawImage(botonSonido, 50, 50);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        if (raton.isMouseButtonDown(0)) {
            if ((raton.getMouseX() >= 50 && 69 >= raton.getMouseX()) && (raton.getMouseY() >= 50 && raton.getMouseY() <= 86)) {
                if (musica.playing()) {
                    botonSonido = new Image("res/soundoff.png");
                    musica.pause();
                } else {
                    botonSonido = new Image("res/soundon.png");
                    musica.resume();
                }
            }
            if ((raton.getMouseX() >= 800 && 1110 >= raton.getMouseX()) && (raton.getMouseY() >= 500 && raton.getMouseY() <= 565)) {
                System.out.println("Bienvenido al juego");
                game.enterState(1);
            }
        }
    }

}