/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FightKnights.Logic;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.*;
import org.newdawn.slick.state.*;

/**
 *
 * @author hp
 */
public class PantallaCarga extends BasicGameState {

    private UnicodeFont fuente;
    private UnicodeFont fuentelo;
    private int cargar=0;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
         
        java.awt.Font fuenteLO;
        try {
            java.awt.Font fuenteUAX = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/Hellgrazer.otf"));
            fuenteUAX = fuenteUAX.deriveFont(java.awt.Font.PLAIN, 60);
            fuenteLO = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    org.newdawn.slick.util.ResourceLoader.getResourceAsStream("res/zrnic___.ttf"));
            fuenteLO = fuenteLO.deriveFont(java.awt.Font.PLAIN,30);
            fuente = new UnicodeFont(fuenteUAX);
            fuentelo = new UnicodeFont(fuenteLO);
            fuente.addAsciiGlyphs();
            fuentelo.addAsciiGlyphs();
            ColorEffect color = new ColorEffect(java.awt.Color.BLUE);
            fuente.getEffects().add(color);
            fuentelo.getEffects().add(color);
            fuente.loadGlyphs();
            fuentelo.loadGlyphs();
        } catch (FontFormatException ex) {
            Logger.getLogger(PantallaCarga.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PantallaCarga.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        fuente.drawString(250, 300, "Developed by DEPthesda");
        fuente.drawString(450, 400, "Equipo D");
        fuentelo.drawString(1100, 600, "Loading: "+cargar + " %");
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        try {
            Thread.sleep(100);
            cargar += 1;
        } catch (Exception e) {

        }
        if (this.cargar == 101) {
            try {
                Thread.sleep(1000);
                game.enterState(0);
            } catch (Exception e) {

            }
        }
    }

}
