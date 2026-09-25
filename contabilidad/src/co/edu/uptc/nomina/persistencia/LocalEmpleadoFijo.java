package co.edu.uptc.nomina.persistencia;

import co.edu.uptc.nomina.interfaces.IGestionEmpleadoFijo;
import co.edu.uptc.nomina.modelo.EmpleadoTerminoFijo;
import co.edu.uptc.nomina.modelo.Nomina;
import java.util.ArrayList;
import java.util.List;

public class LocalEmpleadoFijo implements IGestionEmpleadoFijo {
    private Nomina nomina;

    public LocalEmpleadoFijo() {
        this.nomina = new Nomina();
    }

    @Override
    public void actualizar(EmpleadoTerminoFijo empleado) {
        // Implementación en memoria - buscar y actualizar
        List<EmpleadoTerminoFijo> empleados = nomina.getEmpleadosFijos();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId() == empleado.getId()) {
                empleados.set(i, empleado);
                break;
            }
        }
    }

    @Override
    public void eliminar(long id) {
        List<EmpleadoTerminoFijo> empleados = nomina.getEmpleadosFijos();
        empleados.removeIf(emp -> emp.getId() == id);
    }

    @Override
    public void guardar(EmpleadoTerminoFijo empleado) {
        nomina.agregarEmpleadoFijo(empleado);
    }

    @Override
    public List<EmpleadoTerminoFijo> listar() {
        return nomina.getEmpleadosFijos();
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }
}