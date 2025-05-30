import java.util.List;
// Produccion para el producto estandar
public class OrdenMasa extends OrdenProduccion{

    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);  // llama al constructor de OrdenProduccion
    }

    //Metodo para mostrar la info de un producto estandar
    @Override
    public void mostrarResumen() {
        System.out.println("Tipo de Orden: Producto estandar");
        super.mostrarResumen(); //Uso esto para imprimir la info personalizada

    }
}
