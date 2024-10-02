package net.gestiondedocumental.main;

import java.util.Scanner;

// Aqui empieza crear documentos
public class AdministracionDeDocumentos{
    public void crearDocumento() {
    Scanner scanner = new Scanner(System.in);

    // Solicitar información al usuario
    System.out.println("Por favor ingrese la siguiente información para crear un documento:");

    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();

    System.out.print("Fecha de Publicación (dd/mm/yyyy): ");
    String fechaPublicacion = scanner.nextLine();

    System.out.print("ISBN: ");
    String isbn = scanner.nextLine();

    System.out.print("Tipo de Documentos (ej: libro, revista, etc.): ");
    String tipoDocumentos = scanner.nextLine();

    System.out.print("Género: ");
    String genero = scanner.nextLine();

    System.out.print("Autor: ");
    String autor = scanner.nextLine();

    System.out.print("Descripción: ");
    String descripcion = scanner.nextLine();

    System.out.print("Número de Páginas: ");
    int numeroPaginas = scanner.nextInt();

    System.out.print("Edición: ");
    int edicion = scanner.nextInt();

    System.out.print("Cantidad Disponible: ");
    int cantidadDisponible = scanner.nextInt();

    System.out.print("Precio: ");
    double precio = scanner.nextDouble();

    System.out.print("Valoración: ");
    double valoracion = scanner.nextDouble();

    Documento nuevoDocumento = new Documento(
        nombre, fechaPublicacion, isbn, tipoDocumentos, genero, autor, descripcion,
        numeroPaginas, edicion, cantidadDisponible, precio, valoracion
    );

    System.out.println("Documento creado: " + nuevoDocumento.getNombre());
    }
}// Aqui acaba




