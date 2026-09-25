package co.edu.uptc.nomina.personas.gui;

import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.Persona;
import co.edu.uptc.nomina.negocio.NominaConfig;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelPadreEmpleadoFijo extends PanelCentral {
    

    public PanelPadreEmpleadoFijo(Evento evento) {
        super(evento);
        //TODO Auto-generated constructor stub
    }
    
    @Override
	public void agregarTituloPanel() {
    	//TODO Auto-generated constructor stub
       tituloPanel = "Empleados Fijos";
    }
    
    @Override
	public void agregarIdentificadorComandoBoton() {
    	//TODO Auto-generated constructor stub
    	btnEliminar.setActionCommand(Evento.ELIMINAR_EF);
    	btnVer.setActionCommand(Evento.VER_EF);
    	btnActualizar.setActionCommand(Evento.ACTUALIZAR_EF);
        btnCrear.setActionCommand(Evento.CREAR_EF);
        btnLimpiar.setActionCommand(Evento.LIMPIAR_EF);
        btnBuscar.setActionCommand(Evento.BUSCAR_EF);
             
    }

    @Override
	public void agregarCabeceraTabla() {
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Doc. Identidad");
        tblEmpleados.setModel(modelo);
    }

  
    @Override
	public void poblarTabla(List<?> ListaEmpleados) {
       modelo.setRowCount(0);
       List<EmpleadoTerminoFijo> empleadosF=(List<EmpleadoTerminoFijo>) ListaEmpleados;
       for (Persona p : empleadosF) {
    	   Object[] fila = { p.getPrimerNombre(), p.getTipoDoc()};
    	   modelo.addRow(fila);
       }
    }

    
}