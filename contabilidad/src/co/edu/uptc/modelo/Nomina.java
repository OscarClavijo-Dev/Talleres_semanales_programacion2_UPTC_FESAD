package co.edu.uptc.modelo;

import java.util.List;

public class Nomina {
	
	private List<EmpleadoTerminoFijo> empleadosFijos;
	
	private List<EmpleadoTerminoIndefinido> empleadosIndefinido;
	
	

	public List<EmpleadoTerminoFijo> getEmpleadosFijos() {
		return empleadosFijos;
	}

	public void setEmpleadosFijos(List<EmpleadoTerminoFijo> empleadosFijos) {
		this.empleadosFijos = empleadosFijos;
	}

	public List<EmpleadoTerminoIndefinido> getEmpleadosIndefinido() {
		return empleadosIndefinido;
	}

	public void setEmpleadosIndefinido(List<EmpleadoTerminoIndefinido> empleadosIndefinido) {
		this.empleadosIndefinido = empleadosIndefinido;
	}

	
	
}
