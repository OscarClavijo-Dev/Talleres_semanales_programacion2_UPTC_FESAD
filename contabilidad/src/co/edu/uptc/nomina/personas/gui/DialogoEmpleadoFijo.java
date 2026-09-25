package co.edu.uptc.nomina.personas.gui;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import java.awt.*;

public class DialogoEmpleadoFijo extends JDialog {
    private JTextField txtNombre;
    private JTextField txtNumeroDocumento;
    private JComboBox<TipoDocEnum> cmbTipoDocumento;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private NominaConfig nominaConfig;
    private PanelPadreEmpleadoFijo panelPadre;
    private boolean guardadoExitoso;

    public DialogoEmpleadoFijo(Frame owner, PanelPadreEmpleadoFijo panelPadre, NominaConfig nominaConfig) {
        super(owner, "Crear Empleado Fijo", true);
        this.panelPadre = panelPadre;
        this.nominaConfig = nominaConfig;
        this.guardadoExitoso = false;
        inicializarComponentes();
        setSize(350, 250);
        setLocationRelativeTo(owner);
        setResizable(false);
    }

    private void inicializarComponentes() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtNombre = new JTextField(15);
        add(txtNombre, gbc);

        // Número Documento
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Número Documento:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        txtNumeroDocumento = new JTextField(15);
        add(txtNumeroDocumento, gbc);

        // Tipo Documento
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Tipo Documento:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        cmbTipoDocumento = new JComboBox<>(TipoDocEnum.values());
        add(cmbTipoDocumento, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBotones = new JPanel();
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        btnGuardar.addActionListener(e -> guardarEmpleado());
        btnCancelar.addActionListener(e -> {
            guardadoExitoso = false;
            dispose();
        });

        panelBotones.add(btnCancelar);
        panelBotones.add(btnGuardar);
        add(panelBotones, gbc);
    }

    private void guardarEmpleado() {
        try {
            String nombre = txtNombre.getText().trim();
            String numeroDoc = txtNumeroDocumento.getText().trim();
            TipoDocEnum tipoDoc = (TipoDocEnum) cmbTipoDocumento.getSelectedItem();

            if (nombre.isEmpty() || numeroDoc.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

            long id = Long.parseLong(numeroDoc);

            EmpleadoTerminoFijo empleado = new EmpleadoTerminoFijo();
            empleado.setId(id);
            empleado.setPrimerNombre(nombre);
            empleado.setTipoDoc(tipoDoc);

            nominaConfig.getGestEmpleadoFijo().agregarEmpleado(empleado);

            guardadoExitoso = true;
            panelPadre.poblarTabla(nominaConfig.getGestEmpleadoFijo().listarEmpleados());
            dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "El número de documento debe ser numérico",
                "Error de formato",
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Error al guardar: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isGuardadoExitoso() {
        return guardadoExitoso;
    }
}