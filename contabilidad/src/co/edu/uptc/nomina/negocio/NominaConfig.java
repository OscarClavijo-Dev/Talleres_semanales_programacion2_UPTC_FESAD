package co.edu.uptc.nomina.negocio;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.negocio.GestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.persistencia.LocalEmpleadoFijo;
import java.util.List;

public class NominaConfig {
    private GestionEmpleadoFijo gestEmpleadoFijo;
    private IGestionEmpleadoFijo iFijo;

    public NominaConfig() {
    	super();
        //TODO Auto-generated constructor stub
    	iFijo= new LocalEmpleadoFijo();
    	gestEmpleadoFijo= new GestionEmpleadoFijo(iFijo);
    }

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

    public List<EmpleadoTerminoFijo> listarEmpleados() {
        return gestEmpleadoFijo.listarEmpleados();
    }

    public void agregarEmpleadoFijo(EmpleadoTerminoFijo empleado) {
        gestEmpleadoFijo.agregarEmpleado(empleado);
    }
}