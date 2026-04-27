
import java.util.Objects;

public class Paciente implements Comparable<Paciente> {
    private String codigo;
    private String nombre;
    private int prioridad;

    public Paciente(String codigo, String nombre, int prioridad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(codigo, paciente.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Paciente [codigo=" + codigo + ", nombre=" + nombre + ", prioridad=" + prioridad + "]";
    }
}
