package co.edu.uptc.nomina.gui;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


import co.edu.uptc.nomina.modelo.Persona;
import co.edu.uptc.nomina.negocio.GestionSeguridad;
import co.edu.uptc.nomina.negocio.NominaConfig;
import co.edu.uptc.negocio.dto.CredencialDto;
import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.personas.gui.DialogoEmpleadoFijo;
import co.edu.uptc.nomina.personas.gui.PanelCentral;
import co.edu.uptc.nomina.personas.gui.PanelPadreEmpleadoFijo;


public class VentanaPrincipal extends JFrame {
	
	private PanelLogin pLogin;
	private PanelPadreEmpleadoFijo pCentral;
	private GestionSeguridad seguridad;
	private DialogoEmpleadoFijo nuevoEmplFijo;
	private Evento evento;
    private NominaConfig config;
    
    public VentanaPrincipal() {
    	
    	//TODO Auto-generated constructor stub
    	setSize(900, 600);
    	//TODO pasar a Constante
        setTitle("Nómina - UPTC");
        setLayout(new BorderLayout());
        
        
        // Inicializar componentes o relaciones o asociaciones
        evento = new Evento(this);
        pLogin = new PanelLogin();
      //TODO por clases abstractas
        pCentral = new PanelPadreEmpleadoFijo(evento);
        seguridad = new GestionSeguridad();
        config = new NominaConfig();   
        evento = new Evento(this);
        add(pLogin, BorderLayout.CENTER);
        
       
  
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
    			JOptionPane.showMessageDialog(this, " Usuario o contraseña no valido");
    		}
    	} catch	(Exception e) {
    		//TODO Auto-generated catch block
    		e.printStackTrace();
    		JOptionPane.showMessageDialog(this, e.getMessage());
    	}
    	
    	
    }
    	
    public void lanzarDialogoEmpleadoFijo() {
    	nuevoEmplFijo= new DialogoEmpleadoFijo(evento, "Crear Empelado Fijo", true);
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
}

   

   
   
   