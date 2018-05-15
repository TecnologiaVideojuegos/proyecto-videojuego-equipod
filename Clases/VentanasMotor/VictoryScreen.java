package FightKnights.Logic;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author alex1
 */
public class VictoryScreen extends BasicGameState
{

    private Image fondo1, fondo2;
    private Image botonSalir, botonSonido, botonReset;
    private Input raton;
    private Music musica;
    private boolean gana, ratonPress, reinicioOver, salirOver;
    private Match match;
    private int h1;

    public VictoryScreen() throws SlickException
    {
    }

    @Override
    public int getID()
    {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        match = Match.getMatchInstance();
        fondo1 = new Image("res/victoria1.png");
        fondo2 = new Image("res/victoria2.png");
        botonSalir = new Image("res/salir.png");
        botonReset = new Image ("res/reiniciar.png");
        raton = container.getInput();
        musica = new Music("res/Galway.ogg");
        musica.play();

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
    {
        if(gana){
           fondo2.draw();
        }else{
           fondo1.draw();
        }
        g.drawString(raton.getMouseX() + "", 300, 300);
        g.drawString(raton.getMouseY() + "", 500, 500);
        g.drawImage(botonReset, 380, 435);
        g.drawImage(botonSalir, 700, 435);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        h1 = match.getP_turn();
        gana = h1==1;
        ratonPress = raton.isMousePressed(Input.MOUSE_LEFT_BUTTON);
        ratonSobreBoton();
        botonPulsado(game);
    }
    
    public void ratonSobreBoton()
    {
        reinicioOver = ((raton.getMouseX()>=380&&raton.getMouseY()>=435)&&(raton.getMouseX()<=580&&raton.getMouseY()<=485));
        salirOver = ((raton.getMouseX()>=700&&raton.getMouseY()>=435)&&(raton.getMouseX()<=900&&raton.getMouseY()<=485));

    }
    public void botonPulsado(StateBasedGame game) throws SlickException
    {
        if(ratonPress)
        {
            if(reinicioOver)
            {
                game.enterState(1);
            }
    
            //Cierra el juego 
            if(salirOver)
            {
                System.exit(0);
            }
        }
    }
}
