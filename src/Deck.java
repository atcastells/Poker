import java.util.ArrayList;
import java.util.Random;

/**
 * Created by acastells on 05/04/16.
 */
public class Deck {
	ArrayList<Carta> pokerDeck = new ArrayList<Carta>();

	public Deck(){
		for(int i = 0; i < Palo.values().length;i++){
			for(int j = 0; j < Numeros.values().length; j++){
				Carta c = new Carta(Palo.values()[i],Numeros.values()[j]);
				pokerDeck.add(c);
			}
		}
	}

	public Carta getCard(){
		Random rd = new Random();
		return pokerDeck.remove(rd.nextInt(numCartes()));
	}

	public int numCartes(){
		return pokerDeck.size();
	}

}
