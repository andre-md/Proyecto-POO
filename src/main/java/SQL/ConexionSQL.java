package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class ConexionSQL {
    
        private static String url = "jdbc:mysql://localhost:3306/GestionCanchas";
        private static String user = "root";
        private static String password = "21122006";
        
        public static Connection obtenerConexion(){
            
            Connection con = null;
            
            try{
                con = DriverManager.getConnection(url, user, password);
            }catch(SQLException e){
                System.out.println("Error en la conexion:" + e.getMessage());
            }
            return con;
        }
        
        

}
