package co.edu.uptc.nomina.personas.gui;

import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.negocio.NominaConfig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public abstract class PanelCentral extends JPanel {
	protected String tituloPanel;
	protected JButton btnEliminar;
	protected JButton btnVer;
    protected JButton btnActualizar;
    protected JButton btnCrear;
    protected JButton btnBuscar;
    protected JButton btnLimpiar;
    protected JTable tblEmpleados;
    protected DefaultTableModel modelo;
    
    

    public PanelCentral(Evento evento) {
        
    	JPanel pSuperior = new JPanel();
    	pSuperior.setLayout(new BorderLayout());
    	setLayout(new BorderLayout());
    	
    	JPanel pTitulo= new JPanel();
    	pTitulo.add(new JLabel(tituloPanel));
    	
    	JPanel pBtnFuncion= new JPanel();
    	btnEliminar = new JButton(Evento.ELIMINAR);
    	btnVer = new JButton(Evento.VER);
    	btnActualizar = new JButton(Evento.ACTUALIZAR);
    	btnCrear = new JButton(Evento.CREAR);
    	
        
        btnEliminar.addActionListener(evento);
        btnVer.addActionListener(evento);
        btnActualizar.addActionListener(evento);
        btnCrear.addActionListener(evento);
        
        pBtnFuncion.add(btnEliminar);
        pBtnFuncion.add(btnVer);
        pBtnFuncion.add(btnActualizar);
        pBtnFuncion.add(btnCrear);
        
        JPanel pFiltros= new JPanel();
        JTextField txBuscar= new JTextField();
        txBuscar.setPreferredSize(new Dimension(145, 30));
        btnBuscar = new JButton(Evento.BUSCAR);
        btnLimpiar = new JButton(Evento.LIMPIAR);
        
        btnLimpiar.addActionListener(evento);
        btnBuscar.addActionListener(evento);
        
        
        pFiltros.add(txBuscar);
        pFiltros.add(btnBuscar);
        pFiltros.add(btnLimpiar);
        
        pSuperior.add(pTitulo,BorderLayout.NORTH);
        pSuperior.add(pBtnFuncion,BorderLayout.CENTER);
        pSuperior.add(pFiltros,BorderLayout.SOUTH);
        modelo = new DefaultTableModel();
        tblEmpleados= new JTable();
        agregarCabeceraTabla();
        
        
        JScrollPane spTabla= new JScrollPane(tblEmpleados);
        
        add(pSuperior,BorderLayout.NORTH);
        add(spTabla,BorderLayout.CENTER);
        agregarIdentificadorComandoBoton();
        
        
    }

   public abstract void agregarTituloPanel();
   
   public abstract void agregarIdentificadorComandoBoton();
   public abstract void agregarCabeceraTabla();
   public abstract void poblarTabla(List<?> ListaEmpleados);
  

    
}