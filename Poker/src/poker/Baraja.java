
package poker;

import java.util.ArrayList;
import java.util.Random;
//Importar las librerías ArrayList y Random

public class Baraja {
    /* La clase Baraja simula una baraja de cartas, por lo que contiene dos atributos
    privados de tipo array de Strings que contienen uno los palos y otro las figuras
    de una baraja española de 20 cartas. Además se asocia a la clase carta con un 
    array de tipo Carta, la baraja
    
    Contiene los métodos crearBaraja, que crea la baraja de cartas; y crearMano,
    que crea una mano con 5 cartas seleccionadas de la baraja aleatoriamente
    */
    private final Carta[] baraja;
    private final String[] palos ={"Oros","Bastos","Espadas","Copas"};
    private final String[] figuras = {"As","Dos","Sota","Caballo","Rey"};

    public Baraja(Carta[] baraja) {
        this.baraja = baraja;
    }
       
    public Carta[] crearBaraja(){
        //Método que devuelve un array de tipo Carta, la baraja
        
        int i,j,n=0;
        
        while (n<20){
        //Limite de 20 cartas
        
            for (i=0;i<4;i++){
            //Límite para los palos
            
                for (j=0;j<5;j++){
                //Límite para las figuras
                
                    baraja[n]=new Carta(figuras[j],palos[i]);
                    //Instancia 20 objetos de tipo Carta seleccionados de los 
                    //arrays figura y palo de tipo String
                    
                n++;
                //Incrementa con cada iteración de figuras para no repetir índices
                }
            }
        }
        return baraja;
    }
    
    public Carta[] crearMano(Carta[] baraja){
        /* Método que devuelve un array de tipo Carta, la mano. Entra la baraja 
        
        Primero, crea un array de números aleatorios, que serán los índices de la 
        baraja. Luego crea un array de tipo Carta, la mano,que contiene cartas de 
        la baraja seleccionadas aleatoriamente 
        */
        
        ArrayList<Integer> nums = new ArrayList<>();   
        Random rand = new Random();
        int i, numeros[]=new int[20],random;
        while (nums.size() < 20) {
            random = rand.nextInt(20);
            if (!nums.contains(random)) 
                nums.add(random);
        }
        //Crea números entre 0 y 20 y comprueba que no se repitan
        
        for(i=0;i<5;i++)
            numeros[i]=nums.get(i);
        //Sustituye el ArrayList por un array fijo
        
        Carta[] mano = new Carta[5];
        for (i=0;i<mano.length;i++)
            mano[i]=baraja[numeros[i]];
        //Crea la mano
        
        return mano;
    }   
}
