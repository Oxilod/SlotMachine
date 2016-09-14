package pozos.estructura;

/**
 * Created by ioangiurgiu on 15/02/16.
 */
public class Roca extends Seccion{

    private int dureza;
    private int golpesRecibidos = 0;
    private boolean rota = false;

    public Roca(Posicion posicion){
        super(posicion);
        dureza = 5;
     }
    public Roca(Posicion posicion, int dureza) {
        super(posicion);
        this.dureza = dureza;
    }

    public boolean golpear(){
        golpesRecibidos++;
        if (golpesRecibidos >= dureza){
            rota = true;
        }else if (golpesRecibidos < dureza) {
            rota = false;
            dureza--;
        }
        return esRota();
    }

    public boolean esRota(){
        return rota;
    }

    public int estadoRoca(){
        return dureza;
    }

}
