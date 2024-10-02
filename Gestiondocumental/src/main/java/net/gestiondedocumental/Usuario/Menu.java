package net.gestiondedocumental.Usuario;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch(opcion) {
                case 1:
                    RegistrarUsuario.registrar();
                    break;
                case 2:
                    if (IngresarUsuario.ingresar()) {
                        subMenu();
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void subMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSUBMENÚ");
            System.out.println("1. Libros");
            System.out.println("2. Comprar Libros");
            System.out.println("3. Actualizar Datos");
            System.out.println("4. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch(opcion) {
                case 1:
                    System.out.println("Visualizando lista de libros...");
                    break;
                case 2:
                    System.out.println("Funcionalidad para comprar libros...");
                    break;
                case 3:
                    ActualizarDatos.actualizar();
                    break;
                case 4:
                    System.out.println("Sesión cerrada.");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 4);
    }
}
