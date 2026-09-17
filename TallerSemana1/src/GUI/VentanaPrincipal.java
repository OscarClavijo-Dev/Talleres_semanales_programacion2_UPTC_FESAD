package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

//Ventana principal

public class VentanaPrincipal extends JFrame{
	
//ATRIBUTOS DE INSTANCIA
	private PanelInformacion informacion;
	
//ATRIBUTOS DE CLASE
	
	
	private JButton buttonAceptar;
	private JButton buttonCancelar;
	
//METODO CONSTRUCTOR
	
public VentanaPrincipal () {
	
	setSize(500, 150);
	setTitle("Datos Personales");
	setLayout(new BorderLayout());
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
	//inicializacion del panel de informacion
	informacion= new PanelInformacion();
	
	//Inicializacion de los botones, asignado un nombre
	buttonAceptar= new JButton("Aceptar");
	buttonCancelar= new JButton("Cancelar");
	
	//Se crea un panel auxiliar donde se alamcena los botones
	JPanel PanelBotones= new JPanel();
	JPanel panPrimer= new JPanel();
	
	
	
	//Se agregan los botones
	
	PanelBotones.add(buttonAceptar);
	PanelBotones.add(buttonCancelar);
	
	//Se agrega el panel a la ventana centro
	add(informacion,BorderLayout.CENTER);
	//panPrimer.setBorder(new TitledBorder("Botones"));
	
	//Se indica que el subpanel que contiene los botones estara ubicado
	// en la reigon sur de la ventana
	
	add(PanelBotones,BorderLayout.SOUTH);
		
	
}

	public static void main(String[] args) {
		//Crea una nueva ventana
		VentanaPrincipal venPrimaria= new VentanaPrincipal();
		venPrimaria.setVisible(true);
		
	}
	
}
   