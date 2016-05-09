import java.lang.reflect.Array;
import java.util.ArrayList;

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
                if(jugada[i].Numero().getPosicio() > jugada[j].Numero().getPosicio()){
                    temp = jugada[i];
                    jugada[i] = jugada[j];
                    jugada[j] = temp;
                }
            }
        }

        /*Eliminem cartes amb numeros repetits*/
        ArrayList<Carta> llistaCartes = new ArrayList<Carta>();
        Numeros numEliminar = null;
        boolean numeroGuardat = false;

        for (int i = 0; i < Numeros.values().length; i++) {
            numEliminar = Numeros.values()[i];
            for (int j = 0; j < jugada.length; j++) {
                if(jugada[j].Numero() == numEliminar){
                    if(!numeroGuardat){
                        numeroGuardat = true;
                        llistaCartes.add(jugada[j]);
                    }
                }
            }
            numeroGuardat = false;
        }

        Carta[] arrayEscala = new Carta[llistaCartes.size()];
        arrayEscala = (Carta[])llistaCartes.toArray(arrayEscala);

        /*Comprobem si hi ha escala*/
        for (int i = 0; i < arrayEscala.length; i++) {
            for (int j = i+1; j < arrayEscala.length && !Escala; j++) {
                if(arrayEscala[i].Numero().getPosicio() +1 == arrayEscala[j].Numero().getPosicio()){
                    array[contadorEscala] =  arrayEscala[i];
                    i = j;
                    contadorEscala++;
                    if (contadorEscala == 5){
                        if(arrayEscala.length >=5){
                            Carta[] escalaMesGran = new Carta[arrayEscala.length-1];
                            for (int k = 0; k < escalaMesGran.length; k++) {
                                escalaMesGran[k] = arrayEscala[k+1];
                            }
                            if(!(jugadaEscala(escalaMesGran) == null)){
                                return jugadaEscala(escalaMesGran);
                            }
                        }
                        return array;
                    }
                }
            }
            contadorEscala = 0;
        }
            return null;
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
        ArrayList<Carta> llistaCartes  = new ArrayList<Carta>();

        for (int i = 0; i < jugada.length; i++) {
            llistaCartes.add(jugada[i]);
        }
        Carta[] array = new Carta[4];

        if(parella == null){
            return null;
        }

        array[0] = jugadaParella(jugada)[0];
        if (array[0] == null){
            return null;
        }
        array[1] = jugadaParella(jugada)[1];

        /*Eliminem les cartes de la parella anterior de la llista*/
        int contador = 0;
        for (int i = 0; i < llistaCartes.size(); i++) {
            if(llistaCartes.get(i).equals(array[contador]) && contador < 2){
                llistaCartes.remove(i);
                contador++;
            }
        }
        int controlArray = 0;
        /*Creem una array a partir de la Arraylist*/
        Carta[] arrayDobleParella = new Carta[llistaCartes.size()];
        arrayDobleParella = (Carta[])llistaCartes.toArray(arrayDobleParella);


        if(jugadaParella(arrayDobleParella) == null){
            return null;
        }
        array[2] = jugadaParella(arrayDobleParella)[0];
        if (array[2] == null){
            return null;
        }
        array[3] = jugadaParella(arrayDobleParella)[1];
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
                valorCartaAlta = cartaAlta.Numero().getNumero();
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