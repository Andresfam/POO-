/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.gestiondedocumental.main;

import database.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lll
 */
public class BooksVisualizer {
    public static List<Object[]> getBooks() {
        List<Object[]> books = new ArrayList<>();
        String query = "SELECT id, autor, tipo, precio, cantidad FROM books";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("autor"),
                    rs.getString("tipo"),
                    rs.getDouble("precio"),
                    rs.getInt("cantidad")
                };
                books.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public static boolean addBook(String autor, String tipo, double precio, int cantidad) {
    String query = "INSERT INTO books (autor, tipo, precio, cantidad) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, autor);
        stmt.setString(2, tipo);
        stmt.setDouble(3, precio);
        stmt.setInt(4, cantidad);

        return stmt.executeUpdate() > 0; // Retorna true si se insertó con éxito
    } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }
}
