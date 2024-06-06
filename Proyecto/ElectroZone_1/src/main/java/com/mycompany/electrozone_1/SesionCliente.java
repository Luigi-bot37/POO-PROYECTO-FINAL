/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

/**
 *
 * @author leo
 */
public class SesionCliente extends Usuario {

    private String apellidos;
    private Domicilio domicilio;

    public SesionCliente() {
        super();
        this.apellidos = " ";
        this.domicilio = null;
    }

    public SesionCliente(String apellidos, Domicilio domicilio, String nombre, String clave, String fechaNacimiento, String sexo, long numeroCel, long numeroTarjeta) {
        super(nombre, clave, fechaNacimiento, sexo, numeroCel, numeroTarjeta);
        this.apellidos = apellidos;
        this.domicilio = domicilio;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        String cade = "\n" + "Nombre de Usuario: " + super.getNombre()
                + "\n" + "Apellidos: " + apellidos
                + "\n" + "Fecha de Nacimiento: " + super.getFechaNacimiento()
                + "\n" + "Sexo: " + super.getSexo()
                + "\n" + "Numero telefonico: " + super.getNumeroCel()
                + "\n" + "Tarjeta Bancaria: " + super.getNumeroTarjeta()
                + "\n" + "Direccion: " + domicilio.toString();
        return cade;
    }

    @Override
    public String convertiraTexto() {
        return String.format("%s,%s,%s,%s,%s,%s,%d,%d", apellidos,
                domicilio.convertiraTexto(), super.getNombre(), super.getClave(),
                super.getFechaNacimiento(), super.getSexo(), super.getNumeroCel(), super.getNumeroTarjeta());
    }

    // Método para crear un objeto Cliente desde texto
    public static SesionCliente convertiraCliente(String texto) {
        String[] datos = texto.split(",");
        Domicilio domicilio = new Domicilio();
        domicilio.convertiraDomicilio(datos[1]);
        return new SesionCliente(datos[0], domicilio, datos[2], datos[3], datos[4],
                datos[5], Long.parseLong(datos[6]), Long.parseLong(datos[7]));
    }
}
