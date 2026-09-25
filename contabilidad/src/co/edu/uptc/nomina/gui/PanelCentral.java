package co.edu.uptc.nomina.gui;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public abstract class PanelCentral extends JPanel {
    protected JButton btnActualizar;
    protected JButton btnBuscar;
    protected JButton btnCrear;
    protected JButton btnEliminar;
    protected JButton btnLimpiar;
    protected JButton btnVer;
    protected DefaultTableModel modelo;
    protected JTable tblEmpleados;
    protected String tituloPanel;

    public PanelCentral() {
        inicializarComponentes();
    }

    protected void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder(tituloPanel != null ? tituloPanel : "Panel"));

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.LEFT));

        btnCrear = new JButton("Crear");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnLimpiar = new JButton("Limpiar");
        btnVer = new JButton("Ver");

        panelBotones.add(btnCrear);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVer);

        // Tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Salario Base", "Días", "Salario Total"};
        modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblEmpleados = new JTable(modelo);
        tblEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tblEmpleados);

        add(panelBotones, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    protected abstract void agregarCabeceraTabla();
    protected abstract void agregarIdentificadorComandoBoton();
    protected abstract void agregarTituloPanel();
    protected abstract void poblarTabla(List<?> lista);
}