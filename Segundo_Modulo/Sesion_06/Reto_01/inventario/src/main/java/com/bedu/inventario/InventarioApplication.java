package com.bedu.inventario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ProductoRepository repository) {
		return (args) -> {
			// Guardar algunos productos
			repository.save(new Producto("Laptop", "Portátil de 16 pulgadas", 1200.00));
			repository.save(new Producto("Teclado mecánico", "Switch azul", 800.00));
			repository.save(new Producto("Mouse gamer", "Alta precisión", 600.00));
			//repository.save(new Producto("","",0));

			// Código para que el usuario pueda agregar productos :)
			Scanner scanner = new Scanner(System.in);
			String continuar = "si";

			System.out.println("\nDeseas agregar un nuevo producto? (Si/No)");
			String opcion = scanner.nextLine().toLowerCase();
			do {
				if (opcion.equals("si")) {
					//Agrega un  nuevo producto
					System.out.println("°°°°°°°° Nuevo producto °°°°°°°°");
					System.out.print("Nombre: ");
					String nombre = scanner.nextLine();

					System.out.print("Descripción: ");
					String descripcion = scanner.nextLine();

					System.out.print("Precio: ");
					double precio = 1;
					try {
						precio = Double.parseDouble(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("❌ Precio inválido, se establecerá en 1");
					}
					try {
						repository.save(new Producto(nombre, descripcion, precio));
						System.out.println("Producto agregado con éxito");
					} catch (Exception e) {
						System.out.println("Upps!!!, Ocurrio un error inesperado \nError: " + e);
					}

					System.out.print("¿Deseas agregar otro producto? (SI/NO): ");
					opcion = scanner.nextLine().toLowerCase();

				} else if ((opcion.equals("no"))) {
					//Aqui va a haber un menu para hacer oras operaciones :)
					System.out.println("°°°°°°°°°° MENU °°°°°°°°°°");
					System.out.println("¿Que quieres hacer??");
					System.out.println("1.- Mostar lista de productos");
					System.out.println("2.- Buscar productos especifico");
					System.out.println("3.- Filtrar por precio mayor que");
					System.out.println("4.- Buscar producto (Ignore si son Mayusculas o minusculas)");
					System.out.println("5.- Filtrar un rango de precio");
					System.out.println("6.- Buscar por palabra inicial");
					System.out.println("7.- Salir");

					int menu = scanner.nextInt();
					scanner.nextLine();
					switch (menu){
						case 1 -> {
							// Mostrar todos los productos
							System.out.println("📂 Productos disponibles:");
							repository.findAll().forEach(System.out::println);
						}
						case 2 -> {
							// Buscar por nombre parcial
							System.out.println("Ingresa la palabra que quieres buscar: ");
							String busqueda = scanner.nextLine();
							System.out.println("\n🔍 Productos que contienen '" + busqueda + "' :");
							repository.findByNombreContaining(busqueda).forEach(System.out::println);
						}
						case 3 -> {
							//Buscar por precio mayor que
							System.out.println("Ingresa el precio: ");
							double precio = scanner.nextInt();
							scanner.nextLine();
							System.out.println("\n🔍 Productos cuyo precio es mayor que $" + precio + " :");
							repository.findByPrecioGreaterThan(precio).forEach(System.out::println);
						}
						case 4 -> {
							//Buscar por producto con nombre especifico (Ignore si son Mayusculas o minusculas)
							System.out.println("Ingrese la palabra que quieres buscar: ");
							String busqueda = scanner.nextLine();
							System.out.println("\n🔍 Productos que contienen '" + busqueda + "' :");
							repository.findByNombreContainingIgnoreCase(busqueda).forEach(System.out::println);
						}
						case 5 -> {
							//Buscar por productos que se encuetren entre un rango de precios dados
							System.out.println("Ingresa el precio mínimo: ");
							double precioMin = scanner.nextInt();
							scanner.nextLine();
							System.out.println("Ingresa el precio maxímo: ");
							double precioMax = scanner.nextInt();
							scanner.nextLine();
							System.out.println("\n🔍 Productos que se encuentran en el rango $" + precioMin + " hasta $" + precioMax + " :");
							repository.findByPrecioBetween(precioMin,precioMax).forEach(System.out::println);
						}
						case 6 -> {
							//Buscar por productos empiece con algo especifico (Ignore si son Mayusculas o minusculas)
							System.out.println("Ingrese la palabra que quieres buscar: ");
							String busqueda = scanner.nextLine();
							System.out.println("\n🔍 Productos que comienzan por '" + busqueda + "' :");
							repository.findByNombreStartingWithIgnoreCase(busqueda).forEach(System.out::println);
						}
						case 7 -> {
							System.out.println("👋 ¡Hasta luego!");
							continuar = "No";
							scanner.close();
							break; // Sale del while
						}
						default -> System.out.println("Algo salio mal");
					}
					if (menu == 7) break;

				}else {
					System.out.println("Por favor ingresa una opción válida :D");
				}

			} while ((continuar.equals("si")));
		};
	}
}