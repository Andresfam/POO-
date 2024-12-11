/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.gestiondedocumental.main;

import database.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author lll
 */
public class LoginSystem {

    public static boolean authenticate(String username, String password) {
        String query = "SELECT * FROM user_account WHERE user = ? AND password = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Retorna true si encuentra una fila
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getRole(String username) {
        String query = "SELECT roles FROM user_account WHERE user = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("roles");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no encuentra el usuario
    }
}