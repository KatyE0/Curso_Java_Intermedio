//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Esto es donde se simulan todos los pedidos
        List<Pedido> pedidos = List.of(
                new Pedido  ("Ana", "Domicilio", "+52558985551"),
                new Pedido  ("Luis", "Local", null),
                new Pedido  ("Marta", "domicilio", "558162555"),
                new Pedido  ("Pedro", "DOMICILIO", null)
        );

        // Pedidos con entrga a domicilio
        System.out.println("\nEntrega a domicilio: ");
        //Sream para filtrar por domicilios
        pedidos.stream()
                // Usp equals(), para filtrar el contenido
                // Uso toUpperCase() para convertir a mayusculas y poder hacer buena comparacion
                .filter(p -> "DOMICILIO".equals(p.getTipoEntrega().toUpperCase()))
                .forEach(System.out::println);

        //Recuperar e imprimir los telefonos disponibles
        System.out.println("\nNumeros confirmados: ");
        pedidos.stream()
                .map(Pedido::getTelefono)//Llama al metodo que trasforma a Optional
                .filter(Optional::isPresent) // El filtro descarta los datos null
                .map(Optional::get)
                .map(tel -> "Confirmación enviada al número: " + tel) //Usa el formato para imprimir
                .forEach(System.out::println); // Imprime aplicando el formato

    }
}