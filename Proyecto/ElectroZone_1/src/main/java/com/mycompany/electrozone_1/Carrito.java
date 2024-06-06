/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leo
 */
public class Carrito {

    private List<Inventario> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public Inventario getProducto(int i) {
        return productos.get(i);
    }

    // Método para agregar un producto al carrito
    public void agregarInventario(Inventario inventario) {
        productos.add(inventario);
    }

    // Método para quitar un producto del carrito
    public void quitarInventario(Inventario inventario) {
        productos.remove(inventario);
    }

    // Método para obtener la lista de productos en el carrito
    public void getInventario() {
        System.out.println("-----CARRITO DE COMPRAS-----");
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i).toString());
            System.out.println("----------");
        }
    }

    // Método para calcular el total del carrito
    public double calcularTotal() {
        double total = 0;
        for (Inventario inventario : productos) {
            total += inventario.getPrecio();
        }
        return total;
    }

    public int getSize() {
        return productos.size();
    }

}
