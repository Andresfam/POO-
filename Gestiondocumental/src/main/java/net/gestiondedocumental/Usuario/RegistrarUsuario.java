package net.gestiondedocumental.Usuario;
import java.util.Scanner;

public class RegistrarUsuario {
    private static Scanner scanner = new Scanner(System.in);
    public static void registrar() {
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

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombre, edad, correo, celular, nombreUsuario, contrasena);
        
        System.out.println("Usuario registrado exitosamente.");
    }
}
