
package poker;

public class Jugador {
    /* La clase Jugador contiene los atributos privados nombre, NIF y saldo acumulado 
    en cada momento del juego de un jugador general;además del constructor y de 
    los correspondientes métodos get y set de los atributos
    
    De esta clase heredan dos clases hijas, Jugador_registrado y Jugaador_ocasional
    */
    private String NIF;
    private String nombreApellidos;
    private double saldoAcumulado;


    public Jugador(String NIF, String nombreApellidos, double saldoAcumulado) {
        this.NIF = NIF;
        this.nombreApellidos = nombreApellidos;
        this.saldoAcumulado = saldoAcumulado;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

}
