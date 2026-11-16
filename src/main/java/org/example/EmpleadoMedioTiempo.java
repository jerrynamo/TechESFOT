package org.example;


public class EmpleadoMedioTiempo extends Empleado {
    private double horasTrabajadas;
    private double pagoPorHora;

    public EmpleadoMedioTiempo(String codigo, String nombre, String apellido, String cargo, double horasTrabajadas, double pagoPorHora) {
        super(codigo, nombre, apellido, cargo, 0);
        this.horasTrabajadas = horasTrabajadas;
        this.pagoPorHora = pagoPorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getPagoPorHora() {
        return pagoPorHora;
    }

    @Override
    public double calcularSueldo() {
        return horasTrabajadas * pagoPorHora;
    }

    @Override
    public String toString() {
        return "[Medio tiempo]" + super.toString();
    }
}

