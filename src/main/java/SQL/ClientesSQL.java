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
}
