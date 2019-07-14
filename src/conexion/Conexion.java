/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GerardoG
 */
public class Conexion {
    
    
    
    
    public static void main(String[] args) {
        
        close(getConnection());
        
    }
    
    public static Connection getConnection() {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");  
        	Connection con = DriverManager.getConnection(  
                    "jdbc:oracle:thin:@localhost:1521:XE", "RESTAURANTE_ORTIZ","1234");  
            
       
        	System.out.println("Conectado");
            return con;
           
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 

    public static void close(Connection con) {
        try {
            con.close();
            System.out.println("Cerrado");
        } catch (Exception ex) {
        }
    }
    
}

