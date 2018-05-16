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

public class PantallaPausa extends BasicGameState
{

    private Image fondo;
    private Input raton;
    private Music musica;
    private boolean ratonPress;
  
    public PantallaPausa() throws SlickException
    {
        
    }

    @Override
    public int getID()
    {
        return 4;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException
    {
        fondo = new Image("res/pausa.png");
        raton = container.getInput();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
    {
        g.drawImage(fondo, 275, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
    {
        ratonPress = raton.isMousePressed(Input.MOUSE_LEFT_BUTTON);
        if(ratonPress)
        {
            game.enterState(1);
        }
    }
}