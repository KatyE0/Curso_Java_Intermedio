import java.util.concurrent.*;

public class MovilidadApp {

    // Simulacion de Calculo de la ruta
    public static CompletableFuture<String> calcularRuta() {
      return CompletableFuture.supplyAsync(()-> {
          //Simula con un tiempo de 10 segunados
          try {
              System.out.println("Calculando ruta optima...");
              Thread.sleep(10000); // Simula la latencia de la tarea
              System.out.println("RUTA CALCULADA");
          } catch (InterruptedException e) {
              e.printStackTrace();
              System.out.println("Ocurrió un error inesperado \nError: " + e);
          }
          return "Centro -> Norte";
      });
    }

    // Simulacion de Estimacion de tarifa
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() ->{
            //Simula con un tiempo de 5 segunados
            double tarifa = 75.50;
            try {
                System.out.println("Calculando Tarifa...");
                Thread.sleep(5000); //Simula la latencia de la tarea
                System.out.println("TARIFA CALCULADA ");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Ocurrió un error inesperado \nError: " + e);
            }
            return tarifa;
        });

    }

    // Método para combinar operaciones
    public static CompletableFuture<Void> combinacion() {
        // Inicia el calculo de la ruta
        return calcularRuta()
                //Usa thenCombine para juntar ambos el resultado de la ruta, con el de la tarifa
                .thenCombine(estimarTarifa(), (ruta, tarifa) ->
                        // Si puede acceder a ambos resultados, le da formato al mensaje
                        "Ruta: " + ruta + " | Tarifa estimada: $" + String.format("%.2f", tarifa)
                )
                // Si hubiera un error lo captura y lanza un formato para el error
                .exceptionally(ex -> "❌ Error en el procesamiento: " + ex.getMessage())
                //Imprime el resultado ya sea el correcto o con manejo de error
                .thenAccept(System.out::println);
    }

}
