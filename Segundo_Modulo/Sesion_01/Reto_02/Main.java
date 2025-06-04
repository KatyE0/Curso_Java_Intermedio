import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creacion de listas para cada tipo de material
        List<Video> videos = new ArrayList<>();
        List<Articulo> articulos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        // Agrego los materiales
        videos.add(new Video("Introducción a Java", "Mario", 20));
        videos.add(new Video("POO en Java", "Danna", 30.5));

        articulos.add(new Articulo("Historia de Java", "Eva",1200));
        articulos.add(new Articulo("Tipos de datos", "Luis","ochocientos"));

        ejercicios.add(new Ejercicio("Variables y tipos", "Mario", false));
        ejercicios.add(new Ejercicio("Condicionales", "Kary", true));

        //Imprimiendo :3
        MaterialCurso.mostrarMateriales(videos);
        MaterialCurso.mostrarMateriales(articulos);
        MaterialCurso.mostrarMateriales(ejercicios);

        //Llama al metodo que contabiliza la duracion de los videos
        MaterialCurso.contarDuracionVideos(videos);

        //Llama al metodo que marca como revisado los ejercicios
        MaterialCurso.marcarEjerciciosRevisados(ejercicios);
        
    }
}