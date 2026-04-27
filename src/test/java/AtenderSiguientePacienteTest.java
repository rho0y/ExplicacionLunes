import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtenderSiguientePacienteTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaAtenderPacienteConMayorPrioridad() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);
        sistema.registrarPaciente("P003", "Jose", 2);

        assertEquals("P002 | Maria | Prioridad 1", sistema.atenderSiguientePaciente());
    }

    @Test
    public void deberiaReducirCantidadAlAtender() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);

        sistema.atenderSiguientePaciente();

        assertEquals(1, sistema.obtenerCantidadPacientes());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayPacientes() {
        assertEquals("No hay pacientes", sistema.atenderSiguientePaciente());
    }
}
