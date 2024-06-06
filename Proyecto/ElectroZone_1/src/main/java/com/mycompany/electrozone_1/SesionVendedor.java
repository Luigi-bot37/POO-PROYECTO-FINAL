/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

/**
 *
 * @author leo
 */
public class SesionVendedor extends Usuario {

    public SesionVendedor() {
        super();
    }

    public SesionVendedor(String nombre, String clave, String fechaNacimiento, String sexo, long numeroCel, long numeroTarjeta) {
        super(nombre, clave, fechaNacimiento, sexo, numeroCel, numeroTarjeta);
    }

    @Override
    public String toString() {
        String cade = super.toString();
        return cade;
    }

    @Override
    public String convertiraTexto() {
        return String.format("%s,%s,%s,%s,%d,%d", super.getNombre(),
                super.getClave(), super.getFechaNacimiento(),
                super.getSexo(), super.getNumeroCel(), super.getNumeroTarjeta());
    }

    // Método para crear un objeto Cliente desde texto
    public SesionVendedor convertiraVendedor(String texto) {
        String[] datos = texto.split(",");

        return new SesionVendedor(datos[0], datos[1],
                datos[2], datos[3], Long.parseLong(datos[4]), Long.parseLong(datos[5]));
    }
}
