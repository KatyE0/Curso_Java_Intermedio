package com.bedu.inventario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Esta interfaz extiende JpaRepository para gestionar operaciones CRUD sobre la entidad Producto
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Método personalizado que busca productos cuyo nombre contenga un texto específico (no sensible a mayúsculas)
    List<Producto> findByNombreContaining(String nombre);

    // Método para buscar un precio mayor que a un numero dado
    List<Producto> findByPrecioGreaterThan(double precio);

    //Método para buscar un producto cuyo nombre contenga un texto específico (Ignore si son Mayusculas o minusculas)
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    //Método que busca productos que se encuentren entre un rango de precios dados
    List<Producto> findByPrecioBetween(double min, double max);

    //Meétodo que busca productos empiece con algo especifico (Ignore si son Mayusculas o minusculas)
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);

}