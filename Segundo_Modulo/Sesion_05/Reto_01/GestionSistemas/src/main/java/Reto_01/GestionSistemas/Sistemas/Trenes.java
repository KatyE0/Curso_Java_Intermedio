package Reto_01.GestionSistemas.Sistemas;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class Trenes {
    private final Random random = new Random();

    // Método que simula la frecuencia y detecta retrasos en los trenes.
    public Flux<String> trenesRetraso() {
        // Duration.ofMillis(700) para que de un numero a 700ms
        return Flux.interval(Duration.ofMillis(700))
                // Simula el retraso entre 0 - 10 min
                .map(i -> random.nextInt(10))
                // Es critico si retraso > 5
                .filter(retraso -> retraso > 5)
                //Si el estado es critico, imprime un mensaje
                .map(retraso -> "\uD83D\uDE9D Tren maglev con retraso crítico: " + retraso + " minutos.")
                .doOnNext(System.out::println) // Imprime el mensaje
                .onBackpressureBuffer(5);
    }

}
