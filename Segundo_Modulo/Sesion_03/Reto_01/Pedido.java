import java.util.Optional;

public class Pedido {
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    // Metodo get que devuelve Optional para evitar NullPointerException
    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public String getCliente() {
        return cliente;
    }

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    //Metodo to String para imprimir con un formato especifico
    @Override
    public String toString() {
        return "Cliente: " + cliente + " | Entrega: " + tipoEntrega + " | Telefono: " + telefono ;
    }


}