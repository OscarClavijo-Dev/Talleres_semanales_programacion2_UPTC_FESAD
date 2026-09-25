package co.edu.uptc.nomina.gui;

import co.edu.uptc.negocio.dto.CredencialDto;
import co.edu.uptc.nomina.negocio.GestionSeguridad;
import co.edu.uptc.nomina.negocio.NominaConfig;
import co.edu.uptc.nomina.personas.gui.DialogoEmpleadoFijo;
import co.edu.uptc.nomina.personas.gui.PanelPadreEmpleadoFijo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {
    private NominaConfig config;
    private Evento evento;
    private DialogoEmpleadoFijo nuevoEmplFijo;
    private PanelPadreEmpleadoFijo pCentral;
    private PanelLogin pLogin;
    private GestionSeguridad seguridad;

    public VentanaPrincipal() {
        setTitle("Sistema de Nómina - UPTC");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar componentes
        evento = new Evento(this);
        pLogin = new PanelLogin();
      //TODO por clases abstractas
        pCentral = new PanelPadreEmpleadoFijo(evento, config);
        seguridad = new GestionSeguridad();
        config = new NominaConfig();   
        evento = new Evento(this);
        add(pLogin, BorderLayout.CENTER);
        
       
  
    }
    
    public static void main(String[] args) {
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(Boolean.TRUE);
    }

    public void loguear() {
    	try {
    		CredencialDto validar = pLogin.getCredencialesUsuario();
    		
    		if(validar != null && seguridad.validarLogueo(validar)) {
    			pLogin.setVisible(Boolean.FALSE);
    			add(pCentral, BorderLayout.CENTER);
    			pCentral.setVisible(Boolean.TRUE);
    		} else {
    			JOptionPane.showMessageDialog(this, e.getMessage());
    		}
    	} catch	(Exception e) {
    		//TODO Auto-generated catch block
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(this, e.getMessage());
    	}
    	
    	
    }
    	
    public void lanzarDialogoEmpleadoFijo() {
    	nuevoEmplFijo= new DialogoEmpleadoFijo(evento,"Crear Empleado Fijo", true);
    	nuevoEmplFijo.setVisible(Boolean.TRUE);
        
    }

    public void cerrarDialogEmpFijo() {
       nuevoEmplFijo.setVisible(Boolean.FALSE);
       nuevoEmplFijo=null;
    }

    public void crearEmpleadoFijo() {
    	config.getGestEmpleadoFijo().agregarEmpleado(nuevoEmplFijo.capturarDatos());
        cerrarDialogEmpFijo();
        pCentral.poblarTabla(config.getGestEmpleadoFijo().listarEmpleados());
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