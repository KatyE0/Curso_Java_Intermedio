import java.util.List;

public class Sucursal {
    private final String nombre;
    // Este atributo es de tipo List para poder simular como se guardan todos los datos
    private final List<Encuesta> ecuestas;

    public Sucursal(String nombre, List<Encuesta> encuestas){
        this.nombre=nombre;
        this.ecuestas=encuestas;
    }

    // Getters
    public List<Encuesta> getEcuestas() {
        return ecuestas;
    }

    public String getNombre() {
        return nombre;
    }
}
