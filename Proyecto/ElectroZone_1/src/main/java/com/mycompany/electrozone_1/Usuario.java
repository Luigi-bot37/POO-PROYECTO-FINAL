/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

/**
 *
 * @author leo
 */
public class Usuario {

    private String nombre;
    private String clave;
    private String fechaNacimiento;
    private String sexo;
    private long numeroCel;
    private long numeroTarjeta;

    public Usuario() {
        this.nombre = " ";
        this.clave = " ";
        this.fechaNacimiento = " ";
        this.sexo = " ";
        this.numeroCel = 0;
        this.numeroTarjeta = 0;
    }

    public Usuario(String nombre, String clave, String fechaNacimiento, String sexo, long numeroCel, long numeroTarjeta) {
        this.nombre = nombre;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.numeroCel = numeroCel;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(long numeroCel) {
        this.numeroCel = numeroCel;
    }

    public long getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        String cade = "Nombre de Usuario: " + nombre + "\n"
                + "Fecha de Nacimiento: " + fechaNacimiento + "\n"
                + "Sexo: " + sexo + "\n"
                + "Numero Telefonico: " + numeroCel + "\n"
                + "Tarjeta bancaria: " + numeroTarjeta;
        return cade;
    }

    public String convertiraTexto() {
        return String.format("%s,%s,%s,%s,%d,%d", nombre,
                clave, fechaNacimiento,
                sexo, numeroCel, numeroTarjeta);
    }

    public Usuario convertiraUsuario(String texto) {
        String[] datos = texto.split(",");

        if (datos.length == 6) {

            return new SesionVendedor(
                    datos[0].trim(),
                    datos[1].trim(),
                    datos[2].trim(),
                    datos[3].trim(),
                    Long.parseLong(datos[4].trim()),
                    Long.parseLong(datos[5].trim())
            );
        } else if (datos.length == 14) {

            Domicilio domicilio = new Domicilio();
            domicilio.convertiraDomicilio(
                    String.join(",", datos[1].trim(),
                            datos[2].trim(),
                            datos[3].trim(), datos[4].trim(),
                            datos[5].trim(), datos[6].trim(), datos[7].trim())
            );
            return new SesionCliente(
                    datos[0].trim(),
                    domicilio,
                    datos[8].trim(),
                    datos[9].trim(),
                    datos[10].trim(),
                    datos[11].trim(),
                    Long.parseLong(datos[12].trim()),
                    Long.parseLong(datos[13].trim())
            );
        } else {
            throw new IllegalArgumentException("Tipo desconocido");
        }

    }
}
