/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.gestiondedocumental.main;

public class Venta {
    private String nombreUsuario;
    private String nombreLibro;
    private int cantidadComprada;
    private double precioIndividual;
    private double total;

    public Venta(String nombreUsuario, String nombreLibro, int cantidadComprada, double precioIndividual) {
        this.nombreUsuario = nombreUsuario;
        this.nombreLibro = nombreLibro;
        this.cantidadComprada = cantidadComprada;
        this.precioIndividual = precioIndividual;
        this.total = cantidadComprada * precioIndividual;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public double getPrecioIndividual() {
        return precioIndividual;
    }

    public double getTotal() {
        return total;
    }
}
