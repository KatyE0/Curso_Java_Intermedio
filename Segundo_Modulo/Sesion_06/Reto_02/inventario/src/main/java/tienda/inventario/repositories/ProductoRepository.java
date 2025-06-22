package tienda.inventario.repositories;

import tienda.inventario.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
