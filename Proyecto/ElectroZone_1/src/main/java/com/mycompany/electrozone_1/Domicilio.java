/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.electrozone_1;

/**
 *
 * @author luis
 */
//Esta clase le da un domicilio los usuarios clientes
public class Domicilio {

    private int num;
    private String calle;
    private String colonia;
    private int cp;
    private String ciudad;
    private String estado;
    private String pais;

    public Domicilio() {
        this.num = 0000;
        this.calle = "-----";
        this.colonia = "-----";
        this.cp = 00000;
        this.ciudad = "-----";
        this.estado = "-----";
        this.pais = "-----";
    }

    public Domicilio(int num, String calle, String colonia, int cp, String ciudad, String estado, String pais) {
        this.num = num;
        this.calle = calle;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        String cade = "\n" + "Numero: " + num + "\n" + "Calle: " + calle + "\n" + "Colonia: "
                + colonia + "\n" + "Cod. Postal: " + cp + "\n" + "Ciudad: " + ciudad + "\n"
                + "Estado: " + estado + "\n"
                + "Pais: " + pais;
        return cade;
    }

    public String convertiraTexto() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", num, calle, colonia, cp, ciudad, estado, pais);
    }

    // Método para crear un objeto Domicilio desde texto
    public Domicilio convertiraDomicilio(String texto) {
        String[] datos = texto.split(",");
        return new Domicilio(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5], datos[6]);
    }
}
