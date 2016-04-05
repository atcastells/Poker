/**
 * Created by Aaron Castells on 05/04/2016.
 */
public class Jugada {


    public Jugada(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5){

        /*Desglossament de cartes per a les jugades*/

        /*Passem els numeros de la jugada a una array*/
        Numeros[] jugadaNumeros = new Numeros[5];
        jugadaNumeros[0] = carta1.numero;
        jugadaNumeros[1] = carta2.numero;
        jugadaNumeros[2] = carta3.numero;
        jugadaNumeros[3] = carta4.numero;
        jugadaNumeros[4] = carta5.numero;

        /*Fem el recompte de palos*/
        Palo[] jugadaPalos = new Palo[5];
        jugadaPalos[0] = carta1.palo;
        jugadaPalos[1] = carta2.palo;
        jugadaPalos[2] = carta3.palo;
        jugadaPalos[3] = carta4.palo;
        jugadaPalos[4] = carta5.palo;

        /*Calculem les possibles jugades*/
        boolean escaleraReal = jugadaEscaleraReal(jugadaNumeros,jugadaPalos);
    }

    public boolean jugadaEscaleraReal(Numeros[] jugadaNum,Palo[] jugadaPalo){
        int coincidencies = 0;
        int intents = 0;
        Numeros EscaleraReal = Numeros.C10;
        int cors = 0;
        int diamants = 0;
        int trebols = 0;
        int piques = 0;
        for (int i = 0; i < jugadaPalo.length; i++){
            if(jugadaPalo[i] == Palo.Cors){
                cors++;
            }
            if(jugadaPalo[i] == Palo.Diamants){
                diamants++;
            }
            if(jugadaPalo[i] == Palo.Trebols){
                trebols++;
            }
            if(jugadaPalo[i] == Palo.Piques){
                piques++;
            }
        }
        if (cors == 5 || diamants == 5 || trebols == 5 || piques == 5){
            while(intents < 6){
                for (int i = 0; i < jugadaNum.length; i++){
                    if (jugadaNum[i] == EscaleraReal){
                        coincidencies++;
                        EscaleraReal = EscaleraReal.next();
                    }
                    else {
                        intents++;
                    }
                }
                if(coincidencies == 5){
                    return true;
                }
            }
        }
        return false;
    }
}
