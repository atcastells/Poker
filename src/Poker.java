import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by acastells on 05/04/16.
 */
public class Poker {
	public static void main(String[] args){
		new Poker().inici();
	}

	void inici(){

		/*Inicialització*/
		gui gui = new gui();
		Deck deck1 = new Deck();
		int jugadorPrincipal;
		boolean guanyador = false;
		final int CARTES_TAULA = 30;

		/*Creem Jugadors*/
		ArrayList<Jugadors> llistaJugadors = new ArrayList<Jugadors>();

		afegirJugadors(deck1,llistaJugadors,"Agustí",100);
		afegirJugadors(deck1,llistaJugadors,"Alex",100);
		afegirJugadors(deck1,llistaJugadors,"Marc",100);
		afegirJugadors(deck1,llistaJugadors,"Aaron",100);

		/*Imprimim el llistat de jugadors*/
		gui.funcioTaula(columnesNoms,StringJugadors(llistaJugadors));
		gui.imprimir("Selecciona un jugador escribint el nom, o crean un de nou:");
		jugadorPrincipal = jugadorPrincipal(llistaJugadors,gui.readString(),deck1,gui); //Seleccionem el jugador principal
		gui.ln();gui.ln();


		/*Creem la taula*/
		Carta[] cartesTaula = new Carta[CARTES_TAULA];
		for (int i = 0; i < CARTES_TAULA;i++){
			cartesTaula[i] = deck1.getCard();
		}
		Taula taula1 = new Taula(cartesTaula,29,10);

		/*Començem el loop principal*/
		while (!guanyador){
			boolean turnoJugador = true;
			//Recorrem els jugadors
			for(int i = 0; i < llistaJugadors.size();i++){
				if(i == jugadorPrincipal && turnoJugador){  //Torn del jugador Principal
					turnoJugador = false;
					boolean pujar = taula1.getApostaMax() > llistaJugadors.get(jugadorPrincipal).getAposta();
					boolean igualar = taula1.getApostaMax() > llistaJugadors.get(jugadorPrincipal).getAposta();
					boolean apostar = taula1.getDiners() == 0;
					boolean allIn = llistaJugadors.get(jugadorPrincipal).getCredit() < taula1.getMinAposta() || llistaJugadors.get(jugadorPrincipal).getCredit() < taula1.getApostaMax();
					boolean pasar = taula1.apostaMax == llistaJugadors.get(jugadorPrincipal).getAposta();
					boolean sortirMenu = false;
					//Mostra missatge de jugador principal
					gui.imprimir("Jugador: "+llistaJugadors.get(jugadorPrincipal).getNom());
					gui.ln();gui.ln();
					int opcioMenu = 0;
					while (opcioMenu < menuOpcions.length && !sortirMenu){
						gui.imprimir(gui.funcioMenu(menuOpcions));
						opcioMenu = gui.readInt("Selecciona una opció: ");
						switch (opcioMenu){
							case 1:  //Apostar
								gui.ln();
								gui.imprimir("Aposta mínima: "+taula1.getMinAposta());
								gui.ln();
								gui.imprimir("Diners totals: "+llistaJugadors.get(jugadorPrincipal).getCredit());
								gui.ln();
								if(apostar){
									llistaJugadors.get(jugadorPrincipal).aposta(taula1.minAposta,gui);
								}
								else {
									gui.ln();
									gui.imprimir("No pots apostar, puja o iguala la aposta.");
								}
								break;
							case 2:  //Pujar
								gui.ln();
								gui.imprimir("Aposta actual: "+taula1.getApostaMax());
								gui.ln();
								gui.imprimir("Diners totals: "+llistaJugadors.get(jugadorPrincipal).getCredit());
								gui.ln();
								if(pujar){
									llistaJugadors.get(jugadorPrincipal).aposta(taula1.minAposta,gui);
								}
								break;
							case 3: //Igualar
								gui.ln();
								gui.imprimir("Aposta actual: "+taula1.getApostaMax());
								gui.ln();
								gui.imprimir("Diners totals: "+llistaJugadors.get(jugadorPrincipal).getCredit());
								gui.ln();
								if (igualar && !allIn){
									llistaJugadors.get(jugadorPrincipal).aposta(taula1.minAposta,taula1.apostaMax,gui);
								}
								break;
							case 4: //Pasar
								if (pasar){
									sortirMenu = true;
								}
									break;
							case 5: //Retirarse
								break;
							case 6: //Jugar
								break;
							case 7: //Veure cartes
								gui.ln();
								gui.imprimir("Cartes propies:");
								gui.ln();
								gui.imprimir(llistaJugadors.get(jugadorPrincipal).toString());
								gui.ln();gui.ln();
								gui.imprimir("Cartes taula:");
								gui.ln();
								for(int j = 0; j < taula1.cartesMostrades;j++){
									gui.imprimir(taula1.stringCartes(j));
									gui.ln();
								}
								gui.ln();
								break;
							case 8:	//TEST
								gui.ln();
								gui.imprimir("Les jugades que tens disponibles son: \n");
								/*Creem array amb les cartes del jugador + taula*/
								Carta[] cartesjugador = new Carta[taula1.cartesMostrades + llistaJugadors.get(jugadorPrincipal).ma.length];
								int controlArray = 0;
								for (int j = 0; j < llistaJugadors.get(jugadorPrincipal).ma.length; j++) {
									cartesjugador[controlArray] = llistaJugadors.get(jugadorPrincipal).ma[j];
									controlArray++;
								}
								for (int j = 0; j < taula1.cartesMostrades; j++) {
									cartesjugador[controlArray] = taula1.cartesTaula[j];
									controlArray++;
								}
								Jugada jugada01 = new Jugada(cartesjugador);
								if(!(jugada01.cartaMesAlta == null)){
									gui.imprimir("La carta mes alta es "+jugada01.cartaMesAlta[0].toString()+"\n");

								}
								if(!(jugada01.parella == null)){
									gui.imprimir("Parella de "+jugada01.parella[0].toString()+ " i "+jugada01.parella[1]+"\n");
								}
								if(!(jugada01.dobleParella == null)){
									gui.imprimir("Doble parella de "+jugada01.dobleParella[0].toString()+ " i "+jugada01.dobleParella[2]+"\n");
								}
								if(!(jugada01.trio == null)){
									gui.imprimir("Trio de "+jugada01.trio[0].toString()+"\n");
								}
								if(!(jugada01.escala == null)){
									gui.imprimir("Escala de "+jugada01.escala[0]+" a "+ jugada01.escala[jugada01.escala.length-1]);
								}
								break;
						}
					}
					gui.enterContinue();
				}
				else {
					evaluarJugades(llistaJugadors,i);


				}
            }

			}

		}



	/**************************FUNCIONS AUXILIARS***********************************/
	String[][] StringJugadors(ArrayList<Jugadors> llistaJugadors){
		String[][] jugadors = new String[llistaJugadors.size()][3];
		for(int i = 0; i < jugadors.length;i++){
			jugadors[i][0] = llistaJugadors.get(i).getNom();
			jugadors[i][1] = llistaJugadors.get(i).getCredit()+"";
		}
		return jugadors;
	}
	int jugadorPrincipal(ArrayList<Jugadors> llistaJugadors,String nom,Deck deck1,gui gui){
		int jugadorPrincipal = 0;
		int contador = 0;
		for(int i = 0; i < llistaJugadors.size();i++){
			if(llistaJugadors.get(i).getNom().equalsIgnoreCase(nom)){
				jugadorPrincipal = i;
				contador++;
			}
		}
		if(contador == 0){
			afegirJugadors(deck1,llistaJugadors,nom,100);
			gui.imprimir("Jugadors actualitzats, nova llista:");
			gui.ln();
			gui.funcioTaula(columnesNoms,StringJugadors(llistaJugadors));
			gui.ln();
			gui.enterContinue();
			return jugadorPrincipal(llistaJugadors,nom,deck1,gui);
		}
		return jugadorPrincipal;
	}
	
	void afegirJugadors(Deck deck1,ArrayList<Jugadors> llistaJugadors,String nom,int diners){
		llistaJugadors.add(new Jugadors(nom,diners,deck1.getCard(),deck1.getCard()));

	}
	int evaluarJugades(ArrayList<Jugadors> llistaJugadors,int numJugador){
        return -1;
	}
	String[] menuOpcions = {"Apostar","Pujar","Igualar","Pasar","Retirarse","Jugar","Veure Cartes","TEST"};

	/*Arrays columnes*/
	String[] columnesNoms = {"Nom","Credit"};
}
