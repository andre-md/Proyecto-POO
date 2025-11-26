package Clases;

public class Clientes {
    private String nombre, dni, telefono;

    public Clientes(String nombre, String dni, String telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(obj==null || getClass() != obj.getClass()) {
            return false;
        }
        Clientes cli= (Clientes)obj;
        return dni.equals(cli.dni);
    }
    
    public int hashCode(){
        return dni.hashCode();
    }
}
