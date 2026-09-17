package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;


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
        setSize(300, 300);
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
        titleExpresion.setHorizontalAlignment(titleExpresion.CENTER);

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

    // MÉTODOS según la guía

    public void activarAccionAlfabetica() {
        JOptionPane.showMessageDialog(this, "La cadena es una tipo alfabética", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionAlfanumerica() {
        JOptionPane.showMessageDialog(this, "La cadena es una tipo alfanumérica", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionCorreo() {
        JOptionPane.showMessageDialog(this, "La cadena es un correo electrónico", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void activarAccionLimpiar() {
        panel.setTextoEvaluar("");
    }

    public void activarAccionNumerica() {
        JOptionPane.showMessageDialog(this, "La cadena es una tipo numerica", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actualizarTitulo() {
        // Actualizar el título según la expresión seleccionada
    }

    
    
    //  Usando la clase Expresion
    public void evaluarExpresion() {
        String texto = panel.getTextoEvaluar();
        
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Ingrese una cadena", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Expresion expr = new Expresion();
        boolean valido = false;
        
        expr.setTipo(Expresion.TIPO_ALFABETICA);
        valido = expr.validarExpresion(texto);
        
        if (valido) {
            JOptionPane.showMessageDialog(this, 
                "Cadena válida", 
                "Resultado", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, 
                "Cadena NO válida", 
                "Resultado", 
                JOptionPane.ERROR_MESSAGE);
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