import java.util.concurrent.Callable;

// Aqui se simula un sistema de control termico
public class SistemaTermico implements Callable<String> {
    // Sobrescribe el metodo call() que será ejecutado por un hilo.
    @Override
    public String call() throws Exception {
        //Supervisa temperaturas internas y externas.
        Thread.sleep(5500); // Simula una tarea que tarda 5.5 segundos en completarse.
        return "Control térmico: temperatura estable (22°C).";
    }
}
