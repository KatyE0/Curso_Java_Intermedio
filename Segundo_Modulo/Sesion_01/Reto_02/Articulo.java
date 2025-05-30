public class Articulo<T> extends MaterialCurso {
    private T palabras;

    public Articulo(String titulo, String autor, T palabras){
        super(titulo, autor);
        this.palabras = palabras;
    }

    //Metodo sobreescrito para mostrar detalles
    @Override
    public void mostrarDetalle() {
        //Informacion para Video
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°\nTipo de material: Articulo\nTitulo:" + titulo + "\nAutor:" + autor + "\nPalabras: " + palabras + " palabras\n");
    }
}
