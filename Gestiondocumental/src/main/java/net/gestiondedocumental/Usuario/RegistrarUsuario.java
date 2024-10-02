package net.gestiondedocumental.Usuario;

import java.util.HashMap;
import java.util.Scanner;

public class RegistrarUsuario {
    private static Scanner scanner = new Scanner(System.in);
    private static HashMap<String, Usuario> usuariosRegistrados = new HashMap<>(); 

    public static Usuario registrar() {
        System.out.println("\nREGISTRO DE USUARIO");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer

        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Número de celular: ");
        String celular = scanner.nextLine();

        String nombreUsuario;
        do {
            System.out.print("Nombre de usuario: ");
            nombreUsuario = scanner.nextLine();

            // Verificar si el nombre de usuario ya está registrado
            if (usuariosRegistrados.containsKey(nombreUsuario)) {
                System.out.println("El nombre de usuario ya está en uso. Por favor, elija otro.");
            }
        } while (usuariosRegistrados.containsKey(nombreUsuario)); 
        
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        // Crear y registrar el nuevo usuario
        Usuario nuevoUsuario = new Usuario(nombre, edad, correo, celular, nombreUsuario, contrasena);
        usuariosRegistrados.put(nombreUsuario, nuevoUsuario);
        System.out.println("Usuario registrado exitosamente.");
        return nuevoUsuario;
    }

    // Método para validar si un usuario ya existe y si la contraseña coincide
    public static boolean validarUsuario(String nombreUsuario, String contrasena) {
        if (usuariosRegistrados.containsKey(nombreUsuario)) {
            // Verificar si la contraseña es correcta
            return usuariosRegistrados.get(nombreUsuario).getContrasena().equals(contrasena);
        }
        return false;  // Usuario no encontrado
    }

    // Método público para verificar si un usuario ya está registrado
    public static boolean existeUsuario(String nombreUsuario) {
        return usuariosRegistrados.containsKey(nombreUsuario);
    }
    
    public static Usuario obtenerUsuario(String nombreUsuario) {
    return usuariosRegistrados.get(nombreUsuario);  // Retorna el objeto Usuario registrado
}

    
    
}
