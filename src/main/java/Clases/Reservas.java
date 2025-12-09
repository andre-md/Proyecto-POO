package Clases;

import java.time.LocalDateTime;

public class Reservas {
    private int idreserva;
    private String dni;
    private String idcancha;
    private LocalDateTime horainicio; 
    private LocalDateTime horafin; 
    private double pagototal;
    private int horas;

    public Reservas(int idreserva, String dni, String idcancha, LocalDateTime horainicio, LocalDateTime horafin, double pagototal, int horas) {
        this.idreserva = idreserva;
        this.dni = dni;
        this.idcancha = idcancha;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.pagototal = pagototal;
        this.horas = horas;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
    

    
}
