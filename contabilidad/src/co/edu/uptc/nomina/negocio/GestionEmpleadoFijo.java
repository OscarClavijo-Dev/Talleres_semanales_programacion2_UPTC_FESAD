package co.edu.uptc.nomina.negocio;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;

public class GestionEmpleadoFijo {
	
	private IGestionEmpleadoFijo fijo;
	
	
	
	public GestionEmpleadoFijo(IGestionEmpleadoFijo fijo) {
		super();
		this.fijo = fijo;
	}



	public void  agregarEmpleado(EmpleadoTerminoFijo empleado) {
		//TODO reglas de negocio
		fijo.guardar(empleado);
	}
}
