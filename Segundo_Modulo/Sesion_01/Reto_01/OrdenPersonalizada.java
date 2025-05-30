// Clase que usa genericos y que es subclase de OrdenProduccion
public class OrdenPersonalizada<T> extends OrdenProduccion {
    // Datao de tipo generico (Type)
    private T cliente;

    private int costoAdicional = 0;

    public void agregarCosto(int extra) {
        this.costoAdicional += extra;
    }

    // Constrcutor para las ordenes personalizadas
    public OrdenPersonalizada(String codigo, int cantidad, T cliente) { //Pide 3 datos (codigo, cantidad, cliente)
        super(codigo, cantidad);  // llama los datos en el constructor de OrdenProduccion
        this.cliente =cliente;
    }

    //Metodo sobreescrito para mostrar info del orden personalizada
    @Override
    public void mostrarResumen() {
        //imprimo los datos unicos de este producto
        System.out.println("Tipo de Orden: Producto Personalizada \nCliente: " + cliente + "\nCosto Adicional: $" + costoAdicional);
        super.mostrarResumen(); // Esto imprime la estuctura predeterminada

    }




}
