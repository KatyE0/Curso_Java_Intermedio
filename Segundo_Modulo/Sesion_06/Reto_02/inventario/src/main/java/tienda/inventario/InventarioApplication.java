package tienda.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tienda.inventario.models.Marca;
import tienda.inventario.models.Producto;
import tienda.inventario.repositories.MarcaRepository;
import tienda.inventario.repositories.ProductoRepository;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
		return (args) -> {
			Marca marca1 = new Marca("Apple");
			marcaRepo.save(marca1);

			Marca marca2 = new Marca(" Samsung");
			marcaRepo.save(marca2);

			productoRepo.save(new Producto("iPhone 15", "Diseño simple y elegante", 90000.00, marca1));
			productoRepo.save(new Producto("Galaxy S23", "Comodo y versatil", 140000.00, marca2));
			productoRepo.save(new Producto("iPad Pro", "Pantalla 10 pulgadas", 7800.00, marca1));
			productoRepo.save(new Producto("Smart TV", "Pantalla 32 pulgadas", 7800.00, marca2));


			System.out.println("📂 Productos registrados:");
			productoRepo.findAll().forEach(p -> System.out.println(p.getNombre() + " - " + p.getMarca().getNombre()));

			System.out.println("📚 Productos por marca:");
			marcaRepo.findAll().forEach(marca -> {
				System.out.println("🏷️ " + marca.getNombre() + ":");
				productoRepo.findAll().stream()
						.filter(p -> p.getMarca().getId().equals(marca.getId()))
						.forEach(p -> System.out.println("   - " + p.getNombre()));
			});

		};
	}


}