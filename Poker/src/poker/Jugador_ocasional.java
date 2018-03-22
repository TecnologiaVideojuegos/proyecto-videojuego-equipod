
package poker;

public class Jugador_ocasional extends Jugador {
    /* La clase Jugador_ocasional hereda de Jugador, y le añade el atributo privado
    numTarjeta de tipo Integer
    
    Contiene los métodos get y set del nuevo atributo y el constructor necesario
    además del método toString que visualiza el jugador ocasional
    */
    
    private int numTarjeta;

    public Jugador_ocasional(int numTarjeta, String NIF, String nombreApellidos, double saldoAcumulado) {
        super(NIF, nombreApellidos, saldoAcumulado);
        this.numTarjeta = numTarjeta;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @Override
    public String toString() {
        return "El jugador ocasional " + super.getNombreApellidos() + " con NIF " +
               super.getNIF() + " y número de tarjeta " + numTarjeta + ", entra en el juego: ";
    }
    
    
}
