package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import negocio.ControlPersonas;

import java.awt.Font;
import java.awt.Color;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.HashMap;
import java.util.Map;
import java.awt.font.TextAttribute;

public class VentanaPrincipal extends JFrame {

    // ATRIBUTOS 
    private JButton buttonAceptar;
    private JButton buttonAnterior;
    private JButton buttonCancelar;
    private JButton buttonSiguiente;

    private Eventos evento;
    private PanelInformacion informacion;
    private ControlPersonas personas;
    private int posicion;

    // CONSTRUCTOR
    public VentanaPrincipal() throws HeadlessException {
        
        // Configuración básica de la ventana
        setTitle("Control de Personas");
      //setSize(800, 400);
        setSize(700,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el objeto Evento
        evento = new Eventos(this);

        // Inicializar componentes
        informacion = new PanelInformacion();
        personas = new ControlPersonas(null);
        posicion = 0;

        // Crear los botones (usando las constantes de Eventos)
        buttonAceptar = new JButton(Eventos.AGREGAR);
        buttonAnterior = new JButton(Eventos.ANTERIOR);
        buttonCancelar = new JButton(Eventos.LIMPIAR);
        buttonSiguiente = new JButton(Eventos.SIGUIENTE);

        // Crear fuente personalizada (según la guía)
        Font nuevaFuente = new Font("Kristen ITC", Font.ITALIC, 12);

        // Aplicar fuente a los botones
        buttonAceptar.setFont(nuevaFuente);
        buttonAnterior.setFont(nuevaFuente);
        buttonCancelar.setFont(nuevaFuente);
        buttonSiguiente.setFont(nuevaFuente);
        
    	// Asigna un color a la letra del botón
        buttonAceptar.setForeground(new Color(0, 0, 255));
        buttonCancelar.setForeground(new Color(0, 0, 255));
        
        // Asigna un color a la letra del botón (usando constantes)
        buttonSiguiente.setForeground(Color.BLUE);
        buttonAnterior.setForeground(Color.BLUE);
        
        // Líneas para generar formato subrayado
        Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Font ItalicUnderline = new Font("Kristen ITC", Font.ITALIC, 12).deriveFont(fontAttributes);

        // Aplica el color de fondo y la fuente subrayada
        buttonAceptar.setBackground(new Color(255, 255, 255));
        buttonAceptar.setFont(ItalicUnderline);
     
        
        // Quita el borde de los botones
        buttonAceptar.setBorderPainted(false);
        buttonAnterior.setBorderPainted(false);
        buttonSiguiente.setBorderPainted(false);
        buttonCancelar.setBorderPainted(false);
        
        // Asigna un color de fondo a cada uno de los botones
        buttonAceptar.setBackground(new Color(255, 255, 155));
        buttonAnterior.setBackground(new Color(255, 255, 175));
        buttonSiguiente.setBackground(new Color(255, 255, 195));
        buttonCancelar.setBackground(new Color(255, 255, 215));

        // Crear panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(new TitledBorder("Botones"));
        
        panelBotones.add(buttonAceptar);
        panelBotones.add(buttonAnterior);
        panelBotones.add(buttonSiguiente);
        panelBotones.add(buttonCancelar);

        
     // Crear barra de menú
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setFont(nuevaFuente);

        // Crear items del menú (los crearás después)
        JMenuItem abrirArchivo = new JMenuItem("Abrir");
        JMenuItem guardarArchivo = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");

        // Agregar items al menú
        menuArchivo.add(abrirArchivo);
        menuArchivo.add(guardarArchivo);
        menuArchivo.addSeparator();
        menuArchivo.add(salir);

        // Agregar menú a la barra
        barraMenu.add(menuArchivo);

        // Establecer la barra de menú
        setJMenuBar(barraMenu);
        
        // Agregar componentes a la ventana
        setLayout(new BorderLayout());
        add(informacion, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        informacion.setModoSoloLectura();
    }

    // MÉTODOS 
    public void abrirArchivo() {
    }

    public void agregarPersona() {
    }

    public void anteriorPersona() {
    }

    public void guardarArchivo() {
    }

    public void limpiarInformacion() {
    }

    public void salir() {
    }

    public void siguientePersona() {
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