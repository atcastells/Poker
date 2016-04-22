/**
 * Created by acastells on 05/04/16.
 */
public class Jugadors {
	String nom;
	int diners;
	int aposta = 0;
	Carta[] ma = new Carta[2];

	public Jugadors(String nom, int Diners){
		this(nom,Diners,null,null);
	}
	public Jugadors(String nom, int Diners, Carta carta1, Carta carta2){
		this.nom = nom;
		this.diners = Diners;
		this.ma[0] = carta1;
		this.ma[1] = carta2;
	}

	public void setCartes(Carta[] cartes){
		ma = cartes;
	}

	public int getAposta(){
		return aposta;
	}

	public Carta getCarta(int x){
		return ma[x];
	}
	public String getNom(){
		return nom;
	}
	public String toString(){
		return(ma[1]+"\n"+ma[0]);
	}
	public int getCredit(){
		return diners;
	}
	void setAposta(int x){
		aposta = x;
	}
	void setCredit(int x){
		diners = x;
	}

	void aposta(int x,gui gui){
		int novaAposta = 0;
		if(diners > x){
			do{
				novaAposta=gui.readInt("Introdueix la teva nova aposta: ");
			}
			while (novaAposta < x);
			aposta += novaAposta;
			diners = diners - novaAposta;
		}
	}
}
