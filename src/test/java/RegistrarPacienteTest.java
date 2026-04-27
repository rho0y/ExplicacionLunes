import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrarPacienteTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaRegistrarPacienteValido() {
        assertTrue(sistema.registrarPaciente("P001", "Ana Torres", 2));
        assertEquals(1, sistema.obtenerCantidadPacientes());
    }

    @Test
    public void noDeberiaRegistrarCodigoNulo() {
        assertFalse(sistema.registrarPaciente(null, "Ana Torres", 2));
    }

    @Test
    public void noDeberiaRegistrarNombreNulo() {
        assertFalse(sistema.registrarPaciente("P001", null, 2));
    }

    @Test
    public void noDeberiaRegistrarCodigoVacio() {
        assertFalse(sistema.registrarPaciente("", "Ana Torres", 2));
        assertFalse(sistema.registrarPaciente("   ", "Ana Torres", 2));
    }

    @Test
    public void noDeberiaRegistrarNombreVacio() {
        assertFalse(sistema.registrarPaciente("P001", "",2));
        assertFalse(sistema.registrarPaciente("P001", "   ", 2));
    }

    @Test
    public void noDeberiaRegistrarPrioridadInvalida() {
        assertFalse(sistema.registrarPaciente("P001", "Ana Torres", 0));
        assertFalse(sistema.registrarPaciente("P002", "Luis Perez", 4));
    }

    @Test
    public void noDeberiaRegistrarPacienteDuplicado() {
        assertTrue(sistema.registrarPaciente("P001", "Ana Torres", 2));
        assertFalse(sistema.registrarPaciente("P001", "Ana Torres", 1));
    }

    @Test
    public void noDeberiaRegistrarSiLaColaEstaLlena() {
        for (int i = 1; i <= 12; i++) {
            assertTrue(sistema.registrarPaciente("P" + i, "Paciente " + i, 3));
        }

        assertFalse(sistema.registrarPaciente("P999", "Extra", 1));
        assertEquals(12, sistema.obtenerCantidadPacientes());
    }
}
