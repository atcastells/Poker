/**
 * Created by Aaron Castells on 05/04/2016.
 */
public enum Jugades {
    EscaleraRealColor(10),EscaleraColor(9),Poker(8),Full(7),Color(6),Escalera(5),Trio(4),DoblePareja(3),Pareja(2),CartaMasAlta(1);
    int numero;
    Jugades(int num){
        numero = num;
    }
}
