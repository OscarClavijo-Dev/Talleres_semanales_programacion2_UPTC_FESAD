package co.edu.uptc.nomina.modelo;

import java.util.ArrayList;
import java.util.List;

public class Nomina {
    private List<EmpleadoTerminoFijo> empleadosFijos;
    private List<EmpleadoTerminoIndefinido> empleadosIndefinido;

    public Nomina() {
        this.empleadosFijos = new ArrayList<>();
        this.empleadosIndefinido = new ArrayList<>();
    }

    public void agregarEmpleadoFijo(EmpleadoTerminoFijo empleado) {
        empleadosFijos.add(empleado);
    }

    public List<EmpleadoTerminoFijo> getEmpleadosFijos() {
        return empleadosFijos;
    }

    public List<EmpleadoTerminoIndefinido> getEmpleadosIndefinido() {
        return empleadosIndefinido;
    }

    public void setEmpleadosFijos(List<EmpleadoTerminoFijo> empleadosFijos) {
        this.empleadosFijos = empleadosFijos;
    }

    public void setEmpleadosIndefinido(List<EmpleadoTerminoIndefinido> empleadosIndefinido) {
        this.empleadosIndefinido = empleadosIndefinido;
    }
}