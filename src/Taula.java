/**
 * Created by acastells on 22/04/16.
 */
public class Taula {
	Carta[] cartesTaula;
	int cartesMostrades;
	int minAposta;
	int aposta = 0;

	public Taula(Carta[] cartesTaula,int x, int y){
		this.cartesTaula = cartesTaula;
		cartesMostrades = x;
		minAposta = y;
	}

	int getCartesMostrades(){
		return cartesMostrades;
	}
	int getMinAposta(){
		return minAposta;
	}
	int getAposta(){
		return aposta;
	}
	String getCarta(int x){
		return cartesTaula[x].toString();
	}
}
