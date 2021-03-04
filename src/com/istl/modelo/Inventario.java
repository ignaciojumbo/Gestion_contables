/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.modelo;

/**
 *
 * @author IDEAPAD 330
 */
public class Inventario {
    private int id_inventario;
    private String codigo_pro;
    private String descripción;
    private String precios_compra;
    private String precio_venta;
    private int can_productos;

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public String getCodigo_pro() {
        return codigo_pro;
    }

    public void setCodigo_pro(String codigo_pro) {
        this.codigo_pro = codigo_pro;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getPrecios_compra() {
        return precios_compra;
    }

    public void setPrecios_compra(String precios_compra) {
        this.precios_compra = precios_compra;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCan_productos() {
        return can_productos;
    }

    public void setCan_productos(int can_productos) {
        this.can_productos = can_productos;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_inventario=" + id_inventario + ", codigo_pro=" + codigo_pro +
                ", descripci\u00f3n=" + descripción + ", precios_compra=" + precios_compra + ", precio_venta="
                + precio_venta + ", can_productos=" + can_productos + '}';
    }

    
    
}
