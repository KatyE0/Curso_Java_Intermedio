import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        AeropuertoControl control = new AeropuertoControl();
        AeropuertoControl.autorizacion().join();


    }
}

