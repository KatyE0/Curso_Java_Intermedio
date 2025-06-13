// Clase para juntar la encuesta con sucursal
public class Seguimiento {
    private final Encuesta encuesta;
    private final String sucursal;

    public Seguimiento(Encuesta encuesta, String sucursal) {
        this.encuesta=encuesta;
        this.sucursal = sucursal;
    }

    //Getters
    public Encuesta getEncuesta() {
        return encuesta;
    }
    public String getSucursal() {
        return sucursal;
    }
}

