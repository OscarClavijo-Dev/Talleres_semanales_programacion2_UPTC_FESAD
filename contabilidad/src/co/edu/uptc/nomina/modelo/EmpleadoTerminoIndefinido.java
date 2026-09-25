package co.edu.uptc.nomina.modelo;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;

public class EmpleadoTerminoIndefinido extends Empleado {
    private String horarioTrabajo;

    public EmpleadoTerminoIndefinido() {
    }

    public EmpleadoTerminoIndefinido(long id, String primerNombre, String primerApellido,
                                      TipoDocEnum tipoDoc, double salarioBase, double diasTrabajados,
                                      String horarioTrabajo) {
        super();
        this.horarioTrabajo = horarioTrabajo;
    }

    @Override
    public double calcularSalario() {
        return (salarioBase * diasTrabajados) / 30;
    }

    public String getHorarioTrabajo() {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(String horarioTrabajo) {
        this.horarioTrabajo = horarioTrabajo;
    }

    @Override
    public String toString() {
        return "Empleado Indefinido: " + getPrimerNombre() + " " + getPrimerApellido() + 
               " - Horario: " + horarioTrabajo;
    }
}