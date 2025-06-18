package Reto_01.GestionSistemas.Sistemas;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class Contaminacion {
    private final Random random = new Random();

    // Método que simula alertas si la contaminacion supera los límites
    public Flux<String> aireContaminacion() {
        // Duration.ofMillis(600) para que de un numero a 600ms
        return Flux.interval(Duration.ofMillis(600))
                // Simula PM2.5 entre 0 - 100
                .map(i -> random.nextInt(100))
                // Es critico si num. particulas > 50
                .filter( particulas -> particulas > 50)
                //Si el estado es critico, imprime un mensaje
                .map(particulas -> "🌫️ Alerta: Contaminación alta (PM2.5: " + particulas + " ug/m3)")
                .doOnNext(System.out::println) // Imprime el mensaje
                .onBackpressureBuffer(5);
    }
}
