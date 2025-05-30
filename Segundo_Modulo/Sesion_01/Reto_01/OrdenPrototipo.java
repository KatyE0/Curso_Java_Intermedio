public class OrdenPrototipo<T> extends OrdenProduccion {
    private T faseDesarrollo;  //Tipo de dato generico

    // Constrcutor para las ordenes de prototipos
    public OrdenPrototipo(String codigo, int cantidad, T faseDesarrollo){ //Pide 3 datos (codigo, cantidad, fase de desarrollo)
        super(codigo,cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    //Metodo sobreescrito para mostrar info del orden personalizada
    @Override
    public void mostrarResumen(){
        //Resumen para orden Prototipo
        System.out.println("Tipo de Orden: Producto Prototipo \nFase de desarrollo: " + faseDesarrollo);
        super.mostrarResumen();
    }

}

