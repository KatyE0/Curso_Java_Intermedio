public class Ejercicio extends MaterialCurso{
    public boolean revisado;

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    public boolean isRevisado() {
        return revisado;
    }


    public Ejercicio(String titulo, String autor, boolean revisado){
        super(titulo, autor);
        this.revisado = revisado;
    }

    //Metodo sobreescrito para mostrar detalles
    @Override
    public void mostrarDetalle() {
        //Informacion para Ejercicio
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°\nTipo de material: Ejercicio\nTitulo:" + titulo + "\nAutor:" + autor + "\nRevisado: " + revisado);
    }
}
