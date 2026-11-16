package org.example;

public class EmpleadoTiempoCompleto extends Empleado {
    private double bono;
    public EmpleadoTiempoCompleto(String codigo, String nombre, String apellido, String cargo, double sueldoBase, double bono) {
        super(codigo, nombre, apellido, cargo, sueldoBase);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    @Override
    public double calcularSueldo() {
        return getSueldoBase() + bono;
    }

    @Override
    public String toString() {
        return "[Tiempo completo] " + super.toString();
    }
}
