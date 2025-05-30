//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Creacion de listas para cada tipo de material
        List<Video> videos = new ArrayList<>();
        List<Articulo> articulos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        // Agrego los materiales
        videos.add(new Video("Video 1", "Autor_1", 20));
        videos.add(new Video("Video 2", "Autor_2", 30.5));

        articulos.add(new Articulo("Articulo_1", "Autor_1",1200));
        articulos.add(new Articulo("Articulo_2", "Autor_2","doscientas"));

        ejercicios.add(new Ejercicio("Ejercicio_1", "Autor_1", false));
        ejercicios.add(new Ejercicio("Ejercicio_2", "Autor_2", true));

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