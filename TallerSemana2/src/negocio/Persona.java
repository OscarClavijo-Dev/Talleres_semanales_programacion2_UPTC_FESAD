package negocio;

import java.awt.*;
import javax.swing.*;

public class Persona {

	//ATRIBUTOS
	private String apellidos;
	private int codigo;
	private String nombres;
	
	
	//CONSTRUCTOR
	public Persona() {
		
	}


	//SETTER & GETTERS
	
	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
}
