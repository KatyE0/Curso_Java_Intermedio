package Reto_01.GestionSistemas.Sistemas;

import reactor.core.publisher.Flux;
import java.util.Random;
import java.time.Duration;

public class Trafico {

    private final Random random = new Random();

    // Método que simula la deteccion de congestión en las principales avenidas.
    public Flux<String> flujoTrafico() {
        // Duration.ofMillis(500) para que de un numero a 500ms
        return Flux.interval(Duration.ofMillis(500))
                //Simula la congestion entre 1-100%
                .map(i -> random.nextInt(100))
                // Es critico si la congestion > 70
                .filter(congestion -> congestion > 70)
                //Si el estado es critico, imprime un mensaje
                .map(congestion -> "🚗 Alerta: Congestión del " + congestion + "% en Avenida Solar")
                .doOnNext(System.out::println) // Imprime el mensaje
                // Simula backpressure, almacenando max 5 datos si hay sobrecarga :)
                .onBackpressureBuffer(5);
    }
}
