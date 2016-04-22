import java.util.ArrayList;

/**
 * Created by acastells on 22/04/16.
 */
public class Taula {
	Carta[] cartesTaula;
	int cartesMostrades;
	int minAposta;
	int diners = 0; //Diners totals a la taula
	int apostaMax = 0;  //Aposta maxima a la taula

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
	int getDiners(){
		return diners;
	}
	String getCarta(int x){
		return cartesTaula[x].toString();
	}
	int getApostaMax(){
		return apostaMax;
	}
	void setApostaMax(int x){
		apostaMax = x;
	}

	void updateValues(ArrayList<Jugadors> jugadors){
		diners = 0;
		for(int i = 0; i < jugadors.size();i++) {
			//Actualitza el contador de aposta MAX
			if (jugadors.get(i).getAposta() < apostaMax) {
				apostaMax = jugadors.get(i).getAposta();
			}
			//Actualitza el contador de diners a la Taula
			diners += jugadors.get(i).getCredit();
		}
	}
}
