package SQL;

import Clases.Canchas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CanchasSQL {

    //INSERTAR CANCHAS
    public boolean insertar(Canchas can) {
        String sql = "INSERT INTO Canchas(codigo, tipo, precioh) VALUES (?, ?, ?)";

        try (Connection con = ConexionSQL.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, can.getCodigo());
            ps.setString(2, can.getTipo());
            ps.setDouble(3, can.getPrecioh());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error insertando cancha: " + e.getMessage());
            return false;
        }
    }

    //SELECCIONAR TODAS LAS CANCHAS
    public ArrayList<Canchas> listar() {
        ArrayList<Canchas> lista = new ArrayList<>();
        String sql = "SELECT * FROM Canchas";

        try (Connection con = ConexionSQL.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Canchas can = new Canchas(
                        rs.getInt("idCancha"),
                        rs.getString("codigo"),
                        rs.getString("tipo"),
                        rs.getDouble("precioh")
                );

                lista.add(can);
            }

        } catch (SQLException e) {
            System.out.println("Error listando canchas: " + e.getMessage());
        }

        return lista;
    }

    //OBTENER CANCHAS POR NOMBRES
    public String obtenerNombreporID(int idCancha) {
        String sql = "SELECT tipo FROM Canchas WHERE idCancha = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); 
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCancha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("tipo");
            }

        } catch (SQLException e) {
            System.out.println("Error buscando cancha: " + e.getMessage());
        }

        return null;
    }

    
    
    public boolean actualizar(Canchas can) {
        String sql = "UPDATE Canchas SET tipo = ?, precioh = ? WHERE idCancha = ?";

        try (Connection con = ConexionSQL.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, can.getTipo());
            ps.setDouble(2, can.getPrecioh());
            ps.setInt(3, can.getIdcancha());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error actualizando cancha: " + e.getMessage());
            return false;
        }
    }
    
    public double obtenerPrecioPorId(int idCancha) {
        String sql = "SELECT precioh FROM Canchas WHERE idCancha = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCancha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("precioh");
            }

        } catch (SQLException e) {
            System.out.println("Error obteniendo precio: " + e.getMessage());
        }

        return 0;
    }


    public boolean eliminar(int idCancha) {
        String sql = "DELETE FROM Canchas WHERE idCancha = ?";

        try (Connection con = ConexionSQL.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCancha);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando cancha: " + e.getMessage());
            return false;
        }
    }
}
