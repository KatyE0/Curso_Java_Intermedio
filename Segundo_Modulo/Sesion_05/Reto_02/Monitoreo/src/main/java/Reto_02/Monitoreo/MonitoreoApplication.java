package Reto_02.Monitoreo;

import Reto_02.Monitoreo.Sistemas.SignosVitales;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;


@SpringBootApplication
public class MonitoreoApplication {

	public static void main(String[] args) throws InterruptedException {

		// Crea una instancia por paciente con su nombre
		SignosVitales paciente1 = new SignosVitales(1, "Kari", 0, 0, 0, 0);
		SignosVitales paciente2 = new SignosVitales(2, "Diana", 0, 0, 0, 0);
		SignosVitales paciente3 = new SignosVitales(3, "Roberto", 0, 0, 0, 0);


		// Simulación para 3 pacientes
		Flux<String> flujo1 = paciente1.flujoSignosVitales()
				.filter(SignosVitales::esCritico)
				.map(SignosVitales::mensajeAlerta)
				.delayElements(Duration.ofSeconds(1));

		Flux<String> flujo2 = paciente2.flujoSignosVitales()
				.filter(SignosVitales::esCritico)
				.map(SignosVitales::mensajeAlerta)
				.delayElements(Duration.ofSeconds(1));

		Flux<String> flujo3 = paciente3.flujoSignosVitales()
				.filter(SignosVitales::esCritico)
				.map(SignosVitales::mensajeAlerta)
				.delayElements(Duration.ofSeconds(1));

		// Fusionar los 3 flujos
		Flux<String> flujoCombinado = Flux.merge(flujo1, flujo2, flujo3)
				.publish()
				.autoConnect();

		// Mostrar cada alerta individual
		flujoCombinado
				.doOnNext(System.out::println)
				.subscribe();

		// Alerta global si hay ≥3 eventos en 2 segundos
		flujoCombinado
				.window(Duration.ofSeconds(2))
				.flatMap(window -> window.collectList())
				.filter(lista -> lista.size() >= 3)
				.subscribe(lista -> {
					System.out.println("🚨 ALERTA GLOBAL: Múltiples signos vitales críticos detectados");
					lista.forEach(System.out::println);
					System.out.println("──────────────────────────────────────────\n");
				});

		// Mantener app activa por 5 segundos
		Thread.sleep(5000);

	}
}

