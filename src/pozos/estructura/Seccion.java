package pozos.estructura;

/**
 * Created by ioangiurgiu on 15/02/16.
 */
public class Seccion{

    private final int capacidad;
    private Posicion posicion;

    public Seccion(){
        capacidad = 12;
    }

    public Seccion (Posicion posicion,int capacidad){
        this.posicion = posicion;
        this.capacidad = capacidad;
    }

    public Seccion(Posicion posicion){
        this(posicion, 12);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

}
