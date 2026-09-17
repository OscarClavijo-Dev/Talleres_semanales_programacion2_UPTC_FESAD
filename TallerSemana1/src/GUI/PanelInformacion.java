package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelInformacion extends JPanel { 
    
  //Atributos cLASE (estaticos)
	
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelDocumento;
	private JLabel labelTipoDocumento;
	private JTextField textoNombres;
	private JTextField textoApellido;
	private JTextField textoDocumento;
	private JComboBox comboTipoDocumento;
	
	//METODOS CONSTRUCTORES
	
    
    public PanelInformacion() {
        // indica como se organizan los componentes
    	
    	setLayout(new GridLayout(2,4));
    	
    	//Inicializacion de los JLabel con titulos
    	
    	labelNombres = new JLabel("Nombres: ");
    	labelApellidos = new JLabel("Apellidos: ");
    	labelDocumento = new JLabel("Documento: ");
    	labelTipoDocumento = new JLabel("Tipo de Documento: ");
    	
    	//Inicializacion de los JTextFiel con sus titulos
    	
    	textoNombres = new JTextField("Escriba su Nombre: ");
    	textoApellido = new JTextField("");
    	textoDocumento = new JTextField("");
    	
    	//iNICIALIZACION JCombox 
    	
    	comboTipoDocumento = new JComboBox();
    	
    	//Agregacion de los items de JComboBox
    	
    	comboTipoDocumento.addItem("Cedula de Ciudadania");
    	comboTipoDocumento.addItem("Tarjeta de Identidad");
    	comboTipoDocumento.addItem("Cedula de Extranjeria");
    	comboTipoDocumento.addItem("Registro Civil");
    	
    	setBorder(new TitledBorder("Datos"));
    
    	//Se agregan componetnes al panel
    	
    	add(labelNombres);
    	add(textoNombres);
    	add(labelApellidos);
    	add(textoApellido);
    	add(labelTipoDocumento);
    	add(comboTipoDocumento);
    	add(labelDocumento);
    	add(textoDocumento);
    	
    }
}