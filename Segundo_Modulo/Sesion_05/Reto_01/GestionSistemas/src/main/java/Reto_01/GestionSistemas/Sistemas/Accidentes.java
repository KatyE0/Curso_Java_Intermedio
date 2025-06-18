package Reto_01.GestionSistemas.Sistemas;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class Accidentes {
    private final Random random = new Random();

    // Método que simula priorizacion de emergencias segun la gravedad de un accidente
    public Flux<String> prioridadAccidentes() {
        // Duration.ofMillis(800) para que de un numero a 800ms
        return Flux.interval(Duration.ofMillis(800))
                // Simula los accidentes viales
                .map(i -> {
                    // Establece las prioridades de llos accidentes
                    String[] prioridad = {"Baja", "Media", "Alta"};
                    // Simula un accidente dando alguna proridad en aleatorio
                    return prioridad[random.nextInt(prioridad.length)];
                })
                // Es critico si la prioridad es Alta
                .filter( critico -> critico.equals("Alta") )
                //Si el estado es critico, imprime un mensaje
                .doOnNext(critico -> System.out.println("\uD83D\uDE91 Emergencia vial: Accidente con prioridad: " + critico))
                .onBackpressureBuffer(5);
    }

}
