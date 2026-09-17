package negocio;

import java.awt.*;
import javax.swing.*;

import persistencia.ArchivoPersona;

public class ControlPersonas {

	
	//ATRIBUTOS
	
	private ArchivoPersona archivo;
	private Persona[] personas;
	private int secuencia;
	private String separador;
	public final int TOTAL_PERSONAS = 100;
	
	
	//CONSTRUCTOR
	

	public ControlPersonas(Persona[] personas) {
		
	}
	
	
	// GETTERS
	public ArchivoPersona getArchivo() {
	    return archivo;
	}

	public Persona[] getPersonas() {
	    return personas;
	}

	public int getSecuencia() {
	    return secuencia;
	}

	public String getSeparador() {
	    return separador;
	}

	// SETTERS
	public void setArchivo(ArchivoPersona archivo) {
	    this.archivo = archivo;
	}

	public void setPersonas(Persona[] personas) {
	    this.personas = personas;
	}

	public void setSecuencia(int secuencia) {
	    this.secuencia = secuencia;
	}

	public void setSeparador(String separador) {
	    this.separador = separador;
	}
	
	
	
	//METODOS
	
	
	public void add(Persona persona) {
	   
	}

	
	public Persona getPersona(int posicion) {
	    return personas[posicion];
	}

	
	public void readArchivo(String nombre, String path) {
	   
	}

	
	public void writerArchivo(String nombre, String path, boolean modoEscritura) {
	  
	}
}
