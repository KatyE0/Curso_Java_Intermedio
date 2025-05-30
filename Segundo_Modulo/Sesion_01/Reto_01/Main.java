import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creacion de listas para las ordenes
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();

        // Órdenes de producción en masa (productos estándar).
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        // Órdenes personalizadas (adaptadas a cliente).
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        // Prototipos (productos en prueba).
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));


        //Imprimir información :D
        //   Usa el metodo generico mostrarOrdenes para imprimir
        OrdenProduccion.mostrarOrdenes(ordenesMasa);
        OrdenProduccion.mostrarOrdenes(ordenesPersonalizadas);
        OrdenProduccion.mostrarOrdenes(ordenesPrototipo);

        //Imprimir ordenes personalizadas con precio actualizado
        OrdenProduccion.procesarPersonalizadas(ordenesPersonalizadas, 200);

    }
}