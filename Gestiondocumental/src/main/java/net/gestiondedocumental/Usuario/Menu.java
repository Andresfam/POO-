package net.gestiondedocumental.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import net.gestiondedocumental.main.AdministracionDeDocumentos;
import net.gestiondedocumental.main.Documento;

public class Menu {
    private static List<Documento> documentos = new ArrayList<>();  

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
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                Usuario nuevoUsuario = RegistrarUsuario.registrar();  
                mostrarSubMenu(nuevoUsuario);  
                break;
                case 2:
                Usuario usuarioIngresado;
                do {
                    usuarioIngresado = IngresarUsuario.ingresar();  
                } while (usuarioIngresado == null); 
                mostrarSubMenu(usuarioIngresado);  
                break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void mostrarSubMenu(Usuario usuario) {
        if (usuario.getTipoDeUsuario().equalsIgnoreCase("Administrador")) {
            mostrarSubMenuAdministrador();
        } else {
            mostrarSubMenuUsuario();
        }
    }

    private static void mostrarSubMenuUsuario() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBIENVENIDO");
            System.out.println("1. Libros");
            System.out.println("2. Comprar Libros");
            System.out.println("3. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("lista de libros...");
                    
                    break;
                case 2:
                    System.out.println(" comprar libros...");
                    break;
                case 3:
                    System.out.println("Sesion cerrada.");
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void mostrarSubMenuAdministrador() {
        Scanner scanner = new Scanner(System.in);
        AdministracionDeDocumentos admin = new AdministracionDeDocumentos();
        int opcion;

        do {
            System.out.println("\nMENÚ ADMINISTRADOR");
            System.out.println("1. Crear Documento");
            System.out.println("2. Editar Documento");
            System.out.println("3. Ver Todos los Documentos");
            System.out.println("4. Eliminar Documento");
            System.out.println("5. Cerrar Sesión");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    Documento nuevoDocumento = admin.crearDocumento();  // Crear documento
                    documentos.add(nuevoDocumento);  // Añadirlo a la lista
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
                            admin.editarDocumento(documentos.get(index - 1));  // Editar documento
                        } else {
                            System.out.println("Índice no valido.");
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
                    System.out.print("Ingrese el ISBN del documento que desea eliminar: ");
                    String isbn = scanner.nextLine();
                    boolean eliminado = admin.eliminarDocumento(documentos, isbn);
                    if (eliminado) {
                        System.out.println("Documento eliminado exitosamente.");
                    } else {
                        System.out.println("No se encontró un documento con ese ISBN.");
                    }
                    break;
                case 5:
                    System.out.println("Sesión cerrada.");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 5);
    }
}
