package Clases;

public class Canchas {
    private int idcancha;
    private String codigo;
    private String tipo;
    private double precioh;

    public Canchas(int idcancha, String codigo, String tipo, double precioh) {
        this.idcancha = idcancha;
        this.codigo = codigo;
        this.tipo = tipo;
        this.precioh = precioh;
    }

    public int getIdcancha() {
        return idcancha;
    }

    public void setIdcancha(int idcancha) {
        this.idcancha = idcancha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
