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
        var base = "archivapro_db";
        var url = "jdbc:mysql://localhost:3306/"+base;
        var user = "root";
        var pw = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db = DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            System.out.println("error conectando a la base de datos"+ e);
        }
        return db;
    }
    
    public static void main(String[] args) throws SQLException {
        var conexion = Conexion.getConnection();
        if(conexion != null){
            System.out.println("conectado exitosamente");
            String selectQuery = "SELECT * FROM user_account";
                Statement statement = conexion.createStatement();

                // execute the query and get the result set
                ResultSet resultSet = statement.executeQuery(selectQuery);
                System.out.println("The Available Data\n");

                // iterate through the result set and print the data
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String author_name = resultSet.getString("user");
                    String book_name = resultSet.getString("password");
                    String book_price = resultSet.getString("books");

                    // print the retrieved data
                    System.out.println("ID: " + id + ", user: " + author_name + ", contrasena: " + book_name
                            + ", Book_Name: " + book_price);
                }
        }
        else{
            System.out.println("no se ha podido conectar");
        }
    }
}
