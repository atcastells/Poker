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
		/*Creem Baraja*/
		gui gui = new gui();
		Deck deck1 = new Deck();
		int x = deck1.numCartes();
		int jugadorPrincipal = 0;
		/*for(int i = 0; i < x; i++){
			System.out.print((i+1)+"    "+deck1.getCard()+"\n");
		}*/

		/*Creem Jugadors*/
		//Creem Llista jugadors
		ArrayList<Jugadors> llistaJugadors = new ArrayList<Jugadors>();

		afegirJugadors(deck1,llistaJugadors,"Agustí",100);
		afegirJugadors(deck1,llistaJugadors,"Alex",100);
		afegirJugadors(deck1,llistaJugadors,"Marc",100);
		afegirJugadors(deck1,llistaJugadors,"Aaron",100);

		/*Llistem les mans de cada jugador*/
		/*for(int i = 0; i < llistaJugadors.size();i++){
			System.out.println(llistaJugadors.get(i).getNom()+"\n"+llistaJugadors.get(i).toString());
		}*/
		
		boolean guanyador = false;
		/*Afegim les cartes a la taula*/
		/*Seleccionem un jugador*/

		gui.funcioTaula(columnesNoms,StringJugadors(llistaJugadors));

		gui.imprimir("Selecciona un jugador escribint el nom, o crean un de nou:");

		jugadorPrincipal = jugadorPrincipal(llistaJugadors,gui.readString(),deck1,gui);
		gui.ln();gui.ln();
		while (!guanyador){
			//Mostra missatge de jugador principal
			gui.imprimir("Jugador: "+llistaJugadors.get(jugadorPrincipal).getNom());
			gui.ln();gui.ln();
			int cartesMostrades = 2;	//
			Carta[] taula = new Carta[5];
			for (int i = 0; i < taula.length && i < cartesMostrades; i++) {
				taula[i] = deck1.getCard();
			}

			/*Accions*/
			gui.imprimir(gui.funcioMenu(menuOpcions));
			int opcioMenu = gui.readInt("Selecciona una opció: ");
			/*Comprovem les jugades*/
			for(int i = 0; i < llistaJugadors.size();i++){
				//System.out.println("Turno de "+llistaJugadors.get(i).getNom()+" amb les cartes:\n"+llistaJugadors.get(i).toString()+"\n"+taula[0]+"\n"+taula[1]+"\n"+taula[2]);
				//new Jugada(llistaJugadors.get(i).getCarta(0),llistaJugadors.get(i).getCarta(1),taula[0],taula[1],taula[2]);
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
	String[] menuOpcions = {"Apostar","Pujar","Igualar","Pasar","Retirarse","Jugar","Veure Cartes"};

	/*Arrays columnes*/
	String[] columnesNoms = {"Nom","Credit"};
}
