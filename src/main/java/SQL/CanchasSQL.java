package SQL;

import Clases.Canchas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CanchasSQL {
    ConexionSQL c= new ConexionSQL();
    public boolean insertar(Canchas can) {
        String insertarC = "INSERT INTO Canchas(codigo, tipo, precioh) values(?, ?, ?)";

        try (Connection con = c.obtenerConexion()){
            PreparedStatement ps = con.prepareStatement(insertarC);
            ps.setString(1, can.getIdcancha());
            ps.setString(2, can.getTipo());
            ps.setDouble(3, can.getPrecioh());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("No se pudo insertar la cancha :( " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Canchas> listar(){
        ArrayList<Canchas> lista = new ArrayList<>();
        String mostrarP="Select * from Canchas";
        
        try(Connection cn=c.obtenerConexion()){
            PreparedStatement ps=cn.prepareStatement(mostrarP);
            ResultSet re=ps.executeQuery();
            while(re.next()){
                Canchas ce=new Canchas(re.getString("codigo"), re.getString("tipo"), re.getDouble("precioh"));
                lista.add(ce);
            }
        }catch(SQLException e){
            System.out.println("Error al mostrar la tabla de Canchas: "+e.getMessage());
        }
        return lista;
    }

    public Canchas buscar(String codigo) {
        String sql = "SELECT * FROM Canchas WHERE codigo = ?";

        try (Connection con =c.obtenerConexion()){
            PreparedStatement ps = con.prepareStatement(sql);

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

        try (Connection con = c.obtenerConexion()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, can.getTipo());
            ps.setDouble(2, can.getPrecioh());
            ps.setString(3, can.getIdcancha());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando cancha: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(String codigo) {
        ConexionSQL cs=new ConexionSQL();
        String sql = "DELETE FROM Canchas WHERE codigo = ?";

        try (Connection con = cs.obtenerConexion())  {
        PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando cancha: " + e.getMessage());
            return false;
        }
    }

}
