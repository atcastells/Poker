/**
 * Created by acastells on 05/04/16.
 */
public class Jugadors {
	String nom;
	int Diners;
	Carta[] ma = new Carta[2];

	public Jugadors(String nom, int Diners){
		this(nom,Diners,null,null);
	}
	public Jugadors(String nom, int Diners, Carta carta1, Carta carta2){
		this.nom = nom;
		this.Diners = Diners;
		this.ma[0] = carta1;
		this.ma[1] = carta2;
	}

	public void setCartes(Carta[] cartes){
		ma = cartes;
	}

	public int aposta(){
		return 1;
	}

	public String toString(){
		return(nom+"\n"+"\t"+ma[1]+"\n"+"\t"+ma[0]);
	}
}
