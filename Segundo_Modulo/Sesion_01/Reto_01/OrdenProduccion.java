import java.util.List;

public abstract class OrdenProduccion {

    //Atributos
    protected String codigo;
    protected int cantidad;

    //Constructor
    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    //Metodos
    //  Metodo para para imprimir la info predeterminada para todas las ordenes
    public void mostrarResumen(){
        System.out.println("Codigo: " + codigo + "\nCantidad: " + cantidad + "\n°°°°°°°°°°°°°°°°°°°°°\n");
    }

    // Metodo Generico que imprime todos los tipos de productos
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) { //El metodo generico se declara con "<?"
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    //Metodo generico que agrega un costo adidional a ls ordenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("|||||||||||||||||||||||||\n\nACTUALIZACION DE PRECIOS\n");
        for (Object obj : lista) { // Uso Object ya que es la clase madre de todas en Java, por eso se puede usar para cualquier tipo de objeto
            OrdenPersonalizada orden = (OrdenPersonalizada) obj; //Hace la conversion de generico a un tipo especifico (Cast)
            orden.agregarCosto(costoAdicional); // Esto agrega el costo adicional a la info del producto
            System.out.println("PRECIO ACTUALIZADO :D");
            orden.mostrarResumen();
        }
    }

}
