package co.edu.uptc.nomina.modelo;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<EmpleadoTerminoFijo> empleadosFijos;
    private List<EmpleadoTerminoIndefinido> empleadosIndefinido;
    
    
    public Nomina() {
    	super();
        empleadosIndefinido= new ArrayList<EmpleadoTerminoIndefinido>();
        empleadosFijos= new ArrayList<EmpleadoTerminoFijo>();
    }
    
    
    
    public List<EmpleadoTerminoFijo> getEmpleadosFijos() {
        return empleadosFijos;
    }
    
    
    public void setEmpleadosFijos(List<EmpleadoTerminoFijo> empleadosFijos) {
        this.empleadosFijos = empleadosFijos;
    }

   

    public void agregarEmpleadoFijo(EmpleadoTerminoFijo empleado) {
        empleadosFijos.add(empleado);
    }

    public void actualizarEmpleadoFijo(EmpleadoTerminoFijo fijoEdicion) {
    	EmpleadoTerminoFijo antiguo=buscarDocIdentidad(fijoEdicion.getNumDocumento());
    	empleadosFijos.remove(antiguo);
    	antiguo.setPrimerNombre(fijoEdicion.getPrimerNombre());
    	antiguo.setTipoDoc(fijoEdicion.getTipoDoc());
        empleadosFijos.add(antiguo);
    }


    public List<EmpleadoTerminoIndefinido> getEmpleadosIndefinido() {
        return empleadosIndefinido;
    }

   

    public void setEmpleadosIndefinido(List<EmpleadoTerminoIndefinido> empleadosIndefinido) {
        this.empleadosIndefinido = empleadosIndefinido;
    }
    
    public EmpleadoTerminoFijo buscarDocIdentidad(long numDocumento) {
    	if(EmpleadoTerminoFijo.getNumDocumento()==numDocumento) {
    		return EmpleadoTerminoFijo;
    	}
    }
    
}