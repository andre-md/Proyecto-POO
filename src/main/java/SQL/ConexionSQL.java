/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        private static String password = "andre123";
        
        public static Connection obtenerConexion(){
            
            Connection con = null;
            
            try{
                con = DriverManager.getConnection(url, user, password);
            }catch(Exception e){
                System.out.println("Error en la conexion:" + e.getMessage());
            }
            return con;
        }
        
        

}
