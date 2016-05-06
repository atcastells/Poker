import java.util.NoSuchElementException;

/**
 * Created by acastells on 05/04/16.
 */
public enum Numeros {
	As(14),C2(2),C3(3),C4(4),C5(5),C6(6),C7(7),C8(8),C9(9),C10(10),J(11),Q(12),K(13);
	int numero;
	Numeros(int num){
		numero = num;
	}

	public int getNumero() {
		return numero;
	}

	public int getPosicio(){
		int n = numero;
		if (n == 14){
			n = 1;
		}
		return n;
	}

	public String toString(){
		if(numero >=2 && numero <=10){
			return numero+"";
		}
		return super.toString();
	}
	public Numeros next(){
	if(ordinal() == values().length -1){
		throw new NoSuchElementException();
	}
		return values()[ordinal() +1];
	}
}
