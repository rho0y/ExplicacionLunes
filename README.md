# Taller Programación III
## Sistema de atención prioritaria con PriorityQueue

### Objetivo
Implementar un sistema de gestión de pacientes utilizando la estructura de datos `PriorityQueue` en Java.

### Contexto
Una clínica necesita organizar la atención de pacientes según su nivel de prioridad.

Cada paciente tiene:
- código
- nombre
- prioridad

### Niveles de prioridad
- 1 = crítica
- 2 = urgente
- 3 = normal

### Reglas de negocio
1. La sala de espera tiene capacidad máxima de 12 pacientes.
2. No se permiten códigos nulos, vacíos o solo espacios.
3. No se permiten nombres nulos, vacíos o solo espacios.
4. La prioridad solo puede ser 1, 2 o 3.
5. No se permiten códigos duplicados.
6. Se atiende primero al paciente con mayor prioridad médica:
    - prioridad 1 antes que 2
    - prioridad 2 antes que 3

### Métodos obligatorios
- `registrarPaciente(String codigo, String nombre, int prioridad)`
- `verSiguientePaciente()`
- `atenderSiguientePaciente()`
- `obtenerCantidadPacientes()`
- `obtenerEspaciosDisponibles()`
- `mostrarColaPrioridad()`

### Mensajes esperados
- Si no hay pacientes en espera: `No hay pacientes`
- Si la cola está vacía al mostrarla: `Cola vacía`

### Restricciones
No modificar:
- archivos de prueba
- `pom.xml`
- workflow de GitHub

Solo trabajar en:
- `src/main/java/SistemaAtencionClinica.java`
- `src/main/java/Paciente.java`
- `src/main/java/Ventana para probar las funcionalidades, realice una vez que pase las pruebas`
Test 7.5 Puntos
Ventana 2.5 Puntos
