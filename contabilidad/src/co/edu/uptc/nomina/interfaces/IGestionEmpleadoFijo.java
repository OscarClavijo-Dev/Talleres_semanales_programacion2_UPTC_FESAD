package co.edu.uptc.nomina.interfaces;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import java.util.List;

public interface IGestionEmpleadoFijo {
	
   public void actualizar(EmpleadoTerminoFijo empleado);
   public void eliminar(long idEmpleado);
   public void guardar(EmpleadoTerminoFijo empleado);
   public EmpleadoTerminoFijo buscar(Long numDocumento);
   public EmpleadoTerminoFijo buscar(long idEmpleado,Long numDocumento);
   
   public List<EmpleadoTerminoFijo> listar();
   EmpleadoTerminoFijo buscar(long numeroDocumento);
}