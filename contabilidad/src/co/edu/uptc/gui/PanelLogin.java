package co.edu.uptc.gui;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import co.edu.uptc.negocio.dto.CredencialDto;


public class PanelLogin extends JPanel{

	private JTextField txUsuario;
	private JPasswordField pfcontrasenia;
	
	public PanelLogin(Evento e) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(4,1,10,10));
		
		
		//inicializar
		txUsuario = new JTextField();
		
		pfcontrasenia = new JPasswordField();
		
		JPanel tempo = new JPanel();
		
		JButton btnCancelar = new JButton(Evento.CANCELAR);
		btnCancelar.addActionListener(e);
		btnCancelar.setActionCommand(Evento.CANCELAR);
		
		JButton btnLogin = new JButton(Evento.LOGIN);
		btnLogin.addActionListener(e);
		btnLogin.setActionCommand(Evento.LOGIN);
		
		
		tempo.add(btnCancelar);
		tempo.add(new JButton(Evento.LOGIN));
		JLabel lbIniciar = new JLabel("Iniciar Sesión");
		lbIniciar.setHorizontalAlignment(JLabel.CENTER);
		
		//agregar a componente
		subPanel.add(lbIniciar);
		subPanel.add(txUsuario );
		subPanel.add(pfcontrasenia);
		subPanel.add(tempo);
		
		add(subPanel);
	}
	
	public CredencialDto getCredencialesUsuario() {
		
		CredencialDto nuevo =new CredencialDto();
		String usuario=txUsuario.getText();
		if(usuario!=null && usuario.isBlank()) {
			nuevo.setUsuario(usuario);
	
		//nuevo.setUsuario(txUsuario.getText());
		nuevo.setPasword(pfcontrasenia.getText().getBytes());
		//TODO por hacer
		return nuevo;
		}else {
			JOptionPane.showMessageDialog(this, " El campo usuario debe ser diligenciado");
		}
		return null;
	}
	
}
