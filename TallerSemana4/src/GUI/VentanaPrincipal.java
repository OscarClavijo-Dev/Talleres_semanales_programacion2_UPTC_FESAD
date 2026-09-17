package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import negocio.Expresion;

public class VentanaPrincipal extends JFrame {
    
    // ATRIBUTOS
    private JButton buttonAceptar;
    private JButton buttonLimpiar;
    private Eventos eventos;
    private PanelExpresion panel;
    private Expresion expresion;
    private JLabel titleExpresion;

    // CONSTRUCTOR
    public VentanaPrincipal() throws HeadlessException {
        
        // Configuración básica
        setTitle("Validador de Expresiones");
        setSize(300, 250); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear objetos
        eventos = new Eventos(this);
        panel = new PanelExpresion(eventos);
        expresion = new Expresion(); 

        // Inicializar botones con constantes públicas
        buttonAceptar = new JButton(eventos.ACEPTAR);
        buttonLimpiar = new JButton(eventos.LIMPIAR);

        // Asignar acción de comando a cada botón
        buttonAceptar.setActionCommand(eventos.ACEPTAR);
        buttonLimpiar.setActionCommand(eventos.LIMPIAR);

        // Agregar ActionListener para que escuchen los eventos
        buttonAceptar.addActionListener(eventos);
        buttonLimpiar.addActionListener(eventos);

        // Crear label de título
        titleExpresion = new JLabel("Expresión");
        titleExpresion.setHorizontalAlignment(JLabel.CENTER);

        // Crear panel de botones
        JPanel Panelbotones = new JPanel();
        Panelbotones.add(buttonAceptar);
        Panelbotones.add(buttonLimpiar);

        // Agregar componentes a la ventana
        setLayout(new BorderLayout());
        add(titleExpresion, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(Panelbotones, BorderLayout.SOUTH);
    }

  
    // MÉTODOS
   

    public void activarAccionAlfabetica() {
        expresion.setTipo(Expresion.TIPO_ALFABETICA); 
        JOptionPane.showMessageDialog(this, "Modo: Alfabética", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionAlfanumerica() {
        expresion.setTipo(Expresion.TIPO_ALFANUMERICA); 
        JOptionPane.showMessageDialog(this, "Modo: Alfanumérica", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionCorreo() {
        expresion.setTipo(Expresion.TIPO_CORREO); 
        JOptionPane.showMessageDialog(this, "Modo: Correo Electrónico", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionNumerica() {
        expresion.setTipo(Expresion.TIPO_NUMERO);
        JOptionPane.showMessageDialog(this, "Modo: Numérica", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionLimpiar() {
        panel.setTextoEvaluar("");
    }

    public void actualizarTitulo() {
        // Actualizar el título según la expresión seleccionada
    }

    public void evaluarExpresion() {
        String texto = panel.getTextoEvaluar();
        
        
        boolean valido = expresion.validarExpresion(texto);
        
        if (valido) {
            JOptionPane.showMessageDialog(this, "¡Cadena VÁLIDA!", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cadena NO válida", "Resultado", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MAIN
    public static void main(String[] args) {
        try {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }
}