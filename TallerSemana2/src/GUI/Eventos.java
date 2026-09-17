package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eventos implements ActionListener {
	
	//ATRIBUTOS
	public static final String ABRIR = "Abrir";
	public static final String AGREGAR = "Agregar";
	public static final String ANTERIOR = "Anterior";
	public static final String GUARDAR = "Guardar";
	public static final String LIMPIAR = "Limpiar";
	public static final String SALIR = "Salir";
	public static final String SIGUIENTE = "Siguiente";
	
	private VentanaPrincipal ventana;

	//CONSTRUCTOR
	
	public Eventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	
	//METODOS
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
