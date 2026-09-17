package co.edu.uptc.nomina.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class PanelCentral extends JPanel {

    protected JTable tabla;
    protected DefaultTableModel modeloTabla;
    protected JButton btnNuevo, btnEliminar, btnVer, btnActualizar, btnBuscar, btnLimpiar;
    protected ActionListener listener;

    public PanelCentral(ActionListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        // Título del Panel
        JLabel lblTitulo = new JLabel(agregarTituloPanel(), SwingConstants.CENTER);
        add(lblTitulo, BorderLayout.NORTH);

        // Tabla y ScrollPane
        modeloTabla = new DefaultTableModel();
        agregarCabeceraTabla(modeloTabla);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Panel de Botones
        JPanel panelBotones = new JPanel();
        btnNuevo = new JButton("Nuevo");
        btnEliminar = new JButton("Eliminar");
        btnVer = new JButton("Ver");
        btnActualizar = new JButton("Actualizar");

        // Asignación de ActionListener
        btnNuevo.addActionListener(listener);
        btnEliminar.addActionListener(listener);
        btnVer.addActionListener(listener);
        btnActualizar.addActionListener(listener);

        asignarIdentificadoresCommandButton();

        panelBotones.add(btnNuevo);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnVer);
        panelBotones.add(btnActualizar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    // Métodos abstractos que deben implementar los hijos
    protected abstract String agregarTituloPanel();
    protected abstract void agregarCabeceraTabla(DefaultTableModel model);
    protected abstract void asignarIdentificadoresCommandButton();
    public abstract void poblarTabla();
}