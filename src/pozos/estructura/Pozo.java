package pozos.estructura;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by ioangiurgiu on 19/02/16.
 */
public class Pozo{
    private int ancho=0;
    private int alto=0;
    private Seccion[][] matriz;
    private int petroleoTotal;
    private int petroleoExtraido = 0;
    private int petroleoPendiente;
    private int columnaGolpeo;

    public Pozo(int ancho, int alto, int bolsasPetroleo, int rocas){
        this.ancho = ancho;
        this.alto = alto;
        matriz = new Seccion[ancho][alto];
        llenarMatriz(bolsasPetroleo, rocas);
        for(int i = 0; i<alto; i++) {
            for(int j = 0; j<ancho; j++) {
                System.out.println("i=" + i + " j=" + j + " tipo=" + matriz[i][j].getClass());
            }
        }
        /*Random rand = new Random();
        for (int i=0; i < ancho; i++){
            matriz[rand.nextInt()][rand.nextInt()] = new Seccion();
        }*/
    }


    public void llenarMatriz(int bolsaPetroleo, int rocas){
        LinkedList<Integer> elementos = new LinkedList<>();
        matriz[0][0] = new Bolsa(new Posicion(0,0));
        for(int i = 0; i<bolsaPetroleo; i++) {
            elementos.add(0);
        }
        for(int i = 0; i<rocas; i++) {
            elementos.add(1);
        }
        int remainingElements = ((ancho*alto) - (elementos.size() + 1));
        for(int i = 0; i<remainingElements; i++) {
            elementos.add(2);
        }

        for(int i = 0; i<alto; i++) {
            for(int j = 0; j<ancho; j++) {
               if(!(i == 0 && j == 0)) {
                   Random random = new Random();
                   int randomNumber = random.nextInt(elementos.size());
                   switch(elementos.get(randomNumber)){
                       case 0:
                           Bolsa bolsaP = new Bolsa(new Posicion(i,j));
                           bolsaP.introducir(Elemento.PETROLEO, bolsaP.getCantidadAire());;
                           matriz[bolsaP.getPosicion().getX()][bolsaP.getPosicion().getY()] = bolsaP;
                           elementos.remove(randomNumber);
                           break;
                       case 1:
                           Roca roca = new Roca(new Posicion(i,j));
                           matriz[roca.getPosicion().getX()][roca.getPosicion().getY()] = roca;
                           elementos.remove(randomNumber);
                           break;
                       case 2:
                           Bolsa bolsaPiedra = new Bolsa(new Posicion(i,j));
                           bolsaPiedra.introducir(Elemento.PIEDRA, bolsaPiedra.getCantidadAire());
                           matriz[bolsaPiedra.getPosicion().getX()][bolsaPiedra.getPosicion().getY()] = bolsaPiedra;
                           elementos.remove(randomNumber);
                           break;
                   }
               }
            }
        }

    }

    public int consultaPetroleo(){
        for(int i = 0; i<alto; i++) {
            for(int j = 0; j<ancho; j++) {
                if (matriz[i][j] instanceof Bolsa){
                    petroleoTotal += ((Bolsa)matriz[i][j]).getCantidadPetroleo();
                }
            }
        }
        return petroleoPendiente = petroleoTotal - petroleoExtraido;
    }

    public Class<? extends Seccion> consultaPosicion(int ancho, int alto){
        return matriz[ancho][ancho].getClass();
    }

    public void consultarSeccionesColumnas(){
        for(int i = 0; i<alto; i++) {
            for(int j = 0; j<ancho; j++) {
                List listaBolsas = new ArrayList<>();
                List listaRocas = new ArrayList<>();
                if (matriz[i][j].getClass() == Bolsa.class) {
                    listaBolsas.add(matriz[i][j]);
                }else {
                    listaRocas.add(matriz[i][j]);
                }
                for (int m = 0 ; m<listaRocas.size(); m++){
                    System.out.printf("%30s\t\t", listaRocas.get(m));
                }
                for (int l = 0; l<listaBolsas.size(); l++){
                    System.out.printf("\n%-30s\t\t", listaBolsas.get(l));
                }



            }
        }
    }

    public void extraerPetroleo(){
        if (matriz[0][0] instanceof Bolsa){
            ((Bolsa)matriz[0][0]).extraer(Elemento.PETROLEO,((Bolsa)matriz[0][0]).getCantidadPetroleo());
            petroleoExtraido -= ((Bolsa)matriz[0][0]).getCantidadPetroleo();
        }
    }

    public void extraerPiedra(){
        if (matriz[0][0] instanceof Bolsa){
            ((Bolsa)matriz[0][0]).extraer(Elemento.PIEDRA, ((Bolsa)matriz[0][0]).getCantidadPiedra());
        }
    }

    public void percutor(int columnaGolpeo){
        Random random = new Random();
        for(int i = 0; i<alto; i++) {
            if (matriz[columnaGolpeo][i] instanceof Roca){
                Roca roca = (Roca)matriz[columnaGolpeo][i];
                roca.golpear();
                System.out.println(roca.estadoRoca());
                break;
            }
        }
    }

    public void bombear(int ancho, int alto){
        ((Bolsa)matriz[alto][ancho]).getCantidadAire();
    }
}

