import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private final SistemaAtencionClinica sistema;

    public Ventana() {
        this.sistema = new SistemaAtencionClinica();
        setTitle("Sistema de Atención Clínica");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Registrar", crearPanelRegistrar());
        tabbedPane.addTab("Atender", crearPanelAtender());
        tabbedPane.addTab("Ver Cola", crearPanelVerCola());

        add(tabbedPane);
    }

    private JPanel crearPanelRegistrar() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField txtCodigo = new JTextField();
        JTextField txtNombre = new JTextField();
        JComboBox<Integer> cmbPrioridad = new JComboBox<>(new Integer[]{1, 2, 3});
        JButton btnRegistrar = new JButton("Registrar Paciente");

        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Prioridad:"));
        panel.add(cmbPrioridad);
        panel.add(new JLabel());
        panel.add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            String nombre = txtNombre.getText();
            int prioridad = (int) cmbPrioridad.getSelectedItem();
            String resultado = sistema.registrarPaciente(codigo, nombre, prioridad);
            JOptionPane.showMessageDialog(this, resultado);
            if (resultado.contains("exitosamente")) {
                txtCodigo.setText("");
                txtNombre.setText("");
            }
        });

        return panel;
    }

    private JPanel crearPanelAtender() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea areaInfo = new JTextArea(10, 30);
        areaInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaInfo);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton btnVerSiguiente = new JButton("Ver Siguiente");
        JButton btnAtenderSiguiente = new JButton("Atender Siguiente");
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVerSiguiente);
        panelBotones.add(btnAtenderSiguiente);
        panel.add(panelBotones, BorderLayout.SOUTH);

        btnVerSiguiente.addActionListener(e -> areaInfo.setText("Siguiente paciente: \n" + sistema.verSiguientePaciente()));

        btnAtenderSiguiente.addActionListener(e -> {
            String atendido = sistema.atenderSiguientePaciente();
            areaInfo.setText("Paciente atendido: \n" + atendido);
            JOptionPane.showMessageDialog(this, "Paciente atendido: \n" + atendido);
        });
        return panel;
    }

    private JPanel crearPanelVerCola() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea areaCola = new JTextArea(10, 30);
        areaCola.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaCola);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JLabel lblInfo = new JLabel();
        panel.add(lblInfo, BorderLayout.NORTH);

        JButton btnActualizar = new JButton("Actualizar Vista de la Cola");
        panel.add(btnActualizar, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> {
            areaCola.setText(sistema.mostrarColaPrioridad());
            lblInfo.setText("Pacientes en cola: " + sistema.obtenerCantidadPacientes() + 
                            " | Espacios disponibles: " + sistema.obtenerEspaciosDisponibles());
        });
        
        // Carga inicial
        btnActualizar.doClick();

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ventana().setVisible(true));
    }
}
