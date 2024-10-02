package net.gestiondedocumental.Usuario;

import java.util.Scanner;

public class IngresarUsuario {
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean ingresar() {
        System.out.println("\nINICIAR SESIÓN");

        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        // Utilizar el método de validación de usuario del archivo RegistrarUsuario
        if (RegistrarUsuario.validarUsuario(nombreUsuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");
            return true;
        } else {
            // Validar si el nombre de usuario existe pero la contraseña es incorrecta
            if (RegistrarUsuario.existeUsuario(nombreUsuario)) {
                System.out.println("Contraseña incorrecta. Por favor, intente nuevamente.");
            } else {
                System.out.println("Nombre de usuario no encontrado. Regístrese o verifique los datos.");
            }
            return false;
        }
    }
}
