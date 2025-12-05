package Clases;

import java.time.LocalDateTime;

public class Reservas {
    private String idreserva;
    private String dni;
    private String idcancha;
    private LocalDateTime horainicio; 
    private LocalDateTime horafin; 
    private double pagototal;

    public Reservas(String idreserva, String dni, String idcancha, LocalDateTime horainicio, LocalDateTime horafin, double pagototal) {
        this.idreserva = idreserva;
        this.dni = dni;
        this.idcancha = idcancha;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.pagototal = pagototal;
    }

    public String getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(String idreserva) {
        this.idreserva = idreserva;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(String idcancha) {
        this.idcancha = idcancha;
    }

    public LocalDateTime getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(LocalDateTime horainicio) {
        this.horainicio = horainicio;
    }

    public LocalDateTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalDateTime horafin) {
        this.horafin = horafin;
    }

    public double getPagototal() {
        return pagototal;
    }

    public void setPagototal(double pagototal) {
        this.pagototal = pagototal;
    }

    public String mostrarInfo(){
        return "Reserva #: " + idreserva +
               " Cliente: " + dni + 
               " Cancha: " + idcancha +
               " Inicio: " + horainicio +
               " fin: " + horafin +
               " Pago Total: " + pagototal;
    }
}
