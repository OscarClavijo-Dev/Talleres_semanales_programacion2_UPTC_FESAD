package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {
    
    // CONSTANTES (según diagrama UML)
    public static final String AGREGAR = "Agregar";
    public static final String GUARDAR = "Guardar";
    public static final String ABRIR = "Abrir";
    public static final String SIGUIENTE = "Siguiente";
    public static final String ANTERIOR = "Anterior";
    public static final String SALIR = "Salir";
    public static final String LIMPIAR = "Limpiar";
    
    private VentanaPrincipal ventanaPrincipal;

    // CONSTRUCTOR
    public Eventos(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String evento = e.getActionCommand();
        
        try {
            if (evento.equals(AGREGAR)) {
                ventanaPrincipal.agregarPersona();
            }
            else if (evento.equals(GUARDAR)) {
                ventanaPrincipal.guardarArchivo();
            }
            else if (evento.equals(ABRIR)) {
                ventanaPrincipal.abrirArchivo();
            }
            else if (evento.equals(SIGUIENTE)) {
                ventanaPrincipal.siguientePersona();
            }
            else if (evento.equals(ANTERIOR)) {
                ventanaPrincipal.anteriorPersona();
            }
            else if (evento.equals(SALIR)) {
                ventanaPrincipal.salir();
            }
            else if (evento.equals(LIMPIAR)) {
                ventanaPrincipal.limpiarInformacion();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}