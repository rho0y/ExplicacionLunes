public class Paciente {

    private String codigo;
    private String nombre;
    private int prioridad;

    public Paciente(String codigo, String nombre, int prioridad) {

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
    public String toString() {
        return "";
    }
}
