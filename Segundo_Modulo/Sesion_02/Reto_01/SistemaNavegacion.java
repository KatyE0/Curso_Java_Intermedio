import java.util.concurrent.Callable;

// Aqui se simula un sistema de navegación
public class SistemaNavegacion implements Callable<String> {
    // Sobrescribe el metodo call() que será ejecutado por un hilo.
    @Override
    public String call() throws Exception {
        // Calcula trayectoria y correcciones orbitales.
        Thread.sleep(10000);  // Simula una tarea que tarda 10 segundo en completarse.
        return "Navegación: trayectoria corregida con éxito.";
    }
}
