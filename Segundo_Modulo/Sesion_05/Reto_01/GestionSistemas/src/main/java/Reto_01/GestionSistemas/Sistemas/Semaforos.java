package Reto_01.GestionSistemas.Sistemas;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class Semaforos {
    private final Random random = new Random();

    // Método que simula priorizacion de emergencias segun la gravedad de un accidente
    public Flux<String> semaforosCriticos() {
        int[] contadorRojos = {0}; // Usamos arreglo para modificar dentro de lambda

        // Duration.ofMillis(400) para que de un numero a 400ms
        return Flux.interval(Duration.ofMillis(400))
                // Simula el estado de los semaforos
                .map(i -> {
                    // Establece estado de los semaforos
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    // Simula el estado dando un color en aleatorio
                    return estados[random.nextInt(estados.length)];
                })
                // Es critico el semaforo es rojo 3 veces seguidas
                .filter(estado -> {
                    if (estado.equals("Rojo")) {
                        contadorRojos[0]++;
                        if (contadorRojos[0] >= 3) {
                            contadorRojos[0] = 0;
                            return true;
                        }
                    } else {
                        contadorRojos[0] = 0;
                    }
                    return false;
                    //})
                })
                //Si el estado es critico, imprime un mensaje
                .doOnNext(estado -> System.out.println("\uD83D\uDEA6 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte"))
                .onBackpressureBuffer(5);
    }


}
