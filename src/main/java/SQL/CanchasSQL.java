package SQL;

import Clases.Canchas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CanchasSQL {

    public boolean insertar(Canchas can) {

        String sql = "INSERT INTO Canchas(codigo, tipo, precioh) values(?, ?, ?)";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, can.getIdcancha());
            ps.setString(2, can.getTipo());
            ps.setDouble(3, can.getPrecioh());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("No se pudo insertar la cancha" + e.getMessage());
            return false;
        }
    }

    public ArrayList<Canchas> listar() {
        ArrayList<Canchas> lista = new ArrayList<>();
        String sql = "SELECT * FROM Canchas";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Canchas can = new Canchas(rs.getString("Codigo"), rs.getString("Tipo"), rs.getDouble("Precioh"));
                lista.add(can);
            }

        } catch (SQLException e) {
            System.out.println("Error listando clientes: " + e.getMessage());
        }

        return lista;
    }

    public Canchas buscar(String codigo) {
        String sql = "SELECT * FROM Canchas WHERE codigo = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Canchas(
                        rs.getString("codigo"),
                        rs.getString("tipo"),
                        rs.getDouble("precioh")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando cancha: " + e.getMessage());
        }

        return null;
    }

    public boolean actualizar(Canchas can) {
        String sql = "UPDATE Canchas SET tipo = ?, precioh = ? WHERE codigo = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, can.getTipo());
            ps.setDouble(2, can.getPrecioh());
            ps.setString(3, can.getIdcancha());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error actualizando cancha: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String codigo) {
        String sql = "DELETE FROM Canchas WHERE codigo = ?";

        try (Connection con = ConexionSQL.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, codigo);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error eliminando cancha: " + e.getMessage());
            return false;
        }
    }

}
