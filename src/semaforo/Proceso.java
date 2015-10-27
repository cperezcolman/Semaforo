
package semaforo;

/**
 * Clase que representa un proceso que se ejecuta por una cantidad de segundos
 * mediante un hilo.
 * @author Carlos Perez
 */
public class Proceso implements Runnable{
    
    /**Semaforo para controlar la cantidad de hilos ejecutados*/
    private final Semaforo semaforo;
    
    /**Duracion en segundos del proceso*/
    private final int duracion;
    
    /**ID del proceso*/
    private final int id;
    
    /**
     * Constructor de la clase en donde se inicializa la duracion del proceso
     * y su identificador
     * @param semaforo
     * @param duracion duracion del proceso en unidad de segundos.
     * @param id identificador del proceso
     */
    public Proceso(Semaforo semaforo, int duracion, int id){
        this.semaforo = semaforo;
        this.duracion = duracion;
        this.id = id;
    }

    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run() {
        this.semaforo.acceder();//intentar acceder al recurso
        System.out.println("Empieza proceso ID=" + id);
        int i = 0;
        //mientras dura el proceso
        while (i++<duracion) {
            try {
                Thread.sleep(1000);//pausar un segundo 
            } catch (InterruptedException ex) {
                
            }
        }
        String seg;
        
        if (duracion>1)
            seg = " segundos";
        else
            seg = " segundo";
        System.out.println("Termina proceso ID=" + id + ", duro " + duracion 
                + seg);
        this.semaforo.liberar();//libera el recurso despues de terminar el proceso
    }
    
    /**
     * Ejecutar el hijo del proceso
     */
    public void ejecutar()
    {
        new Thread(this).start();
    }

}
