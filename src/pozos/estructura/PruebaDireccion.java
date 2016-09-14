package pozos.estructura;

/**
 * Created by ioangiurgiu on 15/02/16.
 */
public class PruebaDireccion {
    public static void main(String[] args) {
        Pozo pozo = new Pozo(4,4,7,5);
        System.out.println(pozo.consultaPetroleo());
        pozo.extraerPetroleo();
        pozo.extraerPiedra();
        pozo.percutor(0);
        pozo.consultarSeccionesColumnas();
    }
}
