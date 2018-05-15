/*
    La clase principal del juego, el tablero, 
    donde los jugadores lanzan sus cartas y se desarrolla la accion
 */
package FightKnights.Logic;

import java.util.ArrayList;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.font.effects.ColorEffect;



public class PantallaJuego extends BasicGameState
{

    private Match partida;
    
    Unit unidadSeleccionada;
    
    private ArrayList <Unit> mazo1, mazo2;
    private ArrayList <Unit> mano1, mano2;
    private ArrayList <Unit> mesa1, mesa2;
    
    private Image cursor;
    private Image tablero, reinicio, rendicion, salir, pasarTurno;
    private Image cartaDePrueba;
    private Image energia1, energia2, vida1, vida2;
    private Image imagenMano1, imagenMano2, imagenMano3, imagenMano4, imagenMano5;
    private Image imagenMesa1_1, imagenMesa1_2, imagenMesa1_3, imagenMesa1_4, imagenMesa1_5;
    private Image imagenMesa2_1, imagenMesa2_2, imagenMesa2_3, imagenMesa2_4, imagenMesa2_5;
    private Input raton;
    
    private boolean carta1Over, carta2Over, carta3Over, carta4Over, carta5Over;
    private boolean cambioDeTurno;
    private boolean ratonPulsado, ratonPress;
    private boolean invocacionPosible = false;
    private boolean reinicioOver, rendicionOver, salirOver, pasarTurnoOver;
    private boolean unit1Over, unit2Over, unit3Over, unit4Over, unit5Over, unit6Over, unit7Over, unit8Over, unit9Over, unit10Over;
    
    private int x1, x2, x3, x4, x5, y1, y2, y3, y4, y5;
    private int xInit1, xInit2, xInit3, xInit4, xInit5, yInit1, yInit2, yInit3, yInit4, yInit5;
    
    private Unit unitSelected = null;
    private Unit targetSelected = null;
            
    private int distanciaX, distanciaY;
    
    private GameContainer container;
    private UnicodeFont fuente;

    @Override
    public int getID() 
    {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException 
    {
        this.container = container;
        
        try 
        {
            Font fuenteUAX = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("fonts/Hellgrazer.otf"));
            fuenteUAX = fuenteUAX.deriveFont(java.awt.Font.PLAIN, 30);
            fuente = new UnicodeFont(fuenteUAX);
            fuente.addAsciiGlyphs();
            ColorEffect color = new ColorEffect(java.awt.Color.DARK_GRAY);
            fuente.getEffects().add(color);
            fuente.loadGlyphs();
        } 
        catch (FontFormatException ex) 
        {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getLocalizedMessage());
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PantallaJuego.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getLocalizedMessage());
        }
        
        partida = Match.getMatchInstance();
        
        partida.setP_turn( 2 );
        partida.setP1_energy( 1 );
        partida.setP2_energy( 1 );
        
        tablero = new Image("res/TABLEROREAL.jpg");
        pasarTurno = new Image("res/pasarturno.png");
        reinicio = new Image("res/reiniciar.png");
        rendicion = new Image("res/rendirse.png");
        salir = new Image("res/salir.png");
        energia1 = new Image("res/circulo amarillo.png");
        energia2 = new Image("res/circulo amarillo.png");
        vida1 = new Image("res/circulo rojo.png");
        vida2 = new Image("res/circulo rojo.png");
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
        pasarTurno.draw(1037, 540, 200, 70);
        rendicion.draw(23, 500, 200, 50);
        reinicio.draw(23, 550, 200, 50);
        salir.draw(23, 600, 200, 50);
        
        energia1.draw(5, 320, 75, 75);
        fuente.drawString(20, 340, partida.getP1_energy()+"");
        //g.drawString(partida.getP1_energy()+"", 30, 345);
        energia2.draw(1200, 320, 75, 75);
        fuente.drawString(1215, 340, partida.getP2_energy()+"");
        //g.drawString(partida.getP2_energy()+"", 1225, 345);
        
        vida1.draw(5, 120, 75, 75);
        fuente.drawString(20, 140, partida.getP1_health()+"");
        //g.drawString(partida.getP1_health()+"", 30, 150);
        vida2.draw(1200, 120, 75, 75);
        fuente.drawString(1215, 140, partida.getP2_health()+"");
        //g.drawString(partida.getP2_health()+"", 1225, 150);
        
        dibujarCartas();
        dibujarEnTablero();
        
        if(unitSelected == null)
        {
            fuente.drawString(200, 400, "UNIT SELECTED : NUUUUUULL");
        }
        else
        {
            fuente.drawString(200, 400, "UNIT SELECTED : " + unitSelected.getName());
        }
        if(targetSelected == null)
        {
            fuente.drawString(700, 400, "TARGET SELECTED : NUUUUUULL");
        }
        else
        {
            fuente.drawString(700, 400, "TARGET SELECTED : " + targetSelected.getName());
        }
    }
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException 
    {
        ratonPulsado = raton.isMouseButtonDown(0);
        ratonPress = raton.isMousePressed(Input.MOUSE_LEFT_BUTTON);
        ratonSobreCartas();
        ratonSobreUnidades();
        ratonSobreBoton();
        botonPulsado();
        dragAndDrop();
    }
    
    public void ratonSobreUnidades()
    {
        
        if((raton.getMouseX()>=120&&raton.getMouseY()>=130)&&(raton.getMouseX()<=180&&raton.getMouseY()<=190))
        {
            if(partida.getP1_table().size() >= 1)
            {
                unit1Over = true;
                //System.out.println("SOBRE UNIDAD 1");
            }
        }
        else
        {
            unit1Over = false;
        }
        if((raton.getMouseX()>=220&&raton.getMouseY()>=230)&&(raton.getMouseX()<=280&&raton.getMouseY()<=290))
        {
            if(partida.getP1_table().size() >= 2)
            {
                unit2Over = true;
            }
        }
        else
        {
            unit2Over = false;
        }
        if((raton.getMouseX()>=120&&raton.getMouseY()>=330)&&(raton.getMouseX()<=180&&raton.getMouseY()<=390))
        {
            if(partida.getP1_table().size() >= 3)
            {
                unit3Over = true;
            }
        }
        else
        {
            unit3Over = false;
        }
        if((raton.getMouseX()>=280&&raton.getMouseY()>=330)&&(raton.getMouseX()<=340&&raton.getMouseY()<=390))
        {
            if(partida.getP1_table().size() >= 4)
            {
                unit4Over = true;
            }
        }
        else
        {
            unit4Over = false;
        }
        if((raton.getMouseX()>=280&&raton.getMouseY()>=130)&&(raton.getMouseX()<=340&&raton.getMouseY()<=190))
        {
            if(partida.getP1_table().size() >= 5)
            {
                unit5Over = true;
            }
        }
        else
        {
            unit5Over = false;
        }
        if((raton.getMouseX()>=1100&&raton.getMouseY()>=130)&&(raton.getMouseX()<=1160&&raton.getMouseY()<=190))
        {
            if(partida.getP2_table().size() >= 1)
            {
                unit6Over = true;
            }
        }
        else
        {
            unit6Over = false;
        }
        if((raton.getMouseX()>=1000&&raton.getMouseY()>=230)&&(raton.getMouseX()<=1060&&raton.getMouseY()<=290))
        {
            if(partida.getP1_table().size() >= 2)
            {
                unit7Over = true;
            }
        }
        else
        {
            unit7Over = false;
        }
        if((raton.getMouseX()>=1100&&raton.getMouseY()>=330)&&(raton.getMouseX()<=1160&&raton.getMouseY()<=390))
        {
            if(partida.getP1_table().size() >= 3)
            {
                unit8Over = true;
            }
        }
        else
        {
            unit8Over = false;
        }
        if((raton.getMouseX()>=940&&raton.getMouseY()>=330)&&(raton.getMouseX()<=1000&&raton.getMouseY()<=390))
        {
            if(partida.getP1_table().size() >= 4)
            {
                unit9Over = true;
            }
        }
        else
        {
            unit9Over = false;
        }
        if((raton.getMouseX()>=940&&raton.getMouseY()>=130)&&(raton.getMouseX()<=1000&&raton.getMouseY()<=190))
        {
            if(partida.getP1_table().size() >= 5)
            {
                unit10Over = true;
            }
        }
        else
        {
            unit10Over = false;
        }
    }
    
    public void ratonSobreBoton()
    {
        reinicioOver = ((raton.getMouseX()>=23&&raton.getMouseY()>=550)&&(raton.getMouseX()<=223&&raton.getMouseY()<=600));
        rendicionOver = ((raton.getMouseX()>=23&&raton.getMouseY()>500)&&(raton.getMouseX()<=223&&raton.getMouseY()<=550));
        salirOver = ((raton.getMouseX()>=23&&raton.getMouseY()>=600)&&(raton.getMouseX()<=223&&raton.getMouseY()<=650));
        pasarTurnoOver = ((raton.getMouseX()>=1037&&raton.getMouseY()>540)&&(raton.getMouseX()<=1237&&raton.getMouseY()<=610));
    }
    
    public void botonPulsado() throws SlickException
    {
        if(ratonPress)
        {
            if(unit1Over)
            {
                System.out.println("UNITOVER1");
                if(partida.getP_turn() == 1)
                {
                    unitSelected = partida.getP1_table().get(0);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP1_table().get(0);
                        GameMethods.executeAttack(unitSelected, targetSelected, 1);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit2Over)
            {
                System.out.println("UNITOVER2");
                if(partida.getP_turn() == 1)
                {
                    unitSelected = partida.getP1_table().get(1);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP1_table().get(1);
                        GameMethods.executeAttack(unitSelected, targetSelected, 1);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit3Over)
            {
                System.out.println("UNITOVER3");
                if(partida.getP_turn() == 1)
                {
                    unitSelected = partida.getP1_table().get(2);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP1_table().get(2);
                        GameMethods.executeAttack(unitSelected, targetSelected, 1);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit4Over)
            {
                System.out.println("UNITOVER4");
                if(partida.getP_turn() == 1)
                {
                    unitSelected = partida.getP1_table().get(3);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP1_table().get(3);
                        GameMethods.executeAttack(unitSelected, targetSelected, 1);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit5Over)
            {
                System.out.println("UNITOVER5");
                if(partida.getP_turn() == 1)
                {
                    unitSelected = partida.getP1_table().get(4);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP1_table().get(4);
                        GameMethods.executeAttack(unitSelected, targetSelected, 1);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit6Over)
            {
                System.out.println("UNITOVER6");
                if(partida.getP_turn() == 2)
                {
                    unitSelected = partida.getP2_table().get(0);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP2_table().get(0);
                        GameMethods.executeAttack(unitSelected, targetSelected, 2);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit7Over)
            {
                System.out.println("UNITOVER7");
                if(partida.getP_turn() == 2)
                {
                    unitSelected = partida.getP2_table().get(1);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP2_table().get(1);
                        GameMethods.executeAttack(unitSelected, targetSelected, 2);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit8Over)
            {
                System.out.println("UNITOVER8");
                if(partida.getP_turn() == 2)
                {
                    unitSelected = partida.getP1_table().get(2);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP2_table().get(2);
                        GameMethods.executeAttack(unitSelected, targetSelected, 2);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit9Over)
            {
                System.out.println("UNITOVER9");
                if(partida.getP_turn() == 2)
                {
                    unitSelected = partida.getP1_table().get(3);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP2_table().get(3);
                        GameMethods.executeAttack(unitSelected, targetSelected, 2);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            if(unit10Over)
            {
                System.out.println("UNITOVER10");
                if(partida.getP_turn() == 2)
                {
                    unitSelected = partida.getP2_table().get(4);
                    System.out.println("UNIT -->" + unitSelected.getName());
                }
                else
                {
                    if(unitSelected != null)
                    {
                        targetSelected = partida.getP2_table().get(4);
                        GameMethods.executeAttack(unitSelected, targetSelected, 2);
                        System.out.println("TARGET -->" + targetSelected.getName());
                        unitSelected = null;
                        targetSelected = null;
                    }
                }
            }
            
            //Reinicia la partida
            if(reinicioOver)
            {
                partida = Match.getMatchInstance();

                partida.setTurn_count( 1 );
                partida.setP_turn( 1 );
                partida.setP1_health( 20 );
                partida.setP2_health( 20 );
                partida.setP1_energy( 1 );
                partida.setP2_energy( 1 );

                unidadSeleccionada = null;
                invocacionPosible = false;

                partida.getP1_deck().clear();
                partida.getP1_table().clear();
                partida.getP1_hand().clear();
                partida.getP2_deck().clear();
                partida.getP2_table().clear();
                partida.getP2_hand().clear();

                initMazos();
            }
            
            //El jugador se rinde y gana el contrario
            if(rendicionOver)
            {
                //Ver que jugador pulsa el boton
                if(partida.getP_turn()==1)
                    partida.setP1_health(0);
                else
                    partida.setP2_health(0);
            }
            
            if(pasarTurnoOver)
            {
                GameMethods.swichTurn(partida.getP_turn());
                unitSelected = null;
                targetSelected = null;
            }
            
            //Cierra el juego 
            if(salirOver)
            {
                System.exit(0);
            }
        }
    }
    
    public void dragAndDrop() throws SlickException
    {
        if(ratonPulsado)
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
            if(invocacionPosible)
            {
                if(y1 < yInit1 - 100 || y2 < yInit2 - 100 || y3 < yInit3 - 100 || y4 < yInit4 - 100 || y5 < yInit5 - 100)
                {
                    if(partida.getP_turn() == 1)
                    {
                        invocacionPosible = false;
                        GameMethods.invokeCard(unidadSeleccionada, null, 1);
                    }
                    else
                    {
                        invocacionPosible = false;
                        GameMethods.invokeCard(unidadSeleccionada, null, 2);
                    }
                }
                
                x1 = xInit1; x2 = xInit2; x3 = xInit3; x4 = xInit4; x5 = xInit5;
                y1 = yInit1; y2 = yInit2; y3 = yInit3; y4 = yInit4; y5 = yInit5;
                distanciaX = 0; distanciaY = 0;
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
                imagenMesa1_1.draw(120, 130, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(220, 230, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 330, 60, 60);
                imagenMesa1_4 = partida.getP1_table().get(3).getRutaImagenMesa();
                imagenMesa1_4.draw(280, 330, 60, 60);
                imagenMesa1_5 = partida.getP1_table().get(4).getRutaImagenMesa();
                imagenMesa1_5.draw(280, 130, 60, 60);
                break;
            case 4:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 130, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(220, 230, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 330, 60, 60);
                imagenMesa1_4 = partida.getP1_table().get(3).getRutaImagenMesa();
                imagenMesa1_4.draw(280, 330, 60, 60);
                break;
            case 3:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 130, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(220, 230, 60, 60);
                imagenMesa1_3 = partida.getP1_table().get(2).getRutaImagenMesa();
                imagenMesa1_3.draw(120, 330, 60, 60);
                break;
            case 2:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 130, 60, 60);
                imagenMesa1_2 = partida.getP1_table().get(1).getRutaImagenMesa();
                imagenMesa1_2.draw(220, 230, 60, 60);
                break;
            case 1:
                imagenMesa1_1 = partida.getP1_table().get(0).getRutaImagenMesa();
                imagenMesa1_1.draw(120, 130, 60, 60);
                break;
            default:
                break;
        }
        
        switch (partida.getP2_table().size())
        {
            case 5:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(1160, 130, -60, 60);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(1060, 230, -60, 60);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(1160, 330, -60, 60);
                imagenMesa2_4 = partida.getP2_table().get(3).getRutaImagenMesa();
                imagenMesa2_4.draw(1000, 330, -60, 60);
                imagenMesa2_5 = partida.getP2_table().get(4).getRutaImagenMesa();
                imagenMesa2_5.draw(1000, 130, -60, 60);
                break;
            case 4:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(1160, 130, -60, 60);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(1060, 230, -60, 60);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(1160, 330, -60, 60);
                imagenMesa2_4 = partida.getP2_table().get(3).getRutaImagenMesa();
                imagenMesa2_4.draw(1000, 330, -60, 60);
                break;
            case 3:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(1160, 130, -60, 60);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(1060, 230, -60, 60);
                imagenMesa2_3 = partida.getP2_table().get(2).getRutaImagenMesa();
                imagenMesa2_3.draw(1160, 330, -60, 60);
                break;
            case 2:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(1160, 130, -60, 60);
                imagenMesa2_2 = partida.getP2_table().get(1).getRutaImagenMesa();
                imagenMesa2_2.draw(1060, 230, -60, 60);
                break;
            case 1:
                imagenMesa2_1 = partida.getP2_table().get(0).getRutaImagenMesa();
                imagenMesa2_1.draw(1160, 130, -60, 60);
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
            
            nombre1 = (r1.nextInt(44) + 1) + "";
            nombre2 = (r2.nextInt(44) + 1) + "";
            
            Unit unit = new Unit(nombre1);
            Unit unit2 = new Unit(nombre2);
            
            mazo1.add(unit);
            mazo2.add(unit2);
        }
        
        partida.setP1_deck(mazo1);
        partida.setP2_deck(mazo2);
        
        ArrayList <Unit> aux = new ArrayList <> ();
        System.out.println(partida.getP1_deck().size() + " init - jugador 1" );
        Unit unit = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        Unit unit2 = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        Unit unit3 = partida.getP1_deck().remove(partida.getP1_deck().size() - 1);
        System.out.println(partida.getP1_deck().size() + " init - jugador 1" );
        aux.add(unit);
        aux.add(unit2);
        aux.add(unit3);
        partida.setP1_hand(aux);
        ArrayList <Unit> aux2 = new ArrayList <> ();
        System.out.println(partida.getP2_deck().size() + " init - jugador 2" );
        Unit unit11 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        Unit unit12 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        Unit unit13 = partida.getP2_deck().remove(partida.getP2_deck().size() - 1);
        System.out.println(partida.getP2_deck().size() + " init - jugador 2" );
        aux2.add(unit11);
        aux2.add(unit12);
        aux2.add(unit13);
        partida.setP2_hand(aux2);
    }
    
}