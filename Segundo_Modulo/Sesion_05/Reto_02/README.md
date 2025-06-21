# Reto 02: Monitoreo reactivo de signos vitales en una UCI

## 🤍 Descripción
Este proyecto simula un sistema de monitoreo en tiempo real para pacientes críticos en una Unidad de Cuidados Intensivos (UCI), usando programación reactiva con Project Reactor. Se generan flujos de datos continuos de frecuencia cardíaca, presión arterial y oxígeno en sangre para varios pacientes. Se aplican filtros para detectar eventos críticos, se controla el flujo con backpressure, y se emiten alertas solo cuando los signos vitales están fuera de los rangos normales.

## 🤍 Objetivos
- Simular un sistema reactivo que monitorea signos vitales de pacientes críticos en tiempo real en una Unidad de Cuidados Intensivos (UCI), aplicando backpressure para controlar el flujo de datos y encadenar operaciones reactivas que filtren eventos anómalos.

## 🤍 Salida obtenida

```bash
java MonitoreoApplication

⚠️ Paciente 1 - Nombre: Kari
PA crítica: 143/51 mmHg 
⚠️ Paciente 3 - Nombre: Roberto
SpO2 baja: 86% 
⚠️ Paciente 2 - Nombre: Diana
FC crítica: 126 bpm | 
PA crítica: 94/58 mmHg

🚨 ALERTA GLOBAL: Múltiples signos vitales críticos detectados


```
#### 🤍 Haz click para volver al [Indice](https://github.com/KatyE0/Curso_Java_Intermedio/blob/main/README.md)

---
Hecho con 🤍 por Karina Escalante