package pozos.estructura;


/**
 * Created by ioangiurgiu on 15/02/16.
 */
public class Bolsa extends Seccion{
    private int cantidadAire;
    private int cantidadPiedra;
    private int cantidadPetroleo;

    public Bolsa(Posicion posicion){
        super(posicion, 5);
        cantidadAire = super.getCapacidad();
    }

    public Bolsa(Posicion posicion, int capacidad){
        super(posicion, capacidad);
        cantidadAire = capacidad;
    }

    public void llenarAire(){
        cantidadPetroleo = 0;
        cantidadPiedra = 0;
        cantidadAire = getCapacidad();
    }

    public void llenarPiedra(){
        cantidadAire = 0;
        cantidadPetroleo = 0;
        cantidadPiedra = getCapacidad();
    }

    public void llenarPetroleo(){
        cantidadPiedra = 0;
        cantidadAire = 0;
        cantidadPetroleo = getCapacidad();
    }

    public int extraer(Elemento elemento, int cantidad){
        /*while (cantidad > cantidadAire && elemento == Elemento.AIRE || cantidad > cantidadPiedra && elemento == Elemento.PIEDRA ||
                cantidad > cantidadPetroleo && elemento == Elemento.PETROLEO){
            cantidad--;
        }*/
        /*if (cantidad <= cantidadAire && elemento == Elemento.AIRE){
            cantidadAire -= cantidad;
        }else if (cantidad <= cantidadPiedra && elemento == Elemento.PIEDRA){
            cantidadPiedra -= cantidad;
            cantidadAire += cantidad;
        }else if (cantidad <= cantidadPetroleo && elemento == Elemento.PETROLEO){
            cantidadPetroleo -= cantidad;
            cantidadAire += cantidad;
        }*/
        if(elemento == Elemento.AIRE) {
            System.out.println("Aire cantidad= " + cantidad + " cantidadAire = " + cantidadAire);
            return cantidadAire;
        } else if (elemento == Elemento.PIEDRA) {
            if(cantidad > cantidadPiedra) {
                cantidadAire += cantidadPiedra;
                int result = cantidadPiedra;
                cantidadPiedra = 0;
                System.out.println("Piedra cantidad= " + cantidad + " cantidadPiedra = " + cantidadPiedra);
                return result;
            } else {
                cantidadPiedra -= cantidad;
                System.out.println("Piedra cantidad= " + cantidad + " cantidadPiedra = " + cantidadPiedra);
                return cantidad;
            }
        } else {
            if(cantidad > cantidadPetroleo) {
                cantidadAire += cantidadPetroleo;
                int result = cantidadPetroleo;
                cantidadPetroleo = 0;
                System.out.println("Petroleo cantidad= " + cantidad + " cantidadPetroleo = " + cantidadPetroleo);
                return result;
            } else {
                cantidadPetroleo -= cantidad;
                System.out.println("Petroleo cantidad= " + cantidad + " cantidadPetroleo = " + cantidadPetroleo);
                return cantidad;
            }
        }
    }

    public int introducir(Elemento elemento, int cantidad){
        /*while (cantidad > cantidadAire){
            cantidad--;
            }*/
        if(cantidad > cantidadAire) {
            cantidad = cantidadAire;
        }
        if (elemento == Elemento.PETROLEO){
            cantidadAire -= cantidad;
            cantidadPetroleo += cantidad;
            System.out.println("Se ha introducido " + cantidad + " de " + elemento);
            return cantidad;
        }else if (elemento == Elemento.PIEDRA){
            cantidadAire -= cantidad;
            cantidadPiedra += cantidad;
            System.out.println("Se ha introducido " + cantidad + " de " + elemento);
            return cantidad;
        } else {
            System.out.println("Se ha introducido " + cantidad + " de " + elemento);
            return cantidad;
        }
    }

    public String cantidades(){
        return  "Cantidad Aire: " + cantidadAire + "\nCantidad Piedra: " + cantidadPiedra + "\nCantidad Petroleo: " +cantidadPetroleo;
    }

    public int getCantidadAire() {
        return cantidadAire;
    }

    public int getCantidadPiedra() {
        return cantidadPiedra;
    }

    public int getCantidadPetroleo() {
        return cantidadPetroleo;
    }
}
