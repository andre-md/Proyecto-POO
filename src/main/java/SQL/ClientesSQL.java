package SQL;

import Clases.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesSQL {
    ConexionSQL cd=new ConexionSQL();
    public boolean insertar(Clientes cli){
        String sql = "INSERT INTO Clientes(dni, nombres, telefono) values(?, ?, ?)";
        try (Connection con = cd.obtenerConexion()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getTelefono());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo insertar el cliente" + e.getMessage());
            return false;
        } 
    }
    public ArrayList<Clientes> listar() {
        ArrayList<Clientes> lista = new ArrayList<>();
        String mostrarC = "SELECT * FROM Clientes";
        try (Connection con = cd.obtenerConexion()){
            PreparedStatement ps = con.prepareStatement(mostrarC); 
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes ce=new Clientes(rs.getInt("idCliente"),rs.getString("dni"), rs.getString("nombres"), rs.getString("telefono"));
                lista.add(ce);
            }
        } catch (SQLException e) {
            System.out.println("Error listando clientes: " + e.getMessage());
        }

        return lista;
    }
    public Clientes buscar(String dni) {
        String sql = "SELECT * FROM Clientes WHERE dni = ?";

        try (Connection con =cd.obtenerConexion()){
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Clientes(
                        rs.getInt("idCliente"),
                        rs.getString("dni"),
                        rs.getString("nombres"),
                        rs.getString("telefono")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando Cliente: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizar(Clientes cli) {
        String sql = "UPDATE Clientes SET nombres = ?, telefono = ? WHERE dni = ?";

        try (Connection con = cd.obtenerConexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getTelefono());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String dni) {
        String sql = "DELETE FROM Clientes WHERE dni = ?";

        try (Connection con = cd.obtenerConexion())  {
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando cancha: " + e.getMessage());
            return false;
        }
    }
}
