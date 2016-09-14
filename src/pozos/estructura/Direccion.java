package pozos.estructura;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by ioangiurgiu on 15/02/16.
 */
public enum Direccion {
    IZQUIERDA, DERECHA, ARRIBA, ABAJO;
    
    public static Direccion aleatorio() {
        List<Direccion> values = Collections.unmodifiableList(Arrays.asList(values()));
        Random random = new Random();
        return values.get(random.nextInt(values.size()));
    }
}
