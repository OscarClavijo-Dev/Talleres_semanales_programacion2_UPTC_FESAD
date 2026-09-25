package co.edu.uptc.nomina.gui;

import co.edu.uptc.nomina.negocio.GestionSeguridad;
import co.edu.uptc.nomina.negocio.NominaConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {
    private NominaConfig config;
    private Evento evento;
    private DialogoEmpleadoFijo nuevoEmpFijo;
    private PanelPadreEmpleadoFijo pCentral;
    private PanelLogin pLogin;
    private GestionSeguridad seguridad;

    public VentanaPrincipal() {
        setTitle("Sistema de Nómina - UPTC");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar componentes
        config = new NominaConfig();
        seguridad = new GestionSeguridad();
        pLogin = new PanelLogin();
        evento = new Evento(this);

        // Agregar listener de cierre de ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmacion = JOptionPane.showConfirmDialog(
                    VentanaPrincipal.this,
                    "¿Está seguro de salir?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION
                );
                if (confirmacion == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setLayout(new BorderLayout());
        add(pLogin, BorderLayout.CENTER);
        setVisible(true);
    }

    public void cerrarDialogEmpFijo() {
        if (nuevoEmpFijo != null) {
            nuevoEmpFijo.dispose();
        }
    }

    public void crearEmpleadoFijo() {
        nuevoEmpFijo = new DialogoEmpleadoFijo(this, evento, "Crear Empleado Fijo", false);
        nuevoEmpFijo.setVisible(true);
    }

    public void lanzarDialogoEmpleadoFijo() {
        crearEmpleadoFijo();
    }

    public void loguear() {
        pLogin.setVisible(false);
        pCentral = new PanelPadreEmpleadoFijo(evento, config);
        add(pCentral, BorderLayout.CENTER);
        pCentral.setVisible(true);
        setTitle("Sistema de Nómina - Empleado Término Fijo");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }

    // Getters
    public NominaConfig getConfig() {
        return config;
    }

    public PanelLogin getpLogin() {
        return pLogin;
    }

    public PanelPadreEmpleadoFijo getpCentral() {
        return pCentral;
    }

    public GestionSeguridad getSeguridad() {
        return seguridad;
    }
}