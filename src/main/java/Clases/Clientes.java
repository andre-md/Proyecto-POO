package Clases;

public class Clientes {
    
    private int idCliente;
    private String dni, nombres, telefono;

    public Clientes(int idCliente, String dni, String nombres, String telefono) {
        this.idCliente= idCliente;
        this.dni = dni;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
