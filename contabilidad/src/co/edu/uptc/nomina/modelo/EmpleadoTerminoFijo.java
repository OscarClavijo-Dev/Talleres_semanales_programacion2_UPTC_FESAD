package co.edu.uptc.nomina.modelo;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;
import java.time.LocalDate;

public class EmpleadoTerminoFijo extends Empleado {
    private LocalDate fechaTerminacionContrato;

    public EmpleadoTerminoFijo() {
    }

    public EmpleadoTerminoFijo(long id, String primerNombre, String primerApellido,
                                TipoDocEnum tipoDoc, double salarioBase, double diasTrabajados,
                                LocalDate fechaTerminacionContrato) {
        super(id, primerNombre, primerApellido, tipoDoc, salarioBase, diasTrabajados);
        this.fechaTerminacionContrato = fechaTerminacionContrato;
    }

    @Override
    public double calcularSalario() {
        return (salarioBase * diasTrabajados) / 30;
    }

    public LocalDate getFechaTerminacionContrato() {
        return fechaTerminacionContrato;
    }

    public void setFechaTerminacionContrato(LocalDate fechaTerminacionContrato) {
        this.fechaTerminacionContrato = fechaTerminacionContrato;
    }

    @Override
    public String toString() {
        return "Empleado Fijo: " + getPrimerNombre() + " " + getPrimerApellido() + 
               " - Salario: $" + String.format("%.2f", calcularSalario());
    }
}