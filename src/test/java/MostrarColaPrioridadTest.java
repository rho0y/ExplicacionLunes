import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MostrarColaPrioridadTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaMostrarMensajeSiColaEstaVacia() {
        assertEquals("Cola vacía", sistema.mostrarColaPrioridad());
    }

    @Test
    public void deberiaMostrarPacientesRegistrados() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);

        String resultado = sistema.mostrarColaPrioridad();

        assertTrue(resultado.contains("P001 | Carlos | Prioridad 3"));
        assertTrue(resultado.contains("P002 | Maria | Prioridad 1"));
    }
}
