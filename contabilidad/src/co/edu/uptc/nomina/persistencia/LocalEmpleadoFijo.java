package co.edu.uptc.nomina.persistencia;

import java.util.List;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.Nomina;

public class LocalEmpleadoFijo implements IGestionEmpleadoFijo {
	
	private Nomina nomina;
	
	
	public LocalEmpleadoFijo() {
		super();
		// TODO Auto-generated constructor stub
		nomina= new Nomina();
	}

	@Override
	public void guardar(EmpleadoTerminoFijo empleado) {
		// TODO Auto-generated method stub
		nomina.agregarEmpleadosFijo(empleado);
	}

	@Override
	public void actualizar(EmpleadoTerminoFijo empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long idEmpelado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmpleadoTerminoFijo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
