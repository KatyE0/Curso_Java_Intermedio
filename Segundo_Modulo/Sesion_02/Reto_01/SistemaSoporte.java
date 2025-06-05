import java.util.concurrent.Callable;

// Aqui se simula un sistema de soporte vital
public class SistemaSoporte implements Callable<String> {
    // Sobrescribe el metodo call() que será ejecutado por un hilo.
    @Override
    public String call() throws Exception {
        // Monitorea presión, oxígeno y condiciones internas.
        Thread.sleep(3000); // Simula una tarea que tarda 3 segundos en completarse.
        return "Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}
