
public class Main {
    public static void main(String[] args) {
        // Inicializa la clase Movilidad app

        MovilidadApp app = new MovilidadApp();

        // Ejecutamos y esperamos a que termine la combinación asincrónica
        app.combinacion().join();  // ← join espera a que se termine el flujo asincrónico

    }
}