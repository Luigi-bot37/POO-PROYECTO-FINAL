/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

/**
 *
 * @author leo
 */
public class Inventario {

    private String nombre;
    private String descripcion;
    private int unidades;
    private double precio;
    private String codigo;

    public Inventario() {
        this.nombre = " ";
        this.descripcion = " ";
        this.unidades = 0;
        this.precio = 0;
        this.codigo = " ";
    }

    public Inventario(String nombre, String descripcion, int unidades, double precio, String codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        String cade = "Nombre: " + nombre.toUpperCase() + "\n"
                + "Codigo de Producto: " + codigo + " \n"
                + "Descripcion: " + descripcion + " \n"
                + "Precio: $" + precio + "\n"
                + "Unidades disponibles: " + unidades;
        return cade;
    }

    public String convertiraTexto() {
        return String.format("%s,%s,%d,%.2f,%s", nombre, descripcion, unidades, precio, codigo);
    }

    // Método para crear un objeto Inventario desde texto
    public Inventario convertiraProducto(String texto) {
        String[] datos = texto.split(",");
        return new Inventario(datos[0], datos[1], Integer.parseInt(datos[2].trim()), Double.parseDouble(datos[3].trim()), datos[4].trim());
    }
}
