package net.gestiondedocumental.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import net.gestiondedocumental.main.AdministracionDeDocumentos;
import net.gestiondedocumental.main.Documento;
import net.gestiondedocumental.main.Venta;

public class Menu {
    private static List<Documento> documentos = new ArrayList<>();
    private static List<Venta> historicoVentas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Ingresar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
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
            mostrarSubMenuUsuario(usuario);
        }
    }

    private static void mostrarSubMenuUsuario(Usuario usuario) {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\nBIENVENIDO");
        System.out.println("1. Libros");
        System.out.println("2. Comprar Libros");
        System.out.println("3. Cerrar Sesión");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                // Mostrar lista de libros
                if (!documentos.isEmpty()) {
                    System.out.println("===== Lista de Libros =====");
                    for (Documento doc : documentos) {
                        System.out.println("Nombre: " + doc.getNombre());
                        System.out.println("Cantidad Disponible: " + doc.getCantidadDisponible());
                        System.out.println("----------------------------");
                    }
                } else {
                    System.out.println("No hay libros disponibles.");
                }
                break;

            case 2:
            // Comprar libros
            if (!documentos.isEmpty()) {
            System.out.println("Seleccione el libro que desea comprar (digite 0 para volver al menú anterior):");
            for (int i = 0; i < documentos.size(); i++) {
                System.out.println((i + 1) + ". " + documentos.get(i).getNombre() + " (Cantidad disponible: " + documentos.get(i).getCantidadDisponible() + ")");
            }
            int libroSeleccionado = scanner.nextInt() - 1;
            scanner.nextLine();

            if (libroSeleccionado == -1) { // El usuario ingresó 0, regresa al menú
                System.out.println("Regresando al menú anterior...");
                break;
            }

            if (libroSeleccionado >= 0 && libroSeleccionado < documentos.size()) {
                Documento libro = documentos.get(libroSeleccionado);

                System.out.print("Ingrese la cantidad que desea comprar: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();

                if (cantidad > 0 && cantidad <= libro.getCantidadDisponible()) {
                    // Reducir la cantidad disponible
                    libro.setCantidadDisponible(libro.getCantidadDisponible() - cantidad);
                    double precioUnitario = libro.getPrecio();
                    double total = precioUnitario * cantidad;

                    // Registrar la venta en el histórico
                    
                    historicoVentas.add(new Venta(usuario.getNombreCompleto(), libro.getNombre(), cantidad, precioUnitario));

                    System.out.println("Compra realizada exitosamente. Ahora hay " + libro.getCantidadDisponible() + " unidades disponibles de '" + libro.getNombre() + "'.");
                    System.out.println("Total de la compra: " + total);
                } else {
                    System.out.println("Cantidad no válida o insuficiente en inventario.");
                }
            } else {
                System.out.println("Opción no válida.");
            }
            } else {
            System.out.println("No hay libros disponibles para comprar.");
            }
            break;


            case 3:
                System.out.println("Sesión cerrada.");
                break;

            default:
                System.out.println("Opción no válida, intente nuevamente.");
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
        System.out.println("5. Historico de ventas");
        System.out.println("6. Cerrar Sesión");
        System.out.print("Seleccione una opcion: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                Documento nuevoDocumento = admin.crearDocumento(); // Crear documento
                documentos.add(nuevoDocumento); // Añadirlo a la lista
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
                        admin.editarDocumento(documentos.get(index - 1)); // Editar documento
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
                        System.out.println("Cantidad Disponible: " + doc.getCantidadDisponible());
                        System.out.println("Fecha de Publicación: " + doc.getFechaPublicacion());
                        System.out.println("ISBN: " + doc.getIsbn());
                        System.out.println("Tipo de Documento: " + doc.getTipoDocumentos());
                        System.out.println("Género: " + doc.getGenero());
                        System.out.println("Autor: " + doc.getAutor());
                        System.out.println("Descripción: " + doc.getDescripcion());
                        System.out.println("Número de Páginas: " + doc.getNumeroPaginas());
                        System.out.println("Edición: " + doc.getEdicion());
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
                
            case 5: // Nueva opción para ver el histórico de ventas
                if (!historicoVentas.isEmpty()) {
                System.out.println("===== Histórico de Ventas =====");
                for (Venta venta : historicoVentas) {
                System.out.println(venta.getNombreUsuario() + " compró '" + venta.getNombreLibro() + 
                    "' a " + venta.getCantidadComprada() + " unidades con un valor de " + 
                    venta.getPrecioIndividual() + ", dando un total de " + venta.getTotal() + ".");
                }
                } else {
                    System.out.println("No hay ventas registradas.");
                }
                break;
                
            case 6:
                System.out.println("Sesión cerrada.");
                break;

            default:
                System.out.println("Opción no válida, intente nuevamente.");
            }
        } while (opcion != 6);
    }
}
