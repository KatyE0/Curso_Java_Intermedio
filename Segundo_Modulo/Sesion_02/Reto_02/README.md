# Reto 02: Acceso controlado a un recurso médico crítico con ReentrantLock

## 🤍 Descripción
Este proyecto modela la competencia por recursos médicos críticos en un hospital, como quirófanos o equipos especializados. Utiliza hilos y ReentrantLock en Java para simular el acceso exclusivo a un recurso compartido por parte de diferentes profesionales de la salud, garantizando sincronización y evitando conflictos de concurrencia.

## 🤍 Objetivos
- Simular una situación hospitalaria donde múltiples profesionales médicos necesitan acceder a un recurso crítico (como una sala de cirugía), aplicando sincronización con ReentrantLock para evitar condiciones de carrera y garantizar la integridad del sistema.

## 🤍 Salida esperada
```bash
java Main

°°°°° Acceso a Quirófanos °°°°° 

-👩‍⚕️ -Dra. Sánchez ha INGRESADO a Quirófano 1
-👩‍⚕️ -Dr. Escalante ha INGRESADO a Quirófano 2
-✅-Dr. Escalante ha SALIDO de Quirófano 2
-✅-Dra. Sánchez ha SALIDO de Quirófano 1
-👩‍⚕️ -Dra. Peréz ha INGRESADO a Quirófano 2
-👩‍⚕️ -Dr. Gómez ha INGRESADO a Quirófano 1
-✅-Dr. Gómez ha SALIDO de Quirófano 1
-✅-Dra. Peréz ha SALIDO de Quirófano 2

```
#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante