package co.edu.uptc.nomina.negocio;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.persistencia.LocalEmpleadoFijo;

public class NominaConfig {

	//Inicialziar negocio
	
	private GestionEmpleadoFijo gestEmpleadoFijo;
	
	
	private IGestionEmpleadoFijo iFijo;


	public NominaConfig() {
		super();
		// TODO Auto-generated constructor stub
		iFijo= new LocalEmpleadoFijo();
		gestEmpleadoFijo= new GestionEmpleadoFijo(iFijo);
	}

	//Getters and Setters

	public GestionEmpleadoFijo getGestEmpleadoFijo() {
		return gestEmpleadoFijo;
	}


	public void setGestEmpleadoFijo(GestionEmpleadoFijo gestEmpleadoFijo) {
		this.gestEmpleadoFijo = gestEmpleadoFijo;
	}


	public IGestionEmpleadoFijo getiFijo() {
		return iFijo;
	}


	public void setiFijo(IGestionEmpleadoFijo iFijo) {
		this.iFijo = iFijo;
	}
	
	
}
