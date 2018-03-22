
package poker;

public class Carta {
    /* La clase Carta contiene dos atributos protegidos de tipo String, el palo 
    y la figura de una carta
    
    Contiene los métodos get y set para ambos Strings y el constructor necesario
    para instanciar los objetos; además de un método toString que permite visualizar 
    el palo y la figura
    */
    protected String figura;
    protected String palo;

    public Carta(String figura, String palo) {
        this.figura = figura;
        this.palo = palo;
    }

    public String getFigura() {
        return figura;
    }

    public void setFigura(String figura) {
        this.figura = figura;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return figura + " de " + palo;
    }

    
    
    
}
