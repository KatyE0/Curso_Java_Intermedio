package tienda.inventario.repositories;
import tienda.inventario.models.Marca;

import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca, Long> {
}