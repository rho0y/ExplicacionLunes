import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VerSiguientePacienteTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaVerPacienteConMayorPrioridad() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);
        sistema.registrarPaciente("P003", "Jose", 2);

        assertEquals("P002 | Maria | Prioridad 1", sistema.verSiguientePaciente());
    }

    @Test
    public void deberiaRetornarMensajeSiNoHayPacientes() {
        assertEquals("No hay pacientes", sistema.verSiguientePaciente());
    }
}
