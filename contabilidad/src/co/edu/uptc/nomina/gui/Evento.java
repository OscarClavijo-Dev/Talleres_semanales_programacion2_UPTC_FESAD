package co.edu.uptc.nomina.gui;

import co.edu.uptc.negocio.dto.CredencialDto;
import co.edu.uptc.nomina.negocio.GestionSeguridad;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Evento extends WindowAdapter implements ActionListener {
    // Constantes de comandos
    public static final String ACTUALIZAR = "Actualizar";
    public static final String ACTUALIZAR_EF = "Actualizar_EF";
    public static final String ACTUALIZAR_TI = "Actualizar_TI";
    public static final String BUSCAR = "Buscar";
    public static final String BUSCAR_EF = "Buscar_EF";
    public static final String BUSCAR_TI = "Buscar_TI";
    public static final String CANCELAR = "Cancelar";
    public static final String CANCELAR_EF = "Cancelar_EF";
    public static final String CREAR = "Crear";
    public static final String CREAR_EF = "Crear_EF";
    public static final String CREAR_TI = "Crear_TI";
    public static final String EDITAR = "Editar";
    public static final String EDITAR_EF = "Editar_EF";
    public static final String ELIMINAR = "Eliminar";
    public static final String ELIMINAR_EF = "Eliminar_EF";
    public static final String ELIMINAR_TI = "Eliminar_TI";
    public static final String GUARDAR = "Guardar";
    public static final String GUARDAR_EF = "Guardar_EF";
    public static final String LIMPIAR = "Limpiar";
    public static final String LIMPIAR_EF = "Limpiar_EF";
    public static final String LIMPIAR_TI = "Limpiar_TI";
    public static final String LOGIN = "Login";
    public static final String VER = "Ver";
    public static final String VER_EF = "Ver_EF";
    public static final String VER_TI = "Ver_TI";

    private VentanaPrincipal ventana;

    public Evento(VentanaPrincipal ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        switch (comando) {
            case LOGIN:
                procesarLogin();
                break;
            case CREAR:
            case CREAR_EF:
                ventana.lanzarDialogoEmpleadoFijo();
                break;
            case GUARDAR:
            case GUARDAR_EF:
                guardarEmpleadoFijo();
                break;
            case CANCELAR:
            case CANCELAR_EF:
                ventana.cerrarDialogEmpFijo();
                break;
        }
    }

    private void procesarLogin() {
        CredencialDto credencial = ventana.getpLogin().getCredencialesUsuario();

        if (credencial == null) {
            JOptionPane.showMessageDialog(ventana,
                "Debe ingresar usuario y contraseña",
                "Error de validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (ventana.getSeguridad().validarLogueo(credencial)) {
            ventana.loguear();
        } else {
            JOptionPane.showMessageDialog(ventana,
                "Usuario o contraseña incorrectos",
                "Error de autenticación",
                JOptionPane.ERROR_MESSAGE);
            ventana.getpLogin().limpiarCampos();
        }
    }

    private void guardarEmpleadoFijo() {
        // Implementación según diagrama de secuencia
        ventana.cerrarDialogEmpFijo();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int confirmacion = JOptionPane.showConfirmDialog(ventana,
            "¿Está seguro de salir del sistema?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}