# Reto 02: Gestión asincrónica de vuelos en un aeropuerto internacional

## 🤍 Descripción
Este proyecto simula el sistema de control de aterrizajes de un aeropuerto internacional utilizando programación asíncrona en Java con CompletableFuture. Se realizan múltiples verificaciones en paralelo (pista, clima, tráfico aéreo y personal en tierra) y se combinan sus resultados para autorizar o denegar el aterrizaje. Se incluye manejo de errores con exceptionally y una versión con fallas aleatorias para representar condiciones reales más complejas.

## 🤍 Objetivos
 - Simular un flujo asincrónico y no bloqueante para la gestión de aterrizajes en un aeropuerto internacional, integrando varias consultas en paralelo con CompletableFuture, combinando sus resultados y manejando errores potenciales.

## 🤍 Salida esperada
 - En caso de que las condiciones sean VERDADERAS
```bash
java Main

🛫 Verificando condiciones para aterrizaje...

🛣️ Verificando condiciones de la pista...
🌦️ Verificando condiciones del clima...
🚦 Verificando tráfico aéreo...
👷‍♂️ Verificando disponibilidad de personal en tierra...

🌦️ Clima favorable: true
🛣️ Pista disponible: true
🚦 Tráfico aéreo despejado: true
👷‍♂️ Personal disponible: true

🛬 Aterrizaje autorizado: todas las condiciones óptimas.
```
- En caso de que algunas condiciones sean FALSAS
```bash
java Main.java

🛫 Verificando condiciones para aterrizaje...

🛣️ Verificando condiciones de la pista...
🌦️ Verificando condiciones del clima...
🚦 Verificando tráfico aéreo...
👷‍♂️ Verificando disponibilidad de personal en tierra...

🌦️ Clima favorable: true
🚦 Tráfico aéreo despejado: true
🛣️ Pista disponible: false
👷‍♂️ Personal disponible: true

🚫 Aterrizaje denegado: condiciones no óptimas.
```


#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante