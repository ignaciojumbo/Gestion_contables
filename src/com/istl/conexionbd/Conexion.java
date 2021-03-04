
package com.istl.conexionbd;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private final String base = "bdEjercicio1";
    private final String user = "root";
    private final String password = "101219931";
    private final String url = "jdbc:mysql://Localhost:3306/" + base;
    

    public Connection getConexion() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        return con;
    }
    
}
