package GUI;

import negocio.ControlPersonas;
import negocio.Persona;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    
    // ATRIBUTOS
    private JButton buttonAceptar;
    private JButton buttonCancelar;
    private JButton buttonSiguiente;
    private JButton buttonAnterior;
    private Eventos evento;
    private PanelInformacion panelInformacion;
    private ControlPersonas controlPersonas;
    private int posicionVisualPersona;

    // CONSTRUCTOR
    public VentanaPrincipal() throws HeadlessException {
        // Configuración básica
        setTitle("Registro de Personas - Semana 5");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear objetos
        controlPersonas = new ControlPersonas();
        evento = new Eventos(this);
        panelInformacion = new PanelInformacion();
        posicionVisualPersona = 0;

        // Crear botones con constantes públicas
        buttonAceptar = new JButton(Eventos.AGREGAR);
        buttonCancelar = new JButton(Eventos.LIMPIAR);
        buttonSiguiente = new JButton(Eventos.SIGUIENTE);
        buttonAnterior = new JButton(Eventos.ANTERIOR);

        // Asignar comandos de acción
        buttonAceptar.setActionCommand(Eventos.AGREGAR);
        buttonCancelar.setActionCommand(Eventos.LIMPIAR);
        buttonSiguiente.setActionCommand(Eventos.SIGUIENTE);
        buttonAnterior.setActionCommand(Eventos.ANTERIOR);

        // Agregar ActionListener
        buttonAceptar.addActionListener(evento);
        buttonCancelar.addActionListener(evento);
        buttonSiguiente.addActionListener(evento);
        buttonAnterior.addActionListener(evento);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(buttonAnterior);
        panelBotones.add(buttonSiguiente);
        panelBotones.add(buttonAceptar);
        panelBotones.add(buttonCancelar);

        // Agregar componentes a la ventana
        setLayout(new BorderLayout());
        add(panelInformacion, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Agregar una persona a la lista de control
     */
    public void agregarPersona() {
        try {
            controlPersonas.add(panelInformacion.getPersona());
            limpiarInformacion();
            panelInformacion.setNumeroUsuarios(controlPersonas.getSecuenciaIngreso());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                ControlPersonas.EXCEPCIONES.getString("excepcion.persona.errorcodigononumerico"),
                "Error de Formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                e.getMessage(),
                "Error de Validación",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void guardarArchivo() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar archivo");
            fileChooser.setSelectedFile(new java.io.File("personas.txt"));
            
            int userSelection = fileChooser.showSaveDialog(this);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File archivo = fileChooser.getSelectedFile();
                String path = archivo.getParent();
                String nombre = archivo.getName();
                
                controlPersonas.writerArchivo(path, nombre, true);
                
                JOptionPane.showMessageDialog(this, 
                    "Archivo guardado correctamente", 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al guardar el archivo: " + e.getMessage(), 
                "Error de E/S", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void abrirArchivo() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Abrir archivo");
            
            int userSelection = fileChooser.showOpenDialog(this);
            
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File archivo = fileChooser.getSelectedFile();
                String path = archivo.getParent();
                String nombre = archivo.getName();
                
                controlPersonas.setSecuenciaIngreso(0);
                controlPersonas.readArchivo(path, nombre);
                
                if (controlPersonas.getSecuenciaIngreso() > 0) {
                    posicionVisualPersona = 0;
                    mostrarPersonaActual();
                }
                
                JOptionPane.showMessageDialog(this, 
                    "Archivo cargado correctamente. Total personas: " + 
                    controlPersonas.getSecuenciaIngreso(), 
                    "Éxito", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al abrir el archivo: " + e.getMessage(), 
                "Error de E/S", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void salir() {
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de salir?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION);
            
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void siguientePersona() {
        if (controlPersonas.getSecuenciaIngreso() > 0) {
            if (posicionVisualPersona < controlPersonas.getSecuenciaIngreso() - 1) {
                posicionVisualPersona++;
                mostrarPersonaActual();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Ya está en la última persona",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "No hay personas registradas",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void anteriorPersona() {
        if (controlPersonas.getSecuenciaIngreso() > 0) {
            if (posicionVisualPersona > 0) {
                posicionVisualPersona--;
                mostrarPersonaActual();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Ya está en la primera persona",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                "No hay personas registradas",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void limpiarInformacion() {
        panelInformacion.limpiarCampos();
    }

    private void mostrarPersonaActual() {
        Persona persona = controlPersonas.getPersona(posicionVisualPersona);
        if (persona != null) {
            panelInformacion.setPersona(persona, controlPersonas.getSecuenciaIngreso());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                VentanaPrincipal ventana = new VentanaPrincipal();
                ventana.setVisible(true);
            } catch (HeadlessException e) {
                e.printStackTrace();
            }
        });
    }
}