package Clases;

public class Canchas {
    private String codigo,tipo;
    private double precioh;

    public Canchas(String codigo, String tipo, double precioh) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precioh = precioh;
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
    
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || getClass() != obj.getClass()) {
            return false;
        }
        Canchas can= (Canchas)obj;
        return codigo.equals(can.codigo);
    }
    
    public int hashCode(){
        return codigo.hashCode();
    }
}
