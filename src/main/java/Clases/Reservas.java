package Clases;

import java.time.LocalDate;

public class Reservas {
    private int idReserva;
    private int idCliente;
    private int idCancha;
    private int horas;
    private String metodoPago;
    private LocalDate fechaReserva;
    private double pagototal;

    public Reservas(int idReserva, int idCliente, int idCancha, int horas, String metodoPago, LocalDate fechaReserva, double pagototal) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idCancha = idCancha;
        this.horas = horas;
        this.metodoPago = metodoPago;
        this.fechaReserva = fechaReserva;
        this.pagototal = pagototal;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCancha() {
        return idCancha;
    }

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getPagototal() {
        return pagototal;
    }

    public void setPagototal(double pagototal) {
        this.pagototal = pagototal;
    }

    
}
