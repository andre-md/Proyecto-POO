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
    
    public boolean crear(Reservas res, Clientes cli, Canchas can,Pago pag) {
        String insertarR = "INSERT INTO Reservas(idReserva, idCliente, idCancha, horaInicio, horaInicio,pagoTotal) values(?, ?, ?)";

        try (Connection con = c.obtenerConexion()){
            
            if (cruceHorario(con, can.getIdcancha(), res.getHorainicio(), res.getHorafin())) {
                System.out.println("Error: La cancha ya está reservada en ese horario");
                return false;
            }
            
            PreparedStatement ps = con.prepareStatement(insertarR);
            ps.setString(1,res.getIdreserva());
            ps.setInt(2, cli.getIdCliente());
            ps.setString(3, can.getIdcancha());
            ps.setTimestamp(4, Timestamp.valueOf(res.getHorainicio()));
            ps.setTimestamp(5, Timestamp.valueOf(res.getHorafin()));
            ps.setDouble(6, pag.getMonto());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo crear la reserva:( " + e.getMessage());
            return false;
        }
    }
     private boolean cruceHorario(Connection con, String idCancha, LocalDateTime inicioNuevo, LocalDateTime finNuevo) {
    String consulta = "SELECT COUNT(*) FROM reservas WHERE idCancha = "+ idCancha +" AND horalnico < "+finNuevo+" AND horaFin > "+inicioNuevo+";";
    
    try (PreparedStatement ps = con.prepareStatement(consulta)) {
        ps.setString(1, idCancha);
        ps.setTimestamp(2, Timestamp.valueOf(finNuevo));    // horalnico < finNuevo
        ps.setTimestamp(3, Timestamp.valueOf(inicioNuevo)); // horafin > inicioNuevo
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        System.out.println("Horario no disponible: " + e.getMessage());
    }
    return false;
}
}

