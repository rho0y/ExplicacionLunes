import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SistemaAtencionClinica {
    private final PriorityQueue<Paciente> colaPacientes;
    private final int capacidadMaxima = 12;

    public SistemaAtencionClinica() {
        this.colaPacientes = new PriorityQueue<>();
    }

    public String registrarPaciente(String codigo, String nombre, int prioridad) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return "El código no puede ser nulo o vacío.";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "El nombre no puede ser nulo o vacío.";
        }
        if (prioridad < 1 || prioridad > 3) {
            return "La prioridad debe ser 1, 2 o 3.";
        }
        if (colaPacientes.size() >= capacidadMaxima) {
            return "La sala de espera está llena.";
        }
        if (colaPacientes.stream().anyMatch(p -> p.getCodigo().equals(codigo))) {
            return "Ya existe un paciente con el mismo código.";
        }
        colaPacientes.offer(new Paciente(codigo, nombre, prioridad));
        return "Paciente registrado exitosamente.";
    }

    public String verSiguientePaciente() {
        if (colaPacientes.isEmpty()) {
            return "No hay pacientes";
        }
        return colaPacientes.peek().toString();
    }

    public String atenderSiguientePaciente() {
        if (colaPacientes.isEmpty()) {
            return "No hay pacientes";
        }
        return colaPacientes.poll().toString();
    }

    public int obtenerCantidadPacientes() {
        return colaPacientes.size();
    }

    public int obtenerEspaciosDisponibles() {
        return capacidadMaxima - colaPacientes.size();
    }

    public String mostrarColaPrioridad() {
        if (colaPacientes.isEmpty()) {
            return "Cola vacía";
        }
        return colaPacientes.stream()
                .map(Paciente::toString)
                .collect(Collectors.joining("\n"));
    }
}
