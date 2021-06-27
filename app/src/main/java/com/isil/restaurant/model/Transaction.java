package com.isil.restaurant.model;

public class Transaction {

    String idmovimiento;
    String fecha;
    String descripcion;
    String monto;
    String movimiento;

    public Transaction() {
    }

    public Transaction(String idmovimiento, String fecha, String descripcion, String monto, String movimiento) {
        this.idmovimiento = idmovimiento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.movimiento = movimiento;
    }

    public String getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(String idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
}
