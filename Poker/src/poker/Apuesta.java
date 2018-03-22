
package poker;

public class Apuesta {
    /* La clase Apuesta 
    
    Contiene el método verPremio, que comprueba el premio de la mano
    */
    
            
    public int verPremio(Carta[] mano,int apuesta,boolean jugador) {
        /* El método extrae las cartas de la mano creada en la clase baraja en dos 
        arrays, los cuales se comprueban por separado; después se tratan los posibles
        premios, comprobando los requisitos del premio con los resultados de la mano
        
        Entran al método la mano, un array con objetos de tipo carta; la apuesta 
        que realiza el jugador en cada momento; y si el jugador es registrado u 
        ocasional, representado por un booleano, pues los premios son distintos
        
        Devuelve un entero, el premio de la mano entrante, ya multiplicado por 
        la apuesta del jugador
        */
        
        int i,as=0,dos=0,sota=0,cab=0,rey=0,oros=0,esp=0,bast=0,cop=0,premio=0;
        //Cada variable almacena un palo o figura distinto de la mano
        
        String[] palos = new String[5]; 
        //Array con los palos de la mano(inicialización)
        
        String[] figuras = new String[5];
        //Array con las figuras de la mano(inicialización)
        
        for(i=0;i<5;i++){
           palos[i]=mano[i].getPalo();
           figuras[i]=mano[i].getFigura();
        //Extrae las figuras y los palos de la mano y los introduce en los arrays
        
            switch (figuras[i]) {
                case "As":
                    as+=1;
                    break;
                case "Dos":
                    dos+=1;
                    break;
                case "Sota":
                    sota+=1;
                    break;
                case "Caballo":
                    cab+=1;
                    break;
                case "Rey":
                    rey+=1;
                    break;
                default:
                    break;
            }
            
            switch(palos[i]){
                case "copas":
                    cop+=1;
                    break;
                case "bastos":
                    bast+=1;
                    break;
                case "espadas":
                    esp+=1;
                    break;
                case "oros":
                    oros+=1;
                    break;
                default:
                    break;
            }
            //Suma 1 a la variable que se haya encontrado en la posición en la que 
            //se encuentra el bucle en cada momento, para ambos palos y figuras              
        }
        
        if(as==4||dos==4||sota==4||cab==4||rey==4){
        //Si el número de figuras extraído de la mano es igual a 4, es póker

            if(jugador==true){ 
            //Si el jugador es registrado, la variable jugador es true
                premio=apuesta*4;
            }
            
            else{
            //Si el jugador es ocasional, la variable jugador es false
                premio=apuesta*2;    
            }
           System.out.println("¡¡¡¡ENHORABUENA!!!!!, ha conseguido póker.");
        }
                
        else if(oros==5||bast==5||cop==5||esp==5){
        //Si todas las cartas son del mismo palo, es color

            if(jugador==true){
                premio=apuesta*10;
            }
            
            else{
                premio=apuesta*5;  
            }
            System.out.println("¡¡¡¡ENHORABUENA!!!!, ha conseguido color.");
        }
        
        else if ((as==3&&(dos==2||sota==2||cab==2||rey==2))||(dos==3&&(as==2||sota==2||cab==2||rey==2))||
                (sota==3&&(as==2||dos==2||cab==2||rey==2))||(cab==3&&(as==2||dos==2||sota==2||rey==2))||
                (rey==3&&(as==2||dos==2||sota==2||cab==2))){
        //Si una figura aparece 3 veces, y otra distinta aparece 2 veces, es full
                      
            if(jugador==true){
                premio=apuesta*8;
            }
            else{
                premio=apuesta*4;  
            }
            System.out.println("¡¡¡¡ENHORABUENA!!!!, ha conseguido full.");
        }
        else if(as==3||dos==3||sota==3||cab==3||rey==3){
        //Si una figura aparece 3 veces, es trio
        
            if(jugador==true){
                premio=apuesta*2;
            }else{
                premio=apuesta;
            }
            System.out.println("¡¡¡¡ENHORABUENA!!!!, ha conseguido trío.");
        }
        return premio;
    }
    
}