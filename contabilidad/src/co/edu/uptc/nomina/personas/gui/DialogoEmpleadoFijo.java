package co.edu.uptc.nomina.personas.gui;

import javax.swing.JTextField;

import co.edu.uptc.nomina.gui.Evento;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;


public class DialogoEmpleadoFijo extends DialogoCentralPersona {
	
	private JTextField txtNumeroDocumento;  

	public DialogoEmpleadoFijo(Evento evento, String tituloDialogo, boolean isCrear) {
		super(evento, tituloDialogo, isCrear);
		// TODO Auto-generated constructor stub
	}

	public EmpleadoTerminoFijo capturarDatos() {
		EmpleadoTerminoFijo nuevo = new EmpleadoTerminoFijo();
		nuevo.setPrimerNombre(txtPrimerNombre.getText());
		nuevo.setTipoDoc((TipoDocEnum) cbxTipoDoc.getSelectedItem());
		return nuevo;
	}
	

	@Override
	public void asignarComandoBotones() {
		// TODO Auto-generated method stub
		
		if(isCrear) {
			btnGuardar.setActionCommand(Evento.GUARDAR_EF);
		} else {
			btnGuardar.setActionCommand(Evento.EDITAR_EF);
		}
		
	}
	
	public void actualizarCampos(EmpleadoTerminoFijo fijoNuevo) {
		txtPrimerNombre.setText(fijoNuevo.getPrimerNombre());
		txtNumeroDocumento.setText(fijoNuevo.getNumDocumento);
		//TODOS campos adicionales
	}
	
	
   
}