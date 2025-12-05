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
}
