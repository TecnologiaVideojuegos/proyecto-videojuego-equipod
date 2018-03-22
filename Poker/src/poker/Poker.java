
package poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//Importación de librerías para pedir datos al usuario y mostrar arrays en pantalla

public class Poker {
    /* La clase Poker contiene el método main necesario para poder instanciar objetos
    del resto de clases y que el programa funcione correctamente. Además del método
    main, contiene otros métodos para pedir datos al usuario y comprobar si este
    es registrado u ocasional, así como un método que crea las distintas manos en 
    cada apuesta y actualiza el saldo del jugador   
    */
    public static void main(String[] args) throws IOException  {       
        /* El método main muestra el mensaje de bienvenida y llama a métodos que 
        crean el jugador según lo que introduce el usuario. 
        
        También llama al método maquinaPoker, encargado de las apuestas y del 
        funcionamiento de los premios y el saldo del jugador
        */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        Jugador jug=null;
        boolean esJugador=true;
        //Inicialización de variables
        
        System.out.println("Bienvenido a la máquina de apuestas On-Line de Póker");
        System.out.println("Antes de empezar, ¿quieres registrarte?(s/n)");
        resp=input.readLine();

        if (resp.toLowerCase().equals("s")){
        //Si la respuesta del jugador es si, se llama al método creador de jugador_registrado
        
            jug=creaRegistrado();
            esJugador=true; 
            //Valor que se utilizará en la clase Apuesta para ver el premio
        }
        
        else if (resp.toLowerCase().equals("n")) {
        //Si la respuesta del jugador es no, se llama al método creador de jugador_ocasional
        
            jug=creaOcasional();
            esJugador=false;
            //Valor que se utilizará en la clase Apuesta para ver el premio
        }
        
        System.out.println(jug.toString());
        //Muestra los datos del jugador
        
        Carta[] cartas = new Carta[20];
        Baraja b = new Baraja(cartas);
        Carta[] baraja=b.crearBaraja();
        Carta[] mano=b.crearMano(baraja);
        Apuesta ap = new Apuesta();
        //Crea los objetos de las distintas clases
        
        maquinaPoker(jug,cartas,b,baraja,mano,ap,esJugador);
        //Método que comprueba las apuestas
    
    }
    public static Jugador_registrado creaRegistrado() throws IOException {
        /* Este método crea un objeto de tipo Jugador_registrado, pidiendo los 
        datos al usuario y devolviendo el jugador
        */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String nombAp,nif;
        double saldoIn;
        int numCuent;
        System.out.println("Introduce tu nombre: ");
        nombAp=input.readLine();
        System.out.println("Introduce tu NIF: ");
        nif=input.readLine();
        System.out.println("Introduce el saldo inicial:");
        saldoIn=Double.parseDouble(input.readLine());
        System.out.println("Introduce el número de cuenta bancaria: ");
        numCuent=Integer.parseInt(input.readLine());
        Jugador_registrado jug_r=new Jugador_registrado(numCuent,nif,nombAp,saldoIn);
        return jug_r;
    }
    
    public static Jugador_ocasional creaOcasional () throws IOException {
        /* Este método crea un objeto de tipo Jugador_ocasional, pidiendo los datos
        al usuario y devolviendo el jugador
        */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String nombAp,nif;
        double saldoIn;
        int numTarj;
        System.out.println("Introduce tu nombre: ");
        nombAp=input.readLine();
        System.out.println("Introduce tu NIF: ");
        nif=input.readLine();
        System.out.println("Introduce el saldo inicial:");
        saldoIn=Double.parseDouble(input.readLine());
        System.out.println("Introduce el número de tarjeta: ");
        numTarj=Integer.parseInt(input.readLine());    
        Jugador_ocasional jug_o=new Jugador_ocasional(numTarj,nif,nombAp,saldoIn);
        return jug_o;
    }
    
    public static void maquinaPoker(Jugador j1,Carta[] cartas,Baraja b,Carta[] baraja,
                                    Carta[] mano, Apuesta ap,boolean esJugador) 
                                    throws IOException  {
        /* Este método contiene un bucle do while que se detendrá cuando el jugador 
        se quede sin dinero o introduzca la tecla q para salir del programa
        
        Entran al método los objetos de las distintas clases así como el tipo de 
        jugador representado por un booleano y no devuelve nada
        */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        int apuesta,i=1;
        do{
            System.out.println(i + "ª apuesta:");
            apuesta = Integer.parseInt(input.readLine());
            while(apuesta<5){       
            //Comprueba si la apuesta introducida es menor que 5
            
                System.out.println("Dinero mínimo a apostar: 5");
                apuesta = Integer.parseInt(input.readLine());
            }
            while((j1.getSaldoAcumulado()-apuesta)<0){
            //Comprueba si se introduce más dinero del que se dispone
            
                System.out.println("No tienes tanto dinero para apostar.Apuesta menos. "
                        + "Dinero actual: " + j1.getSaldoAcumulado());
                apuesta= Integer.parseInt(input.readLine());
            }
            
            System.out.println("Mano de la apuesta:");
            mano=b.crearMano(baraja);           
            System.out.println(Arrays.toString(mano));
            //Crea una mano aleatoria y la muestra al usuario
            
            System.out.println("Dinero ganado: " + ap.verPremio(mano,apuesta,esJugador));
            j1.setSaldoAcumulado(j1.getSaldoAcumulado()+ap.verPremio(mano, apuesta,esJugador)-apuesta);
            //Muestra el dinero ganado con la mano y actualiza el saldo acumulado
            
            if(j1.getSaldoAcumulado()<=0){
                //Si el saldo total tras la apuesta y el premio es menor o igual
                //a 0, termina el programa
                
                System.out.println("No tienes más dinero que apostar.");
                break;
            }
            
            System.out.println("Saldo acumulado: " + j1.getSaldoAcumulado());
            //Muestra el saldo total al usuario
            
            System.out.println("¿Continuar? (q para salir)");
            msg=input.readLine();
            //Si el jugador introduce q, finaliza el programa
            
            i++;
            //Número de la apuesta que incrementa con cada jugada
        }while(!msg.equals("q"));{
        }
    }   
}