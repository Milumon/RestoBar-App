package com.isil.restaurant.model;

public class Employee {

    String idempleado;
    String apellidos;
    String nombres;
    String cargo;
    String fechanacimiento;

    public Employee(String idempleado, String apellidos, String nombres, String cargo, String fechanacimiento) {
        this.idempleado = idempleado;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.cargo = cargo;
        this.fechanacimiento = fechanacimiento;
    }

    public String getID() {
        return idempleado;
    }
    public void setID(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getfecha() {
        return fechanacimiento;
    }
    public void setfechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

}
