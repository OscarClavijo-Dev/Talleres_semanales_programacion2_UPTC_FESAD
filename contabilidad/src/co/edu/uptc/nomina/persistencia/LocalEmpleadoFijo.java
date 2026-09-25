package co.edu.uptc.nomina.persistencia;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.Nomina;
import java.util.ArrayList;
import java.util.List;

public class LocalEmpleadoFijo implements IGestionEmpleadoFijo {
	
    private Nomina nomina;

    public LocalEmpleadoFijo() {
    	super();
    	
        nomina = new Nomina();
    }

    @Override
    public void guardar(EmpleadoTerminoFijo empleado) {
        nomina.agregarEmpleadoFijo(empleado);
    }
    
    @Override
    public void actualizar(EmpleadoTerminoFijo empleado) {
        nomina.actualizarEmpleadoFijo(empleado);
    }

    @Override
    public void eliminar(long id) {
        
    }

    @Override
    public List<EmpleadoTerminoFijo> listar() {
        return nomina.getEmpleadosFijos();
    }

	@Override
	public EmpleadoTerminoFijo buscar(long numeroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoTerminoFijo buscar(Long numDocumento) {
		return nomina.buscarDocIdentidad(numDocumento);
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmpleadoTerminoFijo buscar(long idEmpleado, Long numDocumento) {
		return null;
		// TODO Auto-generated method stub
		
	}


}