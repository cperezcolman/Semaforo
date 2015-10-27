package semaforo;

/**
 * Clase que representa un semaforo que se utiliza en la programacion
 * concurrente, con el objetivo de restringir o permitir el acceso a recursos
 * compartidos.
 *
 * @author Carlos Perez
 */
public class Semaforo {

    /**
     * La cantidad de recursos disponibles para el semaforo
     */
    private int recursosDisponibles;

    /**
     * Constructor en donde se inicializa la cantidad de recursos disponibles
     * para el Semaforo.
     *
     * @param cantidadRecursos cantidad de recursos disponibles
     */
    public Semaforo(int cantidadRecursos) {
        recursosDisponibles = cantidadRecursos;
        System.out.println("Iniciado el semaforo con valor " + cantidadRecursos);
    }

    /**
     * Metodo sincronizado que es llamado cuando un proceso termina y deja
     * disponible un recurso aumentando su valor en 1, y desbloquea al hilo que
     * lo ha invocado con el metodo notify().
     */
    public synchronized void liberar() {
        recursosDisponibles++;//libera un recurso
        notifyAll();//avisa a todos los procesos que hay un recurso disponible
                 //y todos tratan de acceder a el como loco.
    }

    /**
     * Metodo sincronizado que verifica si hay recurso disponible para el
     * proceso que lo invoca; si esta disponible disminuye la cantidad de
     * recursos disponibles en 1, sino, el hilo se queda bloqueado con el metodo
     * wait() mientras el numero de recursos disponibles sea 0.
     */
    public synchronized void acceder() {
        while (recursosDisponibles == 0) {
            try {
                wait();//bloquear proceso
            } catch (Exception e) {

            }
        }
        recursosDisponibles--;//tomar un recurso
    }

}
