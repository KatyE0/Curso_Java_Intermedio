# Reto 01: Gestión reactiva de sistemas críticos en Meridian Prime

## 🤍 Descripción
Este proyecto simula el monitoreo en tiempo real de los sistemas críticos de Meridian Prime, una ciudad inteligente inspirada en Horizon Zero Dawn. Utiliza programación reactiva en Java con Project Reactor y Flux para procesar múltiples flujos simultáneos (tráfico, contaminación, accidentes, trenes maglev y semáforos). El sistema detecta eventos críticos, simula backpressure y emite alertas globales si tres o más eventos ocurren al mismo tiempo, garantizando una respuesta no bloqueante y eficiente.

## 🤍 Objetivos
- Simular el flujo reactivo y no bloqueante para la gestión en tiempo real de los sistemas críticos de Meridian Prime (una ciudad inteligente inspirada en Horizon Zero Dawn), usando Project Reactor y Flux para procesar múltiples flujos concurrentes.

## 🤍 Tecnologias usadas
- Java 24
- Spring Boot 3.x
- Project Reactor (Reactor Core)
- Maven

## 🤍 Salida obtenida

```bash
java GestionSistemas

🌫️ Alerta: Contaminación alta (PM2.5: 72 ug/m3)
🚝 Tren maglev con retraso crítico: 7 minutos.
🌫️ Alerta: Contaminación alta (PM2.5: 82 ug/m3)
🚑 Emergencia vial: Accidente con prioridad: Alta
🚝 Tren maglev con retraso crítico: 7 minutos.
🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime

```
## 🤍 Ejecución del proyecto

### 1. Clona el repositorio

```bash
git clone https://github.com/KatyE0/Curso_Java_Intermedio/Segundo_Modulo/Sesion_05/Reto_01
cd Reto_01
```

### 2. Ejecuta el proyecto
Desde IDE (recomendado)
Ejecuta la clase:
```bash
GestionSistemasApplication.java
```
O desde terminal
``` bash
./mvnw spring-boot:run
```
## 🤍 Estructura del proyecto
``` bash
Reto_01/GestionSistemas/src/main/java/Reto_01/GestionSistemas
│
├── GestionSistemasApplication.java   # Clase principal con la lógica de ejecución
│
└──  Sistemas/          # Paquete con la logica para cada sistema
        ├──  Trafico.java
        ├──  Contaminacion.java
        ├──  Accidentes.java
        ├── Trenes.java
        └── Semaforos.java
        
```

#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante
