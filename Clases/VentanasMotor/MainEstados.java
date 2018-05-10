package FightKnights.Logic;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author hp
 */
public class MainEstados extends StateBasedGame {
    private AppGameContainer contenedor;
    public static void main(String[] args) {
        try {
            MainEstados juego = new MainEstados("");
        } catch (SlickException slick) {

        }
    }
    
    public MainEstados(String name) throws SlickException {
        super("Fight Knights");
        contenedor = new AppGameContainer(this);
        contenedor.setDisplayMode(1280, 720, false);
        contenedor.setShowFPS(true);
        contenedor.setFullscreen(true);
        contenedor.start();
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        this.addState(new Menu());
        this.addState(new PantallaJuego());
    }

}
