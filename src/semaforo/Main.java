
package semaforo;

import java.util.Random;

/**
 * Implementación del algoritmo Semáforo para la ejecución de procesos 
 * concurrentes.
 * @author Carlos Perez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaforo semaforo = new Semaforo(3);
        int duracion;
        
        for (int i = 1; i <= 10; i++) {
            duracion = new Random().nextInt(10)+1;//numero rando entra 1 y 10
            new Proceso(semaforo, duracion, i).ejecutar();
        }
    }
    
}
