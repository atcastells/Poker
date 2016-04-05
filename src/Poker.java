import java.util.ArrayList;

/**
 * Created by acastells on 05/04/16.
 */
public class Poker {
	public static void main(String[] args){
		new Poker().inici();
	}

	void inici(){
		/*Creem Baraja*/
		Deck baraja1 = new Deck();
		int x = baraja1.numCartes();
		/*for(int i = 0; i < x; i++){
			System.out.print((i+1)+"    "+baraja1.getCard()+"\n");
		}*/

		/*Creem Jugadors*/

		//Creem Llista jugadors
		ArrayList<Jugadors> llistaJugadors = new ArrayList<Jugadors>();

		llistaJugadors.add(new Jugadors("Josep",100,baraja1.getCard(),baraja1.getCard()));
		llistaJugadors.add(new Jugadors("Miguel",100,baraja1.getCard(),baraja1.getCard()));
		llistaJugadors.add(new Jugadors("Jose",100,baraja1.getCard(),baraja1.getCard()));
		llistaJugadors.add(new Jugadors("Mateu",100,baraja1.getCard(),baraja1.getCard()));
		llistaJugadors.add(new Jugadors("Aaron",100,baraja1.getCard(),baraja1.getCard()));
		llistaJugadors.add(new Jugadors("Oscar",100,baraja1.getCard(),baraja1.getCard()));

		/*Llistem les mans de cada jugador*/
		for(int i = 0; i < llistaJugadors.size();i++){
			System.out.println(llistaJugadors.get(i).toString());
		}
	}
}
