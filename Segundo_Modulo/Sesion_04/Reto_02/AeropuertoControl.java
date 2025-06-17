import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {

    private static final Random random = new Random();

    // Método para simular espera (latencia)
    public static void espera(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Verificar Pista
    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Verificando condiciones de la pista...");
            espera(2 + random.nextInt(2));
            boolean disponible = random.nextInt(100) < 80;
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }

    // Verificar Clima
    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌦️ Verificando condiciones del clima...");
            espera(2 + random.nextInt(2));
            boolean favorable = random.nextInt(100) < 85;
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    // Verificar Tráfico Aéreo
    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Verificando tráfico aéreo...");
            espera(2 + random.nextInt(2));
            boolean libre = random.nextInt(100) < 90;
            System.out.println("🚦 Tráfico aéreo despejado: " + libre);
            return libre;
        });
    }

    // Verificar Personal en Tierra
    public static CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("👷‍♂️ Verificando disponibilidad de personal en tierra...");
            espera(2 + random.nextInt(2));
            boolean disponible = random.nextInt(100) < 95;
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        });
    }

    // Método que combina los resultados y decide si autoriza el aterrizaje
    public static CompletableFuture<Void> autorizacion() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        return CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenRun(() -> {
                    try {
                        boolean condicionesOk =
                                pista.get() && clima.get() && trafico.get() && personal.get();

                        if (condicionesOk) {
                            System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\n❌ Error al procesar las verificaciones: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n❌ Error general del sistema: " + ex.getMessage());
                    return null;
                });
    }
}
