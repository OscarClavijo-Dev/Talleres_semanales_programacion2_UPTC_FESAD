package co.edu.uptc.gui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.uptc.negocio.GestionSeguridad;
import co.edu.uptc.negocio.dto.CredencialDto;

public class VentanaPrincipal extends JFrame{
	
	private PanelLogin pLogin;
	private PanelCentral pCentral;
	private GestionSeguridad seguridad;
	
	private Evento evento;
	public VentanaPrincipal() {
		//TODO Auto-generated constructor stub
		
		setSize(400,400);
		//TODO pasar a constante
		setTitle("Nomina");
		setLayout(new BorderLayout());
		
		//Inicializar relaciones o asociaciones
		evento = new Evento(this);
		pLogin=new PanelLogin(evento);
		pCentral= new PanelCentral();
		seguridad= new GestionSeguridad();
		add(pLogin,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		VentanaPrincipal v = new VentanaPrincipal();
		v.setVisible(Boolean.TRUE);
	}
	public void Loguear() {
		
		try {
			CredencialDto validar=pLogin.getCredencialesUsuario();
			
			if(validar!=null&&seguridad.validarLogueo(validar)) {
				pLogin.setVisible(Boolean.FALSE);
				add(pCentral,BorderLayout.CENTER);
				pCentral.setVisible(Boolean.TRUE);
			}else {
				JOptionPane.showInternalMessageDialog(this, " Usuario o contraseña no valido ");
			}
			
		} catch (Exception e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,e.getMessage());
		}
		
		
	}
	
}
