import java.util.List;

public abstract class MaterialCurso {
    public String titulo;
    public String autor;

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }

    // Constrcutor
    public MaterialCurso(String titulo, String autor){
        this.titulo = titulo;
        this.autor = autor;
    }

    //Metodo abstracto
    public abstract void mostrarDetalle();

    //Metodos genericos
    //  Muestra el detalle de todos los materiales.
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        for (MaterialCurso material:lista){
            material.mostrarDetalle();
        }
    }

    //  Suma y muestra la duración total de los videos
    public static void contarDuracionVideos(List<? extends Video> lista){
        double totalMinutos=0.0;
        for (Video<? extends Number> contador:lista){
            totalMinutos += contador.getMinutos().doubleValue(); // Uso double.Value(), para poder usar el tipo generico y contabilizar los minutos
        }
        System.out.println("\n|||||||||||||||||||||||| \nDuración total: " + totalMinutos + " minutos");
    }

    //Actualiza el estado de los ejercicios a revisado = true y muestra un mensaje por cada uno
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        System.out.println("||||||||||||||||||||||||");
        for (Object revision:lista){ //Uso Object ya que es la clase madre de todas en Java, por eso se puede usar para cualquier tipo de objeto
            if (revision instanceof Ejercicio) { // se asegura de que el cast sea seguro
                Ejercicio ejer = (Ejercicio) revision; //Guardo el valor de revison (boolean)
                if (ejer.revisado == false){ // Evaluo si es true o false
                    //Cambio los valores false a true
                    ejer.setRevisado(true);
                    System.out.println("\nACTUALIZACION DE REVISION EXITOSA\nTipo de material: Ejercicio\nTitulo:" + ejer.getTitulo() + "\nAutor:" + ejer.getAutor() + "\nRevisado: " + ejer.isRevisado());
                }
            }

        }
    }

}
