/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;
import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;



public class PantallaJuego extends BasicGameState
{

    private Match partida;
    
    private ArrayList <Unit> mazo1, mazo2;
    private ArrayList <Unit> mano1, mano2;
    private ArrayList <Unit> mesa1, mesa2;
    
    private Image cursor;
    private Image tablero;
    private Image cartaDePrueba;
    private Image imagenMano1, imagenMano2, imagenMano3, imagenMano4, imagenMano5;
    private Input raton;
    
    private boolean carta1Over, carta2Over, carta3Over, carta4Over, carta5Over;
    private boolean cambioDeTurno;
    
    @Override
    public int getID() 
    {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        partida = Match.getMatchInstance();
        
        mazo1 = new ArrayList <> ();
        mazo2 = new ArrayList <> ();
        
        mano1 = new ArrayList <> ();
        mano2 = new ArrayList <> ();
        
        mesa1 = new ArrayList <> ();
        mesa2 = new ArrayList <> ();
        
        partida.setP_turn( 1 );
        
        initMazos();
        
        tablero = new Image("res/TABLEROREAL.jpg");
        
        cambioDeTurno = false;
        
        raton = container.getInput();
        cursor = new Image("res/cursor.png");
        container.setMouseCursor(cursor, 0, 0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        tablero.draw();
        
        dibujarCartas();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        ratonSobreCartas();
    }
    
    public void ratonSobreCartas()
    {
        if((raton.getMouseX()>=250&&raton.getMouseX()<=360)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650))
        {
            carta1Over = true;
        }
        else
        {
            carta1Over = false;
        }
        if((raton.getMouseX()>=410&&raton.getMouseX()<=520)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650))
        {
            carta2Over = true;
        }
        else
        {
            carta2Over = false;
        }
        if((raton.getMouseX()>=570&&raton.getMouseX()<=680)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650))
        {
            carta3Over = true;
        }
        else
        {
            carta3Over = false;
        }
        if((raton.getMouseX()>=730&&raton.getMouseX()<=840)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650))
        {
            carta4Over = true;
        }
        else
        {
            carta4Over = false;
        }
        if((raton.getMouseX()>=890&&raton.getMouseX()<=1000)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650))
        {
            carta5Over = true;
        }
        else
        {
            carta5Over = false;
        }
    }
    
    public void dibujarCartas()
    {
        
        if(partida.getP_turn() == 1)
        {
            if(partida.getP1_hand().size() == 5)
            {
                imagenMano1 = mano1.get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
                imagenMano4 = partida.getP1_hand().get(3).getRutaImagenTablero();
                imagenMano4.draw(730, 500, 110, 150);
                imagenMano5 = partida.getP1_hand().get(4).getRutaImagenTablero();
                imagenMano5.draw(890, 500, 110, 150);
            }
            else if(partida.getP1_hand().size() == 4)
            {
                imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
                imagenMano4 = partida.getP1_hand().get(3).getRutaImagenTablero();
                imagenMano4.draw(730, 500, 110, 150);
            }
            else if(partida.getP1_hand().size() == 3)
            {
                imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
            }
            else if(partida.getP1_hand().size() == 2)
            {
                imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
            }
            else if(partida.getP1_hand().size() == 1)
            {
                imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
            }
            
        }
        else
        {
            if(partida.getP2_hand().size() == 5)
            {
                imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
                imagenMano4 = partida.getP2_hand().get(3).getRutaImagenTablero();
                imagenMano4.draw(730, 500, 110, 150);
                imagenMano5 = partida.getP2_hand().get(4).getRutaImagenTablero();
                imagenMano5.draw(890, 500, 110, 150);
            }
            else if(partida.getP2_hand().size() == 4)
            {
                imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
                imagenMano4 = partida.getP2_hand().get(3).getRutaImagenTablero();
                imagenMano4.draw(730, 500, 110, 150);
            }
            else if(partida.getP2_hand().size() == 3)
            {
                imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
                imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                imagenMano3.draw(570, 500, 110, 150);
            }
            else if(partida.getP2_hand().size() == 2)
            {
                imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
                imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                imagenMano2.draw(410, 500, 110, 150);
            }
            else if(partida.getP2_hand().size() == 1)
            {
                imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                imagenMano1.draw(250, 500, 110, 150);
            }
        }
        
        if(partida.getP_turn() == 1)
        {
            if(carta1Over)
            {
                if(partida.getP1_hand().size() >= 1)
                {
                    imagenMano1.draw(500, 50, 250, 375);
                }
            }
            if(carta2Over)
            {
                if(partida.getP1_hand().size() >= 2)
                {
                    imagenMano2.draw(500, 50, 250, 375);
                }
            }
            if(carta3Over)
            {
                if(partida.getP1_hand().size() >= 3)
                {
                    imagenMano3.draw(500, 50, 250, 375);
                }
            }
            if(carta4Over)
            {
                if(partida.getP1_hand().size() >= 4)
                {
                    imagenMano4.draw(500, 50, 250, 375);
                }
            }
            if(carta5Over)
            {
                if(partida.getP1_hand().size() == 5)
                {
                    imagenMano5.draw(500, 50, 250, 375);
                }
            }
        }
        else
        {
            if(carta1Over)
            {
                if(partida.getP2_hand().size() >= 1)
                {
                    imagenMano1.draw(500, 50, 250, 375);
                }
            }
            if(carta2Over)
            {
                if(partida.getP2_hand().size() >= 2)
                {
                    imagenMano2.draw(500, 50, 250, 375);
                }
            }
            if(carta3Over)
            {
                if(partida.getP2_hand().size() >= 3)
                {
                    imagenMano3.draw(500, 50, 250, 375);
                }
            }
            if(carta4Over)
            {
                if(partida.getP2_hand().size() >= 4)
                {
                    imagenMano4.draw(500, 50, 250, 375);
                }
            }
            if(carta5Over)
            {
                if(partida.getP2_hand().size() == 5)
                {
                    imagenMano5.draw(500, 50, 250, 375);
                }
            }
        }
        
    }
    
    public void initMazos() throws SlickException
    {
        for(int i = 0; i < 20; i++)
        {
            String nombre1, nombre2;
            
            Random r1 = new Random();
            Random r2 = new Random();
            
            nombre1 = (r1.nextInt(9) + 1) + "";
            nombre2 = (r1.nextInt(9) + 1) + "";
            
            Unit unit = new Unit(nombre1);
            Unit unit2 = new Unit(nombre2);
            
            mazo1.add(unit);
            mazo2.add(unit2);
        }
        
        partida.setP1_deck(mazo1);
        partida.setP2_deck(mazo2);
        
        ArrayList <Unit> aux = new ArrayList <> ();
        Unit unit = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        Unit unit2 = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        Unit unit3 = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        aux.add(unit);
        aux.add(unit2);
        aux.add(unit3);
        partida.setP1_hand(aux);
        ArrayList <Unit> aux2 = new ArrayList <> ();
        Unit unit11 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        Unit unit12 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        Unit unit13 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        aux2.add(unit);
        aux2.add(unit2);
        aux2.add(unit3);
        partida.setP2_hand(aux2);
    }
    
}
