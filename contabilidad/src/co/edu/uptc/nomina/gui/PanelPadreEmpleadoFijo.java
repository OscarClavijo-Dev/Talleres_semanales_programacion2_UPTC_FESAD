package co.edu.uptc.nomina.gui;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPadreEmpleadoFijo extends PanelCentral {
    private Evento evento;
    private NominaConfig config;

    public PanelPadreEmpleadoFijo(Evento evento, NominaConfig config) {
        this.evento = evento;
        this.config = config;
        this.tituloPanel = "Empleado Término Fijo";
        inicializarComponentes();
        agregarCabeceraTabla();
        agregarIdentificadorComandoBoton();
        agregarTituloPanel();
        poblarTabla(config.listarEmpleados());
        configurarEventos();
    }

    @Override
    protected void agregarCabeceraTabla() {
        String[] columnas = {"ID", "Nombre", "Apellido", "Salario Base", "Días Trabajados", "Salario Total"};
        modelo.setColumnIdentifiers(columnas);
    }

    @Override
    protected void agregarIdentificadorComandoBoton() {
        btnCrear.setActionCommand(Evento.CREAR_EF);
        btnActualizar.setActionCommand(Evento.ACTUALIZAR_EF);
        btnEliminar.setActionCommand(Evento.ELIMINAR_EF);
        btnBuscar.setActionCommand(Evento.BUSCAR_EF);
        btnLimpiar.setActionCommand(Evento.LIMPIAR_EF);
        btnVer.setActionCommand(Evento.VER_EF);
    }

    @Override
    protected void agregarTituloPanel() {
        setBorder(BorderFactory.createTitledBorder(tituloPanel));
    }

    @Override
    protected void poblarTabla(List<?> lista) {
        modelo.setRowCount(0);
        List<EmpleadoTerminoFijo> empleados = (List<EmpleadoTerminoFijo>) lista;
        
        for (EmpleadoTerminoFijo emp : empleados) {
            Object[] fila = new Object[]{
                emp.getId(),
                emp.getPrimerNombre(),
                emp.getPrimerApellido(),
                String.format("$%.2f", emp.getSalarioBase()),
                emp.getDiasTrabajados(),
                String.format("$%.2f", emp.calcularSalario())
            };
            modelo.addRow(fila);
        }
    }

    private void configurarEventos() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((VentanaPrincipal) SwingUtilities.getWindowAncestor(PanelPadreEmpleadoFijo.this))
                    .lanzarDialogoEmpleadoFijo();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tblEmpleados.getSelectedRow();
                if (fila != -1) {
                    long id = (long) modelo.getValueAt(fila, 0);
                    config.getGestEmpleadoFijo().eliminar(id);
                    poblarTabla(config.listarEmpleados());
                } else {
                    JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                        "Seleccione un empleado para eliminar",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.setRowCount(0);
            }
        });
    }
}