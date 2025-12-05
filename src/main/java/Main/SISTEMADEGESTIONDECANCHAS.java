package Main;

import GUI.MenuPrincipal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carlo
 */
public class SISTEMADEGESTIONDECANCHAS {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/GestionCanchas";
        String user = "root";
        String password = "andre123";
        
        try{
           Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");
        } catch(SQLException e){
            System.out.println("Error en la conexion: " + e.getMessage());
        }
        
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
        m.setLocationRelativeTo(null);
    }
}
