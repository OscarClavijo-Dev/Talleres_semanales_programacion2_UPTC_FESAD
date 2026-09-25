package co.edu.uptc.nomina.personas.gui;

import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class DialogoCentralPersona extends JDialog {
	
	protected boolean isCrear;
	protected String tituloDialogo;
	protected JTextField txtPrimerNombre;
	protected JComboBox<TipoDocEnum> cbxTipoDoc;
	protected JButton btnGuardar;
    protected JButton btnCerrar;
    
    


    public DialogoCentralPersona(Evento evento, String tituloDialogo, boolean isCrear) {
        
    	this.isCrear=isCrear;
    	setSize(250, 250);
    	setTitle(tituloDialogo);
    	setLayout(new BorderLayout());
    	cbxTipoDoc = new JComboBox<TipoDocEnum>(TipoDocEnum.values());
    	txtPrimerNombre = new JTextField();
    	JPanel pEmpleadoPadre = new JPanel();
    	JPanel pEmpleado = new JPanel();
    	pEmpleado.setLayout(new GridLayout(2, 6));
    	pEmpleado.add(new JLabel("Nombre"));
    	pEmpleado.add(txtPrimerNombre);
    	pEmpleado.add(new JLabel("Tipo Documento"));
    	pEmpleado.add(cbxTipoDoc);
    	
    	pEmpleadoPadre.add(pEmpleado);
    	if(isCrear) {
    		btnGuardar = new JButton(Evento.GUARDAR);
    		
    		
    	} else {
    		btnGuardar = new JButton(Evento.EDITAR);
    	}
    	
    	btnCerrar= new JButton(Evento.CANCELAR);
    	
    	btnGuardar.addActionListener(evento);
    	btnCerrar.addActionListener(evento);
    	btnCerrar.setActionCommand(Evento.CANCELAR_EF);
    	
    	JPanel pBotones = new JPanel();
    	pBotones.add(btnCerrar);
    	pBotones.add(btnGuardar);
    	
    	add(pEmpleadoPadre, BorderLayout.CENTER);
    	add(pBotones, BorderLayout.SOUTH);
    	
    	asignarComandoBotones();
    	
    }

   
   public abstract void asignarComandoBotones();
}