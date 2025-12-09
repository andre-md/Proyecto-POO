package Clases;

public class Canchas {
    private String idcancha,tipo;
    private double precioh;

    public Canchas(String idcancha, String tipo, double precioh) {
        this.idcancha = idcancha;
        this.tipo = tipo;
        this.precioh = precioh;
    }

    public String getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(String idcancha) {
        this.idcancha = idcancha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioh() {
        return precioh;
    }

    public void setPrecioh(double precioh) {
        this.precioh = precioh;
    }
       
}
