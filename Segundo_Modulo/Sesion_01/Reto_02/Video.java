//Uso un dato generico N que estiende de Number
public class Video<N extends Number> extends MaterialCurso{
    private  N minutos;

    public N getMinutos() {
        return minutos;
    }

    //Constructor
    public Video (String titulo, String autor, N minutos){
        super(titulo, autor);
        this.minutos = minutos;
    }

    //Metodo sobreescrito para mostrar detalles
    @Override
    public void mostrarDetalle() {
        //Informacion para Video
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°\nTipo de material: Video\nTitulo:" + titulo + "\nAutor:" + autor + "\nDuración: " + minutos + " minutos\n");
    }
}
