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
		int linea = 10;
		int altura = 5;
		String carta = palo+" "+numero;
		/*for(int i = 0; i <= altura;i++){
			for(int j = 0; j <= linea; j++){
				if((i == 0 || i == altura)&& j != 0 && j!= linea){
					carta +="-";
				}
				if((j == 0 || j == linea)){
					carta +="|";
				}
				if(i == 1 && j != 0 && j!= (linea - palo.toString().length())){
					carta +=" ";
				}
				if((i == 2 || i == 3)&& j != 0 && j!= linea){
					carta+=" ";
				}
				if(i == 4 && j == 0){
					carta+=numero;
					j += numero.toString().length()-1;
				}
				if(i == 4 && j!=1 && j != (linea -numero.toString().length())){
					carta+=" ";
				}
				if(i == 1 && j == linea - palo.toString().length()){
					carta +=palo;
					j += palo.toString().length()-1;
				}
			}
			carta+="\n";
		}*/
		return carta;
	}

}
