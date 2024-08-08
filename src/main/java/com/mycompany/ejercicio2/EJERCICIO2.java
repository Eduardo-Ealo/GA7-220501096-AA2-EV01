/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desvo
 */
public class EJERCICIO2 {

    public static void main(String[] args)throws SQLException {
        String usuario="root";
        String password="admin";
        String url="jdbc:mysql://localhost/ejercicio";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            statement.execute("INSERT INTO `usuarios` (`Id`, `documento`, `nombres`) VALUES (NULL, '1143368537', 'Dilan andres');");
            System.out.println();
            rs=statement.executeQuery("SELECT * FROM `usuarios`");
            while (rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EJERCICIO2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
