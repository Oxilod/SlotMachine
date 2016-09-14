package pozos.estructura;


/**
 * Created by ioangiurgiu on 15/02/16.
 */
public final class Posicion {

    private final int x;
    private final int y;
    private Direccion dir;

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Posicion() {
        this(0,0);
    }
    public Posicion(Posicion posicion){
        this(posicion.getX(), posicion.getY());
    }
    public Posicion adyacente(Direccion direccion) {
        if (direccion == dir.DERECHA){
            return new Posicion(x+1,y);
        }else if (direccion == dir.IZQUIERDA){
            return new Posicion(x-1, y);
        }else if (direccion == dir.ARRIBA){
            return new Posicion(x, y+1);
        }else if (direccion == dir.ABAJO){
            return new Posicion(x, y-1);
        }else {
            return new Posicion(x,y);
        }
    }
    public double distance(Posicion pos1){
        return Math.sqrt((pos1.getX() - x)*(pos1.getX() - x))+(((pos1.getY() - y)*(pos1.getY() - y)));
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
