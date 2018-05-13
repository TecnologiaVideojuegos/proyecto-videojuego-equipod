/*
    La clase principal del juego, el tablero, 
    donde los jugadores lanzan sus cartas y se desarrolla la accion
 */
package FightKnights.Logic;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;



public class PantallaJuego extends BasicGameState
{

    private Match partida;
    
    Unit unidadSeleccionada;
    
    private ArrayList <Unit> mazo1, mazo2;
    private ArrayList <Unit> mano1, mano2;
    private ArrayList <Unit> mesa1, mesa2;
    
    private Image cursor;
    private Image tablero, reinicio, rendicion, salir;
    private Image cartaDePrueba;
    private Image imagenMano1, imagenMano2, imagenMano3, imagenMano4, imagenMano5;
    private Image imagenMesa1_1, imagenMesa1_2, imagenMesa1_3, imagenMesa1_4, imagenMesa1_5;
    private Image imagenMesa2_1, imagenMesa2_2, imagenMesa2_3, imagenMesa2_4, imagenMesa2_5;
    private Input raton;
    
    private boolean carta1Over, carta2Over, carta3Over, carta4Over, carta5Over;
    private boolean cambioDeTurno;
    private boolean ratonPulsado;
    private boolean invocacionPosible = false;
    private boolean reinicioOver, rendicionOver, salirOver;
    
    private int x1, x2, x3, x4, x5, y1, y2, y3, y4, y5;
    private int xInit1, xInit2, xInit3, xInit4, xInit5, yInit1, yInit2, yInit3, yInit4, yInit5;
    private int distanciaX, distanciaY;

    @Override
    public int getID() 
    {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        partida = Match.getMatchInstance();
        
        partida.setP_turn( 1 );
        partida.setP1_energy( 100 );
        partida.setP2_energy( 100 );
        
        tablero = new Image("res/TABLEROREAL.jpg");
        reinicio = new Image("res/reiniciar.png");
        rendicion = new Image("res/rendirse.png");
        salir = new Image("res/salir.png");
        
        raton = container.getInput();
        cursor = new Image("res/cursor.png");
        container.setMouseCursor(cursor, 0, 0);
        
        mazo1 = new ArrayList <> ();
        mazo2 = new ArrayList <> ();
        mano1 = new ArrayList <> ();
        mano2 = new ArrayList <> ();
        mesa1 = new ArrayList <> ();
        mesa2 = new ArrayList <> ();
        
        y1 = 500; y2 = 500; y3 = 500; y4 = 500; y5 = 500;
        yInit1 = 500; yInit2 = 500; yInit3 = 500; yInit4 = 500; yInit5 = 500;
        x1 = 250; x2 = 410; x3 = 570; x4 = 730; x5 = 890;
        xInit1 = 250; xInit2 = 410; xInit3 = 570; xInit4 = 730; xInit5 = 890;
        distanciaX = 0; distanciaY = 0;
        
        unidadSeleccionada = null;
        invocacionPosible = false;
        
        initMazos();
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException 
    {
        
        tablero.draw();
        reinicio.draw(1037, 540, 200, 70);
        rendicion.draw(23, 510, 200, 50);
        salir.draw(23, 590, 200, 50);

        dibujarCartas();
        
        dibujarEnTablero();
    }
    
    public void ratonSobreBoton()
    {
        reinicioOver = ((raton.getMouseX()>=1037&&raton.getMouseY()>=540)&&(raton.getMouseX()<=1237&&raton.getMouseY()<=610));
        rendicionOver = ((raton.getMouseX()>=23&&raton.getMouseY()>510)&&(raton.getMouseX()<=223&&raton.getMouseY()<=560));
        salirOver = ((raton.getMouseX()>=23&&raton.getMouseY()>=590)&&(raton.getMouseX()<=223&&raton.getMouseY()<=640));
    }
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        ratonSobreCartas();
        ratonSobreBoton();
        
        ratonPulsado = raton.isMouseButtonDown(0);
        
        botonPulsado();
        draggAndDrop();
    }
    
    public void botonPulsado()
    {
        if(ratonPulsado==true)
        {
            //Reinicia la partida
            if(reinicioOver==true)
            {
               
            }
            
            //El jugador se rinde y gana el contrario
            if(rendicionOver==true)
            {
                //Ver que jugador pulsa el boton
                if(partida.getP_turn()==1)
                {
                    partida.setP1_health(0);
                }
                
                else
                {
                    partida.setP2_health(0);
                }
            }
            
            //Cierra el juego 
            if(salirOver==true)
            {
                System.exit(0);
            }
        }
    }
    
    public void draggAndDrop() throws SlickException
    {
        if(ratonPulsado==true)
        {
            if((raton.getMouseX()>=x1&&raton.getMouseX()<=x1+110)&&(raton.getMouseY()>=y1&&raton.getMouseY()<=y1+150))
            {
                if(distanciaX == 0 && distanciaY == 0)
                {
                    distanciaX = raton.getMouseX() - x1;
                    distanciaY = raton.getMouseY() - y1;
                }
                x1 = raton.getMouseX() - distanciaX;
                y1 = raton.getMouseY() - distanciaY;
                
                if(partida.getP1_hand().size() >= 1)
                {
                    invocacionPosible = true;
                    if(partida.getP_turn() == 1)
                    {
                        unidadSeleccionada = partida.getP1_hand().get(0);
                    }
                    else
                    {
                        unidadSeleccionada = partida.getP2_hand().get(0);
                    }
                }
            }
            if((raton.getMouseX()>=x2&&raton.getMouseX()<=x2+110)&&(raton.getMouseY()>=y2&&raton.getMouseY()<=y2+150))
            {
                if(distanciaX == 0 && distanciaY == 0)
                {
                    distanciaX = raton.getMouseX() - x2;
                    distanciaY = raton.getMouseY() - y2;
                }
                x2 = raton.getMouseX() - distanciaX;
                y2 = raton.getMouseY() - distanciaY;
                
                if(partida.getP1_hand().size() >= 2)
                {
                    invocacionPosible = true;
                    if(partida.getP_turn() == 1)
                    {
                        unidadSeleccionada = partida.getP1_hand().get(1);
                    }
                    else
                    {
                        unidadSeleccionada = partida.getP2_hand().get(1);
                    }
                }
            }
            
            if((raton.getMouseX()>=x3&&raton.getMouseX()<=x3+110)&&(raton.getMouseY()>=y3&&raton.getMouseY()<=y3+150))
            {
                if(distanciaX == 0 && distanciaY == 0)
                {
                    distanciaX = raton.getMouseX() - x3;
                    distanciaY = raton.getMouseY() - y3;
                }
                x3 = raton.getMouseX() - distanciaX;
                y3 = raton.getMouseY() - distanciaY;
                
                if(partida.getP1_hand().size() >= 3)
                {
                    invocacionPosible = true;
                    if(partida.getP_turn() == 1)
                    {
                        unidadSeleccionada = partida.getP1_hand().get(2);
                    }
                    else
                    {
                        unidadSeleccionada = partida.getP2_hand().get(2);
                    }
                }
            }
            if((raton.getMouseX()>=x4&&raton.getMouseX()<=x4+110)&&(raton.getMouseY()>=y4&&raton.getMouseY()<=y4+150))
            {
                if(distanciaX == 0 && distanciaY == 0)
                {
                    distanciaX = raton.getMouseX() - x4;
                    distanciaY = raton.getMouseY() - y4;
                }
                x4 = raton.getMouseX() - distanciaX;
                y4 = raton.getMouseY() - distanciaY;
                
                if(partida.getP1_hand().size() >= 4)
                {
                    invocacionPosible = true;
                    if(partida.getP_turn() == 1)
                    {
                        unidadSeleccionada = partida.getP1_hand().get(3);
                    }
                    else
                    {
                        unidadSeleccionada = partida.getP2_hand().get(3);
                    }
                }
            }
            if((raton.getMouseX()>=x5&&raton.getMouseX()<=x5+110)&&(raton.getMouseY()>=y5&&raton.getMouseY()<=y5+150))
            {
                if(distanciaX == 0 && distanciaY == 0)
                {
                    distanciaX = raton.getMouseX() - x5;
                    distanciaY = raton.getMouseY() - y5;
                }
                x5 = raton.getMouseX() - distanciaX;
                y5 = raton.getMouseY() - distanciaY;
                
                if(partida.getP1_hand().size() >= 5)
                {
                    invocacionPosible = true;
                    if(partida.getP_turn() == 1)
                    {
                        unidadSeleccionada = partida.getP1_hand().get(4);
                    }
                    else
                    {
                        unidadSeleccionada = partida.getP2_hand().get(4);
                    }
                }
                
            }
        }
        else
        {
            x1 = xInit1; x2 = xInit2; x3 = xInit3; x4 = xInit4; x5 = xInit5;
            y1 = yInit1; y2 = yInit2; y3 = yInit3; y4 = yInit4; y5 = yInit5;
            distanciaX = 0; distanciaY = 0;
            
            if(invocacionPosible)
            {
                if(partida.getP_turn() == 1)
                {
                    GameMethods.invokeCard(unidadSeleccionada, null, 1);
                    invocacionPosible = false;
                }
                else
                {
                    GameMethods.invokeCard(unidadSeleccionada, null, 2);
                    invocacionPosible = false;
                }
            }
        }
    }

    public void ratonSobreCartas()
    {
        //comprobar si el raton esta por encima de las cartas del mazo
        carta1Over = (raton.getMouseX()>=250&&raton.getMouseX()<=360)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650);
        carta2Over = (raton.getMouseX()>=410&&raton.getMouseX()<=520)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650);
        carta3Over = (raton.getMouseX()>=570&&raton.getMouseX()<=680)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650);
        carta4Over = (raton.getMouseX()>=730&&raton.getMouseX()<=840)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650);
        carta5Over = (raton.getMouseX()>=890&&raton.getMouseX()<=1000)&&(raton.getMouseY()>=500&&raton.getMouseY()<=650);
    }
    
    public void dibujarEnTablero()
    {
        //Dibuja las cartas en el jugador segun el numero de cartas disponible
        switch (partida.getP1_table().size())
        {
            case 5:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 150, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(170, 250, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 350, 60, 60);
                imagenMesa1_4 = partida.getP1_table().get(3).getRutaImagenMesa();
                imagenMesa1_4.draw(220, 250, 60, 60);
                imagenMesa1_5 = partida.getP1_table().get(4).getRutaImagenMesa();
                imagenMesa1_5.draw(220, 150, 60, 60);
                break;
            case 4:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 150, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(170, 250, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 350, 60, 60);
                imagenMesa1_4 = partida.getP1_table().get(3).getRutaImagenMesa();
                imagenMesa1_4.draw(220, 250, 60, 60);
                break;
            case 3:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 150, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(170, 250, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 350, 60, 60);
                break;
            case 2:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 150, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(170, 250, 60, 60);
                break;
            case 1:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 150, 60, 60);
                break;
            default:
                break;
        }
        
        switch (partida.getP2_table().size())
        {
            case 5:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(x1, y1, 110, 150);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(x2, y2, 110, 150);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(x3, y3, 110, 150);
                imagenMesa2_4 = partida.getP2_table().get(3).getRutaImagenMesa();
                imagenMesa2_4.draw(x4, y4, 110, 150);
                imagenMesa2_5 = partida.getP2_table().get(4).getRutaImagenMesa();
                imagenMesa2_5.draw(x5, y5, 110, 150);
                break;
            case 4:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(x1, y1, 110, 150);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(x2, y2, 110, 150);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(x3, y3, 110, 150);
                imagenMesa2_4 = partida.getP2_table().get(3).getRutaImagenMesa();
                imagenMesa2_4.draw(x4, y4, 110, 150);
                break;
            case 3:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(x1, y1, 110, 150);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(x2, y2, 110, 150);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(x3, y3, 110, 150);
                break;
            case 2:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(x1, y1, 110, 150);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(x2, y2, 110, 150);
                break;
            case 1:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(x1, y1, 110, 150);
                break;
            default:
                break;
        }
    }
    
    public void dibujarCartas()
    {
        //Dibuja las cartas en el tablero segun el numero de cartas
        if(partida.getP_turn() == 1)
        {
            switch (partida.getP1_hand().size())
            {
                case 5:
                    imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    imagenMano4 = partida.getP1_hand().get(3).getRutaImagenTablero();
                    imagenMano4.draw(x4, y4, 110, 150);
                    imagenMano5 = partida.getP1_hand().get(4).getRutaImagenTablero();
                    imagenMano5.draw(x5, y5, 110, 150);
                    break;
                case 4:
                    imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    imagenMano4 = partida.getP1_hand().get(3).getRutaImagenTablero();
                    imagenMano4.draw(x4, y4, 110, 150);
                    break;
                case 3:
                    imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP1_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    break;
                case 2:
                    imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP1_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    break;
                case 1:
                    imagenMano1 = partida.getP1_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    break;
                default:
                    break;
            }
            
        }
        else
        {
            switch (partida.getP2_hand().size())
            {
                case 5:
                    imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    imagenMano4 = partida.getP2_hand().get(3).getRutaImagenTablero();
                    imagenMano4.draw(x4, y4, 110, 150);
                    imagenMano5 = partida.getP2_hand().get(4).getRutaImagenTablero();
                    imagenMano5.draw(x5, y5, 110, 150);
                    break;
                case 4:
                    imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    imagenMano4 = partida.getP2_hand().get(3).getRutaImagenTablero();
                    imagenMano4.draw(x4, y4, 110, 150);
                    break;
                case 3:
                    imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    imagenMano3 = partida.getP2_hand().get(2).getRutaImagenTablero();
                    imagenMano3.draw(x3, y3, 110, 150);
                    break;
                case 2:
                    imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    imagenMano2 = partida.getP2_hand().get(1).getRutaImagenTablero();
                    imagenMano2.draw(x2, y2, 110, 150);
                    break;
                case 1:
                    imagenMano1 = partida.getP2_hand().get(0).getRutaImagenTablero();
                    imagenMano1.draw(x1, y1, 110, 150);
                    break;
                default:
                    break;
            }
        }
        
        //Si el raton esta encima de una carta, la dibuja
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
        
        //inicia los mazos de los jugadores 
        
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
