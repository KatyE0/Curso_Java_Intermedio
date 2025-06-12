import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    //Este atributo representa el recurso (ej. Sala de ciruguia)
    private String nombre;

    // Declara el uso de ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    //Constrcutor
    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    //Metodo que simulara el uso de un recurso
    public void usar(String profesional){

        //Aqui es donde va una "llave" para que solo un hilo acceda a esto
        lock.lock();

        //Simulación del tiempo de uso del recurso
        try {
            System.out.println("-\uD83D\uDC69\u200D⚕\uFE0F -" + profesional + " ha INGRESADO a " + nombre );
            Thread.sleep(2000); // Simula la espera de 2s
            System.out.println("-✅-" + profesional + " ha SALIDO de " + nombre );
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // capturar y restaurar el estado de interrupción del hilo interrumpido
            System.out.println("La tarea fue interrumpida :(");
        } catch (Exception e) {
            System.out.println("Upss!!!......Ocurrió un error :(\nERROR: " + e);
        }finally {
            lock.unlock(); // Libera la llave
        }

    }
}