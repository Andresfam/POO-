/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author Juan Esteban
 */
public class Documentomodel {
    private String nombre;
    private String tipoDocumentos;
    private String autor;
    private int cantidadDisponible;
    private double precio;

    public Documentomodel(String nombre, String tipoDocumentos, String autor, int cantidadDisponible, double precio) {
        this.nombre = nombre;
        this.tipoDocumentos = tipoDocumentos;
        this.autor = autor;
        this.cantidadDisponible = cantidadDisponible;
        this.precio = precio;
    }

    public Documentomodel() {
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumentos() {
        return tipoDocumentos;
    }

    public void setTipoDocumentos(String tipoDocumentos) {
        this.tipoDocumentos = tipoDocumentos;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
