# Reto 02: Productos por marca en una tienda en línea

## 🤍 Descripción
Este proyecto extiende el modelo de inventario integrando relaciones entre entidades con JPA. Se crea una entidad Marca relacionada con Producto mediante una relación @ManyToOne, representando un catálogo típico de una tienda en línea donde múltiples productos pertenecen a una misma marca. A través de consultas y filtrado en consola, se muestran los productos agrupados por marca, reforzando el uso de relaciones en bases de datos relacionales con Spring Boot

## 🤍 Objetivos
- Reforzar el uso de relaciones en JPA mediante una entidad nueva llamada Marca, relacionada con Producto, simulando un modelo básico de una tienda en línea. Se trabajará con relaciones @ManyToOne, ideal para representar que varios productos pertenecen a una marca.

## 🤍 Tecnologias usadas
- Java 24
- Spring Boot 3.5
- Maven
- Spring Data JPA
- Project Reactor
- Jakarta Bean Validation


## 🤍 Salida obtenida
```bash
java InventarioApplication

📂 Productos registrados:

iPhone 15 - Apple
Galaxy S23 -  Samsung
iPad Pro - Apple
Smart TV -  Samsung

📚 Productos por marca:

🏷️ Apple:
   - iPhone 15
   - iPad Pro
🏷️  Samsung:
   - Galaxy S23
   - Smart TV
   
```

## 🤍 Ejecución del proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/KatyE0/Curso_Java_Intermedio/Segundo_Modulo/Sesion_06/Reto_02
cd Reto_02
```

### 2. Ejecuta el proyecto
Desde IDE (recomendado)
Ejecuta la clase:
```bash
InventarioApplication.java
```
O desde terminal
``` bash
./mvnw spring-boot:run
```
## 🤍 Estructura del proyecto
``` bash
Reto_02/inventario/src/main/java/tienda/
└──  inventario/ 
        ├──  InventarioApplication.java  # Clase principal con la lógica de ejecución
        ├──  repositories/
        │       ├── MarcaRepository.java
        │       └── ProductoRepository.java
        └──  models/
               ├── Marca.java
               └── Producto.java
```

#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante
