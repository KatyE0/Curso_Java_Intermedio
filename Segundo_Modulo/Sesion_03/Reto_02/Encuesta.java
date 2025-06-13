import java.util.Optional;

public class Encuesta{
    private final String paciente;
    private final String comentario;
    private final int calificacion;

    public Encuesta(String paciente, String comentario, int calificacion){
        this.paciente=paciente;
        this.comentario=comentario;
        this.calificacion=calificacion;
    }

    // Getters de la clase
    public int getCalificacion() {
        return calificacion;
    }

    public String getPaciente() {
        return paciente;
    }

    //Este get es Optional para manejar valores null
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
