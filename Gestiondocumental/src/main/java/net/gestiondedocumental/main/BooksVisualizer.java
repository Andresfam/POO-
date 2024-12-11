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
        String query = "SELECT id, autor, titulo, tipo, precio, cantidad FROM books";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("id"),
                    rs.getString("autor"),
                    rs.getString("titulo"),
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
    
    public static boolean addBook(String autor, String titulo, String tipo, double precio, int cantidad) {
    String query = "INSERT INTO books (autor, titulo, tipo, precio, cantidad) VALUES (?, ?, ?, ?, ?)";

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, autor);
        stmt.setString(2, titulo);
        stmt.setString(3, tipo);
        stmt.setDouble(4, precio);
        stmt.setInt(5, cantidad);

        return stmt.executeUpdate() > 0; // Retorna true si se insertó con éxito
    } catch (Exception e) {
        e.printStackTrace();
        return false;
        }
    }
    
    public static boolean updateBook(int id, String autor, String titulo, String tipo, double precio, int cantidad) {
        String query = "UPDATE books SET autor = ?, titulo = ?, tipo = ?, precio = ?, cantidad = ? WHERE id = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, autor);
            stmt.setString(2, titulo);
            stmt.setString(3, tipo);
            stmt.setDouble(4, precio);
            stmt.setInt(5, cantidad);
            stmt.setInt(6, id);

            return stmt.executeUpdate() > 0; // Retorna true si se actualizó con éxito
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
