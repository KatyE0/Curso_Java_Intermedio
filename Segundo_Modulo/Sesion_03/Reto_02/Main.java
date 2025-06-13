//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Lista para simular los datos de las encuestas y las sucursales donde se tomaron
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Juan", null, 5),
                        new Encuesta("María", "El tiempo de espera fue largo", 3)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Carlos", null, 1),
                        new Encuesta("Luisa", "Muy buena atención", 5)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Esteban", "La atención fue buena, pero la limpieza puede mejorar ", 4),
                        new Encuesta("Diana", "La atención fue buena, pero la limpieza puede mejorar", 3)
                )),
                new Sucursal("Este", List.of(
                        new Encuesta("Andrés", "Gran atencion ", 4),
                        new Encuesta("Sofía", "Pesimo servicio", 2)
                ))
        );

        //Procesamiento de los comentarios
        sucursales.stream()
                //Usa FlatMao para transformar cada sucursal en un Stream de encuestas, y luego junta todos esos streams en uno solo.
                .flatMap(sucursal -> sucursal.getEcuestas().stream()
                        //Filtra las calificaciones que sean <=3
                        .filter(encuesta -> encuesta.getCalificacion()<=3)
                        //Combinar las encuestas con la sucursal
                        .map(encuesta -> new Seguimiento(encuesta,sucursal.getNombre()) )
                )
                //Filtra los comentarios que sean null y los descarta
                .filter(p -> p.getEncuesta().getComentario().isPresent() )
                //Da el formato para imprimir lo que se necesita
                .map(p ->
                        //Usa deferentes metodos get para acceder a la info que se necesita :)
                                "\n°°°°° Sucursal " + p.getSucursal() +
                                        ": Seguimiento a paciente con comentario °°°°°° \nNombre: " +
                                        p.getEncuesta().getPaciente() + "\nComentario: " +
                                        p.getEncuesta().getComentario().get()
                        )
                .forEach(System.out::println); //Imprime :D

    }
}