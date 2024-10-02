package net.gestiondedocumental.main;

import java.util.Scanner;
import java.util.List;
import java.util.Iterator;

// Aqui empieza crear documentos
public class AdministracionDeDocumentos {
    public Documento crearDocumento() {
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
        return nuevoDocumento;
        
    }

    // Aqui empieza el editar
    public void editarDocumento(Documento documento) {
        Scanner scanner = new Scanner(System.in);

        // Editar nombre
        System.out.print("Editar Nombre: " + documento.getNombre() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            documento.setNombre(nombre);
        }

        // Editar fecha de publicación
        System.out.print("Editar Fecha: " + documento.getFechaPublicacion() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String fechaPublicacion = scanner.nextLine();
        if (!fechaPublicacion.isEmpty()) {
            documento.setFechaPublicacion(fechaPublicacion);
        }

        // Editar ISBN
        System.out.print("Editar ISBN: " + documento.getIsbn() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String isbn = scanner.nextLine();
        if (!isbn.isEmpty()) {
            documento.setIsbn(isbn);
        }

        // Editar tipo de documentos
        System.out.print("Editar Tipo de documento: " + documento.getTipoDocumentos() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String tipoDocumentos = scanner.nextLine();
        if (!tipoDocumentos.isEmpty()) {
            documento.setTipoDocumentos(tipoDocumentos);
        }

        // Editar género
        System.out.print("Editar Genero: " + documento.getGenero() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String genero = scanner.nextLine();
        if (!genero.isEmpty()) {
            documento.setGenero(genero);
        }

        // Editar autor
        System.out.print("Editar autor: " + documento.getAutor() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String autor = scanner.nextLine();
        if (!autor.isEmpty()) {
            documento.setAutor(autor);
        }

        // Editar descripción
        System.out.print("Editar Descripcion: " + documento.getDescripcion() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String descripcion = scanner.nextLine();
        if (!descripcion.isEmpty()) {
            documento.setDescripcion(descripcion);
        }

        // Editar número de páginas
        System.out.print("Editar Numero de paginas: " + documento.getNumeroPaginas() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String numeroPaginas = scanner.nextLine();
        if (!numeroPaginas.isEmpty()) {
            documento.setNumeroPaginas(Integer.parseInt(numeroPaginas));
        }

        // Editar edición
        System.out.print("Editar Edicion: " + documento.getEdicion() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String edicion = scanner.nextLine();
        if (!edicion.isEmpty()) {
            documento.setEdicion(Integer.parseInt(edicion));
        }

        // Editar cantidad disponible
        System.out.print("Editar cantidad: " + documento.getCantidadDisponible() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String cantidadDisponible = scanner.nextLine();
        if (!cantidadDisponible.isEmpty()) {
            documento.setCantidadDisponible(Integer.parseInt(cantidadDisponible));
        }

        // Editar precio
        System.out.print("Editar el precio: " + documento.getPrecio() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String precio = scanner.nextLine();
        if (!precio.isEmpty()) {
            documento.setPrecio(Double.parseDouble(precio));
        }

        // Editar valoración
        System.out.print("Editar la valoracion: " + documento.getValoracion() + ". Presione Enter para mantenerlo o ingrese un nuevo valor: ");
        String valoracion = scanner.nextLine();
        if (!valoracion.isEmpty()) {
            documento.setValoracion(Double.parseDouble(valoracion));
        }

        System.out.println("Los datos del documento han sido actualizados.");
    }
        public boolean eliminarDocumento(List<Documento> documentos, String isbn) {
        Iterator<Documento> iterator = documentos.iterator();
        while (iterator.hasNext()) {
            Documento doc = iterator.next();
            if (doc.getIsbn().equals(isbn)) {
                iterator.remove();
                System.out.println("Documento con ISBN " + isbn + " ha sido eliminado.");
                return true;
            }
        }
        System.out.println("No se encontró un documento con ISBN " + isbn);
        return false;
    }
}

// Aqui acaba
