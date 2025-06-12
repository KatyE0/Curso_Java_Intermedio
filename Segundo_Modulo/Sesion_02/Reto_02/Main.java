//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {



        RecursoMedico sala1 = new RecursoMedico("Quirófano 1");
        RecursoMedico sala2 = new RecursoMedico("Quirófano 2");


        //Creacion de pool de hilos con ExecutorService
        ExecutorService ejecutor = Executors.newFixedThreadPool(4);

        // Uso lambdas que usen Runnable para ingresar cada medico o enfermero
        Runnable tarea1 = () -> {
            // Se asigna el hilo con el nombre del profesional
            Thread.currentThread().setName("Dra. Sánchez");
            // Se asigna el hilo con el nombre del profesional
            sala1.usar(Thread.currentThread().getName());
        };

        Runnable tarea2 = () -> {
            // Se asigna el hilo con el nombre del profesional
            Thread.currentThread().setName("Dr. Gómez");
            // Se asigna el hilo con el nombre del profesional
            sala1.usar(Thread.currentThread().getName());
        };

        Runnable tarea3 = () -> {
            // Se asigna el hilo con el nombre del profesional
            Thread.currentThread().setName("Dr. Escalante");
            // Se asigna el hilo con el nombre del profesional
            sala2.usar(Thread.currentThread().getName());
        };

        Runnable tarea4 = () -> {
            // Se asigna el hilo con el nombre del profesional
            Thread.currentThread().setName("Dra. Peréz");
            // Se asigna el hilo con el nombre del profesional
            sala2.usar(Thread.currentThread().getName());
        };



        // Uso Executor Service para ejecutar e imprimir
        System.out.println("°°°°° Acceso a Quirófanos °°°°° ");
        // Enviar tareas al ejecutor
        ejecutor.execute(tarea1);
        ejecutor.execute(tarea2);
        ejecutor.execute(tarea3);
        ejecutor.execute(tarea4);

        // Apagar el ejecutor después de terminar
        ejecutor.shutdown();


    }
}