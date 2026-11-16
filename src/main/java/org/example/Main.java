package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) {

        int opcion = 0;

        do {
            System.out.println("\n--- MENU DE EMPLEADOS ---");
            System.out.println("1. Registrar empleado tiempo completo");
            System.out.println("2. Registrar empleado medio tiempo");
            System.out.println("3. Mostrar empleados registrados");
            System.out.println("4. Mostrar estadisticas");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarTiempoCompleto();
                    break;
                case 2:
                    registrarMedioTiempo();
                    break;
                case 3:
                    mostrarEmpleados();
                    break;
                case 4:
                    mostrarEstadisticas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no invalida....");
            }
        } while (opcion != 5);
    }

    public static boolean codigoExiste(String codigo){
        for (Empleado empleado : empleados) {
            if (empleado.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }

    public static void registrarTiempoCompleto(){
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        if (codigoExiste(codigo)){
            System.out.println("El codigo ya esta registrado ");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Sueldo base: ");
        double sueldoBase = sc.nextDouble();
        sc.nextLine();

        System.out.print("Bono: ");
        double bono = sc.nextDouble();
        sc.nextLine();

        if (sueldoBase < 0 || bono < 0){
            System.out.println("El sueldo y el bono no pueden ser negativos");
            return;
        }

        Empleado empleado = new EmpleadoTiempoCompleto(codigo, nombre, apellido, cargo, sueldoBase, bono);
        empleados.add(empleado);

        System.out.println("Empleado tiempo completo registrado exitosamente");
    }

    public static void registrarMedioTiempo(){
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();

        if (codigoExiste(codigo)){
            System.out.println("El codigo ya esta registrado");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Cargo: ");
        String cargo = sc.nextLine();

        System.out.print("Horas trabajadas: ");
        double horas = sc.nextDouble();
        sc.nextLine();

        System.out.print("Pago por hora: ");
        double pagoPorHora = sc.nextDouble();
        sc.nextLine();

        if (horas < 0 || pagoPorHora < 0) {
            System.out.println("Las horas y el pago por hora no pueden ser negativos");
            return;
        }

        Empleado empleado = new EmpleadoMedioTiempo(codigo, nombre, apellido, cargo, horas, pagoPorHora);
        empleados.add(empleado);

        System.out.println("Empleado medio tiempo registrado exitosamente");
    }

    public static void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }

        System.out.println("\n- Lista de empelados registrados -");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }

    public static void mostrarEstadisticas(){
        if (empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
            return;
        }

        Empleado empleadoMayor = empleados.get(0);
        double sumaSueldos = 0;

        for (Empleado empleado : empleados) {
            double sueldo = empleado.calcularSueldo();
            sumaSueldos += sueldo;
            if (sueldo > empleadoMayor.calcularSueldo()) {
                empleadoMayor = empleado;
            }
        }

        double promedio = sumaSueldos / empleados.size();

        System.out.println("El empleado con mayor sueldo es: " + empleadoMayor.getNombre() + " " + empleadoMayor.getApellido());

        System.out.printf("El promedio salarial entre todos los empleados es: $%.2f%n", promedio);
    }
}
