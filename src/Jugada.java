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
        return null;
    }
    public Carta[] jugadaEscalaColor(Carta[] jugada){
        return null;
    }
    public Carta[] jugadaPoker(Carta[] jugada){
        return null;
    }
    public Carta[] jugadaFull(Carta[] jugada){
        return null;
    }
    public Carta[] jugadaColor(Carta[] jugada){
        return null;
    }
    public Carta[] jugadaEscala(Carta[] jugada){
        Numeros num = null;     //Variable per comprobar escala
        boolean Escala = false;
        Carta temp = null;
        int contadorEscala = 0;
        Carta[] array = new Carta[5];
        /*Ordenem la array*/
        for (int i = 0; i < jugada.length; i++) {
            for (int j = i+1; j < jugada.length; j++) {
                if(jugada[i].Numero().getNumero() > jugada[j].Numero().getNumero()){
                    temp = jugada[i];
                    jugada[i] = jugada[j];
                    jugada[j] = temp;
                }
            }
        }
        /*Comprobem si hi ha escala*/
        for (int i = 0; i < jugada.length && !Escala; i++) {
            for (int j = i+1; j < jugada.length; j++) {
                if(jugada[i].Numero().next() == jugada[j].Numero()){
                    contadorEscala++;
                    array[contadorEscala - 1] = jugada[i];
                    if(contadorEscala == 5){
                        Escala = true;
                    }
                }
                else {
                    if(contadorEscala > 0){
                        contadorEscala = 0;
                    }
                    else {
                        i++;
                    }
                }
            }

        }
        if (Escala){
            return array;
        }
        else {
            return null;
        }
    }
    public Carta[] jugadaTrio(Carta[] jugada){
        Carta[] array = new Carta[3];
        int cartes = 0;
        for (int i = 0; i < jugada.length; i++) {
            for (int j = i+1; j < jugada.length; j++) {
                if(jugada[i].Numero().getNumero() == jugada[j].Numero().getNumero() && cartes < 3){
                    cartes++;
                    array[cartes-1] = jugada[j];
                }
            }
            if (cartes > 2){
                return array;
            }
            else {
                cartes = 0;
            }
        }
        return null;
    }
    public Carta[] jugadaDobleParella(Carta[] jugada){
        Carta[] array = new Carta[4];
        if(parella == null){
            return null;
        }
        array[0] = jugadaParella(jugada)[0];
        if (array[0] == null){
            return null;
        }
        Carta[] arrayParella2 = new Carta[jugada.length-2]; //Creem una array per buscar la segona parella
        array[1] = jugadaParella(jugada)[1];
        int contador = 0;   //Contador per inserir a la array nova
        int cartesAeliminar = jugada.length - arrayParella2.length;
        for (int i = 0; i < jugada.length; i++) {   //Eliminem les dos cartes de la 1a parella de la llista de cartes
            for (int j = i + 1; j < array.length; j++) {
                if(!(jugada[i].equals(array[j])) && !(array[j] == null)){
                    arrayParella2[contador] = jugada[i];
                    contador++;
                }
            }
        }
        if(jugadaParella(arrayParella2) == null){
            return null;
        }
        array[2] = jugadaParella(arrayParella2)[0];
        if (array[2] == null){
            return null;
        }
        array[3] = jugadaParella(arrayParella2)[1];
        return array;
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
    public Carta[] jugadaCartaAlta(Carta[] jugada){;
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