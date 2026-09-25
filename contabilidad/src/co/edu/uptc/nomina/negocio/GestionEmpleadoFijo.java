package co.edu.uptc.nomina.negocio;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import java.util.List;

public class GestionEmpleadoFijo implements IGestionEmpleadoFijo {
    private IGestionEmpleadoFijo fijo;

    public GestionEmpleadoFijo() {
        this.fijo = new co.edu.uptc.nomina.persistencia.LocalEmpleadoFijo();
    }

    @Override
    public void actualizar(EmpleadoTerminoFijo empleado) {
        fijo.actualizar(empleado);
    }

    @Override
    public void eliminar(long id) {
        fijo.eliminar(id);
    }

    @Override
    public void guardar(EmpleadoTerminoFijo empleado) {
        fijo.guardar(empleado);
    }

    @Override
    public List<EmpleadoTerminoFijo> listar() {
        return fijo.listar();
    }

    public void agregarEmpleado(EmpleadoTerminoFijo empleado) {
        guardar(empleado);
    }

    public List<EmpleadoTerminoFijo> listarEmpleados() {
        return listar();
    }

    public IGestionEmpleadoFijo getFijo() {
        return fijo;
    }

    public void setFijo(IGestionEmpleadoFijo fijo) {
        this.fijo = fijo;
    }
}