package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionSQL {
    
        private static String url = "jdbc:mysql://localhost:3306/GestionCanchas";
        private static String user = "root";
        private static String password = "admin";
        
        public Connection obtenerConexion(){
            try{
                return DriverManager.getConnection(url, user, password);
            }catch(SQLException e){
                System.out.println("Error en la conexion con la base de datos: "+url+ e.getMessage());
                return null;
            }
        }
}
