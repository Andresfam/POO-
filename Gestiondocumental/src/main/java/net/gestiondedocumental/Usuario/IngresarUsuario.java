package net.gestiondedocumental.Usuario;
import java.util.Scanner;

public class IngresarUsuario {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean ingresar() {
        System.out.println("\nINICIAR SESIÓN");
        
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        if (validarUsuario(nombreUsuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");
            return true;
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
            return false;
        }
    }

    private static boolean validarUsuario(String nombreUsuario, String contrasena) {
        return true;  // Se asume que se valida correctamente
    }
}
