/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author carlo
 */
public class Pago {
    private int idpago;
    private String idreserva;
    private double monto;
    private String metodoPago;
    private LocalDate fechapago;
    private String estado;
    private String observacion;

    public Pago(int idpago, String idreserva, double monto, String metodoPago, LocalDate fechapago, String estado, String observacion) {
        this.idpago = idpago;
        this.idreserva = idreserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechapago = fechapago;
        this.estado = estado;
        this.observacion = observacion;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(String idreserva) {
        this.idreserva = idreserva;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDate getFechapago() {
        return fechapago;
    }

    public void setFechapago(LocalDate fechapago) {
        this.fechapago = fechapago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public String mostrarInfo() {
        return "Pago: " +
                "ID=" + idpago +
                ", Reserva=" + idreserva +
                ", Monto=" + monto +
                ", Método=" + metodoPago +
                ", Fecha=" + fechapago +
                ", Estado=" + estado +
                ", Observaciones=" + observacion + "\n";
    }
}
