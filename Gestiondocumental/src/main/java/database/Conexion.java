/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lll
 */
public class Conexion {
    public static Connection getConnection(){
        Connection db = null;
        var base = "ARCHIVAPRO_DB";
        var url = "jdbc:mysql://34.55.72.158:3306/ARCHIVAPRO_DB";
        var user = "user";
        var pw = "tiTxAzhT5YSSbIIXXsDTdM3tF2mR0T5VrLY8KVSZTYGUDADgDirqNm";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            System.out.println("error conectando a la base de datos"+ e);
        }
        return db;
    }
}
