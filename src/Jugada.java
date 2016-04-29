/**
 * Created by Aaron Castells on 05/04/2016.
 */
public class Jugada {
    Carta[] cartaMesAlta;
    Carta[] parella;
    Carta[] dobleParella;
    Carta[] trio;
    Carta[] escala;
    Carta[] color;
    Carta[] full;
    Carta[] poker;
    Carta[] escalaColor;
    Carta[] escalaReal;


    public Jugada(Carta[] cartes){
        
        /************Assignem els valors a les variables a retornar*******/
        cartaMesAlta = jugadaCartaAlta(cartes);
        parella = jugadaParella(cartes);
        dobleParella = jugadaDobleParella(cartes);
        trio = jugadaTrio(cartes);
        escala=jugadaEscala(cartes);
        color=jugadaColor(cartes);
        full=jugadaFull(cartes);
        poker=jugadaPoker(cartes);
        escalaColor = jugadaEscalaColor(cartes);
        escalaReal = jugadaEscaleraReal(cartes);
    }
    
    /********Comprobem les jugades possibles*******/
    public Carta[] jugadaEscaleraReal(Carta[] jugada){

    }
    public Carta[] jugadaEscalaColor(Carta[] jugada){
        
    }
    public Carta[] jugadaPoker(Carta[] jugada){
        
    }
    public Carta[] jugadaFull(Carta[] jugada){
        
    }
    public Carta[] jugadaColor(Carta[] jugada){
        
    }
    public Carta[] jugadaEscala(Carta[] jugada){
        
    }
    public Carta[] jugadaTrio(Carta[] jugada){

    }
    public Carta[] jugadaDobleParella(Carta[] jugada){
        Carta[] array = new Carta[4];
        array[0] = jugadaParella(jugada)[0];
        if (array[0] == null){
            return null;
        }
        array[1] = jugadaParella(jugada)[1];
        for (int i = 0; i < ; i++) {
            
        }
        int MAX = 0;

    }
    public Carta[] jugadaParella(Carta[] jugada){
        Carta[] array = new Carta[2];
        int MAX = 0;
        for (int i = 0; i < jugada.length; i++) {
            for (int j = i+1; j < jugada.length; j++) {
                if (jugada[i].Numero().getNumero() == jugada[j].Numero().getNumero()){
                    if (jugada[i].Numero().getNumero() > MAX){
                        array[0] = jugada[i];
                        array[1] = jugada[j];
                        MAX = array[0].numero.getNumero();
                    }

                }
            }
        }
        if(!(array[0] == null)){
            return array;
        }
        else {
            return null;
        }

    }
    public Carta[] jugadaCartaAlta(Carta[] jugada){
        Carta cartaAlta = null;
        int valorCartaAlta = 0;
        int coincidencies = 0;
        for (int i = 0; i < jugada.length; i++) {
            if(jugada[i].Numero().getNumero() > valorCartaAlta){
                cartaAlta = jugada[i];
                coincidencies++;
            }
        }
        if(coincidencies > 0){
            Carta[] llistaCartaAlta = {cartaAlta};
            return llistaCartaAlta;
        }
        else {
            return null;
        }
    }
}
