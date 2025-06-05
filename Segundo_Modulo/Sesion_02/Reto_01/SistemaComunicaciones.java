import java.util.concurrent.Callable;
// Uso Callable para definir tareas que retornan un valor y pueden lanzar excepciones.

// Aqui se simula un sistema de comunicacion
public class SistemaComunicaciones implements Callable<String> {
    // Sobrescribe el metodo call() que será ejecutado por un hilo.
    @Override
    public String call() throws Exception {
        // Establece contacto con la estación terrestre
        Thread.sleep(1500); // Simula una tarea que tarda 1.5 segundos en completarse.
        return "Comunicaciones: enlace con estación terrestre establecido.";
    }
}
