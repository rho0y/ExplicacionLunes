import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObtenerEspaciosDisponiblesTest {

    private SistemaAtencionClinica sistema;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaAtencionClinica();
    }

    @Test
    public void deberiaIniciarConDoceEspacios() {
        assertEquals(12, sistema.obtenerEspaciosDisponibles());
    }

    @Test
    public void deberiaDisminuirEspaciosAlRegistrar() {
        sistema.registrarPaciente("P001", "Carlos", 3);
        sistema.registrarPaciente("P002", "Maria", 1);

        assertEquals(10, sistema.obtenerEspaciosDisponibles());
    }
}