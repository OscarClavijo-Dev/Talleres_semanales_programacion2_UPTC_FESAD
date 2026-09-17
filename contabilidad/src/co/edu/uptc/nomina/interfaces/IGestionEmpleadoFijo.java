package co.edu.uptc.nomina.interfaces;

import java.util.List;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;

public interface IGestionEmpleadoFijo {

	public void guardar(EmpleadoTerminoFijo empleado);
	
	public void actualizar(EmpleadoTerminoFijo empleado);
	
	public void eliminar(Long idEmpelado);
	
	public List<EmpleadoTerminoFijo> listar();
}