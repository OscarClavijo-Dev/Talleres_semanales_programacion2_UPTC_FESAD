package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {
    
    // CONSTANTES (según diagrama UML)
    public static final String ACEPTAR = "Aceptar";
    public static final String ALFABETICA = "Alfabética";
    public static final String ALFANUMERICA = "Alfanumérica";
    public static final String CORREO = "e-mail";
    public static final String LIMPIAR = "Limpiar";
    public static final String NUMERICA = "Numérica";
    
    private VentanaPrincipal ventana;

    // CONSTRUCTOR
    public Eventos(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    // MÉTODO de ActionListener - encargado de atrapar los eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        // Atrapa el evento que se generó en una variable temporal
        String evento = e.getActionCommand();
        
        // Compara con las constantes a cual pertenece el evento generado
        if (evento.equals(ALFABETICA)) {
            ventana.activarAccionAlfabetica();
        }
        else if (evento.equals(ALFANUMERICA)) {
            ventana.activarAccionAlfanumerica();
        }
        else if (evento.equals(NUMERICA)) {
            ventana.activarAccionNumerica();
        }
        else if (evento.equals(CORREO)) {
            ventana.activarAccionCorreo();
        }
        else if (evento.equals(ACEPTAR)) {
            ventana.evaluarExpresion();
        }
        else if (evento.equals(LIMPIAR)) {
            ventana.activarAccionLimpiar();
        }
    }
}