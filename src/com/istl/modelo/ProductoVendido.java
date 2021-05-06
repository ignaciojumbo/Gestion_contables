/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.istl.modelo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductoVendido {
    private int idproductovendido;
    private int inventarioIdInventario;
    private int notaventaIDNotaVenta;
    private int cantidadproducto;
    private double valorTotal;

    public int getIdproductovendido() {
        return idproductovendido;
    }

    public void setIdproductovendido(int idproductovendido) {
        this.idproductovendido = idproductovendido;
    }

    public int getInventarioIdInventario() {
        return inventarioIdInventario;
    }

    public void setInventarioIdInventario(int inventarioIdInventario) {
        this.inventarioIdInventario = inventarioIdInventario;
    }

    public int getNotaventaIDNotaVenta() {
        return notaventaIDNotaVenta;
    }

    public void setNotaventaIDNotaVenta(int notaventaIDNotaVenta) {
        this.notaventaIDNotaVenta = notaventaIDNotaVenta;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    

}
