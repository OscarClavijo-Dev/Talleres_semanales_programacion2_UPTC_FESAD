package co.edu.uptc.nomina.interfaces;

import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import java.util.List;

public interface IGestionEmpleadoFijo {
    void actualizar(EmpleadoTerminoFijo empleado);
    void eliminar(long id);
    void guardar(EmpleadoTerminoFijo empleado);
    EmpleadoTerminoFijo buscar(long numeroDocumento);
    List<EmpleadoTerminoFijo> listar();
}