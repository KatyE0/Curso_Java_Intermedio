import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Crea un pool de hilos (thread pool) con 4 para ejecutarlos simultaneamente
        ExecutorService executor = Executors.newFixedThreadPool(4);

        //Inicia cada uno de los sistemitas
        Future<String> navegacion = executor.submit(new SistemaNavegacion()); // Se usa Future para obtener el resultado luego
        Future<String> comunicacion = executor.submit(new SistemaComunicaciones());
        Future<String> soporte = executor.submit(new SistemaSoporte());
        Future<String> termico = executor.submit(new SistemaTermico());

        try {
            // Espera y obtiene el resultado de cada sistema
            System.out.println("Simulación de misión espacial iniciada...\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
            System.out.println(comunicacion.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(navegacion.get());
            System.out.println("Todos los sistemas reportan estado operativo :D");

        } catch (InterruptedException e) {
            // Excepcion por si el hilo es interrumpido
            System.out.println("La tarea fue interrumpida :(");
        } catch (ExecutionException e) {
            // Por si ocurre una exepcion en lo que se ejecuta la tarea
            System.out.println("Upss!!!......Ocurrió un error :(\nERROR: " + e.getCause());
        }
        // Cierra el executor cuando ya no se necesitan más tareas.
        executor.shutdown();
    }
}