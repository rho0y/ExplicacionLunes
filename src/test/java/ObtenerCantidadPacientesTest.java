import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerCantidadPacientesTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaIniciarEnCero() {
        assertEquals(0, sistema.obtenerCantidadPacientes());
    }

    @Test
    public void deberiaContarPacientesCorrectamente() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);
        sistema.registrarPaciente("P003", "Jose", 2);

        assertEquals(3, sistema.obtenerCantidadPacientes());
    }
}