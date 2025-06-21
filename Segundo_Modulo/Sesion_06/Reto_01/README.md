# Reto 01: Registro de productos para inventario

## 🤍 Descripción
Este proyecto amplía un sistema de inventario utilizando Spring Boot, Spring Data JPA y validaciones con Jakarta Bean Validation. Se agregan restricciones en la entidad Producto y consultas personalizadas en el ProductoRepository para simular escenarios reales de un backend, como búsqueda por nombre, rangos de precios y filtrado por prefijos. Los resultados se prueban y muestran en consola mediante un CommandLineRunner.

## 🤍 Objetivos
- Reforzar la creación de entidades con JPA, usando el mismo proyecto del ejemplo anterior para agregar validaciones y consultas específicas en la clase Producto, simulando un sistema de inventario más realista.

## 🤍 Tecnologias usadas
- Java 24
- Spring Boot 3.x
- Project Reactor (Reactor Core)
- Maven

## 🤍 Salida obtenida
- Permite al usuario ingresar productos por teclado
```bash
java InventarioApplication

Deseas agregar un nuevo producto? (Si/No): si

°°°°°°°° Nuevo producto °°°°°°°°
Nombre: Audífonos Bluetooth
Descripción: Cancelación de ruido, batería 20 hrs
Precio: 950
Producto agregado con éxito

¿Deseas agregar otro producto? (SI/NO): si
°°°°°°°° Nuevo producto °°°°°°°°
Nombre: Memoria USB 128GB
Descripción: Velocidad alta, resistente al agua
Precio: 120.50
Producto agregado con éxito
```
- Despues despliega un menu para el usuario
```bash
¿Deseas agregar otro producto? (SI/NO): no

°°°°°°°°°° MENU °°°°°°°°°°
¿Que quieres hacer??
1.- Mostar lista de productos
2.- Buscar productos especifico
3.- Filtrar por precio mayor que
4.- Buscar producto (Ignore si son Mayusculas o minusculas)
5.- Filtrar un rango de precio
6.- Buscar por palabra inicial
7.- Salir
```
- Caso 1
```bash
1
📂 Productos disponibles:
Producto[id=1, nombre='Laptop', precio=1200.00]
Producto[id=2, nombre='Teclado mecánico', precio=800.00]
Producto[id=3, nombre='Mouse gamer', precio=600.00]
Producto[id=4, nombre='Audífonos Bluetooth', precio=950.00]
Producto[id=5, nombre='Tablet 10”', precio=2500.80]
Producto[id=6, nombre='Escritorio Gamer', precio=3500.00]
Producto[id=7, nombre='Memoria USB 128GB', precio=120.50]
```
- Caso 2
```bash
2
Ingresa la palabra que quieres buscar: 
Laptop

🔍 Productos que contienen 'Laptop' :
Producto[id=1, nombre='Laptop', precio=1200.00]
```
- Caso 3
```bash
3
Ingresa el precio: 
500

🔍 Productos cuyo precio es mayor que $500.0 :
Producto[id=1, nombre='Laptop', precio=1200.00]
Producto[id=2, nombre='Teclado mecánico', precio=800.00]
Producto[id=3, nombre='Mouse gamer', precio=600.00]
Producto[id=4, nombre='Audífonos Bluetooth', precio=950.00]
Producto[id=5, nombre='Tablet 10”', precio=2500.80]
Producto[id=6, nombre='Escritorio Gamer', precio=3500.00]
```
- Caso 4
```bash
4
Ingrese la palabra que quieres buscar: 
TECLADO

🔍 Productos que contienen 'TECLADO' :
Producto[id=2, nombre='Teclado mecánico', precio=800.00]
```
- Caso 5
```bash
5
Ingresa el precio mínimo: 
400
Ingresa el precio maxímo: 
1000

🔍 Productos que se encuentran en el rango $400.0 hasta $1000.0 :
Producto[id=2, nombre='Teclado mecánico', precio=800.00]
Producto[id=3, nombre='Mouse gamer', precio=600.00]
Producto[id=4, nombre='Audífonos Bluetooth', precio=950.00]
```
- Caso 6
```bash
6
Ingrese la palabra que quieres buscar: 
M

🔍 Productos que comienzan por 'M' :
Producto[id=3, nombre='Mouse gamer', precio=600.00]
Producto[id=7, nombre='Memoria USB 128GB', precio=120.50]
```
- Caso 7
```bash
°°°°°°°°°° MENU °°°°°°°°°°
¿Que quieres hacer??
1.- Mostar lista de productos
2.- Buscar productos especifico
3.- Filtrar por precio mayor que
4.- Buscar producto (Ignore si son Mayusculas o minusculas)
5.- Filtrar un rango de precio
6.- Buscar por palabra inicial
7.- Salir
7
👋 ¡Hasta luego!

```
## 🤍 Ejecución del proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/KatyE0/Curso_Java_Intermedio/Segundo_Modulo/Sesion_06/Reto_01
cd Reto_01
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
Reto_01/inventario/src/main/java/com/bedu/
└──  inventario/  
        ├──  InventarioApplication.java   # Clase principal con la lógica de ejecución
        ├──  Producto.java
        └──  ProductoRepository.java
```

#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante