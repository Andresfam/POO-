
package net.gestiondedocumental.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdministracionDeDocumentos admin = new AdministracionDeDocumentos();
        Scanner scanner = new Scanner(System.in);
        List<Documento> documentos = new ArrayList<>(); // Lista para almacenar los documentos

        while (true) {
            System.out.println("===== Menú de Administración de Documentos =====");
            System.out.println("1. Crear Documento");
            System.out.println("2. Editar Documento");
            System.out.println("3. Ver Todos los Documentos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    admin.crearDocumento();
                    // Suponiendo que el método 'crearDocumento' devuelve un objeto Documento
                    Documento nuevoDocumento = admin.crearDocumento();
                    documentos.add(nuevoDocumento); // Agregar el nuevo documento a la lista
                    break;
                case 2:
                    if (!documentos.isEmpty()) {
                        System.out.println("Seleccione el documento a editar:");
                        for (int i = 0; i < documentos.size(); i++) {
                            System.out.println((i + 1) + ". " + documentos.get(i).getNombre());
                        }
                        int index = scanner.nextInt();
                        scanner.nextLine();
                        if (index > 0 && index <= documentos.size()) {
                            admin.editarDocumento(documentos.get(index - 1));
                        } else {
                            System.out.println("Índice no válido.");
                        }
                    } else {
                        System.out.println("No hay documentos para editar. Cree uno primero.");
                    }
                    break;
                case 3:
                    if (!documentos.isEmpty()) {
                        System.out.println("===== Lista de Documentos =====");
                        for (Documento doc : documentos) {
                            System.out.println("Nombre: " + doc.getNombre());
                            System.out.println("Fecha de Publicación: " + doc.getFechaPublicacion());
                            System.out.println("ISBN: " + doc.getIsbn());
                            System.out.println("Tipo de Documento: " + doc.getTipoDocumentos());
                            System.out.println("Género: " + doc.getGenero());
                            System.out.println("Autor: " + doc.getAutor());
                            System.out.println("Descripción: " + doc.getDescripcion());
                            System.out.println("Número de Páginas: " + doc.getNumeroPaginas());
                            System.out.println("Edición: " + doc.getEdicion());
                            System.out.println("Cantidad Disponible: " + doc.getCantidadDisponible());
                            System.out.println("Precio: " + doc.getPrecio());
                            System.out.println("Valoración: " + doc.getValoracion());
                            System.out.println("----------------------------");
                        }
                    } else {
                        System.out.println("No hay documentos creados aún.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
