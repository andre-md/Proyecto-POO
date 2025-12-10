/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Clases.Reservas;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author carlo
 */
public class ReservasSQL {
    
    
    // INSERTAR RESERVA
    public boolean insertar(Reservas r){
        String sql = "INSERT INTO Reservas(idCliente, idCancha, horas, fecha, metodoPago, pagoTotal) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection con = ConexionSQL.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, r.getIdCliente());
            ps.setInt(2, r.getIdCancha());
            ps.setInt(3, r.getHoras());
            ps.setDate(4, Date.valueOf(r.getFechaReserva()));
            ps.setString(5, r.getMetodoPago());
            ps.setDouble(6, r.getPagototal());
            
            return ps.executeUpdate() > 0;
            
        } catch(SQLException e){
            System.out.println("Error insertando reserva: " + e.getMessage());
            return false;
        }
    }
    //LISTAR LAS RESERVAS
    public ArrayList<Reservas> listar(){
        ArrayList<Reservas> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reservas";
        
        try(Connection con = ConexionSQL.obtenerConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while(rs.next()){
                Reservas r = new Reservas(
                        rs.getInt("idReserva"),
                        rs.getInt("idCliente"),
                        rs.getInt("idCancha"),
                        rs.getInt("horas"),
                        rs.getString("metodoPago"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("pagoTotal")
                );
                
                lista.add(r);
            }
            
        } catch(SQLException e){
            System.out.println("Error listando reservas: " + e.getMessage());
        }
        
        return lista;
    }
}
