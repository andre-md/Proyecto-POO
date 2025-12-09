package SQL;

import Clases.Reservas;
import Clases.Canchas;
import Clases.Clientes;
import Clases.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class ReservasSQL {
    ConexionSQL c= new ConexionSQL();
    
    public boolean añadir(Reservas res, Clientes cli, Canchas can,Pago pag) {
        String insertarR = "INSERT INTO Reservas(idCliente, idCancha, horaInicio, horaFin,pagoTotal) values(?, ?, ?)";

        try (Connection con = c.obtenerConexion()){
            
            if (cruceHorario(con, can.getIdcancha(), res.getHorainicio(), res.getHorafin())) {
                System.out.println("La cancha ya está reservada en ese horario");
                return false;
            }
            
            PreparedStatement ps = con.prepareStatement(insertarR);
            ps.setInt(1, cli.getIdCliente());
            ps.setString(2, can.getIdcancha());
            ps.setTimestamp(3, Timestamp.valueOf(res.getHorainicio()));
            ps.setTimestamp(4, Timestamp.valueOf(res.getHorafin()));
            ps.setDouble(5, pag.getMonto());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo crear la reserva:( " + e.getMessage());
            return false;
        }
    }
    private boolean cruceHorario(Connection con, String idCancha, LocalDateTime inicioNuevo, LocalDateTime finNuevo) {
    String consulta = "SELECT COUNT(*) FROM reservas WHERE idCancha = ? AND " + "horalnico < ? AND horafin > ?";
    
    try (PreparedStatement ps = con.prepareStatement(consulta)) {
        ps.setString(1, idCancha);
        ps.setTimestamp(2, Timestamp.valueOf(finNuevo));    // horalnico < finNuevo
        ps.setTimestamp(3, Timestamp.valueOf(inicioNuevo)); // horafin > inicioNuevo
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;        }
    } catch (SQLException e) {
        System.out.println("Horario no disponible: " + e.getMessage());
    }
    return false;
    }
    
    public int limpiar() {
    // Elimina reservas que terminaron hace más de 24 horas
    String sql = "DELETE FROM reservas WHERE horaFin < DATE_SUB(NOW(), INTERVAL 1 DAY)";
    
    try (Connection con = c.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        int eliminadas = ps.executeUpdate();
        System.out.println("Se eliminaron " + eliminadas + " reservas vencidas (más de 24h)");
        return eliminadas;
        
    } catch (Exception e) {
        System.out.println("No se pudo eliminar ninguna reserva: " + e.getMessage());
        return 0;
    }
    }
    
    public boolean eliminar(int idReserva) {
        String sql = "DELETE FROM Reservas WHERE idReserva=?";

        try (Connection con = c.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idReserva);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando reserva: " + e.getMessage());
            return false;
        }
    }
}

