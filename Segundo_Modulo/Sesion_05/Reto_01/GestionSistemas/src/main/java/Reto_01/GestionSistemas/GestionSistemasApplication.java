package Reto_01.GestionSistemas;

import Reto_01.GestionSistemas.Sistemas.*;


import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import java.time.Duration;



@SpringBootApplication
public class GestionSistemasApplication {

	@SneakyThrows
    public static void main(String[] args) {

		//Clases inicializadas
		Trafico trafico = new Trafico();
		Contaminacion contaminacion = new Contaminacion();
		Accidentes accidentes = new Accidentes();
		Trenes trenes = new Trenes();
		Semaforos semaforos = new Semaforos();

		// Cada flujo ya emite solo eventos críticos
		Flux<String> traficoFlux = trafico.flujoTrafico();
		Flux<String> contaminacionFlux = contaminacion.aireContaminacion();
		Flux<String> accidentesFlux = accidentes.prioridadAccidentes();
		Flux<String> trenesFlux = trenes.trenesRetraso();
		Flux<String> semaforosFlux = semaforos.semaforosCriticos();


		//Metodo para combinar el flujo 
		Flux.merge(traficoFlux, contaminacionFlux, accidentesFlux, trenesFlux, semaforosFlux)
				.bufferTimeout(5, Duration.ofSeconds(2)) // Agrupar eventos por ventana de tiempo
				.filter(lista -> lista.size() >= 3) // Alerta global si hay >=3 eventos críticos juntos
				.doOnNext(lista -> System.out.println("🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n"))
				.subscribe();


		// Mantener el programa corriendo (porque Flux es asincrónico)
		Thread.sleep(10000);

	}

}
