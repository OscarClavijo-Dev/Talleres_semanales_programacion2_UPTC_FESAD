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

 

    public List<EmpleadoTerminoIndefinido> getEmpleadosIndefinido() {
        return empleadosIndefinido;
    }

   

    public void setEmpleadosIndefinido(List<EmpleadoTerminoIndefinido> empleadosIndefinido) {
        this.empleadosIndefinido = empleadosIndefinido;
    }
}