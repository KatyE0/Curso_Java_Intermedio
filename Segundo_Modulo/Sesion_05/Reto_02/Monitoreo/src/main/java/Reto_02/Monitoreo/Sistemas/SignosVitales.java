package Reto_02.Monitoreo.Sistemas;

import Reto_02.Monitoreo.MonitoreoApplication;
import reactor.core.publisher.Flux;
import java.util.Random;
import java.time.Duration;



//Calse para simular los signos vitales de un paciente
public class SignosVitales {
    private final int pacienteId; //Numero del paciente
    private final String pacienteNombre;
    private final int frecunciaCardiaca; // FC
    private final int presionSistolica; // PA
    private final int presionDiastolica; // PA
    private final int oxigenacion; // SpO2
    private final Random random = new Random(); //Usado para la simulacion de datos aletarios


    public SignosVitales(int pacienteId, String pacienteNombre, int frecunciaCardiaca, int presionSistolica, int presionDiastolica, int oxigenacion){
        this.pacienteId = pacienteId;
        this.pacienteNombre = pacienteNombre;
        this.frecunciaCardiaca = frecunciaCardiaca;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
        this.oxigenacion = oxigenacion;
    }

    //Metodo para simular los signos vitales de un paciente
    public Flux<SignosVitales> flujoSignosVitales() {
        return Flux.interval(Duration.ofMillis(300))
                .onBackpressureBuffer(10)
                .map(i -> new SignosVitales(
                        pacienteId,
                        pacienteNombre,
                        40 + random.nextInt(100),  // Frecuencia Cardiaca: 40-140
                        80 + random.nextInt(80),   // Presión Sistólica: 80-160
                        50 + random.nextInt(50),   // Presión Diastólica: 50-100
                        85 + random.nextInt(15)    // Oxigenación SpO2: 85-100
                ))
                .take(10); // Limitar cantidad de eventos por paciente
    }

    //Metodo para filtrar resultados criticos
    public boolean esCritico() {
        return frecunciaCardiaca < 50 || frecunciaCardiaca > 120
                || presionSistolica < 90 || presionSistolica > 140
                || presionDiastolica < 60 || presionDiastolica > 90
                || oxigenacion < 90;
    }

    //Metodo para lanzar alertas si es critico
    public String mensajeAlerta() {
        StringBuilder alerta = new StringBuilder("⚠️ Paciente " + pacienteId + " - Nombre: " + pacienteNombre);

        // Si la frecuencia cardiaca esta en el rango => < 50 || > 120 bpm, lanza un mensaje
        if (frecunciaCardiaca < 50 || frecunciaCardiaca > 120) {
            alerta.append("\nFC crítica: ").append(frecunciaCardiaca).append(" bpm | ");
        }
        // Si la frecuencia cardiaca esta en el rango => 	< 90/60 mmHg o > 140/90 mmHg, lanza un mensaje
        if (presionSistolica < 90 || presionSistolica > 140 || presionDiastolica < 60 || presionDiastolica > 90) {
            alerta.append("\nPA crítica: ").append(presionSistolica).append("/").append(presionDiastolica).append(" mmHg | ");
        }
        // Si la frecuencia cardiaca esta en el rango => < 90%, lanza un mensaje
        if (oxigenacion < 90) {
            alerta.append("\nSpO2 baja: ").append(oxigenacion).append("% | ");
        }

        return alerta.toString().replaceAll("\\|\\s*$", ""); // elimina último "|"
    }


}
