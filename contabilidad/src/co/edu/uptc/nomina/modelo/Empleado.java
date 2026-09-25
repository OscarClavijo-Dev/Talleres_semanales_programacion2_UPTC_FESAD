package co.edu.uptc.nomina.modelo;

import co.edu.uptc.nomina.modelo.enums.TipoDocEnum;

public abstract class Empleado extends Persona {
    protected double salarioBase;
    protected double diasTrabajados;

    public Empleado() {
    }

    public Empleado(long id, String primerNombre, String primerApellido, 
                    TipoDocEnum tipoDoc, double salarioBase, double diasTrabajados) {
        super(id, primerNombre, primerApellido, tipoDoc);
        this.salarioBase = salarioBase;
        this.diasTrabajados = diasTrabajados;
    }

    public abstract double calcularSalario();

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(double diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }
}