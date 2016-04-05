/**
 * Created by acastells on 05/04/16.
 */
public class Carta {
	Palo palo;
	Numeros numero;

	public Carta(Palo palo,Numeros num){
		this.palo = palo;
		numero = num;
	}

	Numeros getNumero(){
		return numero;
	}

	Palo getPalo(){
		return palo;
	}

	public String toString(){
		return (palo + "    "+numero);
	}

}
