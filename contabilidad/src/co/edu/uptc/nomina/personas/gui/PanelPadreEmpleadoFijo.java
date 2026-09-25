package co.edu.uptc.nomina.personas.gui;

import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPadreEmpleadoFijo extends PanelCentral {
    private NominaConfig nominaConfig;
    private Evento evento;

    public PanelPadreEmpleadoFijo(Evento evento, NominaConfig nominaConfig) {
        this.evento = evento;
        this.nominaConfig = nominaConfig;
        this.tituloPanel = "";
        inicializarComponentes();
        agregarCabeceraTabla();
        agregarIdentificadorComandoBoton();
        poblarTabla(nominaConfig.getGestEmpleadoFijo().listarEmpleados());
        configurarEventos();
    }

    @Override
    protected void agregarCabeceraTabla() {
        String[] columnas = {"Primer Nombre", "Tipo Documento", "Doc. Identidad"};
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
	public void poblarTabla(List<?> lista) {
        modelo.setRowCount(0);
        List<EmpleadoTerminoFijo> empleados = (List<EmpleadoTerminoFijo>) lista;

        for (EmpleadoTerminoFijo emp : empleados) {
            Object[] fila = new Object[]{
                emp.getPrimerNombre(),
                emp.getTipoDoc() != null ? emp.getTipoDoc().name() : "",
                emp.getId()
            };
            modelo.addRow(fila);
        }
    }

    public long getItemSeleccionadoDocNumero() {
    	
    	int fila =tblEmpleados.getSelectedRow();
    	long var=Long.parseLong(tblEmpleados.getModel().getValueAt(fila, 2).toString());
    	
    	return var;
    }
    
    
    
    
    private void configurarEventos() {
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogoEmpleadoFijo dialogo = new DialogoEmpleadoFijo(
                    (Frame) SwingUtilities.getWindowAncestor(PanelPadreEmpleadoFijo.this),
                    PanelPadreEmpleadoFijo.this,
                    nominaConfig
                );
                dialogo.setVisible(true);
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tblEmpleados.getSelectedRow();
                if (fila != -1) {
                    long id = (long) modelo.getValueAt(fila, 2);
                    nominaConfig.getGestEmpleadoFijo().eliminar(id);
                    poblarTabla(nominaConfig.getGestEmpleadoFijo().listarEmpleados());
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

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog(PanelPadreEmpleadoFijo.this,
                    "Ingrese el número de documento:");
                if (idStr != null && !idStr.trim().isEmpty()) {
                    try {
                        long id = Long.parseLong(idStr.trim());
                        EmpleadoTerminoFijo emp = nominaConfig.getGestEmpleadoFijo().buscar(id);
                        if (emp != null) {
                            JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                                "Empleado encontrado:\n" + emp.getPrimerNombre() +
                                " - " + emp.getTipoDoc() + " - " + emp.getId(),
                                "Búsqueda exitosa",
                                JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                                "Empleado no encontrado",
                                "Búsqueda",
                                JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                            "El documento debe ser numérico",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tblEmpleados.getSelectedRow();
                if (fila != -1) {
                    String nombre = (String) modelo.getValueAt(fila, 0);
                    String tipoDoc = (String) modelo.getValueAt(fila, 1);
                    long id = (long) modelo.getValueAt(fila, 2);
                    JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                        "Nombre: " + nombre + "\nTipo: " + tipoDoc + "\nDocumento: " + id,
                        "Detalle Empleado",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(PanelPadreEmpleadoFijo.this,
                        "Seleccione un empleado para ver",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public NominaConfig getNominaConfig() {
        return nominaConfig;
    }
}