package co.edu.uptc.nomina.negocio;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.negocio.NominaConfig;
import java.util.List;

public class GestionEmpleadoFijo implements IGestionEmpleadoFijo {
	
    private IGestionEmpleadoFijo fijo;

    public void agregarEmpleado(EmpleadoTerminoFijo empleado) {
    	//TODO reglas de negocio
    	fijo.guardar(empleado);
    }

	public GestionEmpleadoFijo(IGestionEmpleadoFijo fijo) {
		super();
		this.fijo = fijo;
	}

	public List<EmpleadoTerminoFijo> listarEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}
	
//Los genere por que estaba dando un error
	
	@Override
	public void actualizar(EmpleadoTerminoFijo empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void guardar(EmpleadoTerminoFijo empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpleadoTerminoFijo buscar(long numeroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpleadoTerminoFijo> listar() {
		// TODO Auto-generated method stub
		return null;
	}
   
   
   
}