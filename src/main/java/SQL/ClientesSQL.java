/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.Clientes;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author carlo
 */
public class ClientesSQL {
    
    //INSERTAR NUEVO CLIENTE
    public boolean insertar(Clientes cli){
        
        String sql = "INSERT INTO Clientes(dni, nombres, telefono) values(?, ?, ?)";
        
        try (Connection con = ConexionSQL.obtenerConexion(); 
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getTelefono());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("No se pudo insertar el cliente" + e.getMessage());
            return false;
        } 
    }
    
    //LISTAR TODOS LOS CLIENTES
    public ArrayList<Clientes> listar() {
        ArrayList<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Connection con = ConexionSQL.obtenerConexion(); 
            PreparedStatement ps = con.prepareStatement(sql); 
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Clientes cli = new Clientes(
                        rs.getInt("idCliente"),
                        rs.getString("dni"),
                        rs.getString("nombres"),
                        rs.getString("telefono")
                );
                lista.add(cli);
            }

        } catch (SQLException e) {
            System.out.println("Error listando clientes: " + e.getMessage());
        }

        return lista;
    }
    
    //OBTENER NOMBRES DE LOS CLIENTES
    public String obtenerNombrePorId(int idCliente) {
        String sql = "SELECT nombres FROM Clientes WHERE idCliente = ?";
        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nombres");
            }

        } catch (Exception e) {
            System.out.println("Error obteniendo nombre: " + e.getMessage());
        }
        return "";
    }
    
    //ELIMINAR CLIENTES
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM Clientes WHERE idCliente = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando cliente: " + e.getMessage());
            return false;
        }
    }
}
