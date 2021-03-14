/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.istl.modelo;

import java.util.Date;

/**
 *
 * @author IDEAPAD 330
 */
public class Inventario {
    private int id_inventario;
    private String codigo_pro;
    private int can_productos;
    private String descripcion;
    private String precios_compra_sin_iva;
    private String precios_compra_con_iva;
    private String precio_mayorita;
    private String cliente_fijo;
    private String cliente_normal;
    private String fecha_caducidad;
    private Date fecha_registro;
    private Date fecha_actualizacion;

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

    public int getCan_productos() {
        return can_productos;
    }

    public void setCan_productos(int can_productos) {
        this.can_productos = can_productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecios_compra_sin_iva() {
        return precios_compra_sin_iva;
    }

    public void setPrecios_compra_sin_iva(String precios_compra_sin_iva) {
        this.precios_compra_sin_iva = precios_compra_sin_iva;
    }

    public String getPrecios_compra_con_iva() {
        return precios_compra_con_iva;
    }

    public void setPrecios_compra_con_iva(String precios_compra_con_iva) {
        this.precios_compra_con_iva = precios_compra_con_iva;
    }

    public String getPrecio_mayorita() {
        return precio_mayorita;
    }

    public void setPrecio_mayorita(String precio_mayorita) {
        this.precio_mayorita = precio_mayorita;
    }

    public String getCliente_fijo() {
        return cliente_fijo;
    }

    public void setCliente_fijo(String cliente_fijo) {
        this.cliente_fijo = cliente_fijo;
    }

    public String getCliente_normal() {
        return cliente_normal;
    }

    public void setCliente_normal(String cliente_normal) {
        this.cliente_normal = cliente_normal;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id_inventario=" + id_inventario + ", codigo_pro=" + codigo_pro + ", can_productos=" + can_productos + ", descripcion=" + descripcion + ", precios_compra_sin_iva=" + precios_compra_sin_iva + ", precios_compra_con_iva=" + precios_compra_con_iva + ", precio_mayorita=" + precio_mayorita + ", cliente_fijo=" + cliente_fijo + ", cliente_normal=" + cliente_normal + ", fecha_caducidad=" + fecha_caducidad + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }

    

 

    
    
}
