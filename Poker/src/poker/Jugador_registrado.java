
package poker;

public class Jugador_registrado extends Jugador {
    /* La clase Jugador_registrado hereda de Jugador, y le añade el atributo privado
    numCuenta de tipo Integer
    
    Contiene los métodos get y set del nuevo atributo y el constructor necesario
    además del método toString que visualiza el jugador registrado
    */
    
    private int numCuenta;

    public Jugador_registrado(int numCuenta, String NIF, String nombreApellidos, double saldoAcumulado) {
        super(NIF, nombreApellidos, saldoAcumulado);
        this.numCuenta = numCuenta;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return "El jugador registrado " + super.getNombreApellidos() + " con NIF " + 
               super.getNIF() + " y número de cuenta " + numCuenta + ", entra en el juego:";
    }

    
}
